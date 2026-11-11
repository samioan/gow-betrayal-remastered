#include "platform.h"

#include <windows.h>
#include <mmsystem.h>

#include <algorithm>
#include <atomic>
#include <chrono>
#include <condition_variable>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <deque>
#include <functional>
#include <mutex>
#include <string>
#include <thread>
#include <vector>

namespace gow {

// Audio problems are silent by nature, so failures go to %LOCALAPPDATA%\gow-betrayal-port\audio.log:
// that file is what to ask for in a "no sound" report.
void audioLog(const std::string& line) {
  static std::mutex m;
  static bool announced = false;
  std::lock_guard<std::mutex> lk(m);
  const char* local = std::getenv("LOCALAPPDATA");
  std::string dir = local ? std::string(local) + "\\gow-betrayal-port" : std::string(".");
  CreateDirectoryA(dir.c_str(), nullptr);
  FILE* f = fopen((dir + "\\audio.log").c_str(), "a");
  if (!f) return;
  if (!announced) {
    announced = true;
    SYSTEMTIME t;
    GetLocalTime(&t);
    fprintf(f, "---- %04d-%02d-%02d %02d:%02d:%02d\n", t.wYear, t.wMonth, t.wDay, t.wHour, t.wMinute, t.wSecond);
  }
  fprintf(f, "%s\n", line.c_str());
  fclose(f);
}

// A MIDI file flattened for playback: channel messages in time order, timed in milliseconds from the start.
struct MidiSequence {
  struct Event {
    double ms;
    uint32_t msg;  // packed for midiOutShortMsg: status | data1 << 8 | data2 << 16
  };
  std::vector<Event> events;
  double lengthMs = 0;               // one pass, up to the last track's end
  std::atomic<bool> playing{false};  // cleared by the sequencer when a pass ends without looping, or on stop
};

namespace {

void audioLog(const char* what, int code) { gow::audioLog(std::string(what) + ": " + std::to_string(code)); }

// PlaySound calls can block, so the wav path runs them on this worker thread, in order. The game thread only
// queues commands. Leaked on purpose: the thread outlives static destruction.
struct Worker {
  std::mutex m;
  std::condition_variable cv;
  std::deque<std::function<void()>> queue;
  std::thread th;

