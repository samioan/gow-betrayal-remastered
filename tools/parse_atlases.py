#!/usr/bin/env python3
"""Phase 2: parse every sprite atlas (type 254) and animation set (type 247).

Replicates, byte for byte, `Engine.loadSprites(int, byte[])` (old name a.b) and
`Engine.loadAnimSet(int)` (old name a.g) from betrayal/src/Engine.java, and asserts
that every resource is consumed exactly. Atlas rectangles are checked against the
size of the PNG they reference (reported, not asserted: `Sprite.draw` clips, so an
out-of-range rectangle is legal, just worth knowing about).

Output goes to stdout (derived from copyrighted data: never commit it).

    python tools/parse_atlases.py            # verify everything
    python tools/parse_atlases.py atlas 1036 # dump one atlas   (id = bank << 10 | index)
    python tools/parse_atlases.py anim 1024  # dump one animation set's summary
"""
import struct
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import parse_banks  # noqa: E402

_banks = {}


def resource(rid, cur_bank=None):
    """(bytes, type) of resource `rid`; bank 0 means the caller's own bank."""
    bank = rid >> 10 or cur_bank
    if bank not in _banks:
        _banks[bank] = parse_banks.load_bank(bank)
    data, lens, types, offs = _banks[bank]
    i = rid & 1023
    return data[offs[i]:offs[i + 1]], types[i]


class Stream:
    """The bits of java.io.DataInputStream the loaders use."""

    def __init__(self, b):
        self.b, self.p = b, 0

    def read(self):
        v = self.b[self.p]
        self.p += 1
        return v

    def readByte(self):
        v = self.read()
        return v - 256 if v > 127 else v

    def readChar(self):
        v = struct.unpack_from(">H", self.b, self.p)[0]
        self.p += 2
        return v

    def readShort(self):
        v = struct.unpack_from(">h", self.b, self.p)[0]
        self.p += 2
        return v

    def readFully(self, n):
        v = self.b[self.p:self.p + n]
        assert len(v) == n, "read past end"
        self.p += n
        return v

    def k(self):  # Engine.k(): unsigned byte, 255 escapes to a 16-bit char
        v = self.read()
        return self.readChar() if v == 255 else v

    def l(self):  # Engine.l(): signed byte, -128 escapes to a 16-bit short
        v = self.readByte()
        return self.readShort() if v == -128 else v

    def remaining(self):
        return len(self.b) - self.p


def png_size(blob):
    assert blob[:8] == b"\x89PNG\r\n\x1a\n", "not a PNG"
    return struct.unpack(">II", blob[16:24])


def s16(v):
    v &= 0xFFFF
    return v - 0x10000 if v & 0x8000 else v


FIELDS = ["offX", "offY", "srcX", "srcY", "w", "h", "e", "f", "advance", "metric"]


def parse_atlas(rid):
    """Engine.loadSprites: returns (imageId, [ {field: value} per sprite ])."""
    bank = rid >> 10
    blob, t = resource(rid)
    assert t == 254, f"{rid}: type {t}, not an atlas"
    s = Stream(blob)
    image_id = s.readChar()
    s.readByte()
    dlen = s.readShort() - 4
    mask = s.readChar()
    count = s.readChar()
    data = s.readFully(dlen)
    assert s.remaining() == 0, f"{rid}: {s.remaining()} trailing bytes"
    present = [(mask >> i) & 1 == 0 for i in range(16)]
    sizes, bit = [], 5
    for g in range(3):
        for _ in range(2 if g == 0 else 4):
            if present[g]:
                sizes.append(2 if present[bit] else 1)
                bit += 1
            else:
                sizes.append(0)
    sprites = []
    for i in range(count):
        pos, vals = 0, []
        for f, sz in enumerate(sizes):
            v, sh = 0, sz - 1
            if sh >= 0:
                pos += i << sh
                if sh == 0:
                    v = data[pos] - 256 if data[pos] > 127 else data[pos]
                    if f > 1 and f not in (6, 7):
                        v &= 255
                else:
                    v = s16((data[pos] << 8) | data[pos + 1])
                pos += (count - i) << sh
            vals.append(v)
        sprites.append(dict(zip(FIELDS, vals)))
    consumed = sum(count * sz for sz in sizes)
    assert consumed == dlen, f"{rid}: columns use {consumed} of {dlen} bytes"
    return image_id, sprites, bank


