#!/usr/bin/env python3
"""Outline a renamed source file: every method with its line range and size, plus
which other methods of the same class it calls. Aids the phase 1 read-through of Game.

    python tools/outline.py Game                 # all methods, in file order
    python tools/outline.py Game --big 150       # only methods of >= 150 lines
    python tools/outline.py Game --calls 4       # show callers/callees of the method starting at line ... (name or line)
"""
import re
import sys
from pathlib import Path

SRC = Path(__file__).resolve().parent.parent / "betrayal" / "src"
SIG = re.compile(r"^   (?:(?:public|private|protected|static|final|synchronized|abstract)\s+)*"
                 r"([\w\[\]<>]+)\s+(\w+)\((.*?)\)\s*(?:throws [\w, ]+)?\s*\{\s*$")
CTOR = re.compile(r"^   (?:public|private|protected)\s+(\w+)\((.*?)\)\s*(?:throws [\w, ]+)?\s*\{\s*$")


def methods(lines):
    """[(start_line, end_line, name, signature)] using the fixed 3-space member indent."""
    out, cur = [], None
    for i, line in enumerate(lines, 1):
        m = SIG.match(line)
        c = CTOR.match(line)
        if (m or c) and cur is None:
            name = m.group(2) if m else c.group(1)
            params = m.group(3) if m else c.group(2)
            cur = (i, name, f"{m.group(1) + ' ' if m else ''}{name}({params})")
        elif cur is not None and line == "   }":
            out.append((cur[0], i, cur[1], cur[2]))
            cur = None
    return out


def main():
    if len(sys.argv) < 2:
        sys.exit(__doc__)
    lines = (SRC / f"{sys.argv[1]}.java").read_text(encoding="utf-8").splitlines()
    ms = methods(lines)
    big = int(sys.argv[sys.argv.index("--big") + 1]) if "--big" in sys.argv else 0
    if "--calls" in sys.argv:
        target = sys.argv[sys.argv.index("--calls") + 1]
        sel = [m for m in ms if str(m[0]) == target or m[2] == target]
        names = {m[2] for m in ms}
        for s, e, n, sig in sel:
            body = "\n".join(lines[s:e])
            callees = sorted({c for c in re.findall(r"\b(\w+)\(", body) if c in names and c != n})
            callers = sorted({f"{n2}@{s2}" for s2, e2, n2, _ in ms
                              if re.search(rf"\b{n}\(", "\n".join(lines[s2:e2])) and n2 != n})
            print(f"{s}-{e} {sig}\n  calls:     {', '.join(callees)}\n  called by: {', '.join(callers)}")
        return
    for s, e, n, sig in ms:
        if e - s + 1 >= big:
            print(f"{s:5d}-{e:<5d} {e - s + 1:5d}  {sig}")
    print(f"\n{len(ms)} methods")


if __name__ == "__main__":
    main()
