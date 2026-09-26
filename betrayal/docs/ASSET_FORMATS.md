# God of War: Betrayal -- asset formats

Paths are relative to `betrayal/extracted/` (regenerate with
`python tools/extract_jar.py`). The jar has 6 class files, `i.png` (icon)
and 31 resource banks `RP1..RP33` (no RP11, no RP31). Everything below is
verified by `python tools/parse_banks.py` unless marked *(unverified)*.

## The `RP*` container (confirmed from `a.java`, `a.a(DataInputStream)`)

All big-endian:

```
u8    flags        bit 0 -> length entries are 2 bytes (0) or 4 bytes (1)
u16   count        number of resources
u2/4  lengths[count]
u8    types[count] resource type byte
u32   payloadSize  (== sum of lengths)
u8    payload[]    resources back to back, in order (no offset table)
```

A resource id is `(bank << 10) | index`. `a.m(id)` lazily loads `/RP<bank>`
(`bank == 0` means "the bank already loaded"; only one bank is resident at a
time). All 31 banks parse with exact consumption (197 resources).

This is byte-for-byte the format used by the Clone Home jar
(`../rac-j2me-decomp/clonehome/docs/ASSET_FORMATS.md`).

## Resource type byte

Counts are from `parse_banks.py`. Meanings are by analogy with Clone Home's
identical type bytes; the loaders in `Engine` should be read to confirm each.

| Byte | Count | Where | Meaning |
|---|---|---|---|
| 253 | 34 | image banks | PNG image |
| 254 | 34 | one per image bank | sprite atlas -- **parsed, exact** (below) |
| 247 | 25 | image banks | animation set -- **parsed, exact** (below) |
| 251 | 75 | image banks | palette-swap / byte arrays for image loading |
| 250 | 6 | RP10, 12, 29, 30, 32, 33 | UTF-8 string table. RP10[0] starts `01 25 \| 00 06 "Select" 00 04 "Exit" ...`, i.e. u16 count (0x125) then u16-length strings -- checked by eye, not yet by a parser |
| 0 | 11 | RP1 | audio, `audio/midi` (`MThd` header) |
| 255 | 1 | RP1[4] (id 1028) | the **menu table**: 128 bytes = 32 big-endian ints (below) |
| **245** | 11 | RP9 (2), RP19..RP27 | **Level file** -- bit-packed, **parsed, exact** (below) |

`SoundPlayer` treats type `14` as `video/3gp` and everything else as
`audio/midi` (`SoundPlayer.a(byte)`).

By resource-type mix alone (inference, not verified): RP1-RP8 are common art
and UI, RP13-RP18 and RP28 are art bundles, RP9/RP19-27 hold the type-245
data, and RP10/12/29/30/32/33 are string tables.

## Sprite atlas (type 254) -- verified by `tools/parse_atlases.py`

Loader: `Engine.loadSprites(id, swap)`. Same layout as Clone Home's atlas.

```
u16  imageId       PNG resource (bank 0 = the atlas's own bank)
u8   (unused)
s16  dataLen + 4
u16  mask          bit clear = present. bit0: {offsetX, offsetY}; bit1: {srcX, srcY, width, height};
                   bit2: {e, f, advance, metric}. Bits 5.. (one per present field, in order):
                   clear = 2-byte column, set = 1-byte column
u16  count         number of sprites
u8   data[dataLen] one column per present field, column-major (count entries each)
```

Field order of the 10 values = `Sprite.load(short[10])`: `offsetX, offsetY, srcX,
srcY, width, height, e, f, advance, metric`. 1-byte columns are signed for
offsetX/offsetY/e/f and unsigned for the rest. In a *font* atlas, `e` is the
delta-encoded character code (`Engine.setFont` rewrites them; `font[0].metric`
= line height, `[1]` = baseline, `[2]` = default advance).

All 34 atlases (2,814 sprites) consume their data exactly. One quirk: atlas 2054
(RP2[6]) defines 128 tiles of 22x22, four per row, but its PNG (128x256) only
contains the first 44 -- 84 rectangles lie outside it (harmless, `Sprite.draw`
clips). Check which tiles `Game` actually uses.

## Animation set (type 247) -- verified by `tools/parse_atlases.py`

Loader: `Engine.loadAnimSet(id)`. Two primitive readers: `k()` = unsigned byte
whose value 255 escapes to a 16-bit char; `l()` = signed byte whose value -128
escapes to a 16-bit short. Columns are read in this exact order:

```
u8   (unused)
u16  nAnims
k[nAnims]        steps per animation           (cumulative -> start index)
l[nAnims]        loop count & 63               (0 = loop forever)
-- per animation step (total = sum of steps), each a column:
k[]  timing      duration index (bits 0-5) + flag bits 6-7 (a 16-bit value's high byte is kept too)
k[]  frame id
l[]  dx
l[]  dy
u16  nFrames
k[nFrames]       parts per frame
-- per part (total = sum), each a column:
2-bit flip flags (4 per byte, read with k())
k[]  sprite index          l[]  x           l[]  y
k[nFrames]       hit/hurt boxes per frame
-- per box (total = sum), each a column:
l[]  x   l[]  y   k[]  width   k[]  height   k[]  type
u16  nDurations
k[nDurations]    step durations
```

At runtime an *animation* is a list of steps; each step names a *frame* (a
list of sprite parts with offsets and flip flags plus optional boxes), a
duration, and a movement delta. `Engine.stepAnim` advances a slot by a time
step and interpolates the movement; `Engine.drawFrame` draws a frame's parts
through a `Sprite[]` (an atlas). All 25 sets consume exactly (e.g. RP28[0]:
122 animations, 1,051 steps, 699 frames, 15,019 parts, 189 boxes).

## Level files (type 245) -- verified by `tools/parse_levels.py`

Eleven levels: `Game.levelIds` (`bB`) = `9217, 19456, 20480 ... 27648` (RP9[1],
RP19[0]..RP27[0]) for the ten story levels, plus **RP9[0] (id 9216)**, a special
level the main menu starts directly (`levelResourceId = 9216`, entered with
`iN = true`; probably a tutorial/bonus stage -- confirm). Loaded by
`Game.loadLevelStep` (a state machine over `levelLoadStep` 0..10, one step per
frame so the loading bar can animate); all ten story levels plus RP9[0] parse with
exact consumption (0-7 spare padding bits).

**Bit order** (`Game.readBits(n)`): LSB-first. Bits come from the low end of each
byte, and a value is assembled little-endian across bytes. `bitsFor(n)` =
`ceil(log2(n))` = `(n - 1).bit_length()`, so `bitsFor(1) == 0`.

```
1   skip            10  skip
10  q               (nonzero on levels that open with a dialogue/cutscene id -- unconfirmed)
1   flip            (stored inverted: hu = bit != 1 -- camera look-ahead side)
1   dA   1  dB      (choose between two enemy atlas variants: 18433/4097, 16385/17409)
1   skip
16  hs
1   skip
16  nTileTypes      4  tileBits      nTileTypes x tileBits: tile-sheet index for each tile type
16  width  16 height (in 16 px tiles)
width*height x bitsFor(nTileTypes): the map, one tile-type index per cell, row-major
8   skip
nTileTypes x 1: solid flag per tile type  ->  cellFlags[type] |= 1 ... (bit 0 = solid)
10  nGroups         (posBits = bitsFor(worldW*worldH + 1), world size in pixels)
nGroups x {
  10 type   16 count
  count x posBits   position deltas: x += delta; while (x >= worldW) { x -= worldW; y++ }
                    (raster order over the pixel grid, so positions arrive sorted by y, then x)
  then the type-specific extra fields for each object (or once, for type 6)
}
```

The tile sheet is image 2058 (RP2[10]) recoloured by a palette-swap array chosen
per level: `levelPaletteVariants` (`bG`) = `{-1,-1,-1,2,0,1,1,0,2,2}` selects RP2[20+n]
(type 251) or none (-1). The same variant number picks the per-level swap array
for every enemy/prop atlas the level loads in steps 2-9 (`getResourceBytes(base +
variant)`).

Levels: 232x39, 204x46, 112x59, 113x67, 139x43, 178x38, 116x74, 113x72, 41x138 (a
tall vertical level), 54x57 tiles; 479-1277 objects each.

### Object group types (`Game.spawnObjects(type, count)`)

The per-object extra bit widths are exactly those in `PER_OBJECT` in
`tools/parse_levels.py`. Meanings are read from `spawnObjects` plus the code in
`updateGameplay` that consumes each list (see `CLASS_MAP.md`, "Gameplay"):

