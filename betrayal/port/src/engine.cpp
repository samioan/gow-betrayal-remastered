#define _CRT_SECURE_NO_WARNINGS
#include "engine.h"

#include <windows.h>
#include <dbghelp.h>

#include <algorithm>
#include <climits>
#include <cstdio>
#include <cstring>

#define STBI_NO_STDIO
#include "stb_image.h"

#include "gen/classes.h"

namespace gow {

namespace {

// Engine.keyCodeTable: bit index -> MIDP key code.
int8_t g_keyCodeTable[32];
struct KeyTableInit {
  KeyTableInit() {
    g_keyCodeTable[1] = -1;
    g_keyCodeTable[2] = -3;
    g_keyCodeTable[3] = 35;
    g_keyCodeTable[4] = -8;
    g_keyCodeTable[5] = -4;
    g_keyCodeTable[6] = -2;
    g_keyCodeTable[8] = -5;
    g_keyCodeTable[10] = 42;
    for (int i = 0; i < 10; i++) g_keyCodeTable[16 + i] = (int8_t)(48 + i);
    g_keyCodeTable[27] = -6;
    g_keyCodeTable[29] = -7;
  }
} g_keyTableInit;

bool readFile(const std::string& path, std::vector<uint8_t>& out) {
  FILE* f = std::fopen(path.c_str(), "rb");
  if (!f) return false;
  std::fseek(f, 0, SEEK_END);
  long n = std::ftell(f);
  std::fseek(f, 0, SEEK_SET);
  out.resize((size_t)n);
  size_t got = n ? std::fread(out.data(), 1, (size_t)n, f) : 0;
  std::fclose(f);
  return got == (size_t)n;
}

// The game's own exceptions (array bounds, EOF) were caught or killed its thread in Java; the port
// logs each distinct throw site once and carries on with the next frame.
void logJavaException(const char* where, const JavaException& e) {
  static std::string seen;
  std::string sig;
  for (int i = 0; i < e.nframes && i < 4; i++) sig += std::to_string((uintptr_t)e.frames[i]) + ",";
  if (seen.find(sig) != std::string::npos || seen.size() > 4000) return;
  seen += sig + ";";
  FILE* f = std::fopen("exceptions.log", "a");
  if (!f) return;
  std::fprintf(f, "%s: %s\n", where, e.what);
  HANDLE proc = GetCurrentProcess();
  static bool symInit = false;
  if (!symInit) {
    SymSetOptions(SYMOPT_LOAD_LINES | SYMOPT_UNDNAME);
    SymInitialize(proc, nullptr, TRUE);
    symInit = true;
  }
  alignas(SYMBOL_INFO) char buf[sizeof(SYMBOL_INFO) + 256];
  SYMBOL_INFO* sym = (SYMBOL_INFO*)buf;
  for (int i = 0; i < e.nframes; i++) {
    sym->SizeOfStruct = sizeof(SYMBOL_INFO);
    sym->MaxNameLen = 255;
    DWORD64 disp = 0;
    DWORD lineDisp = 0;
    IMAGEHLP_LINE64 line = {sizeof line};
    if (!SymFromAddr(proc, (DWORD64)e.frames[i], &disp, sym)) continue;
    bool hasLine = SymGetLineFromAddr64(proc, (DWORD64)e.frames[i], &lineDisp, &line) != 0;
    std::fprintf(f, "   %s  %s:%lu\n", sym->Name, hasLine ? line.FileName : "?", hasLine ? line.LineNumber : 0);
  }
  std::fclose(f);
}

// Java int arithmetic helpers (the animation data packs fields into ints).
inline int shl(int v, int n) { return (int)((uint32_t)v << n); }
inline int shr(int v, int n) { return v >> n; }                   // arithmetic
inline int ushr(int v, int n) { return (int)((uint32_t)v >> n); }  // logical

}  // namespace

void MIDlet::notifyDestroyed() {}

// Sprite.draw (Sprite.java): clip the rectangle to its sheet, then drawRegion with anchor TOP|LEFT.
void Sprite::draw(Graphics* g, int x, int y, int flags) {
  flags &= 3;
  x += (flags & 2) == 0 ? offsetX : -(offsetX + width);
  y += (flags & 1) == 0 ? offsetY : -(offsetY + height);
  int rw = width, rh = height, sx = srcX, sy = srcY;
  if (sx < 0) { rw += sx; x += sx; sx = 0; }
  if (sy < 0) { rh += sy; y += sy; sy = 0; }
  int over;
  if ((over = sx + rw - sheet->w) > 0) rw -= over;
  if ((over = sy + rh - sheet->h) > 0) rh -= over;
  if (rw > 0 && rh > 0) g->drawRegion(sheet, sx, sy, rw, rh, flags, x, y, 20);
}

Engine::Engine(MIDlet* m) : midlet(m) {
  std::vector<uint8_t> probe;
  ok_ = readFile(Platform::dataDir + "/RP1", probe);
  CreateDirectoryA(Platform::saveDir.c_str(), nullptr);
  setViewSize(240, 320);
}

// ------------------------------------------------------------- lifecycle
// Engine.i(int): 0 start, 1 pause, 2 resume, 3 destroy, 5 first key after a resume.
void Engine::onLifecycle(int state) {
  if (state == 3) {
    if (soundPlayer) soundPlayer->shutdown();
    quit = true;
    midlet->notifyDestroyed();
  }
  if (state == 0 || state == 1 || state == 2) {
    clearBorders = true;
    resetFrameTiming_ = true;
    clearKeys();
  }
}

void Engine::hideNotify() { postLifecycle(1); }
void Engine::showNotify() { postLifecycle(2); }

// Engine.postLifecycle (old j(int)): destroy is immediate; pause/resume are queued and applied by
// processLifecycle() on the game thread. Pausing mutes the sound until the first key press after resume.
void Engine::postLifecycle(int s) {
  if (s == 3) {
    onLifecycle(3);
  } else if (started_ && (s == 1 || s == 2)) {
    if (s == 1) {
      resumed_ = false;
      if (!mutedByPause) {
        mutedByPause = true;
        soundBeforePause = soundEnabled;
        soundEnabled = false;
      }
    }
    pendingLifecycle_ = s;
    lifecycleTime_ = (double)GetTickCount64();
  }
}

// Engine.processLifecycle (old m()), made non-blocking: returns true while the game must not run.
bool Engine::processLifecycle(double nowMs) {
  if (pendingLifecycle_ != -1) {
    if (lifecycleState_ != 1) {
      if (soundPlayer) soundPlayer->stop();
      onLifecycle(1);
      lifecycleState_ = 1;
    }
    if (pendingLifecycle_ == 1) pendingLifecycle_ = -1;
    if (pendingLifecycle_ == 2) {
      if (!shown || nowMs - lifecycleTime_ < 750) return true;  // resume takes effect after 750 ms
      pendingLifecycle_ = -1;
      if (soundPlayer) soundPlayer->stop();
      onLifecycle(2);
      lifecycleState_ = 2;
      resumed_ = true;
    }
    if (pendingLifecycle_ != -1) return true;
  }
  if (pendingResume_) {
    pendingResume_ = false;
    onLifecycle(5);
  }
  return false;
}

void Engine::resetFrameTimer() {
  frameTime = minFrameTime;
  resetFrameTiming_ = true;
}

// One pass of Engine.run's loop body.
int Engine::runFrame(double nowMs, Surface& screen) {
  if (!started_) {
    started_ = true;
    onLifecycle(0);
  }
  if (processLifecycle(nowMs) || !shown) {
    resetFrameTiming_ = true;
    return 100;
  }
  // Engine.run's pacing, corrected. The original measures the time since the last step; if that is under
  // minFrameTime it sleeps (at least 10 ms) so the step is told exactly minFrameTime, and it then runs the
  // step. It also records the clock reading taken *before* the sleep as "the last step". On a 2007 phone
  // the work per frame alone exceeded 40 ms so the sleep never mattered, but on a fast machine it makes the
  // loop alternate between "sleep then step" and "step at once" (the sleep counts as elapsed time), i.e.
  // about 2 steps per 45 ms while every step is told 40 ms: the game runs ~1.8x too fast. Here the last-step
  // time is taken after the sleep, so the step period settles at minFrameTime (25 steps/s) and the game
  // is told the real time between steps. The sleep is returned to the caller; the step runs on the next call.
  if (sleeping_) {
    sleeping_ = false;
    frameTime = minFrameTime;
    lastFrameStart_ = nowMs;
  } else if (resetFrameTiming_) {
    resetFrameTiming_ = false;
    frameTime = minFrameTime;
    lastFrameStart_ = nowMs;
  } else {
    int dt = (int)(nowMs - lastFrameStart_);
    if (dt > 4000) postLifecycle(2);
    if (dt > maxFrameTime || dt < 0) dt = maxFrameTime;
    frameTime = dt;
    if (frameTime < minFrameTime) {
      sleeping_ = true;
      return std::max(minFrameTime - frameTime, 10);
    }
    lastFrameStart_ = nowMs;
  }
  tickCount++;
  try {
    update();
  } catch (const JavaException& e) {
    logJavaException("update", e);
  }
  if (soundPlayer) soundPlayer->run();
  if (quit) return 0;

  // The logical canvas width follows the resolution setting (widescreen): the game publishes it in
  // Game::viewW, the surface is resized to match and the game is told to redraw everything.
  if (screen.w != Game::viewW) {
    screen.resize(Game::viewW, 320);
    Game::redrawAll = true;
  }
  screen.resetTransform();
  bordersCleared = clearBorders;
  clearBorders = false;
  screen.resetClip();
  try {
    paintFrame(&screen);
  } catch (const JavaException& e) {
    logJavaException("render", e);
  }
  return 0;
}

// ------------------------------------------------------------- display
void Engine::setViewSize(int w, int h) {
  clearBorders = true;
  if (w <= 0) w = 240;
  if (h <= 0) h = 320;
  viewWidth = w;
  viewHeight = h;
  viewOffsetX = 240 - w;
  viewOffsetY = 320 - h;
  if (viewOffsetX < 0) viewOffsetX++;
  if (viewOffsetY < 0) viewOffsetY++;
  viewOffsetX >>= 1;
  viewOffsetY >>= 1;
}

void Engine::paintFrame(Graphics* g) {
  if (240 != viewWidth || 320 != viewHeight) {
    if (bordersCleared) {
      int v = (320 - viewHeight + 1) >> 1;
      g->setColor(0);
      if (v > 0) {
        if (viewOffsetY > 0) g->fillRect(0, 0, 240, viewOffsetY);
        g->fillRect(0, 320 - v, 240, v);
      }
      if ((v = (240 - viewWidth + 1) >> 1) > 0) {
        if (viewOffsetX > 0) g->fillRect(0, viewOffsetY, viewOffsetX, viewHeight);
        g->fillRect(240 - v, viewOffsetY, v, viewHeight);
      }
    }
    g->translate(viewOffsetX, viewOffsetY);
  }
  g->setClip(0, 0, viewWidth, viewHeight);
  render(g);
}

void Engine::setClip(Graphics* g, int x, int y, int w, int h) {
  if ((viewOffsetX | viewOffsetY) != 0) {
    if (x < 0) { w += x; x = 0; }
    int over;
    if ((over = x + w - viewWidth) > 0) w -= over;
    if (y < 0) { h += y; y = 0; }
    if ((over = y + h - viewHeight) > 0) h -= over;
  }
  g->setClip(x, y, w, h);
}

// ------------------------------------------------------------------ keys
void Engine::handleKey(int code, bool down) {
  if (!code) return;
  for (int i = 1; i < 32; i++) {
    if (g_keyCodeTable[i] != code) continue;
    int bit = 1 << i;
    if (down) {
      pendingPressed_ |= bit;
      downKeys_ |= bit;
      pendingReleased_ &= ~bit;
    } else {
      pendingReleased_ |= bit;
    }
  }
}

void Engine::keyPressed(int code) {
  if (mutedByPause && resumed_) {  // first key after a resume restores the sound
    mutedByPause = false;
    soundEnabled = soundBeforePause;
    pendingResume_ = true;
  }
  handleKey(code, true);
}

void Engine::keyReleased(int code) { handleKey(code, false); }

void Engine::platformKey(int code, bool down) {
  if (down) keyPressed(code);
  else keyReleased(code);
}

void Engine::clearKeys() {
  pendingPressed_ = 0;
  downKeys_ = 0;
  pendingReleased_ |= keysHeld;
  keysPressed = 0;
  keysHeld = 0;
}

void Engine::pollKeys() {
  keysPressed = pendingPressed_;
  pendingPressed_ = 0;
  pendingReleased_ &= downKeys_;
  downKeys_ &= ~pendingReleased_;
  keysHeld = keysPressed | downKeys_;
  pendingReleased_ = 0;
  pendingReleased_ |= downKeys_ & 939524096;  // soft keys release themselves next frame
  pendingReleased_ |= downKeys_ & 16;
}

// --------------------------------------------------------------- records
static std::string recPath(int id) { return Platform::saveDir + "/rec" + std::to_string(id) + ".bin"; }

Arr<int8_t> Engine::readRecord(int id) {
  FILE* f = std::fopen(recPath(id).c_str(), "rb");
  if (!f) return Arr<int8_t>();
  std::fseek(f, 0, SEEK_END);
  long n = std::ftell(f);
  std::fseek(f, 0, SEEK_SET);
  Arr<int8_t> out((int)n);
  size_t got = n ? std::fread(out.data(), 1, (size_t)n, f) : 0;
  std::fclose(f);
  return got == (size_t)n ? out : Arr<int8_t>();
}

bool Engine::writeRecord(int id, const Arr<int8_t>& data) {
  std::string p = recPath(id);
  std::remove(p.c_str());
  if (data == nullptr) return true;
  FILE* f = std::fopen(p.c_str(), "wb");
  if (!f) return false;
  bool ok = data.length() == 0 || std::fwrite(data.data(), 1, (size_t)data.length(), f) == (size_t)data.length();
  std::fclose(f);
  return ok;
}

// Record -9: 3 bytes = {sound on, unused, unused}; created as FF FF FF when missing.
void Engine::syncSettings(bool write) {
  if (!write && settingsLoaded_) return;
  if (write) {
    writeRecord(-9, Arr<int8_t>::make((uint8_t)soundEnabled, (uint8_t)optionByte_, 0));
    return;
  }
  settingsLoaded_ = true;
  Arr<int8_t> b = readRecord(-9);
  if (b == nullptr || b.length() != 3) {
    b = Arr<int8_t>::make(-1, -1, -1);
    writeRecord(-9, b);
  }
  soundEnabled = b[0] != 0;
  optionByte_ = b[1] != 0;
}

int Engine::parseIntOr(const String& s, int fallback) {
  if (s == nullptr) return fallback;
  const std::u16string& u = s.str();
  if (u.empty()) return fallback;
  size_t i = 0;
  bool neg = false;
  if (u[0] == u'-' || u[0] == u'+') { neg = u[0] == u'-'; i = 1; }
  if (i >= u.size()) return fallback;
  int64_t v = 0;
  for (; i < u.size(); i++) {
    if (u[i] < u'0' || u[i] > u'9') return fallback;
    v = v * 10 + (u[i] - u'0');
    if (v > 2147483648LL) return fallback;
  }
  v = neg ? -v : v;
  return v > INT_MAX || v < INT_MIN ? fallback : (int)v;
}

// Engine.sortInts: the comb sort of the original (gap shrinks by 197/256), on the first n entries.
void Engine::sortInts(const Arr<int>& a, int n) {
  int gap = n--;
  bool swapped;
  do {
    if (gap != 1) gap = gap * 197 >> 8;
    swapped = false;
    int i = n - gap;
    for (int j = n; i >= 0; j--) {
      if (a[i] > a[j]) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        swapped = true;
      }
      i--;
    }
  } while (swapped || gap > 1);
}

