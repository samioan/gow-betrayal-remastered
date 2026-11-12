God of War: Betrayal - Remastered
=================================

A PC port of the 2007 J2ME mobile game "God of War: Betrayal" (Glu Mobile),
rebuilt from the game's own decompiled code.

STATUS: complete. The whole game -- every level, the arena and both bosses -- has been played
through. Future updates are possible, and the launcher installs them for you.

Controls: arrows/WASD move, Space/J/Z attack, K/X/Q/E cycle weapons (the left soft key),
Esc/P pause (the right soft key), Tab/U upgrade screen. Gamepad, in a level: d-pad/stick move,
A jump, X attack, B grab/block, Y or right shoulder cycle weapons, left shoulder or Back open
the upgrade screen, Start pauses. Gamepad, everywhere else (menus, cutscenes, pop-ups): A/Cross
confirms, B/Circle backs out or exits, matching the on-screen Select/Exit labels. F11 or
Alt+Enter toggles fullscreen.

The game starts in borderless fullscreen. Main menu > Options and the pause menu (press Left twice
past Sound) have PC settings: Resolution (Original, Auto, 4:3, 16:10, 16:9, 21:9 -- the level shows
more to the sides; nothing is stretched) Fullscreen and FPS (Original, 60, 90, 120, 144, 165, 240, Unlimited: the game logic keeps its original
speed, extra frames are interpolated for smoother movement). The launcher's Windowed option starts in a window.


WHAT YOU NEED
-------------

This download does NOT include the game. It cannot: the game belongs to
its rights holders. You supply your own copy of the J2ME .jar, the Sony
Ericsson K800i version (240x320, MIDlet 1.4.20; other versions are not
supported). The launcher unpacks it for you --
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
