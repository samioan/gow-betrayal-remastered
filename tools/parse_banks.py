#!/usr/bin/env python3
"""Phase 0/2: validate every RP<n> resource bank of God of War: Betrayal.

Replicates the container loader in a.java (`a.a(DataInputStream)` / `a.m(int)`)
and asserts that each bank's length table, type table and payload size agree
exactly. Prints a per-bank summary and a global type histogram. Output goes to
stdout (derived from copyrighted data: never commit it).

Container layout (all big-endian), same as the Ratchet & Clank: Clone Home banks:

    u8   flags        bit0 -> offset width: 2 bytes (0) or 4 bytes (1)   [width = (1 + (flags & 1)) << 1]
    u16  count        number of resources
    u<width>[count]   length of each resource
    u8[count]         type byte of each resource
    u32  total        payload size (== sum of lengths)
    u8[total]         payload: resources back to back

A resource id is (bank << 10) | index: bank = id >> 10 selects /RP<bank>
(bank 0 means "the bank already loaded"), index = id & 1023.

    python tools/parse_banks.py            # verify every bank
    python tools/parse_banks.py dump 1 5   # list resource 5 of bank 1 (type, length, head bytes)
"""
import re
import struct
import sys
from collections import Counter
from pathlib import Path

EXT = Path(__file__).resolve().parent.parent / "betrayal" / "extracted"


def bank_numbers():
    nums = [int(m.group(1)) for p in EXT.glob("RP*") if (m := re.fullmatch(r"RP(\d+)", p.name))]
    return sorted(nums)


def load_bank(n):
    d = (EXT / f"RP{n}").read_bytes()
    width = (1 + (d[0] & 1)) << 1
    count = struct.unpack(">H", d[1:3])[0]
    p = 3
    lens = [int.from_bytes(d[p + i * width:p + (i + 1) * width], "big") for i in range(count)]
    p += width * count
    types = list(d[p:p + count])
    p += count
    total = struct.unpack(">I", d[p:p + 4])[0]
    p += 4
    assert sum(lens) == total, f"RP{n}: length table sums to {sum(lens)}, header says {total}"
    assert p + total == len(d), f"RP{n}: {len(d) - p - total} unexplained trailing bytes"
    offs = [0]
    for length in lens:
        offs.append(offs[-1] + length)
    return d[p:p + total], lens, types, offs


def main():
    if not EXT.exists():
        sys.exit("betrayal/extracted/ missing -- run tools/extract_jar.py first")
    if len(sys.argv) >= 4 and sys.argv[1] == "dump":
        data, lens, types, offs = load_bank(int(sys.argv[2]))
        i = int(sys.argv[3])
        blob = data[offs[i]:offs[i + 1]]
        print(f"RP{sys.argv[2]}[{i}] type={types[i]} len={lens[i]} head={blob[:32].hex(' ')}")
        return
    hist = Counter()
    total_res = 0
    for n in bank_numbers():
        _, lens, types, _ = load_bank(n)
        c = Counter(types)
        hist.update(c)
        total_res += len(lens)
        print(f"RP{n:<3} ok  {len(lens):4d} resources  types={dict(sorted(c.items()))}")
    print(f"\n{len(bank_numbers())} banks, {total_res} resources, all containers exact")
    print("type histogram:", dict(sorted(hist.items())))


if __name__ == "__main__":
    main()
