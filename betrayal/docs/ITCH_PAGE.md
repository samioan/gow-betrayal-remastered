# itch.io page copy

The text for the store page, kept in the repo so it can be revised like
anything else rather than living only in a web form. Paste into itch's
description field; it takes Markdown. Adapted from
`../../rac-j2me-decomp/clonehome/docs/ITCH_PAGE.md` and
`../../tes-travels-decomp/oblivion/docs/ITCH_PAGE.md`.

Page settings that matter:

- **Kind of project**: Downloadable. Not "HTML" -- there is nothing to run
  in a browser.
- **Pricing**: free. This is someone else's game; charging for a port of
  it would be indefensible whatever the licence situation.
- **Platforms**: Windows only for now.
- **Upload**: the `GodOfWarBetrayalRemastered-gow-v<version>-win64.zip`
  from the matching GitHub release, marked "Windows" and **not** "This file
  will be played in the browser".
- **Cover image**: `betrayal/port/src/launcher/assets/banner_source.png`,
  cropped to itch's 630x500 (Kratos and the logo are the parts to keep).
- Leave **"Generate itch.io app manifest"** off -- the launcher already
  updates itself from GitHub, and two update mechanisms fighting over the
  same folder is a bug waiting to happen.

---

## God of War: Betrayal -- Remastered

**The 2007 mobile God of War on PC, in widescreen and at 60+ FPS, rebuilt
from the original game's own code.**

*God of War: Betrayal* was a side-scrolling prequel to the PS2 games, made
for J2ME (mobile Java) phones with 240x320 screens by Glu Mobile. It has been
effectively unplayable for years unless you still have a compatible phone or
an emulator and the original game file.

Fight through Kratos's early campaign for Ares -- blades combos, three magic
modes, grapple finishers and QTEs, upgrades bought with red orbs -- across
every level of the original game.

This is that game, running natively on Windows: not an emulator, but a port
made by reading the original game's own decompiled bytecode and translating
it to C++ around a new Windows front end.

### What you need

**This download does not include the game.** It cannot -- the game belongs
to its rights holders. You supply your own copy of
`God-of-War-Betrayal_J2ME_EN_v148.jar`.

1. Download and unzip anywhere.
2. Run **GodOfWar.exe**.
3. Choose your `.jar` file -- the launcher unpacks it for you.
4. Pick **Fullscreen** or **Windowed**, and press **Play**.

### Made for a modern screen

- **Widescreen** (Main menu > Options, or the pause menu): Original, Auto,
  4:3, 16:10, 16:9, 21:9. The world simply shows more of the level; Kratos,
  enemies and the HUD keep their original proportions -- nothing is
  stretched, and the HUD, soft-key labels and dialogue text move out to the
  screen's own corners and edges.
- **Frame rate**: Original, 60, 90, 120, 144, 165, 240 or Unlimited. The game
  logic keeps its original speed (25 steps a second), and the extra frames
  are smoothly interpolated.
- **Borderless fullscreen by default**, toggleable with F11 or Alt+Enter.
- **Controls**: keyboard/mouse, or an XInput gamepad laid out like a modern
  game and the original PS2 titles -- A jumps, X attacks, B grabs/blocks,
  Y or the right shoulder cycles blades and magic (echoing the PS2 games'
  own R1), the left shoulder or Back opens the upgrade screen, Start pauses.
- **Portable.** No installer, no registry keys, no Visual C++
  redistributable. Your game file is unpacked into `data\`; saves and
  display settings live in `%LOCALAPPDATA%\gow-betrayal-port\`. Uninstalling
  is deleting the folder.
- **It updates itself** from the GitHub releases, and asks first.

### This is an early work in progress

The game runs from the splash screens through the first level; it has
**not** yet been played all the way through, so expect rough edges further
in. The port simply carries on from any error the original phone would have
crashed on, rather than crashing itself.

Source, the full record of how it was reverse engineered, and the issue
tracker: <https://github.com/samioan/gow-betrayal-remastered>

---

*God of War* is a trademark of Sony Interactive Entertainment. This
project is not affiliated with, endorsed by, or supported by Sony, Santa
Monica Studio, Glu Mobile, Metaflow or the game's original developers and
publishers.