  Worker() {
    th = std::thread([this] {
      for (;;) {
        std::function<void()> job;
        {
          std::unique_lock<std::mutex> lk(m);
          cv.wait(lk, [this] { return !queue.empty(); });
          job = std::move(queue.front());
          queue.pop_front();
        }
        job();
      }
    });
    th.detach();
  }
  void post(std::function<void()> f) {
    {
      std::lock_guard<std::mutex> lk(m);
      queue.push_back(std::move(f));
    }
    cv.notify_one();
  }
};

Worker& worker() {
  static Worker* w = new Worker();
  return *w;
}

// Length of a PCM wav in milliseconds (0 if the header is not understood).
int wavMillis(const Arr<int8_t>& d) {
  if (d.length() < 44) return 0;
  const uint8_t* p = (const uint8_t*)d.data();
  auto u32 = [&](int o) { return (uint32_t)p[o] | (uint32_t)p[o + 1] << 8 | (uint32_t)p[o + 2] << 16 | (uint32_t)p[o + 3] << 24; };
  uint32_t byteRate = 0, dataLen = 0;
  for (int o = 12; o + 8 <= d.length();) {
    uint32_t id = u32(o), len = u32(o + 4);
    if (id == 0x20746D66) byteRate = u32(o + 16);  // "fmt "
    if (id == 0x61746164) { dataLen = len; break; }  // "data"
    o += 8 + (int)len + (int)(len & 1);
  }
  return byteRate ? (int)((int64_t)dataLen * 1000 / byteRate) : 0;
}

// Parses a Standard MIDI File (format 0 or 1) into a MidiSequence: every track's channel messages merged in
// tick order, then timed through the tempo map. Meta events other than tempo and end-of-track, and sysex, are
// dropped. Returns an empty sequence if the file is not understood.
std::shared_ptr<MidiSequence> parseMidi(const Arr<int8_t>& d) {
  auto seq = std::make_shared<MidiSequence>();
  const uint8_t* p = (const uint8_t*)d.data();
  int n = d.length();
  auto u16 = [&](int o) { return (int)(p[o] << 8 | p[o + 1]); };
  auto u32 = [&](int o) { return (uint32_t)p[o] << 24 | (uint32_t)p[o + 1] << 16 | (uint32_t)p[o + 2] << 8 | p[o + 3]; };
  if (n < 14 || memcmp(p, "MThd", 4) != 0) return seq;
  int division = u16(12);
  double smpteTicksPerMs = 0;
  if (division & 0x8000) {  // SMPTE: frames per second x ticks per frame
    smpteTicksPerMs = (256 - (division >> 8)) * (division & 0xFF) / 1000.0;
    if (smpteTicksPerMs <= 0) return seq;
  } else if (division == 0) {
    return seq;
  }

  struct Raw {
    int64_t tick;
    uint32_t msg;
  };
  std::vector<Raw> raw;
  std::vector<std::pair<int64_t, int>> tempos;  // (tick, microseconds per quarter note)
  int64_t endTick = 0;
  int o = 8 + (int)u32(4);
  while (o + 8 <= n) {
    uint32_t len = u32(o + 4);
    int start = o + 8;
    int end = (int)std::min<int64_t>((int64_t)start + len, n);
    if (memcmp(p + o, "MTrk", 4) == 0) {
      int q = start, status = 0;
      int64_t tick = 0;
      auto varLen = [&]() {
        int v = 0;
        for (int i = 0; i < 4 && q < end; i++) {
          int b = p[q++];
          v = v << 7 | (b & 0x7F);
          if (!(b & 0x80)) break;
        }
        return v;
      };
      while (q < end) {
        tick += varLen();
        if (q >= end) break;
        if (p[q] & 0x80) status = p[q++];
        if (status == 0xFF) {
          if (q >= end) break;
          int type = p[q++];
          int l = varLen();
          if (type == 0x51 && l == 3 && q + 3 <= end) tempos.push_back({tick, p[q] << 16 | p[q + 1] << 8 | p[q + 2]});
          q += l;
          status = 0;
          if (type == 0x2F) break;
        } else if (status == 0xF0 || status == 0xF7) {
          q += varLen();
          status = 0;
        } else if (status >= 0x80) {
          int hi = status & 0xF0;
          int count = (hi == 0xC0 || hi == 0xD0) ? 1 : 2;
          if (q + count > end) break;
          uint32_t msg = (uint32_t)status | (uint32_t)p[q] << 8 | (count == 2 ? (uint32_t)p[q + 1] << 16 : 0);
          raw.push_back({tick, msg});
          q += count;
        } else {
          break;  // a data byte with no running status: the rest of this track is not understood
        }
      }
      endTick = std::max(endTick, tick);
    }
    o = start + (int)len;
  }

  std::stable_sort(raw.begin(), raw.end(), [](const Raw& a, const Raw& b) { return a.tick < b.tick; });
  std::stable_sort(tempos.begin(), tempos.end(), [](const auto& a, const auto& b) { return a.first < b.first; });
  // tick -> ms through the tempo map (ticks arrive in increasing order)
  size_t ti = 0;
  int64_t segTick = 0;
  double segMs = 0;
  int tempo = 500000;
  auto toMs = [&](int64_t tick) {
    if (smpteTicksPerMs > 0) return tick / smpteTicksPerMs;
    while (ti < tempos.size() && tempos[ti].first <= tick) {
      segMs += (double)(tempos[ti].first - segTick) * tempo / division / 1000.0;
      segTick = tempos[ti].first;
      tempo = tempos[ti].second;
      ti++;
    }
    return segMs + (double)(tick - segTick) * tempo / division / 1000.0;
  };
  seq->events.reserve(raw.size());
  for (const Raw& r : raw) seq->events.push_back({toMs(r.tick), r.msg});
  seq->lengthMs = toMs(endTick);
  if (!seq->events.empty()) seq->lengthMs = std::max(seq->lengthMs, seq->events.back().ms);
  return seq;
}

// Plays one MidiSequence at a time through the Windows MIDI mapper, on its own thread with millisecond timing.
// Replaces MCI, which needed a temp file and a sequencer device per sound, took 100+ ms per command and refused
// to play while another sequencer device held the port (MCIERR_SEQ_PORT_INUSE, 337). SoundPlayer itself only
// ever plays one sound at a time, so one sequence slot is all the game needs.
class Sequencer {
 public:
  Sequencer() {
    std::thread([this] { run(); }).detach();
  }

  void play(const std::shared_ptr<MidiSequence>& seq, int loops) {
    std::lock_guard<std::mutex> lk(m_);
    if (cur_) {
      cur_->playing = false;
      silence();
    }
    cur_ = seq;
    seq->playing = true;
    next_ = 0;
    loopsLeft_ = loops == 0 ? 1 : loops;  // MMAPI: -1 = forever, n = n passes
    t0_ = Clock::now();
    cv_.notify_one();
  }