int Engine::binarySearch(const Arr<int>& a, int hi, int key) {
  int lo = 0;
  while (lo <= hi) {
    int mid = (lo + hi) >> 1;
    int v;
    if ((v = a[mid]) < key) {
      lo = mid + 1;
    } else {
      if (v <= key) return mid;
      hi = mid - 1;
    }
  }
  return hi + 1;
}

// -------------------------------------------------------------- resources
bool Engine::parseBank(DataInputStream* in) {
  resourceLengths_.clear();
  bankData_.clear();
  resourceTypes = Arr<int8_t>();
  if (in == nullptr) {
    loadedBank_ = -1;
    return false;
  }
  loadedBank_ = 0;
  try {
    int flags = in->read();
    int width = (1 + (flags & 1)) << 1;
    int count = in->readChar();
    Arr<int8_t> tmp(width * count);
    in->readFully(tmp);
    resourceLengths_.assign((size_t)count, 0);
    int p = 0;
    for (int i = 0; i < count; i++)
      for (int j = width - 1; j >= 0; j--) resourceLengths_[(size_t)i] |= (255 & tmp[p++]) << (j << 3);
    resourceTypes = Arr<int8_t>(count);
    in->readFully(resourceTypes);
    Arr<int8_t> data(in->readInt());
    in->readFully(data);
    bankData_.assign((const uint8_t*)data.data(), (const uint8_t*)data.data() + data.length());
    return true;
  } catch (const JavaException&) {
    return false;
  }
}

