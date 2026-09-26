#!/usr/bin/env python3
"""God of War: Betrayal phase 1: rename the decompilation into betrayal/src/.

Unlike a regex pass over single-letter identifiers, this renames
at the class-file level: Vineflower's --user-renamer-class hook is given
tools/ch_rename/ChRenamer.java, which reads betrayal/docs/names.map, so every
reference -- including inherited members reached through a subclass, and the
same single letter reused in different classes -- is rewritten correctly.

    python tools/rename_gow.py            # regenerate betrayal/src/ and compile-check it
    python tools/rename_gow.py --no-check # skip the javac check

Steps: compile ChRenamer, run Vineflower over betrayal/extracted/ with the
map, apply PATCHES (decompiler artifacts that do not compile), write
betrayal/src/*.java, then compile them against the MIDP/CLDC/Nokia-UI stub
jars in tools/midp-stubs/. The compiler is the final arbiter: src/ must build
with zero errors.

names.map format (one entry per line, '#' comments):
    class  <old> <New>
    field  <oldClass>.<oldField> <newName>
    method <oldClass>.<oldMethod>(<paramTypes>) <newName>
paramTypes are Java-style, comma separated, package-free, with obfuscated
class names left as they are: (int,byte[]) (Graphics,f[],int) ().
"""
import shutil
import subprocess
import sys
import tempfile
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from decompile import VINEFLOWER, find_java  # noqa: E402

ROOT = Path(__file__).resolve().parent.parent
GAME = ROOT / "betrayal"
EXTRACTED = GAME / "extracted"
MAP = GAME / "docs" / "names.map"
OUT = GAME / "src"
RENAMER_SRC = ROOT / "tools" / "ch_rename" / "ChRenamer.java"
STUBS = ROOT / "tools" / "midp-stubs"

# Decompiler artifacts that are not valid Java, fixed textually after the
# rename. (file, old, new); every entry must match exactly once.
PATCHES: list[tuple[str, str, str]] = [
    # Game's static initializer is pure obfuscator dead code: three arrays are built and popped
    # (never stored to a field -- checked with javap -c), which Vineflower prints as mistyped
    # assignments. Every real static field initializer is emitted inline on its declaration.
    ("Game.java",
     "      int[] var10000 = new int[]{320, 420, 690, 400, 500, 590, 1030};\n"
     "      var10000 = new int[]{-1, -1, -1};\n"
     "      int[] var1 = new byte[]{13, 4, 4};\n"
     "      var1 = new int[]{-1, 64};\n",
     "      // (obfuscator dead code removed: arrays built and discarded, see rename_gow.py)\n"),
    # SoundPlayer's MIDI tempo maths: the local is an int in the bytecode; Vineflower types it short.
    ("SoundPlayer.java", "         short var5;\n         boolean var6;", "         int var5;\n         boolean var6;"),
    # Vineflower types loop counters that start at a small constant and step by 3 or 5 as `byte`.
    # They are ints in the bytecode: the boot loader's palette table loop runs to 768 and would wrap at
    # 127 (an ArrayIndexOutOfBounds in the port, as in Java), the other three merely need the same care.
    ("Game.java", "for (byte var7 = 0; var7 < var4.length; var7 += 5) {", "for (int var7 = 0; var7 < var4.length; var7 += 5) {"),
    ("Game.java", "for (byte var5 = 0; var5 < var1.length; var5 += 3) {", "for (int var5 = 0; var5 < var1.length; var5 += 3) {"),
    ("Game.java", "for (byte var84 = 0; var84 < this.playerBoxes.length; var84 += 5) {", "for (int var84 = 0; var84 < this.playerBoxes.length; var84 += 5) {"),
    ("Game.java", "for (byte var103 = 0; var103 < this.playerBoxes.length; var103 += 5) {", "for (int var103 = 0; var103 < this.playerBoxes.length; var103 += 5) {"),
    # Port addition (widescreen): the visible width of the scene follows the logical canvas width.
    # The C++ Scene (betrayal/port/src/scene.cpp) implements the same method; this Java version exists so the
    # renamed tree still compiles and java2cpp knows the signature.
    ("Scene.java", "   private final int bufferWidth;", "   private int bufferWidth;"),
    ("Scene.java", "      this.scrollX = var1;\n      this.scrollY = var2;\n   }\n",
     "      this.scrollX = var1;\n      this.scrollY = var2;\n   }\n\n"
     "   public final void setBufferWidth(int var1) {\n"
     "      if (var1 != this.bufferWidth) {\n"
     "         this.bufferWidth = var1;\n"
     "         this.buffer = Image.createImage(var1, this.bufferHeight);\n"
     "         this.bufferGraphics = this.buffer.getGraphics();\n"
     "         this.fullRedraw = true;\n"
     "      }\n"
     "   }\n"),
    # Same family as Clone Home: Vineflower can also type iinc'd int locals as byte, or a byte[]
    # local as an unknown class `B`. Add entries here as compile errors show them.
]


def run(cmd, **kw):
    return subprocess.run([str(c) for c in cmd], check=True, **kw)


def main() -> None:
    check = "--no-check" not in sys.argv
    java = Path(find_java())
    javac = java.with_name("javac.exe" if java.suffix == ".exe" else "javac")

    with tempfile.TemporaryDirectory(prefix="gow_rename_") as tmp:
        tmp = Path(tmp)
        cls_dir, out_dir = tmp / "cls", tmp / "out"
        cls_dir.mkdir()
        out_dir.mkdir()

        run([javac, "-d", cls_dir, "-cp", VINEFLOWER, RENAMER_SRC])
        sep = ";" if sys.platform == "win32" else ":"
        run([
            java, f"-Dch.map={MAP}", "-cp", f"{VINEFLOWER}{sep}{cls_dir}",
            "org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler",
            "-log=WARN", "-ren=1", "-urc=ChRenamer",
            EXTRACTED, out_dir,
        ])

        sources = sorted(out_dir.glob("*.java"))
        if not sources:
            sys.exit("Vineflower produced no sources")

        # Clear the contents, not the directory itself: on Windows the directory cannot be removed
        # while any shell has it as its working directory.
        OUT.mkdir(exist_ok=True)
        for old in OUT.glob("*.java"):
            old.unlink()
        texts = {p.name: p.read_text(encoding="utf-8") for p in sources}
        for fname, old, new in PATCHES:
            if texts[fname].count(old) != 1:
                sys.exit(f"patch does not match exactly once in {fname}: {old[:60]!r}")
            texts[fname] = texts[fname].replace(old, new)
        for name, text in texts.items():
            (OUT / name).write_text(text, encoding="utf-8", newline="\n")
        print(f"wrote {len(texts)} files -> {OUT.relative_to(ROOT)}")

        if check:
            classpath = sep.join(str(j) for j in sorted(STUBS.glob("*.jar")))
            build = tmp / "build"
            build.mkdir()
            run([javac, "-nowarn", "-proc:none", "-encoding", "UTF-8",
                 "--release", "8", "-cp", classpath, "-d", build,
                 *sorted(OUT.glob("*.java"))])
            print("compile check: OK (0 errors)")


if __name__ == "__main__":
    main()
