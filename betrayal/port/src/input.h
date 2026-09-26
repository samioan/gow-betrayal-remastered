// Keyboard, mouse and gamepad bindings. Physical inputs are translated to the MIDP key codes the
// game's Engine expects (-1 up, -2 down, -3 left, -4 right, -5 fire, -6/-7 soft keys, 42 '*',
// 35 '#', ASCII digits). The game code is untouched.
//
// Default bindings:
//   move            arrows / WASD / d-pad / left stick
//   attack, confirm Space, J, Z / gamepad A
//   weapon cycle    K, X, Q, E / gamepad X            (the left soft key: also confirms in menus)
//   pause, back     Esc, P, Backspace / gamepad B, Start   (the right soft key)
//   upgrade screen  Tab, U / gamepad Y                ('#')
#pragma once

namespace input {

// keyDown/keyUp receive MIDP key codes.
void init(void (*keyDown)(int), void (*keyUp)(int));
void keyEvent(unsigned virtualKey, bool down, bool isRepeat);
void poll();        // XInput gamepad, once per frame
void releaseAll();  // focus lost: no stuck keys

}  // namespace input