// Engine.selectBank (old m(int)): id >> 10 names /RP<bank>; bank 0 means "the one already loaded".
void Engine::selectBank(int id) {
  int bank = id >> 10;
  if (bank != 0 && bank != loadedBank_) {
    if (bank > 0) {
      std::vector<uint8_t> file;
      if (readFile(Platform::dataDir + "/RP" + std::to_string(bank), file)) {
        DataInputStream in(file.data(), (int)file.size());
        parseBank(&in);
      }
    } else {
      parseBank(nullptr);
    }
    loadedBank_ = bank;
  }
}

int Engine::resourceOffset(int index) {
  int o = 0;
  while (--index >= 0) o += resourceLengths_[(size_t)index];
  return o;
}

Arr<int8_t> Engine::getResourceBytes(int id) {
  selectBank(id);
  int i = id & 1023;
  Arr<int8_t> out(resourceLengths_.at((size_t)i));
  std::memcpy(out.data(), bankData_.data() + resourceOffset(i), (size_t)out.length());
  return out;
}

DataInputStream* Engine::openResource(int id) {
  selectBank(id);
  int i = id & 1023;
  return new DataInputStream(bankData_.data() + resourceOffset(i), resourceLengths_.at((size_t)i));
}

Image* Engine::loadImage(int id, const Arr<int8_t>& swap) {
  selectBank(id);
  int idx = id & 1023;
  std::string key = std::to_string(loadedBank_) + "/" + std::to_string(id);
  if (swap != nullptr) {
    uint32_t h = 2166136261u;
    for (int i = 0; i < swap.length(); i++) h = (h ^ (uint8_t)swap[i]) * 16777619u;
    key += ":" + std::to_string(h);
  }
  auto it = imageCache_.find(key);  // MIDP images are immutable, so one decoded copy is shared
  if (it != imageCache_.end()) return it->second;

  int off = resourceOffset(idx), len = resourceLengths_.at((size_t)idx);
  std::vector<uint8_t> png(bankData_.begin() + off, bankData_.begin() + off + len);
  if (swap != nullptr) {  // Engine.swapPngPalette: overwrite the bytes at the PLTE payload
    int p = 8;
    while (p + 8 <= (int)png.size()) {
      uint32_t clen = (uint32_t)png[p] << 24 | (uint32_t)png[p + 1] << 16 | (uint32_t)png[p + 2] << 8 | png[p + 3];
      uint32_t typ = (uint32_t)png[p + 4] << 24 | (uint32_t)png[p + 5] << 16 | (uint32_t)png[p + 6] << 8 | png[p + 7];
      p += 8;
      if (typ == 0x504C5445) {  // "PLTE"
        for (int i = 0; i < swap.length() && p + i < (int)png.size(); i++) png[(size_t)(p + i)] = (uint8_t)swap[i];
        break;
      }
      if (typ == 0x49444154) break;  // "IDAT": no palette
      p += (int)clen + 4;
    }
  }
  Image* im = nullptr;
  int w, h, comp;
  unsigned char* px = stbi_load_from_memory(png.data(), (int)png.size(), &w, &h, &comp, 4);
  if (px) {
    im = new Image();
    im->w = w;
    im->h = h;
    im->px.resize((size_t)w * (size_t)h);
    for (int i = 0; i < w * h; i++)
      im->px[(size_t)i] = (uint32_t)px[i * 4 + 3] << 24 | (uint32_t)px[i * 4] << 16 | (uint32_t)px[i * 4 + 1] << 8 | px[i * 4 + 2];
    stbi_image_free(px);
  }
  imageCache_[key] = im;
  return im;
}