def parse_animset(rid):
    """Engine.loadAnimSet: asserts exact consumption, returns a summary dict."""
    blob, t = resource(rid)
    assert t == 247, f"{rid}: type {t}, not an animation set"
    s = Stream(blob)
    s.read()
    n_anims = s.readChar()
    # anim headers: cumulative frame start <<16 | frame count, then loop count <<10
    lens, total = [], 0
    for _ in range(n_anims):
        c = s.k()
        lens.append(c)
        total += c
    loops = [s.l() & 63 for _ in range(n_anims)]
    # per anim-frame: timing byte (+ high byte when 16-bit escaped), then three packed columns
    timing = []
    high = []
    for _ in range(total):
        v = s.k()
        timing.append(v & 255)
        high.append(v >> 8)
    for _ in range(total):  # frame id, << 22
        s.k()
    for _ in range(total):  # dx
        s.l()
    for _ in range(total):  # dy
        s.l()
    n_frames = s.readChar()
    parts_per_frame = [s.k() for _ in range(n_frames)]
    n_parts = sum(parts_per_frame)
    left, bits = 0, 0
    for _ in range(n_parts):  # 2-bit flip flags, four per byte
        if left == 0:
            s.k()
            left = 8
        left -= 2
    for _ in range(n_parts):  # sprite index
        s.k()
    for _ in range(n_parts):  # x
        s.l()
    for _ in range(n_parts):  # y
        s.l()
    boxes_per_frame = [s.k() for _ in range(n_frames)]
    n_boxes = sum(boxes_per_frame)
    for _ in range(n_boxes):  # x
        s.l()
    for _ in range(n_boxes):  # y
        s.l()
    for _ in range(n_boxes):  # w
        s.k()
    for _ in range(n_boxes):  # h (high bits) -- read as k() then k() again for the low bits
        s.k()
    for _ in range(n_boxes):
        s.k()
    n_dur = s.readChar()
    durations = [s.k() for _ in range(n_dur)]
    assert s.remaining() == 0, f"{rid}: {s.remaining()} unread bytes of {len(blob)}"
    return dict(anims=n_anims, anim_frames=total, frames=n_frames, parts=n_parts,
                boxes=n_boxes, durations=durations, loops=loops, size=len(blob))


def main():
    banks = parse_banks.bank_numbers()
    if len(sys.argv) >= 3 and sys.argv[1] == "atlas":
        img, sprites, _ = parse_atlas(int(sys.argv[2]))
        print(f"image {img:#x}, {len(sprites)} sprites")
        for i, sp in enumerate(sprites):
            print(i, sp)
        return
    if len(sys.argv) >= 3 and sys.argv[1] == "anim":
        print(parse_animset(int(sys.argv[2])))
        return

    n_atlas = n_sprites = n_anim = oob = 0
    for b in banks:
        _, lens, types, _ = parse_banks.load_bank(b)
        for i, t in enumerate(types):
            rid = (b << 10) | i
            if t == 254:
                img, sprites, bank = parse_atlas(rid)
                blob, it = resource(img, bank)
                w, h = png_size(blob)
                bad = [k for k, sp in enumerate(sprites)
                       if sp["w"] > 0 and sp["h"] > 0 and
                       (sp["srcX"] < 0 or sp["srcY"] < 0 or sp["srcX"] + sp["w"] > w or sp["srcY"] + sp["h"] > h)]
                oob += len(bad)
                n_atlas += 1
                n_sprites += len(sprites)
                print(f"atlas {rid:5d} RP{b}[{i}]: {len(sprites):3d} sprites, image {img:5d} (type {it}) {w}x{h}"
                      + (f", {len(bad)} rect(s) outside the PNG" if bad else ""))
            elif t == 247:
                r = parse_animset(rid)
                n_anim += 1
                print(f"anim  {rid:5d} RP{b}[{i}]: {r['anims']:3d} anims / {r['anim_frames']:4d} steps, "
                      f"{r['frames']:3d} frames, {r['parts']:4d} parts, {r['boxes']:3d} boxes, {r['size']} bytes -- exact")
    print(f"\n{n_atlas} atlases ({n_sprites} sprites), {n_anim} animation sets parsed; "
          f"all consumed exactly; {oob} sprite rects outside their PNG")


if __name__ == "__main__":
    main()
