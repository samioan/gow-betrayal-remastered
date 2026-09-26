#!/usr/bin/env python3
"""Run the PC port headless with scripted key presses and save a contact sheet of screenshots.

Each screenshot is a separate run from a clean save folder (the port is deterministic apart
from the RNG seed), on a fake 40 ms clock, so `--frames 700,900` shows the game after 700 and 900
logic frames. Needs Pillow (`pip install pillow`) and a built port (betrayal/port/build.bat).
Output is derived from game data: never commit it.

    python tools/port_shots.py --frames 60,160,260 -o sheet.png
    python tools/port_shots.py --frames 700,1100 --press -6@170 --press -6@260 -o level.png

`--press KEY@FRAME[:HOLD]` uses MIDP key codes: -1 up, -2 down, -3 left, -4 right, -5 fire (attack),
-6 left soft key (confirm / weapon cycle), -7 right soft key (skip / pause), 35 '#', 42 '*'.
`--story` adds the presses that get from boot to the first level: language, sound, Play Game,
New Game, skip the intro crawl (about 700 frames).
"""
import argparse
import os
import shutil
import subprocess
import sys
import tempfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
STORY = ["-6@170:3", "-6@260:3", "-6@420:3", "-6@520:3", "-7@640:3"]


def main():
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--frames", required=True, help="comma-separated logic frame counts, one screenshot each")
    ap.add_argument("--press", action="append", default=[], help="KEY@FRAME[:HOLD], repeatable")
    ap.add_argument("--story", action="store_true", help="press through boot to the first level")
    ap.add_argument("--width", type=int, default=0, help="logical canvas width in px (240 = original, 569 = 16:9; default: 240)")
    ap.add_argument("--width-change", default="", help="FRAME:WIDTH, switch the logical width mid-run (tests the resolution setting)")
    ap.add_argument("--exe", default=str(ROOT / "betrayal/port/build/gow_port.exe"))
    ap.add_argument("--data", default=str(ROOT / "betrayal/extracted"))
    ap.add_argument("-o", "--output", default="shots.png")
    a = ap.parse_args()
    try:
        from PIL import Image
    except ImportError:
        sys.exit("Pillow is required: pip install pillow")
    if not Path(a.exe).exists():
        sys.exit(f"{a.exe} not found -- build the port first (betrayal/port/build.bat)")

    presses = (STORY if a.story else []) + a.press
    frames = [int(f) for f in a.frames.split(",")]
    tmp = Path(tempfile.mkdtemp(prefix="gow_shots_"))
    images = []
    try:
        for n in frames:
            saves = tmp / f"saves{n}"
            saves.mkdir()
            bmp = tmp / f"f{n}.bmp"
            cmd = [a.exe, "--data", a.data, "--saves", str(saves), "--dump", str(bmp), "--frames", str(n)]
            if a.width:
                cmd += ["--width", str(a.width)]
            if a.width_change:
                cmd += ["--width-change", a.width_change]
            for p in presses:
                cmd += ["--press", p]
            subprocess.run(cmd, check=True, cwd=tmp)
            images.append(Image.open(bmp).convert("RGB"))
        w = sum(i.width for i in images) + 10 * (len(images) - 1)
        sheet = Image.new("RGB", (w, max(i.height for i in images)), (40, 40, 40))
        x = 0
        for i in images:
            sheet.paste(i, (x, 0))
            x += i.width + 10
        sheet.save(a.output)
        print(f"wrote {a.output}: {len(images)} screenshots at frames {frames}")
        log = tmp / "exceptions.log"
        if log.exists():
            print("the game logged exceptions:\n" + log.read_text()[:1500])
    finally:
        shutil.rmtree(tmp, ignore_errors=True)


if __name__ == "__main__":
    main()