// Engine.loadSprites: the atlas format of docs/ASSET_FORMATS.md.
Arr<Sprite*> Engine::loadSprites(int id, const Arr<int8_t>& swap) {
  try {
    selectBank(id);
    int idx = id & 1023;
    DataInputStream in(bankData_.data() + resourceOffset(idx), resourceLengths_.at((size_t)idx));
    int imageId = in.readChar();
    in.readByte();
    Arr<int8_t> data(in.readShort() - 4);
    int mask = in.readChar();
    int count = in.readChar();
    in.readFully(data);
    bool present[16];
    for (int i = 0; i < 16; i++) present[i] = (mask >> i & 1) == 0;
    int sizes[10], bit = 5, k = 0;
    for (int g = 0; g < 3; g++)
      for (int j = 0; j < (g == 0 ? 2 : 4); j++) sizes[k++] = present[g] ? (present[bit++] ? 2 : 1) : 0;
    Image* img = loadImage(imageId, swap);
    if (!img) return Arr<Sprite*>();
    Arr<Sprite*> out(count);
    Arr<int16_t> v(10);
    for (int i = 0; i < count; i++) {
      out[i] = new Sprite(img);
      int pos = 0;
      for (int f = 0; f < 10; f++) {
        int val = 0, s = sizes[f] - 1;
        if (s >= 0) {
          pos += i << s;
          if (s == 0) {
            val = data[pos];
            if (f > 1 && f != 6 && f != 7) val &= 255;
          } else {
            val = (data[pos] & 255) << 8 | (data[pos + 1] & 255);
          }
          pos += (count - i) << s;
        }
        v[f] = (int16_t)val;
      }
      out[i]->load(v);
    }
    return out;
  } catch (const JavaException&) {
    return Arr<Sprite*>();
  }
}

