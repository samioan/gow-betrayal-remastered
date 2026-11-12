# Notices and attribution

This project is a from-scratch, behavioural re-implementation of
*God of War: Betrayal* (the 2007 J2ME/mobile Java game by Glu Mobile,
built by Metaflow), written by reading the original game's own decompiled
bytecode (see `betrayal/docs/`). It is not affiliated with, endorsed by, or
supported by Sony Interactive Entertainment, Santa Monica Studio, Glu
Mobile, Metaflow, or the game's original developers and publishers.

## What this project does not contain, and never will

**The game.** No script, image, sound, string table or byte of the original
`God-of-War-Betrayal_*.jar` release is committed here, and none is
distributed with any release. See `.gitignore`. The Java under
`betrayal/decompiled/` and `betrayal/src/` is decompiler output kept as the
record of the reverse engineering, and the released executables contain code
derived from it. Neither can run without the original game data, which you
supply yourself.

## Artwork and third-party code

The launcher's background and icon are the game's promo art, supplied by the
project owner (`betrayal/port/src/launcher/assets/banner_source.png`; the
`banner.png` and `gow.ico` files are generated from it by
`tools/make_banner.py` / `tools/make_icon.py`). `.github/social-preview.jpg`
is made from the same image. The "God of War" wordmark and Kratos in it
belong to their owners.

| Component | Licence | Where |
|---|---|---|
| `stb_image` | public domain / MIT | `betrayal/port/third_party/stb/` |
| `puff` (zlib's reference inflate) | zlib | `betrayal/port/third_party/puff/` |
| `javalang` (dev tool only, not shipped) | MIT | used by `tools/java2cpp.py` |
| Vineflower (dev tool only, not shipped) | Apache-2.0 | `tools/vineflower.jar` |

The launcher's file picker uses `IFileOpenDialog` (COM) and its update check
uses WinHTTP, both Windows system components. Release builds link the CRT
statically, so no Visual C++ redistributable is needed.

## Trademarks

"God of War" and "God of War: Betrayal" are trademarks of Sony Interactive
Entertainment LLC. All names are used here for identification and
documentation of the decompilation process only.
