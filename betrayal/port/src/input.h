// Keyboard, mouse and gamepad bindings. Physical inputs are translated to the MIDP key codes the
// game's Engine expects (-1 up, -2 down, -3 left, -4 right, -5 fire, -6/-7 soft keys, 42 '*',
// 35 '#', ASCII digits). The game code is untouched.
//
// Default keyboard/mouse bindings (unaffected by which screen is showing):
//   move            arrows / WASD
//   attack, fire    Space, J, Z, Enter, left mouse button
//   weapon cycle    K, X, Q, E, right mouse button    (the left soft key: also confirms in menus)
//   pause, back     Esc, P, Backspace                 (the right soft key)
//   upgrade screen  Tab, U                            ('#')
//
// Gamepad bindings echo the original PS2 God of War's own layout while in a level (Square = fast
// attack, Circle = grab/context, X = jump, R1 = change magic) and switch to a Select/Back convention
// everywhere else, since jump and grab have no meaning outside a level and the same face buttons are
// free to mean something else there -- see poll()'s `inMenu` argument.
#pragma once

namespace input {

// keyDown/keyUp receive MIDP key codes.
void init(void (*keyDown)(int), void (*keyUp)(int));
void keyEvent(unsigned virtualKey, bool down, bool isRepeat);
void poll(bool inMenu);  // XInput gamepad, once per frame; inMenu selects the button convention
void releaseAll();       // focus lost: no stuck keys

}  // namespace input