  void stop(const MidiSequence* seq) {
    std::lock_guard<std::mutex> lk(m_);
    if (!cur_ || cur_.get() != seq) return;
    cur_->playing = false;
    cur_.reset();
    silence();
    cv_.notify_one();
  }

 private:
  using Clock = std::chrono::steady_clock;

  static Clock::duration ms(double v) {
    return std::chrono::duration_cast<Clock::duration>(std::chrono::duration<double, std::milli>(v));
  }

  void run() {
    std::unique_lock<std::mutex> lk(m_);
    // Opening the synthesizer can take a moment; it happens here, off the game thread.
    MMRESULT r = midiOutOpen(&out_, MIDI_MAPPER, 0, 0, CALLBACK_NULL);
    if (r != MMSYSERR_NOERROR) {
      out_ = nullptr;
      audioLog("midiOutOpen failed", (int)r);
    }
    for (;;) {
      if (!cur_) {
        cv_.wait(lk);
        continue;
      }
      double elapsed = std::chrono::duration<double, std::milli>(Clock::now() - t0_).count();
      const auto& ev = cur_->events;
      while (next_ < ev.size() && ev[next_].ms <= elapsed) {
        if (out_) midiOutShortMsg(out_, ev[next_].msg);
        next_++;
      }
      double length = std::max(cur_->lengthMs, 1.0);
      if (next_ < ev.size()) {
        cv_.wait_until(lk, t0_ + ms(ev[next_].ms));
      } else if (elapsed < length) {
        cv_.wait_until(lk, t0_ + ms(length));
      } else if (loopsLeft_ < 0 || --loopsLeft_ > 0) {  // next pass, on the beat
        t0_ += ms(length);
        next_ = 0;
      } else {
        cur_->playing = false;
        cur_.reset();
        silence();
      }
    }
  }

  // Every channel: all sound off, reset controllers, all notes off, pitch bend centred.
  void silence() {
    if (!out_) return;
    for (uint32_t ch = 0; ch < 16; ch++) {
      midiOutShortMsg(out_, 0xB0 | ch | 120 << 8);
      midiOutShortMsg(out_, 0xB0 | ch | 121 << 8);
      midiOutShortMsg(out_, 0xB0 | ch | 123 << 8);
      midiOutShortMsg(out_, 0xE0 | ch | 0x40 << 16);
    }
  }

  std::mutex m_;
  std::condition_variable cv_;
  HMIDIOUT out_ = nullptr;
  std::shared_ptr<MidiSequence> cur_;
  size_t next_ = 0;
  int loopsLeft_ = 0;
  Clock::time_point t0_;
};

Sequencer& sequencer() {
  static Sequencer* s = new Sequencer();  // leaked on purpose, like the worker
  return *s;
}

}  // namespace

bool Player::isMidi() const { return mime.equals(String(u"audio/midi")); }

// MIDI: parse once (at load time) and start the sequencer thread, so start() costs nothing.
void Player::prefetch() {
  if (data == nullptr || !isMidi() || seq_) return;
  seq_ = parseMidi(data);
  if (seq_->events.empty()) audioLog("midi not understood, bytes", data.length());
  sequencer();
}

void Player::start() {
  if (data == nullptr) return;
  state_ = 400;
  if (isMidi()) {
    prefetch();
    sequencer().play(seq_, loops_);
  } else {
    int ms = wavMillis(data);
    endTime_ = loops_ < 0 || ms == 0 ? 0 : (int64_t)GetTickCount64() + ms;
    Arr<int8_t> bytes = data;
    DWORD flags = SND_MEMORY | SND_ASYNC | SND_NODEFAULT | (loops_ < 0 ? SND_LOOP : 0);
    worker().post([bytes, flags] {
      if (!PlaySoundW((LPCWSTR)bytes.data(), nullptr, flags)) audioLog("PlaySound failed", (int)GetLastError());
    });
  }
}

void Player::stop() {
  bool wasPlaying = state_ == 400;
  state_ = 300;
  if (isMidi()) {
    if (seq_) sequencer().stop(seq_.get());
  } else if (wasPlaying) {
    worker().post([] { PlaySoundW(nullptr, nullptr, 0); });
  }
}

void Player::close() {
  stop();
  state_ = 0;
}

void Player::pumpLoops() {}  // looping is handled by the sequencer thread

// 400 while playing; a finished one-shot drops back to 300 (prefetched), which SoundPlayer's priority check needs.
int Player::getState() {
  if (state_ == 400) {
    if (isMidi()) {
      if (!seq_ || !seq_->playing) state_ = 300;
    } else if (endTime_ && (int64_t)GetTickCount64() >= endTime_) {
      state_ = 300;
    }
  }
  return state_;
}

}  // namespace gow