String Engine::getString(int i) {
  try {
    int a = stringOffsets_.at((size_t)i), b = stringOffsets_.at((size_t)i + 1);
    return String::fromUtf8(std::string((const char*)stringBytes_.data() + a, (size_t)(b - a)));
  } catch (const std::out_of_range&) {
    return String(nullptr);
  }
}

void Engine::loadStringTable(int id) {
  if (id == -1) {
    stringBytes_.clear();
    stringOffsets_.clear();
    return;
  }
  try {
    selectBank(id);
    int idx = id & 1023;
    DataInputStream in(bankData_.data() + resourceOffset(idx), resourceLengths_.at((size_t)idx));
    int n = in.readShort();
    stringOffsets_.assign((size_t)n + 1, 0);
    stringBytes_.assign((size_t)(resourceLengths_[(size_t)idx] - (n + 1) * 2), 0);
    int off = 0, i;
    for (i = 0; i < n; i++) {
      stringOffsets_[(size_t)i] = off;
      int len = in.readShort();
      if (len > 0) {
        Arr<int8_t> tmp(len);
        in.readFully(tmp);
        std::memcpy(stringBytes_.data() + off, tmp.data(), (size_t)len);
      }
      off += len;
    }
    stringOffsets_[(size_t)i] = off;
  } catch (const JavaException&) {
  }
}

// ------------------------------------------------------------------- font
void Engine::setFont(const Arr<Sprite*>& font) {
  font_ = font;
  if (font_ != nullptr && font[3]->metric == 255) {  // a font atlas stores delta-coded character codes
    font[3]->metric = 0;
    int16_t acc = 0;
    for (int i = 0; i < font.length(); i++) {
      Sprite* s = font[i];
      acc = (int16_t)(acc + (s->offsetX << 8) + (s->offsetY & 255));
      s->offsetX = s->charCode;
      s->offsetY = s->f;
      s->charCode = acc;
    }
  }
}

Sprite* Engine::findGlyph(char16_t c) {
  int lo = 0, hi = font_.length() - 1;
  while (lo <= hi) {
    int mid = (lo + hi) >> 1;
    char16_t v = (char16_t)font_[mid]->charCode;
    if (v < c) lo = mid + 1;
    else if (v > c) hi = mid - 1;
    else return font_[mid];
  }
  return nullptr;
}

int Engine::stringWidth(const String& s, int off, int len) {
  Arr<char16_t> a(len);
  for (int i = 0; i < len; i++) a[i] = s.charAt(off + i);
  return charsWidth(a, 0, len);
}

int Engine::charWidth(char16_t c) {
  Arr<char16_t> a = Arr<char16_t>::make(c);
  return charsWidth(a, 0, 1);
}

int Engine::charsWidth(const Arr<char16_t>& s, int off, int len) {
  if (font_ == nullptr) return len * 6;
  len += off;
  int16_t total = 0;
  for (int i = off; i < len; i++) {
    Sprite* g = findGlyph(s[i]);
    total = (int16_t)(total + (g ? g->advance : font_[2]->metric));
  }
  return total;
}

int Engine::fontBaseline() { return font_ != nullptr ? font_[1]->metric : 10; }
int Engine::fontHeight() { return font_ != nullptr ? font_[0]->metric : 12; }

