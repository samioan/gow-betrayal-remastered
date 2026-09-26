#!/usr/bin/env python3
"""Phase 2: parse the type-245 level blobs (RP9[1], RP19..RP27[0]) and RP9[0].

Replicates, bit for bit, the level loader in betrayal/src/Game.java: the step-0 header
parse in `a(byte[], boolean)` (old e.a(byte[],boolean)), the object-group loop in the same
method (steps 10) and the per-object-type extra fields read by `d(int type, int count)`.
Asserts every blob is consumed exactly (up to the final byte's padding bits).

Bit order (Game.m(n)): LSB-first -- bits are taken from the low end of each byte and the
value is assembled little-endian. l(n) = ceil(log2(n)) = (n - 1).bit_length().

Output goes to stdout (derived from copyrighted data: never commit it).

    python tools/parse_levels.py          # verify every level blob
    python tools/parse_levels.py 19456    # dump one level's summary (resource id = bank << 10 | index)
    python tools/parse_levels.py 19456 map  # ...plus an ASCII tile-type map
"""
import sys
from collections import Counter
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import parse_banks  # noqa: E402
import parse_atlases  # noqa: E402

# Level resource ids (Game.levelIds, old e.bB), and the one extra type-245 blob in RP9.
LEVELS = [9217, 19456, 20480, 21504, 22528, 23552, 24576, 25600, 26624, 27648]

# Extra bits read per object by Game.d(type, count), as [(bits, name), ...]. Types absent from
# this table read nothing beyond the position stream. `once` entries are read once per group.
PER_OBJECT = {
    0: [(10, "span")],
    3: [(1, "vertical"), (1, "reverse")],
    4: [(3, "kind"), (10, "value")],
    5: [(10, "span")],
    7: [(6, "anim"), (1, "flag_a"), (1, "flag_b")],
    8: [(10, "a"), (3, "b")],
    9: [(10, "span"), (3, "b")],
    10: [(10, "span")],
    11: [(3, "b"), (10, "hp"), (1, "flag"), (16, "c"), (16, "d"), (10, "e"), (10, "f"), (1, "g"), (1, "h")],
    12: [(3, "b"), (10, "hp"), (1, "flag"), (16, "c"), (16, "d"), (10, "e"), (10, "f"), (1, "g"), (1, "h")],
    13: [(3, "b"), (10, "hp"), (1, "flag"), (16, "c"), (16, "d"), (10, "e"), (10, "f"), (1, "g"), (1, "h"),
         (1, "big_a"), (1, "big_b")],
    14: [(10, "span")] + [(10, "x"), (10, "y"), (1, "f")] * 15,
    17: [(6, "anim")],
    18: [(10, "span")],
    21: [(6, "anim")],
    22: [(1, "flag"), (10, "up"), (10, "down"), (10, "left"), (10, "right")],
    23: [(8, "anim"), (3, "layer")],
    27: [(3, "anim"), (1, "flag")],
    28: [(10, "w"), (10, "h"), (3, "kind"), (10, "value")],
    29: [(10, "span")],
    30: [(1, "kind")],
    31: [(1, "flag")],
    32: [(6, "anim"), (1, "flag")],
    33: [(6, "anim"), (10, "a"), (3, "delay")],
    34: [(1, "flag"), (3, "a"), (3, "b"), (3, "c"), (3, "d")],
    35: [(3, "a"), (10, "b"), (1, "c"), (1, "d")],
    36: [(6, "anim")],
}
PER_GROUP = {6: [(10, "table_a")] * 40 + [(10, "table_b")] * 40}  # read once, ignores the count


class Bits:
    def __init__(self, data):
        self.d, self.pos, self.left, self.cur = data, 0, 0, 0

    def m(self, n):
        v, want = 0, n
        while want > 0:
            if self.left == 0:
                self.cur = self.d[self.pos]
                self.pos += 1
                self.left = 8
            take = min(want, self.left)
            v |= ((self.cur >> (8 - self.left)) & ((1 << take) - 1)) << (n - want)
            self.left -= take
            want -= take
        return v

    def remaining_bits(self):
        return (len(self.d) - self.pos) * 8 + self.left


def l(n):
    return (n - 1).bit_length()


def parse_level(rid):
    blob, t = parse_atlases.resource(rid)
    assert t == 245, f"{rid}: type {t}, not a level"
    b = Bits(blob)
    b.m(1)
    b.m(10)
    lv = {"id": rid, "size": len(blob)}
    lv["hdr_q"] = b.m(10)
    lv["flip"] = b.m(1) != 1
    lv["dA"] = b.m(1)
    lv["dB"] = b.m(1)
    b.m(1)
    lv["hs"] = b.m(16)
    b.m(1)
    n_types = b.m(16)
    bx = b.m(4)
    tile_of_type = [b.m(bx) for _ in range(n_types)]
    by = l(n_types)
    w, h = b.m(16), b.m(16)
    cells = [b.m(by) for _ in range(w * h)]
    b.m(8)
    solid = [b.m(1) for _ in range(n_types)]
    n_groups = b.m(10)
    bz = l(w * 16 * h * 16 + 1)
    lv.update(types=n_types, tile_bits=bx, w=w, h=h, tile_of_type=tile_of_type, cells=cells, solid=solid,
              groups=[], pos_bits=bz)
    ja = w * 16
    for _ in range(n_groups):
        gtype = b.m(10)
        count = b.m(16)
        x = y = 0
        pos = []
        for _ in range(count):
            x += b.m(bz)
            while x >= ja:
                x -= ja
                y += 1
            pos.append((x, y))
        extras = []
        if gtype in PER_GROUP:
            extras.append([b.m(n) for n, _ in PER_GROUP[gtype]])
        else:
            for _ in range(count):
                extras.append([b.m(n) for n, _ in PER_OBJECT.get(gtype, [])])
        lv["groups"].append((gtype, pos, extras))
    lv["spare_bits"] = b.remaining_bits()
    return lv


def main():
    ids = LEVELS
    if len(sys.argv) >= 2 and sys.argv[1].isdigit():
        ids = [int(sys.argv[1])]
    rows = []
    for rid in ids:
        lv = parse_level(rid)
        assert lv["spare_bits"] < 8, f"{rid}: {lv['spare_bits']} bits left unread"
        c = Counter()
        for gtype, pos, _ in lv["groups"]:
            c[gtype] += len(pos)
        print(f"level {rid:5d} RP{rid >> 10}[{rid & 1023}]: {lv['w']:3d}x{lv['h']:<3d} tiles, {lv['types']:3d} tile types "
              f"({lv['tile_bits']} bits), {len(lv['groups']):2d} groups, {sum(c.values()):4d} objects, "
              f"{lv['size']:5d} bytes, {lv['spare_bits']} spare bits -- exact")
        if len(ids) == 1:
            print("  object counts by type:", dict(sorted(c.items())))
            print("  header: q=%d flip=%s dA=%d dB=%d hs=%d" % (lv["hdr_q"], lv["flip"], lv["dA"], lv["dB"], lv["hs"]))
            if len(sys.argv) >= 3 and sys.argv[2] == "map":
                sym = ".#+*=%@&$!?ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                for y in range(lv["h"]):
                    print("".join(sym[lv["cells"][y * lv["w"] + x] % len(sym)] for x in range(lv["w"])))
        rows.append(lv)
    if len(ids) > 1:
        print(f"\n{len(rows)} levels parsed, all consumed exactly")


if __name__ == "__main__":
    main()
