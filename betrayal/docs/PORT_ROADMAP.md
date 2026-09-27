# God of War: Betrayal -- PC port roadmap

Toolchain: CMake + Ninja + MSVC (VS Build Tools, found by `vswhere` in `port/vcvars.bat`), C++17,
raw Win32, software-rendered (no SDL/D3D/GL). Same layout and scripts as
`rac-j2me-decomp/clonehome/port/`.

## Status: the game runs

Driven headlessly (`tools/port_shots.py`) the port reaches, with no exceptions: the Sony Online
Entertainment and Javaground splashes with the loading bar, language select (six languages), the
audio prompt, the main menu with its animated fire effect, the intro story crawl, the first level
(tile map, scenery, Kratos, Spartan soldiers, red-orb hit effects) and the tutorial dialogue and
combat. The real window runs and stays responsive; `build_dist.bat` + `check_dist.ps1` pass.

### Architecture (`port/src/`)

| Part | File | Notes |
|---|---|---|
| Game logic | `gen/*` | `Game`, `GOWMIDlet`, `SoundPlayer` translated from `betrayal/src/` by `tools/java2cpp.py` (regenerate after a `names.map` change; never edit) |
| `Engine` | `engine.h/.cpp` | hand port of `Engine.java`: frame timing + lifecycle state machines (the original's two threads), key bitmasks, record store (one file per id), `RP<n>` banks, atlases, bitmap font, the animation-set runtime (bit-packed arithmetic copied line by line) |
| `Scene` | `scene.h/.cpp` | hand port of `Scene.java`: ring-buffer scroller with tile / static-sprite / object layers |
| `Sprite` | `engine.cpp` | `Sprite.draw` clipping + `drawRegion` |
| Java runtime | `jrt.h/.cpp` | `Arr<T>` (bounds-checked, throws `JavaException`), immutable UTF-16 `String`, `Random` (JDK LCG), `DataInputStream` -- from Clone Home |
| Renderer | `gfx.h/.cpp` | 240x320 `Surface` (an `Image` you can draw into): fillRect/drawRect/drawLine, `drawRegion` with MIDP mirror transforms, `drawRGB`, alpha blending |
| Platform | `platform.h/.cpp` | `MIDlet`, `Display`, MIDI/WAV playback through MCI on a worker thread (`Player`) |
| Shell | `main.cpp`, `display.*`, `input.*` | Win32 window, integer/fit scaling, fullscreen (F11 / Alt+Enter), keyboard + XInput -> MIDP key codes; `--dump` headless mode |

Input: arrows/WASD move, Space/J/Z attack, K/X/Q/E weapon cycle (left soft key), Esc/P/Backspace
pause (right soft key), Tab/U upgrade screen (`#`); gamepad d-pad/stick move, A jump, X attack,
B grab/block (an alias for Down, which already means "interact" on the phone's own keys), Y /
right shoulder cycle weapons, left shoulder / Back open the upgrade screen, Start pauses -- echoing
the original PS2 God of War's own layout (Square attack, Circle grab, X jump, R1 change magic).

Translator bug found in play-testing: `-super.animDeltaY` (the absolute value in the movement code) lost its
minus, so upward moves were treated as downward ones and jumps went down; `java2cpp.py` now keeps prefix operators
on `super.` references and refuses to run if any are dropped.

Decompiler artifacts found while porting are patched in `tools/rename_gow.py` (`PATCHES`): the boot
loader's `byte` loop counter that wraps at 127, and the dead static initializer. Names that collide
in C++ but not in Java (a field called `fontHeight` next to the method `fontHeight()`, fields `o`/`p`
next to methods `o()`/`p()`) are fixed by renaming in `names.map`.

## PC settings, widescreen and fullscreen

The game starts in **borderless fullscreen** (`--windowed` from the launcher overrides it; F11 / Alt+Enter
toggles). Both menus have PC options, styled like the game's own:

- **Main menu > Options:** three extra carousel entries after Language: `Resolution: <mode>`,
  `Fullscreen: ON/OFF` and `FPS: <rate>` (fire / left soft key changes them). `Port::extendMenu` inserts them into the menu table
  (resource 1028) before the Options page's header and shifts every stored page link; the hard-coded jump to the
  Quit page (23 -> 26) is patched.
- **Pause menu:** three more rows past Sound (press Left): the same Resolution, Fullscreen and FPS.
- **Resolution** modes: Original (240), Auto (follows the window), 4:3, 16:10, 16:9, 21:9. The height stays
  320; the logical width is `H * ratio` (427 / 512 / 569 / 747, at most 853). Saved in
  `%LOCALAPPDATA%\gow-betrayal-port\display.cfg` with the other display settings.

How widescreen works (`tools/gow_port_patches.py`, applied to the renamed Java by `java2cpp.py`; every
substitution asserts its match count): `Game.viewW` is the logical width and `Engine::runFrame` resizes the
surface to it. **Only the world uses the extra width**: the `Scene` ring buffer (`Scene.setBufferWidth`), the
camera centring and limits, the camera lock rectangles, and all visibility / activation tests (17 culling
checks and the three 368x448 enemy-activation windows). Everything designed for 240 px (menus, HUD, dialogue
text, pop-ups, soft-key labels) is drawn **centred by translating the frame by `(viewW - 240) / 2`, never
scaled**; the world layer undoes that translation for itself, and the full-width fills (letterbox bars, the
bottom bar, their corner ornaments) are widened. A level narrower than the requested width (the 656 px
vertical level) caps `viewW` at the level width (the window then pillarboxes). Changing the resolution mid-level
redraws everything (tested with `port_shots.py --width-change`).

### FPS (smoother gameplay)

`FPS: Original / 60 / 90 / 120 / 144 / 165 / 240 / Unlimited` (saved with the display settings). The game logic
always runs at its original 25 steps/s; only drawing is faster. With a non-Original rate `Engine::runInterpolated`
runs the logic on a fixed 40 ms clock and draws at the chosen rate, sleeping to the target. Every logic step the game
records the positions of everything that moves, and each extra frame is drawn with those positions **blended**
between the previous and the current step (the picture trails the logic by up to one step). The Java side is
`interpSnapshot` / `interpApply` / `interpRestore` in `tools/gow_port_patches.py`: it blends the camera, the player,
the 15 enemies, the pickup trails (20 x 4), the drifting scenery/props (36 and 17, boxed and health props, hazards)
and the pushable crates, writes the blended values into the game's own fields, lets the normal render code draw,
and restores the real ones. Moves over a threshold (respawns, teleports, camera cuts) and entities whose identity
changed are not blended. Outside the world (menus, boot) nothing moves between steps, so no extra frames are
drawn there. The one decorative animation stepped inside the draw code (the status-effect overlay, slot 137)
advances only on logic steps. Tested headlessly (`--sim-fps 120 --trace`): the camera advances about 1 px per
frame between steps where the logic moves it 3-4 px per step.

Not done: the main menu's fire/Kratos backdrop and the HUD stay at 240 px (centred), the narrow-level cap has
not been exercised, and Scaling (fit / integer) is F7 only, not in the menus.


## Known gaps / next steps

1. **Play through and compare with the original.** Only the first minutes have been exercised
   (headless, scripted). Walk all ten levels and the challenge level, fight every enemy class and
   both bosses, use all four weapon modes, finishers, chests, switches, gates and hazards, and compare
   against the jar running in an emulator (FreeJ2ME, KEmulator).
2. **Sound** is wired (MIDI via MCI, up to 12 slots) but untested. The original only loads three sound
   slots, so most gameplay sound cues are silent by design (`playSound(3..)` is a no-op there too).
3. **Timing (fixed).** The original `Engine.run` paces at 25 steps/s (`minFrameTime` 40 ms, `dt` clamped to
   40..100 ms) but has a quirk: it records "the time of the last step" *before* it sleeps, so on any machine
   fast enough to finish a frame in under 40 ms the loop alternates between "sleep, then step" and "step at
   once" while still telling the game 40 ms per step: about 1.8x too fast. (A 2007 phone never noticed,
   since a frame took over 40 ms anyway; emulators and this port did.) `Engine::runFrame` takes the
   last-step time after the sleep instead, and the shell calls `timeBeginPeriod(1)` for accurate sleeps.
   Measured with `gow_port.exe --bench 15` (real clock, no window): 24.5 steps/s, was 41-48.
4. **More extras**: Speed (logic rate) and Scaling rows in the settings menus, widening the menu backdrops,
   interpolating the remaining small movers (screen-space effects).
5. Real launcher artwork, `docs/ITCH_PAGE.md`, the first `gow-v0.1.0` release.
6. A regression suite: `tools/port_shots.py` plus pinned frame hashes (kept out of git, since they
   derive from game data), run locally before each release.
