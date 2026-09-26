# God of War: Betrayal -- class map

Obfuscated name -> role, with evidence. Names live in `names.map`; the
compile-checked renamed tree is `betrayal/src/` (regenerate with
`python tools/rename_gow.py` -- never edit `src/` by hand).

| Old | New | Confidence | Evidence |
|---|---|---|---|
| `GOWMIDlet` | `GOWMIDlet` | certain | MIDlet entry (manifest `MIDlet-1`); `startApp` creates `new e(this)` and calls `Display.setCurrent`; `destroyApp` calls `a.j(3)`; `pauseApp` -> `hideNotify` |
| `a` | `Engine` | certain | `abstract class a extends GameCanvas implements Runnable`: game loop thread, key handling (`keyPressed`), full-screen + 240x320 setup (`c(240, 320)`), RMS blob store, `RP*` bank loader (`a.m`, `a.a(DataInputStream)`), sprite/anim/string-table loaders, font |
| `b` | `Scene` | certain | wrap-around scrolling renderer: a 240x320 offscreen ring buffer plus a 16x16 tile layer, a sorted static-sprite layer and a linked list of dynamic objects (see below); created by `Scene.create(240, 320)`, driven by `Game` (`setScroll`, `draw`, `setTile`, `addStaticSprite`, `addObject`) |
| `c` | `Sprite` | certain | wraps one atlas `Image`; holds a frame rectangle loaded from a `short[10]`; `a(Graphics, x, y, flags)` clips against the image and `drawRegion`s it with anchor 20 (TOP\|LEFT). Same shape as Clone Home's `Sprite` (`f`) |
| `d` | `SoundPlayer` | certain | `Runnable`; `Manager.createPlayer` over in-memory MIDI (`audio/midi`, `video/3gp` for type 14); rewrites MIDI tempo/division on load |
| `e` | `Game` | certain | `extends a` (Engine); reads `ENABLECHEATS`/`DEMO`/`DemoBuyURL`; ~8.5k lines of state machine, combat, rendering |

## Decompiler artifacts fixed by `tools/rename_gow.py`

- Member names that are Java keywords (`Game.do`) become `do_` automatically
  (in `ChRenamer`), whether or not `names.map` mentions them.
- `Game`'s static initializer holds obfuscator dead code (three arrays built
  and popped, never stored to a field -- verified with `javap -c`); removed.
- `SoundPlayer`: an `int` local typed `short` by Vineflower.

## Engine (a) -- read through, members renamed

`Engine` is a `GameCanvas` + `Runnable` and owns everything generic. Roles,
all confirmed from the code in `betrayal/src/Engine.java`:

- **Game loop** (`run`): each tick `processLifecycle`, measure `frameTime`
  (clamped to `[minFrameTime, maxFrameTime]`; `Game` sets 40 / 100 ms, i.e. a
  25 FPS target), call `update()`, step the `SoundPlayer`, then
  `paintFrame(getGraphics())` + `flushGraphics()`. `render(Graphics)` and
  `update()` are the two abstract hooks `Game` implements.
- **Lifecycle** (`onLifecycle`/`postLifecycle`/`processLifecycle`): codes
  0 = start, 1 = pause (`hideNotify`), 2 = resume (`showNotify`, applied after
  750 ms so a resume event can settle), 3 = destroy, 5 = resume-input.
  Pausing mutes sound (`mutedByPause`, `soundBeforePause`); `Game` overrides
  `onLifecycle` to switch to its pause state.
- **Display** (`setViewSize`, `paintFrame`, `setClip`): logical view is
  `viewWidth x viewHeight` (default 240x320) centred on the device canvas by
  `viewOffsetX/Y`; borders are cleared to black only when `requestClear()`
  was called.
- **Input** (`handleKey`, `pollKeys`, `clearKeys`): `keyCodeTable` maps bit
  index to a MIDP key code (1=UP -1, 2=LEFT -3, 3='#' 35, 4=CLEAR -8,
  5=RIGHT -4, 6=DOWN -2, 8=FIRE -5, 10='*' 42, 16..25 = digits '0'..'9',
  27/29 = soft keys -6/-7). Three bitmasks -- `pendingPressed` (edge events),
  `downKeys`, `pendingReleased` -- are folded once per frame by `pollKeys` into
  `keysPressed` (edges this frame) and `keysHeld` (edges | still down), so a
  tap shorter than one frame still registers.
