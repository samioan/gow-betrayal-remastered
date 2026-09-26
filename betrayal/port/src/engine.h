// Port of Engine.java (betrayal/src/Engine.java, old class `a`): the GameCanvas base class of
// God of War: Betrayal. Frame timing and lifecycle, key state, the RMS-style record store, the
// RP<n> resource banks, bitmap-font text and the animation-set runtime.
//
// Member names and signatures match the renamed Java so the code translated by tools/java2cpp.py
// (gen/) compiles against this unchanged; the arithmetic below follows the Java line by line
// (the animation runtime packs several values per int -- see docs/CLASS_MAP.md, "Animation data
// model"). The threads of the original (game loop, lifecycle timing) become explicit per-frame
// state machines driven by runFrame().
#pragma once
#include <cstdint>
#include <map>
#include <string>
#include <vector>

#include "gfx.h"
#include "jrt.h"
#include "platform.h"

namespace gow {

using Graphics = Surface;

// Sprite.java: one rectangle of an atlas image plus its draw offset.
class Sprite {
 public:
  explicit Sprite(Image* sheet) : sheet(sheet) {}
  void load(const Arr<int16_t>& v) {
    offsetX = v[0]; offsetY = v[1]; srcX = v[2]; srcY = v[3]; width = v[4]; height = v[5];
    charCode = v[6]; f = v[7]; advance = v[8]; metric = v[9];
  }
  void draw(Graphics* g, int x, int y, int trans);
  int anchorOffsetX(int flags) const { return (flags & 2) == 0 ? offsetX : -(offsetX + width); }
  int anchorOffsetY(int flags) const { return (flags & 1) == 0 ? offsetY : -(offsetY + height); }
  int16_t offsetX = 0, offsetY = 0, width = 0, height = 0, charCode = 0, f = 0, advance = 0, metric = 0;
  int16_t srcX = 0, srcY = 0;
  Image* sheet;
};

class SoundPlayer;

class Engine {
 public:
  explicit Engine(MIDlet* midlet);
  virtual ~Engine() = default;

  virtual void render(Graphics* g) = 0;
  virtual void update() = 0;
  virtual void onLifecycle(int state);  // 0 start, 1 pause, 2 resume, 3 destroy, 5 resume-input

  // ---- the port's frame driver (replaces Engine.run's thread)
  bool ok() const { return ok_; }
  bool quit = false;
  bool shown = true;  // false while the window is hidden/unfocused (Canvas.isShown)
  // One iteration of the game loop body. `nowMs` is a monotonic clock. Returns the number of
  // milliseconds the caller should sleep before the next call.
  int runFrame(double nowMs, Surface& screen);
  void hideNotify();
  void showNotify();
  void postLifecycle(int s);
  long tickCount = 0;   // logic steps run
  long paintCount = 0;  // frames drawn

  // ---- render interpolation (the FPS option): logic still runs at 1000/minFrameTime steps per second; extra
  // frames are drawn with the moving objects' positions blended between the previous and the current step.
  // Game overrides these three (tools/gow_port_patches.py). `interpAlpha` is 0..255 through the current step.
  virtual void interpSnapshot() {}                  // called just before every logic step
  virtual bool interpApply(int alpha) { (void)alpha; return false; }  // write blended positions; false = nothing to blend
  virtual void interpRestore() {}                   // put the real positions back after drawing
  static inline int interpAlpha = 256;
  static inline bool tickFrame = true;              // false on the extra (interpolated) frames

  MIDlet* midlet;
  SoundPlayer* soundPlayer = nullptr;
  bool soundEnabled = false, soundBeforePause = false, mutedByPause = false;
  Arr<int8_t> resourceTypes;

  // ---- frame timing (ms)
  int frameTime = 10, minFrameTime = 10, maxFrameTime = 100;
  void resetFrameTimer();
  void resetFrameTimerAlias() { resetFrameTimer(); }

  // ---- input (Engine.keysHeld / keysPressed are read by Game every frame)
  int keysHeld = 0, keysPressed = 0;
  void platformKey(int midpKeyCode, bool down);
  void pollKeys();
  void clearKeys();

  // ---- records (RMS replacement: one file per record id)
  static Arr<int8_t> readRecord(int id);
  static bool writeRecord(int id, const Arr<int8_t>& data);
  void syncSettings(bool write);
  static int parseIntOr(const String& s, int fallback);
  static void sortInts(const Arr<int>& a, int n);
  static int binarySearch(const Arr<int>& a, int hi, int key);

  // ---- resources (RP<n> banks)
  Arr<Sprite*> loadSprites(int id) { return loadSprites(id, Arr<int8_t>()); }
  Arr<Sprite*> loadSprites(int id, const Arr<int8_t>& swap);
  Image* loadImage(int id, const Arr<int8_t>& swap);
  Image* loadImageAlias(int id, const Arr<int8_t>& swap) { return loadImage(id, swap); }
  Arr<int8_t> getResourceBytes(int id);
  Arr<int8_t> getResourceBytesAlias(int id) { return getResourceBytes(id); }
  DataInputStream* openResource(int id);
  String getString(int i);
  void loadStringTable(int id);
  bool parseBank(DataInputStream* in);
  bool parseBankAlias(DataInputStream* in) { return parseBank(in); }