void Engine::drawString(Graphics* g, const String& s, int off, int len, int x, int y, int anchor) {
  Arr<char16_t> a(len);
  for (int i = 0; i < len; i++) a[i] = s.charAt(off + i);
  drawString(g, a, 0, len, x, y, anchor);
}

void Engine::drawString(Graphics* g, const Arr<char16_t>& s, int off, int len, int x, int y, int anchor) {
  if (anchor & 64) y -= fontBaseline();
  else if (anchor & 32) y -= fontHeight();
  if (anchor & 9) x -= charsWidth(s, off, len) >> (anchor & 1);
  if (font_ == nullptr) return;
  for (int end = len + off; off < end; off++) {
    Sprite* gl = findGlyph(s[off]);
    if (gl) {
      gl->draw(g, x, y, 0);
      x += gl->advance;
    } else {
      x += font_[2]->metric;
    }
  }
}

// ---------------------------------------------------------- animation sets
int Engine::readUnsigned() {
  int v = loaderStream_->read();
  return v == 255 ? (int)loaderStream_->readChar() : v;
}

int Engine::readSigned() {
  int v = loaderStream_->readByte();
  return v == -128 ? (int)loaderStream_->readShort() : v;
}

// Reads a run-length column: entry i = (sum of previous counts) << 16 | count_i. Returns the total.
int Engine::readRunLengths(std::vector<int>& v) {
  int sum = 0;
  for (size_t i = 0; i < v.size(); i++) {
    int c = readUnsigned();
    v[i] = shl(sum, 16) | c;
    sum += c;
  }
  return sum;
}

// Three packed columns: sprite/frame id << 22, then x and y as 10-bit signed values at bits 12 and 2.
void Engine::readPackedOffsets(std::vector<int>& v) {
  for (size_t i = 0; i < v.size(); i++) v[i] |= shl(readUnsigned(), 22);
  for (size_t i = 0; i < v.size(); i++) v[i] |= ushr(shl(readSigned(), 22), 10);
  for (size_t i = 0; i < v.size(); i++) v[i] |= ushr(shl(readSigned(), 22), 20);
}

void Engine::loadAnimSet(int id) {
  for (int16_t s : animSetIds_)
    if (id == (s & 32767)) return;  // already loaded
  animSetIds_.push_back((int16_t)id);
  size_t set = animSetIds_.size() - 1;
  animHeaders_.emplace_back();
  animFrameTiming_.emplace_back();
  animFrames_.emplace_back();
  boxStart_.emplace_back();
  frameHeaders_.emplace_back();
  frameParts_.emplace_back();
  boxPos_.emplace_back();
  boxSize_.emplace_back();
  frameDurations_.emplace_back();
  try {
    selectBank(id);
    int idx = id & 1023;
    DataInputStream in(bankData_.data() + resourceOffset(idx), resourceLengths_.at((size_t)idx));
    loaderStream_ = &in;
    in.read();
    int nAnims = in.readChar();
    std::vector<int>& headers = animHeaders_[set];
    headers.assign((size_t)nAnims, 0);
    int steps = readRunLengths(headers);
    for (int i = 0; i < nAnims; i++) headers[(size_t)i] |= shl(63 & readSigned(), 10);  // loop count
    animFrameTiming_[set].assign((size_t)steps, 0);
    animFrames_[set].assign((size_t)steps, 0);
    for (int i = 0; i < steps; i++) {
      int v = readUnsigned();
      animFrameTiming_[set][(size_t)i] = (int8_t)v;
      animFrames_[set][(size_t)i] = v >> 8;
    }
    readPackedOffsets(animFrames_[set]);
    int nFrames = in.readChar();
    boxStart_[set].assign((size_t)nFrames, 0);
    frameHeaders_[set].assign((size_t)nFrames, 0);
    int parts = readRunLengths(frameHeaders_[set]);
    frameParts_[set].assign((size_t)parts, 0);
    int bits = 0, v = 0;
    for (int i = 0; i < parts; i++) {  // 2-bit flip flags, four per byte
      if (bits == 0) {
        v = readUnsigned();
        bits = 8;
      }
      bits -= 2;
      frameParts_[set][(size_t)i] = 3 & v >> bits;
    }
    readPackedOffsets(frameParts_[set]);
    int boxes = 0;
    for (int i = 0; i < nFrames; i++) {
      int c = readUnsigned();
      frameHeaders_[set][(size_t)i] |= shl(c, 8);
      boxStart_[set][(size_t)i] = (uint16_t)boxes;
      boxes += c;
    }
    boxPos_[set].assign((size_t)boxes, 0);
    boxSize_[set].assign((size_t)boxes, 0);
    for (int i = 0; i < boxes; i++) boxPos_[set][(size_t)i] = shl(readSigned(), 21);
    for (int i = 0; i < boxes; i++) boxPos_[set][(size_t)i] |= ushr(shl(readSigned(), 21), 11);
    for (int i = 0; i < boxes; i++) boxPos_[set][(size_t)i] |= readUnsigned();
    for (int i = 0; i < boxes; i++) boxSize_[set][(size_t)i] = (uint16_t)(readUnsigned() << 6);
    for (int i = 0; i < boxes; i++) boxSize_[set][(size_t)i] |= (uint16_t)readUnsigned();
    int nDur = in.readChar();
    frameDurations_[set].assign((size_t)nDur, 0);
    for (int i = 0; i < nDur; i++) frameDurations_[set][(size_t)i] = (uint16_t)readUnsigned();
  } catch (const JavaException&) {
  }
  loaderStream_ = nullptr;
}

