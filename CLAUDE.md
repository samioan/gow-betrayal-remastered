# CLAUDE.md

Decompilation + PC port of the J2ME game *God of War: Betrayal*. Read
`README.md` and `betrayal/docs/ROADMAP.md` first.

## Rules

- **Never commit game data.** `roms/*.jar` and `betrayal/extracted/` are
  gitignored; do not copy resources, decoded assets or parser output into
  tracked files. Tools print derived data to stdout only.
- `betrayal/src/` is generated: change `betrayal/docs/names.map` or the
  `PATCHES` list in `tools/rename_gow.py`, then run `python tools/rename_gow.py`
  (it must end with `compile check: OK (0 errors)`).
- Only rename a class/field/method in `names.map` once its role is confirmed
  from call sites, and record the evidence in `betrayal/docs/CLASS_MAP.md`.
- Sibling projects at `../rac-j2me-decomp` (especially `clonehome/`, the same
  engine family), `../tes-travels-decomp` and `../shadowkey-decomp` are the
  reference for every phase. Use them as hypotheses, verify against this jar.

## Commands

```
python tools/extract_jar.py && python tools/decompile.py
python tools/parse_banks.py
python tools/rename_gow.py
betrayal\port\build.bat                # Debug port (needs VS Build Tools)
betrayal\port\build_dist.bat 0.0.0-x   # shipping build -> betrayal\port\dist
powershell betrayal\port\check_dist.ps1
```

`java` on `PATH` is 1.8; the scripts find a JDK 17+ themselves
(`tools/decompile.py:find_java`). Run the `.bat` files from PowerShell or
`cmd` with a `.\` prefix, not through Git Bash's `cmd //c` without it.

## Port workflow

- `betrayal/port/src/gen/` is generated: fix problems in `names.map`, `PATCHES` in `tools/rename_gow.py`
  or `tools/java2cpp.py`, never in the generated C++. `engine.cpp`, `scene.cpp`, `gfx.cpp`,
  `platform.cpp`, `main.cpp`, `input.cpp`, `display.cpp` are hand-written; `Engine`/`Scene` follow the
  Java line by line.
- Widescreen and the PC menu rows live in `tools/gow_port_patches.py` (asserting text patches on the renamed
  Java) plus `Port::*` in `main.cpp`. Check any UI change at `--width 240` (must look identical to the phone
  game) and `--width 569`.
- Regenerate after any rename: `python tools/rename_gow.py && python tools/java2cpp.py`, then rebuild.
- Look at the game headless: `python tools/port_shots.py --story --frames 700,1100 -o sheet.png` (then
  view the PNG); `--press KEY@FRAME[:HOLD]` scripts input. Never commit the screenshots.
- A Java `ArrayIndexOutOfBounds` in the original shows up as a `JavaException` in `exceptions.log`
  (in the working directory); an empty log after a scripted run is the pass criterion.
- Decompiler typing artifacts (`byte` loop counters, `short` ints) are the usual cause of a runtime
  exception that the Java would not have thrown: compare against the bytecode with `javap -c`.
- Speed check: `gow_port.exe --data betrayal\extracted --bench 10` writes `bench.txt` (logic steps per second on
  the real clock; the original's target is 25). The pacing in `Engine::runFrame` deliberately differs from the
  Java's, which runs too fast on modern machines (see `PORT_ROADMAP.md`, "Timing").
- Debugging behaviour: `gow_port.exe ... --dump x.bmp --frames N --trace t.txt` logs the player's action, position,
  animation delta and ground flag every frame (`--press KEY@FRAME[:HOLD]` scripts input). Compare against what the
  animation data says (e.g. decode with `tools/parse_atlases.py` / the loaders) before suspecting the game logic.
- The translator has dropped operators before (`-super.animDeltaY` lost its minus: jumps went downwards). `java2cpp.py`
  now checks that every `-`/`!`/`~` on a `super.` reference survives; when generated code misbehaves, diff a
  suspicious expression against the Java first.