  // ---- display / clipping
  int bordersClearedFlag() const { return bordersCleared ? 1 : 0; }
  bool bordersCleared = false;
  void setViewSize(int w, int h);
  void resetClip(Graphics* g) { setClip(g, 0, 0, viewWidth, viewHeight); }
  void setClip(Graphics* g, int x, int y, int w, int h);
  void requestClear() { clearBorders = true; }
  static void drawRgb(Graphics* g, const Arr<int>& rgb, int off, int scan, int x, int y, int w, int h, bool alpha) {
    g->drawRGB(rgb, off, scan, x, y, w, h, alpha);
  }
  static void drawRgbAlias(Graphics* g, const Arr<int>& rgb, int off, int scan, int x, int y, int w, int h, bool alpha) {
    drawRgb(g, rgb, off, scan, x, y, w, h, alpha);
  }
  static void drawImageRegion(Image* img, int sx, int sy, int w, int h, Graphics* g, int dx, int dy) {
    g->drawRegion(img, sx, sy, w, h, 0, dx, dy, 20);
  }

  // ---- bitmap font
  void setFont(const Arr<Sprite*>& font);
  int stringWidth(const String& s) { return stringWidth(s, 0, s.length()); }
  int stringWidth(const String& s, int off, int len);
  int charWidth(char16_t c);
  int charsWidth(const Arr<char16_t>& s, int off, int len);
  int fontBaseline();
  int fontHeight();
  void drawString(Graphics* g, const String& s, int x, int y, int anchor) { drawString(g, s, 0, s.length(), x, y, anchor); }
  void drawString(Graphics* g, const String& s, int off, int len, int x, int y, int anchor);
  void drawString(Graphics* g, const Arr<char16_t>& s, int off, int len, int x, int y, int anchor);

  // ---- animation sets (Engine.loadAnimSet and friends)
  int animDeltaX = 0, animDeltaY = 0;  // movement of the last stepAnim, in pixels
  void loadAnimSet(int id);
  void setAnimSetPersistent(int id, bool persistent);
  void releaseTransientAnimSets();
  void releaseAnimSetsAlias() { releaseTransientAnimSets(); }
  void ensureAnimSlots(int n);
  void startAnim(int slot, int setId, int anim);
  void copyAnimSlot(int src, int dst);
  bool stepAnim(int slot, int dt);
  void getFrameBounds(const Arr<Sprite*>& sp, int slot, int x, int y, int flip, const Arr<int>& out);
  int getFrameParts(const Arr<int16_t>& out, int slot, int flip);
  int getFrameBoxes(const Arr<int16_t>& out, int slot, int flip);
  void drawFrame(Graphics* g, const Arr<Sprite*>& sp, int slot, int x, int y, int flip);
  void drawFrameNow(Graphics* g, const Arr<Sprite*>& sp, int frame, int x, int y, int flip);

 private:
  // Java's per-set arrays, indexed by position in animSetIds_.
  std::vector<int16_t> animSetIds_;                        // id | 0x8000 when persistent
  std::vector<std::vector<int>> animHeaders_, animFrames_, frameHeaders_, frameParts_, boxPos_;
  std::vector<std::vector<int8_t>> animFrameTiming_;
  std::vector<std::vector<uint16_t>> boxStart_, boxSize_, frameDurations_;
  std::vector<int16_t> animSlots_;                         // 8 shorts per slot
  int currentSet_ = 0;
  DataInputStream* loaderStream_ = nullptr;
  int resolveFrame(int slot);
  int readRunLengths(std::vector<int>& v);
  void readPackedOffsets(std::vector<int>& v);
  int readUnsigned();
  int readSigned();
  void growAnimSlots(int shorts);

  // Resource banks.
  int loadedBank_ = -1;
  std::vector<int> resourceLengths_;
  std::vector<uint8_t> bankData_;
  void selectBank(int id);
  int resourceOffset(int index);
  std::vector<uint8_t> stringBytes_;
  std::vector<int> stringOffsets_;
  std::map<std::string, Image*> imageCache_;

  // Font.
  Arr<Sprite*> font_;
  Sprite* findGlyph(char16_t c);

  // Keys.
  int pendingPressed_ = 0, downKeys_ = 0, pendingReleased_ = 0;
  bool resumed_ = false, pendingResume_ = false;
  void handleKey(int code, bool down);
  void keyPressed(int code);
  void keyReleased(int code);

  // Frame driver / lifecycle.
  bool ok_ = false;
  bool started_ = false, resetFrameTiming_ = true, clearBorders = true, sleeping_ = false;
  double lastFrameStart_ = 0, lifecycleTime_ = 0, lastTick_ = 0, nextFrame_ = 0;
  int lastFpsMode_ = 0;
  int runInterpolated(double nowMs, Surface& screen, int fps);
  int pendingLifecycle_ = -1, lifecycleState_ = 2;
  bool settingsLoaded_ = false, optionByte_ = false;
  int viewWidth = 240, viewHeight = 320, viewOffsetX = 0, viewOffsetY = 0;
  void paintFrame(Graphics* g);
  bool processLifecycle(double nowMs);  // true while the game must not run
};

}  // namespace gow