- **Resources** (`selectBank`, `parseBank`, `getResourceBytes`,
  `openResource`, `loadImage`, `loadSprites`, `loadStringTable`,
  `getString`): see `ASSET_FORMATS.md`. `loadImage(id, swap)` swaps the PNG
  `PLTE` chunk's bytes with `swap` around `Image.createImage` (palette recolour).
- **Text** (`setFont`, `stringWidth`, `drawString`, `findGlyph`): bitmap
  font from a sprite atlas (glyphs sorted by char code, binary-searched), or
  the system `Font` if none is set.
- **Save store** (`readRecord`, `writeRecord`, `syncSettings`): RMS store named
  by an integer id, blob chunked at 589,824 bytes. `syncSettings` keeps the
  3-byte settings record at id **-9** (byte 0 = sound on).
- **Animation runtime** -- next section.

### Animation data model

Per loaded animation set, indexed by position in `animSetIds` (bit 15 of an id
marks it persistent across `releaseTransientAnimSets`). Bit layouts follow the
shifts in `loadAnimSet` and the readers (`getFrameParts`, `getFrameBoxes`,
`stepAnim`):

| Field | Meaning |
|---|---|
| `animHeaders[anim]` | `firstStep << 16 \| loopCount << 10 \| stepCount` (loop count signed 6-bit, 0 = forever) |
| `animFrameTiming[step]` | duration index (bits 0-5) + flags (bits 6-7) |
| `animFrames[step]` | `frameId << 22 \| dx << 12 \| dy << 2 \| interpFlag` (dx/dy signed 10-bit, flag 2-bit) |
| `frameHeaders[frame]` | `firstPart << 16 \| boxCount << 8 \| partCount` |
| `frameParts[part]` | `spriteIndex << 22 \| x << 12 \| y << 2 \| flip` (2-bit flip) |
| `boxStart[frame]`, `boxPos[box]`, `boxSize[box]` | boxes: `boxPos` = `x << 21 \| y(11-bit) << 10 \| width`, `boxSize` = `height << 6 \| type` |
| `frameDurations[i]` | step length in ms |
| `animSlots` (8 shorts each) | live state: set, anim, step, loops left, time, x, y, best step |

`startAnim(slot, setId, anim)` initialises a slot; `stepAnim(slot, dt)`
advances it and returns whether it is still running, leaving the interpolated
movement in `animDeltaX/Y`; `getFrameParts`/`getFrameBoxes`/`getFrameBounds`/
`drawFrame` read the slot's current frame.

## Sprite (c)

One frame rectangle of an atlas: `offsetX/Y`, `width/height`, `srcX/srcY`
(old fields `i`, `j`), `advance`, `metric`, `charCode`; `e`/`f` double as
extra per-sprite values in non-font atlases (`f` is still unnamed).
`draw(g, x, y, flags)` clips to the sheet and `drawRegion`s it; `flags` bit 1 =
flip X, bit 0 = flip Y (via `anchorOffsetX/Y`).

## SoundPlayer (d)

12 slots (`new SoundPlayer(engine, 12)`): each slot has a `Player`, a loop count and a
priority. `load(slot, resourceId, loops, priority)` builds a `Player` over the in-memory
MIDI resource (`padMidi` first extends short *looping* MIDIs by appending a near-silent
long-delta controller event so they are not cut off -- it rewrites the last track's
length -- evidence: it parses the SMF chunks/tempo and writes a variable-length delta);
`play(slot)` only *queues* the slot (highest priority wins, an equal-or-higher
playing sound is not interrupted) and the engine calls `run()` once per frame to start
it. `stop`, `unload`, `shutdown`, `isSoundOn`/`setSoundOn` (persists through
`Engine.syncSettings`). Game loads slots 0..2 at boot: `1063` (loops forever = music),
`1064` and `1062` (one-shots) -- all type-0 MIDI resources.

## Scene (b)