void Engine::setAnimSetPersistent(int id, bool persistent) {
  size_t i = 0;
  while (id != (animSetIds_.at(i) & 32767)) i++;
  animSetIds_[i] = persistent ? (int16_t)(animSetIds_[i] | 0x8000) : (int16_t)(animSetIds_[i] & 32767);
}

// Keeps only the persistent sets (bit 15 of their id); with none left everything is dropped.
void Engine::releaseTransientAnimSets() {
  std::vector<size_t> keep;
  for (size_t i = 0; i < animSetIds_.size(); i++)
    if (animSetIds_[i] < 0) keep.push_back(i);
  auto pick = [&](auto& v) {
    auto old = v;
    v.clear();
    for (size_t k : keep) v.push_back(old[k]);
  };
  if (!keep.empty()) {
    pick(animSetIds_);
    pick(animHeaders_);
    pick(animFrameTiming_);
    pick(animFrames_);
    pick(boxStart_);
    pick(frameHeaders_);
    pick(frameParts_);
    pick(boxPos_);
    pick(boxSize_);
    pick(frameDurations_);
  } else {
    animSetIds_.clear();
    animHeaders_.clear();
    animFrameTiming_.clear();
    animFrames_.clear();
    boxStart_.clear();
    frameHeaders_.clear();
    frameParts_.clear();
    boxPos_.clear();
    boxSize_.clear();
    frameDurations_.clear();
    animSlots_.clear();
  }
}

void Engine::growAnimSlots(int shorts) {
  if ((int)animSlots_.size() < shorts) animSlots_.resize((size_t)shorts, 0);
}

void Engine::ensureAnimSlots(int n) { growAnimSlots(n * 8); }

// Slot layout (8 shorts): set, anim, step, loops left, time in step, x, y, best step.
void Engine::startAnim(int slot, int setId, int anim) {
  int set = 0;
  while (setId != (animSetIds_.at((size_t)set) & 32767)) set++;
  slot *= 8;
  growAnimSlots(slot + 8);
  int16_t* s = &animSlots_[(size_t)slot];
  s[0] = (int16_t)set;
  s[1] = (int16_t)anim;
  s[2] = 0;
  s[3] = (int16_t)shr(shl(animHeaders_[(size_t)set].at((size_t)anim), 16), 26);  // signed 6-bit loop count
  s[4] = s[5] = s[6] = s[7] = 0;
}

void Engine::copyAnimSlot(int src, int dst) {
  src *= 8;
  dst *= 8;
  growAnimSlots(dst + 8);
  std::memmove(&animSlots_[(size_t)dst], &animSlots_[(size_t)src], 8 * sizeof(int16_t));
}

bool Engine::stepAnim(int slot, int dt) {
  size_t b = (size_t)slot * 8;
  int loops = animSlots_.at(b + 3);
  if (loops == 0) {
    animDeltaX = 0;
    animDeltaY = 0;
    return false;
  }
  size_t set = (size_t)animSlots_[b + 0];
  int step = animSlots_[b + 2];
  dt += (uint16_t)animSlots_[b + 4];
  int px = animSlots_[b + 5];
  int py = animSlots_[b + 6];
  const std::vector<int>& frames = animFrames_[set];
  const std::vector<int8_t>& timing = animFrameTiming_[set];
  int header = animHeaders_[set].at((size_t)animSlots_[b + 1]);
  int first = ushr(header, 16);
  int count = header & 1023;
  int best = step;
  int bestPri = step == animSlots_[b + 7] ? 0 : timing.at((size_t)(first + best)) >> 6 & 3;
  int dur;
  while (dt >= (dur = frameDurations_[set].at((size_t)(timing.at((size_t)(first + step)) & 63)))) {
    dt -= dur;
    if (++step == count) {
      if (loops > 0) {
        if (--loops == 0) {
          step--;
          dt = dur;
          break;
        }
      }
      step = 0;
      int last = frames.at((size_t)(first + count - 1));
      px -= shr(shl(last, 10), 22);
      py -= shr(shl(last, 20), 22);
    }
    int pri = timing.at((size_t)(first + step)) >> 6 & 3;
    if (pri >= bestPri) {
      bestPri = pri;
      best = step;
    }
  }
  int f = frames.at((size_t)(first + step));
  int x = shr(shl(f, 10), 22);
  int y = shr(shl(f, 20), 22);
  if ((f & 3) > 0 && loops != 0 && (step + 1 != count || loops != 1)) {  // interpolate towards the next step
    int nx, ny, nextIdx;
    if (step + 1 == count) {
      nx = x;
      ny = y;
      nextIdx = 0;
    } else {
      nx = ny = 0;
      nextIdx = step + 1;
    }
    int nf = frames.at((size_t)(first + nextIdx));
    nx += shr(shl(nf, 10), 22);
    ny += shr(shl(nf, 20), 22);
    int k = (dt << 12) / dur;
    x += (nx - x) * k >> 12;
    y += (ny - y) * k >> 12;
  }
  animDeltaX = x - px;
  animDeltaY = y - py;
  animSlots_[b + 2] = (int16_t)step;
  animSlots_[b + 3] = (int16_t)loops;
  animSlots_[b + 4] = (int16_t)dt;
  animSlots_[b + 5] = (int16_t)x;
  animSlots_[b + 6] = (int16_t)y;
  animSlots_[b + 7] = (int16_t)best;
  return loops != 0;
}