| Type | Extra bits per object | Meaning |
|---|---|---|
| 0, 10, 29 | 10 (span) | horizontal line of `span+1` cells with cell flag 8192 (**one-way platform**), 64 (**kill zone**: an enemy standing in it dies), 16384 (**narrow beam**: standing on it plays the balance actions 50/51) |
| 5, 18 | 10 | vertical (5) line with flag 8 (**climbable**, ladders/ropes); horizontal (18) line with flag 16 (**ceiling bar** the player can hang from and shimmy along, actions 45-47; some enemies grab them too) |
| 3 | 1+1 | **camera lock** rectangles (`lockRectCount`): orientation + direction |
| 4 | 3+10 | **chests** (anim set 5120, atlas 5123): `kind` 0/1/2 = holds red orbs / health / magic, `value` = amount (spawned as a pickup of that kind when the opening animation finishes); `kind` 3 = an **upgrade chest**: value > 0 = **+max health**, value 0 = **+max magic** (`healthChestsFound`/`magicChestsFound`, +3 each). Opened state per level is stored in `chestFlags` (bit `level` = health chest, bit `level + 10` = magic chest) |
| 6 | 40x10 + 40x10, once | two 40-entry tables (`aY` = player action ids, `aZ` = enemy action ids): the **scripted action sequences** stepped through in cutscene state 105 |
| 7 | 6+1+1 | **breakable walls/blocks** (anim set 2048, atlas 2051): smashed by the player's attack boxes, drop 50 orbs, clear their solid cells |
| 8 | 10+3 | **dialogue triggers**: string id + line count; stepping on the cell (flag 128) opens the dialogue |
| 9 | 10+3 | **tripwires**: a vertical span (flag 256) with a 3-bit gate id; the first time the player crosses it, every gate with that id toggles and the span is cleared |
| 11, 12, 13 | 3+10+1+16+16+10+10+1+1 (+1+1 for 13) | **enemies** of class 1, 2, 3 (13 = large/boss class with variant atlases 13313/14337): respawn count (3 bits), respawn delay x 1000 ms (10 bits), a "talks in cutscene" bit, max health (16), drop amount (16), contact damage (10), spare (10), faces-left bit, patrols bit |
| 14 | 10 + 15x(10+10+1) | **enemy wave triggers**: a vertical span (flag 4) plus 15 (x, y, faces-left) entries; when the player crosses it each enemy moves to entry `enemyWaveSlot` (if off-screen) with full health |
| 17, 36 | 6 | animated scenery props (anim sets 3072, 3074) that drift by their animation's movement deltas |
| 21 | 6 | **health props** (anim set 5121, atlas 5124): hit by the player's attack boxes, each hit advances the anim and drops a 25 health orb |
| 22 | 1+4x10 | cross-shaped area (four arm lengths), one flag |
| 23 | 8+3 | **static scenery sprites** (frame index + layer 0..7) fed to `Scene.addStaticSprite` |
| 25 | 0 | **checkpoint** cell (flag 1024): entering it stores the respawn position (`checkpointX/Y`) |
| 26 | 0 | **player start** (first position) |
| 27 | 3+1 | **pushable crates** (anim set 6144, atlas 6146): block their cells (flags 1+512), pushed by the player's push action |
| 28 | 10+10+3+10 | **arena/kill-quota zone**: rectangle (w+1 x h+1 cells, flag 32), a gate id and the number of kills needed; when enemies spawned inside are killed the matching gates toggle |
| 30, 31 | 1 | single cell marker: 2048/4096 = **ledge-grab point** for facing right/left (30), or a chosen flag (31) |
| 32 | 6+1 | boxed dynamic props (anim set 5122): trigger when the player overlaps their box (bit 0 of the anim id) |
| 33 | 6+10+3 | **hazards** (anim set 6145, atlas 6147): loop their animation, damage the player while overlapping their box (`damage * dt / 4`) |
| 34 | 1+3x4 | **switches** (anim set 2050, atlas 2053): bit = lever (pulled with Down) vs pressure plate (stepped on, or a crate on it); four 3-bit gate ids they toggle |
| 35 | 3+10+1+1 | **gates / moving platforms** (anim set 2049, atlas 2052): id matched by switches/arenas, style, starts-open, and "pan the camera to it when it toggles" |
| 1, 2, 15, 16, 19, 20, 24 | 0 | not used by `spawnObjects` (position only / ignored) |

### Cell flags (`Game.cellFlags`, old `iW`; `setCellFlags`/`clearCellFlags`/`getCellFlags`)

One `short` per map cell; out-of-range reads return 65. Bit values, with the readers
that fix their meaning:

