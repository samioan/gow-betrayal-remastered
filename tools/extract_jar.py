#!/usr/bin/env python3
"""Unpack the game's .jar (a plain zip) into betrayal/extracted/, unmodified.

Usage: python tools/extract_jar.py [betrayal]
  reads roms/God-of-War-Betrayal_K800i_v1420.jar (the Sony Ericsson K800i
  build: Glu Mobile, MIDlet 1.4.20, built by Metaflow -- 22x22 tiles, parallax
  backgrounds, higher-resolution art) and writes betrayal/extracted/
  (gitignored). Any previous extraction is removed first.

The project targets this build only. The earlier generic v1.4.8 jar
(16x16 tiles, no parallax) is no longer supported: its data does not fit the
renamed code or the port.
"""
import shutil
import sys
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent

# game key -> (jar in roms/, game dir, extraction subdir)
BUILDS = {
    "betrayal": ("God-of-War-Betrayal_K800i_v1420.jar", "betrayal", "extracted"),
}


def extract(game: str) -> None:
    jar_name, game_dir, sub = BUILDS[game]
    jar_path = ROOT / "roms" / jar_name
    out_dir = ROOT / game_dir / sub
    if not jar_path.exists():
        sys.exit(f"{jar_path} not found -- put the K800i jar there (see README.md)")
    if out_dir.exists():
        shutil.rmtree(out_dir)
    out_dir.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(jar_path) as zf:
        zf.extractall(out_dir)
    print(f"{game}: extracted {jar_name} -> {out_dir.relative_to(ROOT)}")


def main() -> None:
    games = sys.argv[1:] or list(BUILDS)
    for game in games:
        if game not in BUILDS:
            sys.exit(f"unknown game {game!r}, expected one of {list(BUILDS)}")
        extract(game)


if __name__ == "__main__":
    main()
