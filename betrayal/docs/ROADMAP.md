# God of War: Betrayal -- decompilation roadmap

Target: `roms/God-of-War-Betrayal_J2ME_EN_v148.jar` (MIDlet-Version 1.4.8,
vendor Glu Mobile LTD, `Created-By: Metaflow`, MIDP-2.0 / CLDC-1.0, entry
point `GOWMIDlet`). Plain JVM bytecode -- no native step, so a Java
decompiler (Vineflower) recovers close-to-original source directly.

## What the jar is

- 6 classes: `GOWMIDlet` (entry), `a` (engine base, extends `GameCanvas`),
  `b`, `c`, `d`, `e` (the game, extends `a`, ~280 KB of decompiled source).
  Obfuscation is minifier-style single-letter names only; a handful of
  members are named after Java keywords (`do`) -- legal bytecode, not legal
  source, handled by `tools/ch_rename/ChRenamer.java`.
- 31 `RP<n>` resource banks (RP1..RP33, no RP11/RP31) plus `i.png` (icon).
- Same engine family as *Ratchet & Clank: Clone Home* (also Metaflow):
  identical `RP*` container, identical resource type bytes.
  `../rac-j2me-decomp/clonehome/` is therefore the closest worked example
  for every phase below.
- Native canvas 240x320 (`a.c(240, 320)`), full-screen mode, letterboxed
  when the device canvas differs.
- Optional JAD/manifest attributes read by `Game`: `ENABLECHEATS`, `DEMO`,
  `DemoBuyURL` (none present in this jar's manifest).

## Phases

**Phase 0 -- unpack, decompile, identify: DONE.**
- `python tools/extract_jar.py && python tools/decompile.py` reproduce
  `betrayal/extracted/` (gitignored) and `betrayal/decompiled/` (tracked).
- All 31 RP banks validated by `tools/parse_banks.py` (exact container
  consumption, 197 resources) -- see `ASSET_FORMATS.md`.
- Port toolchain proven: `betrayal/port/build.bat` (Debug) and
  `build_dist.bat` + `check_dist.ps1` (shipping package) both pass; the
  launcher is functional, the game is a placeholder window.

**Phase 1 -- read through, rename: STARTED.**
- `tools/rename_gow.py` renames at the class-file level (Vineflower
  `--user-renamer-class`) from `docs/names.map` into `betrayal/src/` and
  compile-checks the result against `tools/midp-stubs/`: currently
  **0 errors** with the class-level seed (`a`=Engine, `b`=Scene (tentative),
  `c`=Sprite, `d`=SoundPlayer, `e`=Game).
- **`Engine`, `SoundPlayer`, `Scene` and `Sprite` are done**: fully read, every
  member renamed (see `CLASS_MAP.md`).
- **`Game` (8.5k lines) is about 90% read.** Done: input decoding, screen/timing, language
  select + menus + panel slides, the camera, the upgrade screen, the whole level loader, and
  **the entire gameplay update `updateGameplay` (old `z()`, 2,170 lines)**: the player action state
  machine, weapon modes, quick-time-event finishers, chests, switches/gates/arenas, breakable
  walls, hazards, pickups, effects and the enemy AI loop. ~250 fields and the key methods are
  renamed (`names.map`), and **movement/collision** (player and enemy) is now documented
  (`CLASS_MAP.md`, "Movement and collision"), as are the save format, the menu system, the HUD and
  the draw order. Still obfuscated: the boot-screen/splash drawing (`u`, `v`), the remaining helpers
  in the panel/dialogue text layout (`a(int[],byte[],...)`, `p`-family), and about 100 of the less
  important fields (timers, temporaries). Method: read a method at a time, name only what call sites prove, log
  evidence in `CLASS_MAP.md`.
- Because the engine matches Clone Home's, use its `names.map` entries for
  `Engine`/`SoundPlayer`/`Sprite` as *hypotheses* and verify each against this
  jar's code (do not assume; signatures differ -- e.g. GoW's sprite class
  `c` is Clone Home's `f`).

**Phase 2 -- asset formats: STARTED.** Done: container, type bytes, all 34
sprite atlases and all 25 animation sets (`tools/parse_atlases.py`, exact
consumption) and all 11 level files (`tools/parse_levels.py`: bit-packed, exact
consumption, every object-type field width verified). To do: a string-table
parser, the 256x3 table at 1053 (the save layout is done). (Object types and cell flags are now
mostly understood; see `ASSET_FORMATS.md`.)

**Phase 3 -- PC port: SCAFFOLD ONLY.** See `PORT_ROADMAP.md`.

## Open questions

- What does RP9[0] (level id 9216) do? It parses like the ten story levels; the
  main menu starts it directly with `iN = true`. Tutorial/bonus stage?
- What do the remaining unnamed level object types (6/14 scripts, 22, 9, 32) do in play, and
  what are the movement/collision rules (`f`, `g`)? Read those methods next.
