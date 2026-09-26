#!/usr/bin/env python3
"""Unpack the game's .jar (a plain zip) into betrayal/extracted/, unmodified.

Usage: python tools/extract_jar.py [betrayal]
  reads roms/God-of-War-Betrayal_J2ME_EN_v148.jar (Glu Mobile, MIDlet 1.4.8,
  built by Metaflow) and writes betrayal/extracted/ (gitignored).
"""
import sys
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent

# game key -> (jar in roms/, game dir, extraction subdir)
BUILDS = {
    "betrayal": ("God-of-War-Betrayal_J2ME_EN_v148.jar", "betrayal", "extracted"),
}


def extract(game: str) -> None:
    jar_name, game_dir, sub = BUILDS[game]
    jar_path = ROOT / "roms" / jar_name
    out_dir = ROOT / game_dir / sub
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