A scrolling world renderer. `bufferWidth x bufferHeight` (240x320) offscreen `Image` used as
a **toroidal buffer**: `setScroll(x, y)` sets the camera; `updateBuffer` redraws only the strips
that scrolled into view (`redrawRegion` splits them where they wrap), and `blitWrapped` copies
the ring buffer to the screen in up to four pieces. Three layers are composited into the
buffer, in order, by `redrawRect`:
1. **Tile map** (`setTileMap(cols, rows, sheet, tileW, tileH)`, `setTile`): `short[]`, tile id
   `& 4095`, 0 = empty, else sheet cell `id - 1` (cells are enumerated left-to-right,
   top-to-bottom over the sheet). Game uses 16x16 tiles and stores `1 + tileSheetIndex`.
2. **Static sprites** (`initStaticSprites(capacity, sortByY)`, `addStaticSprite`): scenery,
   kept sorted by x (or y for tall levels, `sortByY = width <= height`) and binary-searched
   for the redrawn rectangle; positions are packed as `x << 17 | y << 2 | flip`.
3. **Dynamic objects** (`initObjects(n)`, `addObject` -> slot index): a free-list linked list
   (`objNext`/`objPrev`, `objHead`/`objTail`) of sprites the game repositions each frame;
   `objFirstDirty` marks where the redraw begins. While `objectsOnly` is set, layers 1-2 are
   skipped (used to redraw objects over an already-valid buffer).

## Game (e) -- read so far

**State machine.** The static int `state` (old `I`) is switched on in `update()`,
`render()` and `updateBars()`. Seen so far: `0` boot (staged asset loading, `bootStep` 0..13),
`78` language select (six languages, `languageIndex`), `79` "sound on/off?" prompt (left
soft key = on, right = off), `80` main menu (`menuTable`), `1` level loading
(`loadLevelStep`, `levelLoadStep` 0..10), `100` playing (`z()` = the gameplay update),
`101` dialogue, `102` pause menu, `104`/`105` transitions/cutscene control,
`106` upgrade screen (`updateUpgradeScreen`), `107` text screen, `108`, `109` level
intro/"next level" card. The remaining state meanings (`101`, `104`, `105`, `108`) are still
guesses -- confirm from their handlers.

**Letterbox bars.** The screen has a top and a bottom black bar (`topBar`, `bottomBar`, heights
in 1/256 px) that `drawBars` (old `c(Graphics)`) paints over the scene, with a 14 px softkey/status
bar at y=306 (`drawBottomBar`). `setBarTargets(top, bottom, speedTop, speedBottom)` (old
`a(int,int,int,int)`) sets the target heights; `updateBars` (old `m()`) moves them there each frame
and switches `state` when they arrive. Closing both to `halfHeight` covers the screen: that is how
loading screens, the game-over card (state 108) and the pause menu (102) appear, with text drawn
on the black; opening them to 0 reveals the game.

**Input.** `readPressedKey`/`readHeldKey` collapse the engine's key bitmasks into one logical
code (`pressedKey`, `heldKey`): 1/2/5/6 = up/left/right/down (arrows or 2/4/6/8), 8 = fire (or
5), 27 = left soft key, 29 = right soft key, ASCII for `0-9 * #`.

**Timing/camera.** `frameDelta = frameTime >> hH` (game speed shift), `randomValue =
random.nextInt()` every frame. `updateCamera` eases `cameraX/Y` (`iQ`, `iR`) toward a look-ahead
target around the player, with lock rectangles (`aE`/`aF`, from level object type 3), screen
shake (`av`/`aw`/`ax`) and clamping to `maxCameraX/Y`.

**Upgrade screen.** State 106: `upgradeSelection` (0..3) picks one of four tracks; holding
fire/soft-key drains `upgradePoints` (`hq`) into the current level of the track (`gP`, `gQ`,
`gV`, `gW`, 0..4) at the costs in `gR..gU` = 1000/2000/3000/4000 per level, with a 2.5 s
pause after each level-up. Cheat build (`cheatsEnabled`): keys 7/9 remove/add 20 points.

**Level loader.** See `ASSET_FORMATS.md` ("Level files"): `loadLevelStep`, `spawnObjects`,
`readBits`, `cellFlags` (`getCellFlags`/`setCellFlags`/`clearCellFlags`), `buildStaticSprites`
(feeds the `Scene` static layer from object type 23).

