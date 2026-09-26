God of War: Betrayal - Remastered
=================================

A PC port of the 2007 J2ME mobile game "God of War: Betrayal" (Glu Mobile),
rebuilt from the game's own decompiled code.

STATUS: early build. The game runs from the splash screens through the first level; it has
not been played all the way through yet, so expect rough edges.

Controls: arrows/WASD move, Space/J/Z attack, K/X/Q/E cycle weapons (the left soft key),
Esc/P pause (the right soft key), Tab/U upgrade screen. Gamepad: d-pad/stick, A attack,
X weapons, B/Start pause, Y upgrade screen. F11 or Alt+Enter toggles fullscreen.

The game starts in borderless fullscreen. Main menu > Options and the pause menu (press Left twice
past Sound) have PC settings: Resolution (Original, Auto, 4:3, 16:10, 16:9, 21:9 -- the level shows
more to the sides; nothing is stretched) Fullscreen and FPS (Original, 60, 90, 120, 144, 165, 240, Unlimited: the game logic keeps its original
speed, extra frames are interpolated for smoother movement). The launcher's Windowed option starts in a window.


WHAT YOU NEED
-------------

This download does NOT include the game. It cannot: the game belongs to
its rights holders. You supply your own copy of the J2ME .jar
(God-of-War-Betrayal_J2ME_EN_v148.jar). The launcher unpacks it for you --
you don't need to extract it first.


HOW TO PLAY
-----------

Run GodOfWar.exe. Click "Choose file..." and pick your .jar. Choose
Fullscreen or Windowed. Press Play.

Everything you add is copied into this folder (data\), so you can delete or
move your original .jar afterwards and nothing breaks.

The launcher checks GitHub for new versions on start-up and offers an
"Update" button when there is one. Your saves are kept.


WHERE YOUR FILES GO
-------------------

  data\             the game files you supplied (unpacked from your .jar)
  launcher.cfg      the launcher's own settings
  %LOCALAPPDATA%\gow-betrayal-port\   saves and display settings

Delete this folder to uninstall; delete the %LOCALAPPDATA% one too to also
remove your saves.


NOTICE.md lists the licensing and what this project is and is not.
