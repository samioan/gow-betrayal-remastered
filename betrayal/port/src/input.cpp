#include "input.h"

#include <windows.h>
#include <xinput.h>

#include <cstring>

namespace input {

namespace {

void (*g_down)(int) = nullptr;
void (*g_up)(int) = nullptr;
int g_held[256];  // per physical source: the MIDP code currently held down (0 = none)
constexpr int kPadBase = 0;   // indices 0..255 are virtual keys; the pad uses a separate table below
int g_pad[16];
WORD g_padPrev = 0;
bool g_padDir[4];

constexpr int kUp = -1, kDown = -2, kLeft = -3, kRight = -4, kFire = -5, kSoftL = -6, kSoftR = -7, kStar = 42, kHash = 35;

int codeFor(unsigned vk) {
  switch (vk) {
    case VK_UP: case 'W': return kUp;
    case VK_DOWN: case 'S': return kDown;
    case VK_LEFT: case 'A': return kLeft;
    case VK_RIGHT: case 'D': return kRight;
    case VK_SPACE: case 'J': case 'Z': case VK_RETURN: case VK_LBUTTON: return kFire;
    case 'K': case 'X': case 'Q': case 'E': case VK_RBUTTON: return kSoftL;
    case VK_ESCAPE: case 'P': case VK_BACK: return kSoftR;
    case VK_TAB: case 'U': return kHash;
    case VK_MULTIPLY: return kStar;
    default: break;
  }
  if (vk >= '0' && vk <= '9') return (int)vk;
  if (vk >= VK_NUMPAD0 && vk <= VK_NUMPAD9) return (int)('0' + (vk - VK_NUMPAD0));
  return 0;
}

}  // namespace

void init(void (*keyDown)(int), void (*keyUp)(int)) {
  g_down = keyDown;
  g_up = keyUp;
  std::memset(g_held, 0, sizeof g_held);
  std::memset(g_pad, 0, sizeof g_pad);
}

void keyEvent(unsigned vk, bool down, bool isRepeat) {
  if (vk >= 256) return;
  int code = codeFor(vk);
  if (!code) return;
  if (down) {
    if (isRepeat || g_held[vk]) return;
    g_held[vk] = code;
    if (g_down) g_down(code);
  } else if (g_held[vk]) {
    int c = g_held[vk];
    g_held[vk] = 0;
    if (g_up) g_up(c);
  }
}

void releaseAll() {
  for (int i = 0; i < 256; i++)
    if (g_held[i]) {
      int c = g_held[i];
      g_held[i] = 0;
      if (g_up) g_up(c);
    }
  for (int i = 0; i < 16; i++)
    if (g_pad[i]) {
      int c = g_pad[i];
      g_pad[i] = 0;
      if (g_up) g_up(c);
    }
  g_padPrev = 0;
}

// Face buttons follow a modern layout, echoing the original PS2 God of War's own (Square = fast
// attack, Circle = grab/context, X = jump, R1 = change magic) while `inMenu` is false: A jumps, X
// attacks, B grabs/blocks (an explicit alias for holding Down, which already means "interact" --
// see Game.readPressedKey's pressedKey 6), Y and the right shoulder both cycle weapons/magic, the
// left shoulder and Back both open the upgrade screen, Start pauses on its own. Every slot ORs its
// physical sources together before the down/up edge is detected once, the same pattern the d-pad/
// stick rows already used -- two sources sharing one MIDP code must never edge-detect separately, or
// releasing one while the other is still held would send a spurious key-up (Engine::handleKey tracks
// state per code, not per physical source).
//
// While `inMenu` is true (any screen but the level itself -- see main.cpp's `Game::state != 100`),
// jump and grab have no meaning, so A and B switch to the standard console convention instead: A
// (Cross) confirms/selects, B (Circle) backs out/exits, matching the original phone's own left/right
// soft-key labels (Select, Exit; Yes, No on the audio prompt) the game already draws in that corner.
// A is aliased onto the left soft key only, never fire, even though most menus accept either: Game's
// own readPressedKey() resolves a frame where both bits are held by priority, fire over the left soft
// key, and the audio prompt (Game's `case 79`) reads only the soft key -- aliasing A to both, as an
// earlier version of this code did, made every A press resolve to fire and silently dropped the soft
// key screens read. They are excluded from the d-pad's up/down slots in this mode so a single press
// cannot both move the menu cursor and confirm the entry it lands on; X (still fire outside this
// alias), Y/right shoulder (still the left soft key outside it) and Start (already the right soft key,
// i.e. back, everywhere) are unaffected and keep working the same in both modes.
void poll(bool inMenu) {
  XINPUT_STATE st;
  std::memset(&st, 0, sizeof st);
  if (XInputGetState(0, &st) != ERROR_SUCCESS) return;
  const XINPUT_GAMEPAD& p = st.Gamepad;
  const int dead = 12000;
  bool stickUp = p.sThumbLY > dead, stickDown = p.sThumbLY < -dead, stickLeft = p.sThumbLX < -dead, stickRight = p.sThumbLX > dead;
  bool pressed[16] = {};
  pressed[0] = (p.wButtons & XINPUT_GAMEPAD_DPAD_UP) || stickUp || (!inMenu && (p.wButtons & XINPUT_GAMEPAD_A));
  pressed[1] = (p.wButtons & XINPUT_GAMEPAD_DPAD_DOWN) || stickDown || (!inMenu && (p.wButtons & XINPUT_GAMEPAD_B));
  pressed[2] = (p.wButtons & XINPUT_GAMEPAD_DPAD_LEFT) || stickLeft;
  pressed[3] = (p.wButtons & XINPUT_GAMEPAD_DPAD_RIGHT) || stickRight;
  pressed[4] = (p.wButtons & XINPUT_GAMEPAD_X) != 0;
  pressed[5] = (p.wButtons & (XINPUT_GAMEPAD_Y | XINPUT_GAMEPAD_RIGHT_SHOULDER)) || (inMenu && (p.wButtons & XINPUT_GAMEPAD_A));
  pressed[6] = (p.wButtons & XINPUT_GAMEPAD_START) || (inMenu && (p.wButtons & XINPUT_GAMEPAD_B));
  pressed[7] = (p.wButtons & (XINPUT_GAMEPAD_LEFT_SHOULDER | XINPUT_GAMEPAD_BACK)) != 0;
  static const int codes[8] = {kUp, kDown, kLeft, kRight, kFire, kSoftL, kSoftR, kHash};
  for (int i = 0; i < 8; i++) {
    if (pressed[i] && !g_pad[i]) {
      g_pad[i] = codes[i];
      if (g_down) g_down(codes[i]);
    } else if (!pressed[i] && g_pad[i]) {
      g_pad[i] = 0;
      if (g_up) g_up(codes[i]);
    }
  }
}

}  // namespace input