**Entity state** is stored as parallel arrays per class (sizes 10/15/20/40, indexed by
entity number). Each class owns a block of animation slots: `startAnim(base + i, set, anim)`.

| Anim slots | Set | Owner |
|---|---|---|
| 0-9 | 7168 (RP7) | hit/impact **effects** (`spawnEffect`, `effectAnim`...) |
| 10-29 | 3074 | scenery type 36 |
| 30-39 | 5122 | boxed props (type 32) |
| 40-59 | 3072 | scenery type 17 |
| 60-69 | 5121 | health props (type 21) |
| 70-84 | 6145 | **hazards** (type 33) |
| 85-99 | 4096/18432, 16384/17408, 15360 (+13312/14336 boss) | **enemies** (classes 1, 2, 3) |
| 100-105 | 2049 | **gates** (type 35) |
| 106-110 | 2050 | **switches** (type 34) |
| 111-115 | 6144 | **pushable crates** (type 27) |
| 116-120 | 2048 | **breakable walls** (type 7) |
| 121-130 | 5120 | **chests** (type 4) |
| 131-132 | 1027 | on-screen prompts (**quick-time-event** key icons, dialogue arrow) |
| 135 | **28672 (RP28)** | **the player** (122 animations, 15,019 parts) |
| 136-137 | 1026 / 7168 | temporaries |

## Gameplay (`Game.updateGameplay`, old `z()`, 2,170 lines) -- read through

One call per frame while `state` is 100/105/108. Order: (1) sample the cells under the
player (`onGround` = flag 1, `onPlatform` = flag 8192, `gA/gB` = ledge-grab flags 2048/4096
above), trigger dialogue when the player's cell has flag 128; (2) handle input through
`heldKey` (movement, climbing) and `pressedKey` (actions), or QTE input when `qteActive`;
(3) return the player to idle/fall when an action's animation ends; (4) update every entity
list in turn: chests, pickups, effects, decor, switches, gates, health props, crates, breakable
walls, hazards, then the **enemies**.

**Player.** `playerAction` (`hA`) is the requested action, `playerAnim` (`hB`) the animation
actually shown (the same action id shifted to a variant when a magic mode is active);
`setPlayerAction(id)` (old `s(int)`) does the mapping, resets the combo/attack flags and starts
slot 135. Position `playerX` (centre) / `playerY` (feet) in pixels; `playerWidth`/`playerHeight`.
`facingRight`. Stats: `health`/`maxHealth`, `magic`/`maxMagic` (the meter magic attacks drain),
`upgradePoints` (**red orbs**, spent on the upgrade screen), `orbsCollected`/`orbBudget` (orbs
the level may still spawn). Status flags: `blocking` (holding Down), `climbing`,
`grabbingLedge`, `pushing`, `usingSwitch`, `openingChest`, `attacking`, `airAttacking`,
`attackQueued`/`queuedFacingRight` (buffered next attack), `blockedHit`, `hitFromRight`.

Controls (phone keys): `2`/`5` (or Left/Right) walk, `1` (Up) jump / climb / grab ledge, `6`
(Down) block, open chests, pull levers, finishers when near a weakened enemy, drop through
one-way platforms, `8` (Fire) attack, `*`/left soft key cycle **`weaponMode`** 0..3, right soft
key = pause, `#` = upgrade screen. Cheats when `ENABLECHEATS`: `7` kills the player, `9` refills
health, `0` and `3` toggle invulnerability / one-hit kills, `7`/`9` on the upgrade screen adjust orbs.

**Weapon modes.** `weaponMode` 0 = the **blades** (damage `fI[combo] << bladesLevel`, combo
length `bladesComboLength`), 1 = `magicModeA` (damage `fJ[combo] << magicALevel`, drains
`magic` per hit, own combo `magicAComboLength`), 2 = `magicModeB` (no damage: freezes/stuns
enemies for `fK[magicBLevel] << 5` ms via `enemyStatus`), 3 = `magicModeC` (needs > 256 magic;
a special attack, action 95). Mode B is a held beam: holding Fire drains 12 magic per frame (action 94). The four upgrade tracks on the upgrade screen are exactly these
(`bladesLevel`, `magicALevel`, `magicBLevel`, `magicCLevel`, 0..4, costs 1000/2000/3000/4000).
`resetWeaponMode()` returns to the blades.