| Flag | Set by | Meaning |
|---|---|---|
| 1 | tile type solid bit; solid props (crates, chests, breakables, closed gates) | **solid** |
| 2 | under each enemy while it stands there | occupied by an enemy |
| 4 | type 14 | enemy wave trigger (cleared when crossed) |
| 8 | type 5, pushable crates (climbable variant) | **climbable** (ladder/rope): Up/Down grabs it |
| 16 | type 18 | **ceiling bar** (hang and shimmy) |
| 32 | type 28 | arena zone |
| 64 | type 10 | **kill zone** (enemies die on it) |
| 128 | type 4/8 | dialogue trigger / chest interaction cell |
| 256 | type 9 | tripwire (cleared when crossed) |
| 512 | crates | **pushable** (walking into it starts the push action instead of stopping) |
| 1024 | type 25 | checkpoint |
| 2048 / 4096 | type 30 | **ledge grab** for a right-facing / left-facing player |
| 8192 | type 0 | **one-way platform**: stand on it, drop through with Down |
| 16384 | type 29 | narrow beam (balance actions) |

### Other tables read by `Game`

- `1053` (RP1[29], type 251, 768 bytes = 256 x 3): read at boot into
  `R[i] = b0<<18 | b1<<10 | b2<<2` (a 256-entry three-component table, probably
  colour/tint ramps). Consumer not yet found.
- `1028` (RP1[4], the single type-255 resource): big-endian `int[]` = the **menu table** (`Game.menuTable`, old `iw`):
  bit 22 (0x400000) marks the first entry of a page, bit 23 (0x800000) the last,
  and 0x3000000 marks a level-select entry as unlocked
  (`unlockLevelMenuEntries`: entries 9..18 unlocked up to `furthestLevel`).
- Language string tables (type 250): `Game.languageStringBanks` = RP10, 12, 33, 29,
  30, 32 (ids 10240, 12288, 33792, 29696, 30720, 32768), indexed by the language
  chosen on the state-78 screen (six languages); `languageNameStrings` = strings
  `{23, 24, 21, 20, 22, 19}` of the loaded table are the language names.

## Save data (verified from `Game.saveGame` / `loadGame` / `Engine.syncSettings`)

All persistence goes through `Engine.readRecord(id)` / `writeRecord(id, bytes)`: an RMS record
store *named by the decimal id*, blob split into records of at most 589,824 bytes.

| Store | Size | Contents |
|---|---|---|
| `-9` | 3 bytes | **settings**: byte 0 = sound on, byte 1 = an unused setting, byte 2 = unused. Created as `FF FF FF` if missing or the wrong size. |
| `2` | 76 bytes | **the save slot** (`saveGame(1)` writes record `slot + 1`; only slot 1 is used) |

Save slot layout: 19 big-endian `int`s (`writeIntBE`/`readIntBE`), in this order:

| Offset | Field | Notes |
|---|---|---|
| 0 | `bladesLevel` | 0..4 |
| 4 | `magicALevel` | 0..4 |
| 8 | `bladesComboLength` | at least 3 on load |
| 12 | `magicAComboLength` | at least 2 on load |
| 16 | `magicBLevel` | 0..4 |
| 20 | `magicCLevel` | 0..4 |
| 24 | `healthChestsFound` | max health = `1024 + 192 * n` |
| 28 | `magicChestsFound` | max magic = `1024 + 192 * n` |
| 32 | `upgradePoints` | red orbs in hand |
| 36 / 40 / 44 / 48 | `upgradeProgressC` / `D` / `A` / `B` | partial spend towards the next level of each track (note the order: C, D, A, B) |
| 52 | `furthestLevel` | 0..9; also the level `Continue` starts at (`levelIndex` is set to it) |
| 56 | `orbsCollected` | |
| 60 | `orbBudget` | |
| 64 | `chestFlags` | bit `level` = health chest taken, bit `level + 10` = magic chest taken |
| 68 | `bestKillCount` | best score in the challenge level (RP9[0]) |

A new game (`loadGame` with no record) uses defaults: combo lengths 3 and 2, max health and
magic 1024, everything else 0. The menu's "erase" entry writes 76 zero bytes to record 2 and
reloads. The save is loaded once, at the end of boot (`loadGame(1)`), and written whenever the game
returns to the main menu (after a level, from game over, or from the pause menu), when the player
continues from a level-intro card (state 109) to the next level, after the sound prompt (state 79),
and on `saveAndQuit` (the pause menu's Quit; skipped from the boot and sound-prompt states).
## To document next

- Which atlas each animation set is drawn with (a game-side pairing; read
  `Game`), and what the timing flag bits 6-7, box `type` values and frame
  flip bits mean in play.
- Type 245 and type 255 structure.
- String tables: parse all six and dump the language/structure.
