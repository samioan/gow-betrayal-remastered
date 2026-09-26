# tools/

Shared tooling. Nothing here is game data -- it is either fetched
(`vineflower.jar`, `midp-stubs/`, gitignored) or regenerates output already
tracked elsewhere, so only the scripts are tracked.

## Fetched (not in git)

- **`vineflower.jar`** -- [Vineflower](https://github.com/Vineflower/vineflower)
  1.12.0, a maintained Fernflower fork:
  ```
  curl -L -o tools/vineflower.jar https://github.com/Vineflower/vineflower/releases/download/1.12.0/vineflower-1.12.0.jar
  ```
- **`midp-stubs/`** -- `midpapi20.jar`, `cldcapi11.jar`, `nokiaui.jar`: stub
  jars of the real MIDP-2.0 / CLDC-1.1 / Nokia-UI APIs, used to compile-check
  the renamed tree. This copy came from `../rac-j2me-decomp/tools/midp-stubs/`.

## Scripts

- **`extract_jar.py`** -- unpacks `roms/God-of-War-Betrayal_J2ME_EN_v148.jar`
  (a plain zip) into `betrayal/extracted/`, unmodified.
- **`decompile.py`** -- runs Vineflower over `betrayal/extracted/` and writes
  Java source to `betrayal/decompiled/`. Needs Java 17+: `find_java()` tries
  `$JAVA_HOME`, `java` on `PATH`, then installed Temurin JDKs (the `PATH` java
  on this machine is 1.8, too old).
- **`parse_banks.py`** -- validates every `RP<n>` bank against the container
  format documented in `betrayal/docs/ASSET_FORMATS.md` (exact consumption,
  per-bank type histogram); `dump <bank> <index>` shows one resource's type,
  length and first bytes. stdout only -- output is derived from game data.
- **`parse_atlases.py`** -- replicates `Engine.loadSprites` and
  `Engine.loadAnimSet` byte for byte over every type-254/247 resource, asserting
  exact consumption and reporting atlas rectangles that fall outside their PNG;
  `atlas <id>` / `anim <id>` dump one. stdout only.
- **`parse_levels.py`** -- replicates `Game`'s bit-packed level loader (header, tile map, tile flags,
  object groups and every per-object-type field) over the 11 type-245 level blobs, asserting exact
  consumption; `<id> [map]` dumps one level (with an ASCII tile-type map). stdout only.
- **`outline.py`** -- lists the methods of a renamed source file with line ranges and sizes, and
  callers/callees (`--calls <name|line>`); the map for the `Game` read-through.
- **`rename_gow.py`** (+ **`ch_rename/ChRenamer.java`**) -- phase 1. Runs
  Vineflower with a custom `--user-renamer-class` that reads
  `betrayal/docs/names.map`, applies textual `PATCHES` for decompiler
  artifacts, writes `betrayal/src/`, and compiles it against `midp-stubs/`
  (must be 0 errors). Renames happen on the class files' symbol tables, so
  single letters reused across classes cannot collide. `ChRenamer` also
  renames members whose obfuscated name is a Java keyword (`do` -> `do_`).
  Edit `names.map` or `PATCHES`, never `src/`.
- **`java2cpp.py`** -- phase 3. Translates `betrayal/src/*.java` (`Game`,
  `GOWMIDlet`, `SoundPlayer`) to C++ into `betrayal/port/src/gen/` (or a
  directory given as argv[1]), targeting the port's `jrt.h` runtime and its
  hand-written `Engine`/`Scene`/`Sprite`. Re-run after any change to
  `names.map` or `PATCHES`; the output is tracked. Needs `pip install
  javalang`. Prints statements whose evaluation order might differ from Java.
  Originally written for Clone Home; the per-game text-patch hooks are
  stubbed (`_NoPatch`).
- **`gow_port_patches.py`** -- the PC-port changes (widescreen, the Resolution / Fullscreen menu rows) applied to
  the renamed Java by `java2cpp.py`. Each substitution asserts its expected match count, so a rename or
  decompiler change fails loudly instead of silently dropping a patch. Edit it, not `gen/`.
- **`port_shots.py`** -- runs `gow_port.exe --dump` headless with scripted key
  presses (MIDP key codes) on a fake 40 ms clock and stitches screenshots at
  chosen frame counts into a PNG contact sheet (`--story` presses through boot
  to the first level; `--width N` sets the logical canvas width, `--width-change
  FRAME:W` switches it mid-run; use `--press=-6@170:3` for negative key
  codes). Needs Pillow. Output is derived from game data: never
  commit it.
- **`make_banner.py`**, **`make_icon.py`** -- turn a source image
  (`betrayal/port/src/launcher/assets/banner_source.png`, currently a generated
  placeholder) into the launcher's `banner.png` and `gow.ico`. Use
  PowerShell's System.Drawing, so no extra dependencies.

## Why Vineflower and not Ghidra

The game is a J2ME MIDlet: plain JVM class files. A Java decompiler
reconstructs real source directly -- there is no ARM/native step. See
`../shadowkey-decomp` for the contrasting native (Symbian) case.
