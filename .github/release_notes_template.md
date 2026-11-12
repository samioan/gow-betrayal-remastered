<!--
The body of every God of War: Betrayal GitHub release, with {{TAG}} substituted by
.github/workflows/release.yml.
-->
## God of War: Betrayal Remastered {{TAG}}

A PC port of *God of War: Betrayal* (the 2007 J2ME mobile game by Glu Mobile),
rebuilt from the game's own decompiled code, with widescreen and high frame
rates. The full game is playable from start to finish: every level, the arena
and both bosses.

### Getting it running

1. Download `GodOfWarBetrayalRemastered-{{TAG}}-win64.zip` below and unzip it
   anywhere.
2. Run **GodOfWar.exe**.
3. Point it at your own copy of the game's Sony Ericsson K800i version (240x320, MIDlet 1.4.20) -- the
   launcher unpacks it for you. Other versions of the .jar are not supported.
4. Press **Play**.

The launcher updates itself: when a newer release exists it offers an
**Update** button.

### This download does not include the game

It cannot: the game belongs to its rights holders. You supply your own copy.

### PC options

The game starts in borderless fullscreen. **Main menu > Options** and the **pause menu** have
**Resolution** (Original, Auto, 4:3, 16:10, 16:9, 21:9: widescreen shows more of the level, and the HUD,
menus and sprites are never stretched) **Fullscreen**, and **FPS** (60 to 240 or unlimited; the game keeps its original speed and the extra frames are
interpolated for smoother movement).

### Notes

- Windows 64-bit. No installer and no Visual C++ redistributable -- unzip
  and run.
- Your game files are unpacked to `data\` next to the launcher; saves and
  display settings live in `%LOCALAPPDATA%\gow-betrayal-port\`.

*God of War* is a trademark of Sony Interactive Entertainment. This
project is not affiliated with or endorsed by Sony or the game's original
developers.