// The frame id of a slot's current step (also selects the set in currentSet_).
int Engine::resolveFrame(int slot) {
  slot *= 8;
  currentSet_ = animSlots_.at((size_t)slot + 0);
  int anim = animSlots_[(size_t)slot + 1];
  int step = ushr(animHeaders_[(size_t)currentSet_].at((size_t)anim), 16) + animSlots_[(size_t)slot + 7];
  return ushr(animFrames_[(size_t)currentSet_].at((size_t)step), 22);
}

void Engine::getFrameBounds(const Arr<Sprite*>& sp, int slot, int x, int y, int flip, const Arr<int>& out) {
  int frame = resolveFrame(slot);
  int fh = frameHeaders_[(size_t)currentSet_].at((size_t)frame);
  int p = ushr(fh, 16);
  const std::vector<int>& parts = frameParts_[(size_t)currentSet_];
  int end = p + (fh & 0xFF);
  int minX = INT_MAX, minY = INT_MAX, maxX = INT_MIN, maxY = INT_MIN;
  while (p < end) {
    int part = parts.at((size_t)p++);
    int f = part & 3 ^ flip;
    Sprite* s = sp[ushr(part, 22)];
    int px = s->offsetX + shr(shl(part, 10), 22);
    if ((f & 2) != 0) px = -(px + s->width);
    int py = s->offsetY + shr(shl(part, 20), 22);
    if ((f & 1) != 0) py = -(py + s->height);
    minX = std::min(minX, px);
    minY = std::min(minY, py);
    maxX = std::max(maxX, px + s->width);
    maxY = std::max(maxY, py + s->height);
  }
  out[0] = x + minX;
  out[1] = y + minY;
  out[2] = maxX - minX;
  out[3] = maxY - minY;
}

int Engine::getFrameParts(const Arr<int16_t>& out, int slot, int flip) {
  int frame = resolveFrame(slot);
  int fh = frameHeaders_[(size_t)currentSet_].at((size_t)frame);
  int p = ushr(fh, 16);
  const std::vector<int>& parts = frameParts_[(size_t)currentSet_];
  int n = fh & 0xFF;
  int end = p + n, o = 0;
  while (p < end && o + 3 < out.length()) {
    int part = parts.at((size_t)p++);
    out[o++] = (int16_t)ushr(part, 22);
    int f = part & 3 ^ flip;
    out[o++] = (int16_t)(((f & 2) == 0 ? 1 : -1) * shr(shl(part, 10), 22));
    out[o++] = (int16_t)(((f & 1) == 0 ? 1 : -1) * shr(shl(part, 20), 22));
    out[o++] = (int16_t)f;
  }
  return n;
}

int Engine::getFrameBoxes(const Arr<int16_t>& out, int slot, int flip) {
  int frame = resolveFrame(slot);
  int b = boxStart_[(size_t)currentSet_].at((size_t)frame);
  int n = frameHeaders_[(size_t)currentSet_][(size_t)frame] >> 8 & 0xFF;
  int end = b + n, o = 0;
  while (b < end && o + 4 < out.length()) {
    int pos = boxPos_[(size_t)currentSet_].at((size_t)b);
    int x = shr(pos, 21);
    int y = shr(shl(pos, 11), 21);
    int w = pos & 1023;
    int sz = boxSize_[(size_t)currentSet_].at((size_t)b++);
    int h = sz >> 6;
    int type = sz & 63;
    if ((flip & 2) != 0) x = -(x + w);
    if ((flip & 1) != 0) y = -(y + h);
    out[o++] = (int16_t)x;
    out[o++] = (int16_t)y;
    out[o++] = (int16_t)w;
    out[o++] = (int16_t)h;
    out[o++] = (int16_t)type;
  }
  return n;
}

void Engine::drawFrame(Graphics* g, const Arr<Sprite*>& sp, int slot, int x, int y, int flip) {
  drawFrameNow(g, sp, resolveFrame(slot), x, y, flip);
}

void Engine::drawFrameNow(Graphics* g, const Arr<Sprite*>& sp, int frame, int x, int y, int flip) {
  int fh = frameHeaders_[(size_t)currentSet_].at((size_t)frame);
  int p = ushr(fh, 16);
  const std::vector<int>& parts = frameParts_[(size_t)currentSet_];
  int end = p + (fh & 0xFF);
  while (p < end) {
    int part = parts.at((size_t)p++);
    int dx = shr(shl(part, 10), 22);
    int dy = shr(shl(part, 20), 22);
    Sprite* s = sp[ushr(part, 22)];
    s->offsetX = (int16_t)(s->offsetX + dx);
    s->offsetY = (int16_t)(s->offsetY + dy);
    s->draw(g, x, y, part & 3 ^ flip);
    s->offsetX = (int16_t)(s->offsetX - dx);
    s->offsetY = (int16_t)(s->offsetY - dy);
  }
}

}  // namespace gow
