// Stand-ins for the MIDP / Nokia classes the translated game code touches.
#pragma once
#include <memory>
#include <string>

#include "jrt.h"
#include "gfx.h"

namespace gow {

struct Platform {
  static inline std::string dataDir = ".";
  static inline std::string saveDir = "saves";
};

class Engine;

class MIDlet {
 public:
  virtual ~MIDlet() = default;
  String getAppProperty(const String&) { return String(nullptr); }
  void notifyDestroyed();
  virtual void startApp() {}
  virtual void pauseApp() {}
  virtual void destroyApp(bool) {}
};

class Display {
 public:
  static Display* getDisplay(MIDlet*) {
    static Display d;
    return &d;
  }
  void setCurrent(Engine*) {}
};

// The port's own options shown in the game's Settings screens (Resolution, Fullscreen, Scaling, Speed).
// Rows 0..3; implemented in main.cpp next to the window code.
// Appends a line to %LOCALAPPDATA%\gow-betrayal-port\audio.log (audio failures and --sound-test results).
void audioLog(const std::string& line);

// PC options, implemented next to the window code in main.cpp. Rows: 0 Resolution, 1 Fullscreen, 2 FPS.
struct Port {
  static String label(int row);               // the row's text, e.g. "Resolution: 16:9"
  static void change(int row, int dir);       // activates / cycles the row
  static int viewWidth();
  static int displayFps();                    // 0 = original (25/s), -1 = unlimited, else frames per second                     // logical canvas width wanted right now (240 = original)
  static Arr<int> extendMenu(const Arr<int>& menuTable);  // adds the two rows to the Options page
};

// Nokia UI API: triangles with an ARGB colour.
class DirectGraphics {
 public:
  Surface* g = nullptr;
  void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int argb) {
    g->fillTriangle(x1, y1, x2, y2, x3, y3, (uint32_t)argb);
  }
  void drawTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int argb) {
    uint32_t c = (uint32_t)argb;
    int saved = 0;
    (void)saved;
    g->setColor((int)(c & 0xFFFFFF));
    g->drawLine(x1, y1, x2, y2);
    g->drawLine(x2, y2, x3, y3);
    g->drawLine(x3, y3, x1, y1);
  }
};

struct DirectUtils {
  static DirectGraphics* getDirectGraphics(Surface* g) {
    static DirectGraphics d;
    d.g = g;
    return &d;
  }
};

// javax.microedition.media stand-ins (audio backend arrives with the sound milestone).
struct ByteArrayInputStream {
  Arr<int8_t> data;
  explicit ByteArrayInputStream(const Arr<int8_t>& d) : data(d) {}
};

struct MidiSequence;  // platform.cpp: a parsed MIDI file

// javax.microedition.media.Player. MIDI is parsed once (prefetch) and played by a sequencer thread through the
// Windows MIDI mapper (midiOut); wav goes through PlaySound. One MIDI plays at a time, as SoundPlayer expects.
class Player {
 public:
  void realize() {}
  void prefetch();
  void setMediaTime(int64_t) {}
  void setLoopCount(int n) { loops_ = n; }
  void start();
  void stop();
  void close();
  int getState();  // 300 prefetched, 400 started (a finished clip drops back to 300)
  static void pumpLoops();
  Arr<int8_t> data;
  String mime;

 private:
  bool isMidi() const;
  int loops_ = 1, state_ = 300;
  int64_t endTime_ = 0;  // wav: when a one-shot finishes; 0 = never (looping)
  std::shared_ptr<MidiSequence> seq_;
};

// com.nokia.mid.sound.Sound stand-in. SoundPlayer uses it only for resource type 7 (Nokia ringing tones),
// which this jar does not contain, so it is never constructed in practice: it plays nothing.
class Sound {
 public:
  Sound(const Arr<int8_t>& data, int type) { (void)data; (void)type; }
  void play(int loops) { (void)loops; }
  void stop() {}
  void release() {}
  int getState() { return 1; }  // SOUND_STOPPED (0 = SOUND_PLAYING)
};

struct Manager {
  static Player* createPlayer(ByteArrayInputStream* in, const String& mime) {
    Player* p = new Player();
    p->data = in->data;
    p->mime = mime;
    return p;
  }
};

}  // namespace gow
