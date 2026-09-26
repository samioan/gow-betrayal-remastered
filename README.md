# gow-betrayal-decomp

Decompilation and PC port of **God of War: Betrayal**, the 2007 J2ME
(mobile Java) game published by Glu Mobile and built by Metaflow. Sibling to
`rac-j2me-decomp`, `tes-travels-decomp` and `shadowkey-decomp`, following the
same process -- understand the original game, then build a from-scratch PC
port -- and closest to `rac-j2me-decomp`'s *Clone Home*: same engine family
(identical `RP*` resource-bank container and type bytes).

## The target

`roms/God-of-War-Betrayal_J2ME_EN_v148.jar` (kept out of git, see
`.gitignore`):

| | |
|---|---|
| MIDlet | God Of War, v1.4.8, vendor Glu Mobile LTD, `Created-By: Metaflow` |
| Profile | MIDP-2.0 / CLDC-1.0, entry point `GOWMIDlet` |
| Code | 6 classes: `a` (engine, extends `GameCanvas`), `b`, `c`, `d`, `e` (the game, ~280 KB decompiled) |
| Data | 31 `RP<n>` resource banks (197 resources) + `i.png` |
| Screen | 240x320 |

Plain JVM bytecode, not native code: a Java decompiler (Vineflower)
reconstructs close-to-original Java directly. Obfuscation is single-letter
names only.

## Structure

- `roms/` -- the original `.jar` (gitignored: copyrighted, never commit).
- `betrayal/extracted/` -- the jar unzipped (gitignored; `tools/extract_jar.py`).
- `betrayal/decompiled/` -- Vineflower output (tracked; `tools/decompile.py`).
- `betrayal/src/` -- renamed, compile-checked reference tree
  (`tools/rename_gow.py` from `betrayal/docs/names.map`; never edit by hand).
- `betrayal/docs/` -- `ROADMAP.md`, `ASSET_FORMATS.md`, `CLASS_MAP.md`,
  `PORT_ROADMAP.md`, `names.map`.
- `betrayal/port/` -- the PC port: CMake + Ninja + MSVC, C++17, with a working
  launcher (picks your `.jar`, unpacks it, self-updates from GitHub releases).
  The game itself runs: see Status.
- `tools/` -- see `tools/README.md`.
- `.github/` -- CI (`ci.yml`) and tag-driven release (`release.yml`,
  tags `gow-v*`).

## Status

- **Phase 0 (done):** jar unpacked and decompiled; engine family and
  container format identified; all 31 banks validated byte-exactly; port
  toolchain proven (Debug build, shipping build and `check_dist.ps1` pass).
- **Phase 1 (started):** class-level renames done (`Engine`, `Scene`
  (tentative), `Sprite`, `SoundPlayer`, `Game`); **`Engine` is fully read and
  every member renamed**, and so are `SoundPlayer` and `Scene`; `Game` is about 90% read
  (state machine, input, panels, camera, the level loader and the whole gameplay update:
  player actions, blades + three magic modes, quick-time finishers, enemies, chests,
  switches/gates, hazards, movement and collision, menus, HUD, saves). The renamed tree
  compiles with zero errors against the MIDP/CLDC stubs.
- **Phase 2 (started):** container, resource types, all 34 sprite atlases and
  all 25 animation sets and all 11 bit-packed level files parse with exact byte
  consumption; object/cell-flag semantics, strings still to document; the save layout is done.
- **Phase 3 (the port runs):** the generated `Game` runs on a hand-ported `Engine`/`Scene` and a
  software renderer. Headless, it reaches the splashes, language select, main menu, intro crawl,
  the first level and its tutorial combat with no exceptions; the Release build and package check
  pass. It starts in borderless fullscreen and has PC settings in the main and pause menus
  (widescreen Resolution, Fullscreen and FPS with interpolated frames). It still needs a full play-through against the original. See
  `betrayal/docs/PORT_ROADMAP.md`.

See `betrayal/docs/ROADMAP.md` for the detailed plan and open questions.

## Getting started

Needs Python 3.10+, a JDK 17+ (Vineflower), and for the port CMake plus the
VS Build Tools (C++ workload; Ninja is found via the VS environment or must be
on `PATH`).

```
# put the jar in roms/, then:
python tools/extract_jar.py
python tools/decompile.py
python tools/parse_banks.py          # validate all resource banks
python tools/rename_gow.py           # rename -> betrayal/src/ + compile check
python tools/java2cpp.py             # betrayal/src -> betrayal/port/src/gen (pip install javalang)
betrayal\port\build.bat              # Debug port
betrayal\port\build_dist.bat 0.1.0   # shipping package -> betrayal\port\dist\
python tools/port_shots.py --story --frames 700,1100 -o level.png    # headless screenshots
betrayal\port\build\gow_port.exe --data betrayal\extracted --windowed   # play it
```

`tools/vineflower.jar` and `tools/midp-stubs/` are gitignored; see
`tools/README.md` for how to fetch them.

## Releases

`git tag gow-v0.1.0 && git push origin gow-v0.1.0` builds, checks and
publishes the zip (`.github/workflows/release.yml`). The game is never
included -- the launcher asks players for their own `.jar`. See `NOTICE.md`.