**Finishers / quick-time events.** When an enemy's health is under half and the player stands
near it and presses Down, the game enters `qteActive`: time slows (`slowMotionShift = 1`), an icon
(anim set 1027, slot 131) shows a random direction: `qteDirection` 0..4 = Up, Left, Fire,
Right, Down, drawn with icon animation `qteKeyAnims[direction]` = {2, 4, 5, 6, 8}; each correct press advances `qteProgress` until
`qteRequired` (2 or 3) and plays the kill animation (actions 88-93, 108-117); a wrong key
cancels it.

**Enemies** (`enemy*` arrays, up to 15): `enemyClass` 1/2/3, `enemyAction` (0 idle, 1 patrol,
2 hurt, 3/5/6 attacks, 7-10 deaths...), position/home/tile position, `enemyHealth` (static) /
`enemyMaxHealth`, `enemyContactDamage`, `enemyDropAmount`, respawn count/timer/delay,
`enemyStatus` (freeze timer), `enemyFacingRight`. The AI in the enemies loop is a per-class
distance/cell-flag decision tree that picks the next action from player distance, line of
sight and floor checks. Boss class-3 variants: `bossIndex`, `finalBossIndex`
(`finalBossPhase` counts to 3 and makes the player invulnerable for the ending cutscene).
Hits: the player's attack boxes (`playerBoxes`, slot 135 frame boxes 0 and 1) overlapping the
enemy's hurt boxes (`enemyBoxes[0..9]`) deal damage and spawn `spawnEffect`s; the enemy's box 2
(`enemyBoxes[10..13]`) hurts the player; while `blocking` the damage is negated and `blockedHit` is set instead.

**Pickups** (up to 20 in flight): `spawnPickup(x, y, kind, amount)` where `pickupKind` 0 = red
orbs, 1 = health, 2 = magic, 3 = a **damage projectile** that homes on an enemy
(`pickupTarget`). They drift toward the player (or target), become collectable after 75 ms.

**Switches/gates/arenas.** `triggerSwitchTargets(i)` toggles every gate whose `gateId` equals one of
the switch's four targets (`switchTargets`); `countArenaKill(enemy)` toggles gates when an arena
zone (type 28) has had `arenaKillsNeeded` kills. Gates that `gateShowsCamera` set `cameraPanX/Y`
so the camera pans to them for up to 3.5 s.

## Menus, HUD and screens

- **Menu table** (`menuTable`, resource 1028; see `ASSET_FORMATS.md`): each int packs a type in bits
  26+ (0 = go to page `bits 8-15`; going to page 9 with `levelIndex == 0` instead starts a new game at level 1; 1 = sound toggle, 3/4 = about/help pages, 5 = **start level**
  `menuCursor - levelListStart`, 6 = **start the challenge level** (9216), 8 = quit, 9 = resume the game from the pause
  state, 10 = save and leave for the main menu, 11 = erase save
  (writes 76 zero bytes, reloads), 12 = cycle language), a string id in the low byte, and flags
  (bit 22 first-of-page, 23 last-of-page, 24 has label, 25 selectable, 24/25 also mark unlocked
  level entries). `updateMenu` (old `K()`) moves `menuCursor` with Left/Right (keys 2/5) and acts on
  fire/left soft key; `drawMenu` (old `w`) draws the page over a procedural **fire effect**
  (`updateFireEffect`: a random-seeded heat buffer decays upward through a palette).
- **Pause menu** (state 102, `pauseMenuIndex`): 4 = sound on/off, 3 = help/controls, 2 = return to the
  main menu (asks to confirm), 1 = quit (asks to confirm).
- **Game over** (state 108) shows the level name; in the **challenge level** (RP9[0], `challengeMode`)
  it shows `killCount` and the best score; reaching 1000 kills ends the challenge (string 275).
- **HUD** (`drawHud`): frame anim on slot 133, the current weapon icon (`5 + weaponMode`), a health
  bar at (42, 14) scaled `maxHealth * 6 >> 8` px (24 px at the starting 1024), a magic bar below it
  (flashes `flashColor` when empty in a magic mode) and the red-orb count at (58, 24). The bottom bar
  (`drawBottomBar`) shows the soft-key labels, the **hit-combo counter** (`comboHits`, shown for 2 s
  after a hit) or, inside an arena, "N enemies left".
- **World drawing order** (`drawWorld`): `Scene` (tile map, scenery, objects) then scenery, hazards,
  health props, switches, boxed props, gates, pushables, breakables, chests, enemies and player (the
  player is drawn before the enemy it is grappling), pickups, effects, scenery 17.
- **Chest popup** (state 104): frames "You found a Health/Magic chest", raises max health or magic.
- **Demo build**: with `DEMO = n` the game stops after `n` levels and shows a buy-URL screen.

## Movement and collision (`movePlayer`, `onPlayerCell`, `moveEnemy`, `checkEnemyCell`)

Movement is **animation-driven root motion**: `Engine.stepAnim` leaves the current frame's
movement in `animDeltaX/animDeltaY` (pixels; x is relative to facing), and the game moves the
character by exactly that. The physics is therefore in the animation data plus a few rules:

- **Gravity** is only the falling action (26): `animDeltaY += fallSpeed`, where `fallSpeed`
  grows by 4 every 200 ms up to 8. A landing from `fallSpeed >= 4` shakes the camera.
- `movePlayer(tileX, tileY)` moves in 1/256-pixel steps (`subX`, `subY`; 4096 = one 16 px
  tile). For every cell it enters it calls `onPlayerCell`, then tests the player's body (height /
  16 rows) against solid cells (flag 1). `canMoveX`/`canMoveY` say whether the step was allowed;
  a blocked axis snaps the player to the cell edge (`blockedByWall`), a blocked downward move
  lands (`landed`, action 27, or 50 on a beam, or 95's shock-wave pickup). The leading and
  trailing collision extents are `frontExtent` / `backExtent`.
- **Ledges:** while falling, if the cell above a ledge is free and the ledge cell is solid the
  player hangs on it (`ledgeHanging`, actions 37/40); moving up from a hang mounts it (action 38).
  Head entering a one-way platform (8192) mounts it (action 120); head entering a ceiling bar
  (16) hangs from it (`hangingOnBar`, action 45).
- **Ladders/ropes** (flag 8): moving into one while Up/Down starts climbing (action 33); reaching
  the top sets `atLadderTop`.
- **Pushing:** walking into a pushable (512) starts action 21 and records `pushedCrate`;
  `tryPushCrate` moves it one tile (two for the alternate push) if the cells beyond are free, moving
  its solid/pushable/climbable flags with it.
- `onPlayerCell` (called per cell) handles: checkpoints (1024), **tripwires** (256 -> toggle gates
  with the same id), **enemy wave triggers** (4 -> reposition every off-screen enemy to the
  wave's slot), and arena entry (32).
- Enemies use the same algorithm (`moveEnemy` / `checkEnemyCell`, with `enemySubX/Y`,
  `enemyCanMoveX/Y`, `enemyOnGround`, `enemyClimbing`): class 1 can climb ladders and jump between
  ledges; landing plays class-specific actions and, when the enemy is dead (`health < 0`), drops its
  pickup (class 1: red orbs, class 2: magic, class 3: red orbs; the boss stays on its feet).

**Other helpers named:** `resetLevelState` (clears every entity list and sprite set before a level
loads), `advanceScript` (next dialogue line, or the end-of-level cutscene chain), `spawnDebris`
(adds a dead enemy's / broken prop's sprite parts to the `Scene` as static objects, capped at 1000).

**Renamed so far:** see `names.map` (Game sections). Everything else keeps its obfuscated name:
notably `Game.f/g/d/e/i/K/w`... (player movement/collision, enemy movement, the menus and HUD
drawing).

## Other renames

`GOWMIDlet.a` -> `game`. Methods ending in `Alias` are one-line forwarding
duplicates the obfuscator left in `Engine` (e.g. `loadImageAlias` ->
`loadImage`).
