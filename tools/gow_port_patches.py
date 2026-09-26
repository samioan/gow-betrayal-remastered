"""PC-port changes applied to the renamed Java by java2cpp.py (betrayal/src stays a faithful decompile).

Two features, both driven by the C++ `Port` class (betrayal/port/src/main.cpp / platform.h):

1. WIDESCREEN. The phone canvas is 240x320. `Game.viewW` is the logical width (240 = original, up to 853); the
   port resizes its surface to it. Only the *world* uses the extra width: the Scene ring buffer, the camera, and
   the visibility/activation tests. Everything laid out in 240-px design coordinates (menus, HUD, dialogue,
   pop-ups, soft-key labels) is drawn centred by translating the whole frame by uiX() = (viewW - 240) / 2, so
   nothing is ever stretched. The world layer undoes that translation for itself, and the full-width fills
   (letterbox bars, the bottom status bar, the closed-bars backdrop) are widened to viewW.

2. PC SETTINGS. Two carousel entries (Resolution, Fullscreen) are inserted into the Options menu page (see
   Port::extendMenu, which shifts the menu table) and two rows are added to the pause menu.

Each entry is (kind, old, new, expected count); kind "s" = plain substring, "r" = regex. Every entry must
match exactly the expected number of times, so a rename or decompiler change fails loudly here.
"""
import re

FIELDS = """   // ---- PC port (tools/gow_port_patches.py)
   public static int viewW = 240;
   public static boolean redrawAll = true;
   public int arrowBase = -1;
   private static boolean lastWorld = false;

   private static int uiX() {
      return viewW - 240 >> 1;
   }

   private void updateViewWidth() {
      int var1 = Port.viewWidth();
      if (this.scene != null && var1 > 240 && this.bu < var1) {
         var1 = this.bu < 240 ? 240 : this.bu;
      }

      if (var1 != viewW) {
         viewW = var1;
      }

      if (this.scene != null) {
         this.maxCameraX = this.bu - viewW;
      }
   }

   static {
"""

RENDER_WRAPPER = """   public final void render(Graphics var1) {
      boolean var2 = state == 100 || state == 101 || state == 102 || state == 104 || state == 105 || state == 108;
      int var3 = uiX();
      if (redrawAll || var2 != lastWorld) {
         redrawAll = false;
         lastWorld = var2;
         var1.setClip(0, 0, viewW, 320);
         var1.setColor(0);
         var1.fillRect(0, 0, viewW, 320);
         this.requestClear();
         this.iC = true;
         this.iB = true;
      }

      if (this.scene != null) {
         this.scene.setBufferWidth(viewW);
      }

      if (var3 != 0) {
         var1.translate(var3, 0);
      }

      if (var2) {
         var1.setClip(-var3, 0, viewW, 320);
      } else {
         var1.setClip(0, 0, 240, 320);
      }

      this.renderInner(var1);
      if (var3 != 0) {
         var1.translate(-var3, 0);
      }
   }

   private void renderInner(Graphics var1) {
      switch (state) {"""

PATCHES = [
    # ---------------------------------------------------------------- widescreen: state and the frame wrapper
    ("s", "   static {\n      // (obfuscator dead code removed: arrays built and discarded, see rename_gow.py)\n",
     FIELDS + "      // (obfuscator dead code removed: arrays built and discarded, see rename_gow.py)\n", 1),
    ("s", "   public final void update() {\n      this.frameDelta = super.frameTime >> this.slowMotionShift;\n",
     "   public final void update() {\n      this.updateViewWidth();\n      this.frameDelta = super.frameTime >> this.slowMotionShift;\n", 1),
    ("s", "   public final void render(Graphics var1) {\n      switch (state) {", RENDER_WRAPPER, 1),
    # world states clip to the full width (the world escapes the centring translation, see drawWorld)
    ("s", """            if (state == 100 && this.topBar <= 0 && !this.iB) {
               this.setClip(var1, 0, 0, 240, 306);
            } else {
               this.iB = true;
               this.resetClip(var1);
            }
""", """            if (state == 100 && this.topBar <= 0 && !this.iB) {
               this.setClip(var1, -uiX(), 0, viewW, 306);
            } else {
               this.iB = true;
               this.setClip(var1, -uiX(), 0, viewW, 320);
            }
""", 1),
    # the world layer: undo the centring translation for the scene and every world-space entity
    ("s", "      this.scene.draw(var1);\n      var1.translate(-cameraX, -(cameraY + this.bl));\n",
     "      var1.translate(-uiX(), 0);\n      this.scene.draw(var1);\n      var1.translate(-cameraX, -(cameraY + this.bl));\n", 1),
    ("s", "      var1.translate(cameraX, cameraY + this.bl);\n   }", "      var1.translate(cameraX, cameraY + this.bl);\n      var1.translate(uiX(), 0);\n   }", 1),
    # the finisher prompt above an enemy is placed in screen coordinates
    ("s", "enemyX[this.grappledEnemy] - cameraX,", "enemyX[this.grappledEnemy] - cameraX - uiX(),", 1),
    ("s", "pointInRect(this.playerX, this.playerY, cameraX, cameraY, this.screenWidth, this.screenHeight)",
     "pointInRect(this.playerX, this.playerY, cameraX, cameraY, viewW, this.screenHeight)", 1),
    # ---------------------------------------------------------------- widescreen: camera
    ("s", "cameraX = this.playerX - 120 - ((facingRight ? 1 : -1) * 240 >> 2);",
     "cameraX = this.playerX - (viewW >> 1) - ((facingRight ? 1 : -1) * 240 >> 2);", 2),
    ("s", "int var6 = var2 - 120 + var4;", "int var6 = var2 - (viewW >> 1) + var4;", 1),
    ("s", "this.maxCameraX = this.bu - 240;", "this.maxCameraX = this.bu - viewW;", 1),
    # camera lock / scroll-stop rectangles and their reverse offsets
    ("r", r"(cameraY(?: \+ this\.aJ)?, )240(?=, 320)", r"\1viewW", 5),
    ("s", "? 240 : 0", "? viewW : 0", 2),
    # ---------------------------------------------------------------- widescreen: visibility and activation
    ("r", r"<= 240\b", "<= viewW", 17),
    ("r", r"(?m)^(\s*)368,$", r"\1viewW + 128,", 3),
    # ---------------------------------------------------------------- widescreen: full-width fills
    ("s", "var1.fillRect(0, var2 + 1, 240, 320 - (var3 << 1) - 1);", "var1.fillRect(-uiX(), var2 + 1, viewW, 320 - (var3 << 1) - 1);", 1),
    ("s", "var1.fillRect(0, 0, 240, var2);", "var1.fillRect(-uiX(), 0, viewW, var2);", 1),
    ("s", "var1.drawLine(0, var2 - 1, 240, var2 - 1);", "var1.drawLine(-uiX(), var2 - 1, 240 + uiX(), var2 - 1);", 2),
    ("s", "var1.drawLine(0, var2, 240, var2);", "var1.drawLine(-uiX(), var2, 240 + uiX(), var2);", 1),
    ("s", "var1.fillRect(0, 320 - var3, 240, var3);", "var1.fillRect(-uiX(), 320 - var3, viewW, var3);", 1),
    ("s", "var1.drawLine(0, 320 - var3, 240, 320 - var3);", "var1.drawLine(-uiX(), 320 - var3, 240 + uiX(), 320 - var3);", 1),
    ("s", "var1.drawLine(0, 320 - var3 + 1, 240, 320 - var3 + 1);", "var1.drawLine(-uiX(), 320 - var3 + 1, 240 + uiX(), 320 - var3 + 1);", 1),
    ("s", "this.cq[0].draw(var1, 0, var2, 1);", "this.cq[0].draw(var1, -uiX(), var2, 1);", 1),
    ("s", "this.cq[0].draw(var1, 240, var2, 3);", "this.cq[0].draw(var1, 240 + uiX(), var2, 3);", 1),
    ("s", "this.cq[0].draw(var1, 0, 320 - (var3 - 1), 0);", "this.cq[0].draw(var1, -uiX(), 320 - (var3 - 1), 0);", 1),
    ("s", "this.cq[0].draw(var1, 240, 320 - (var3 - 1), 2);", "this.cq[0].draw(var1, 240 + uiX(), 320 - (var3 - 1), 2);", 1),
    ("s", "var1.fillRect(0, 306, 240, 14);", "var1.fillRect(-uiX(), 306, viewW, 14);", 1),
    ("s", "var1.drawLine(0, 306, 240, 306);", "var1.drawLine(-uiX(), 306, 240 + uiX(), 306);", 1),
    ("s", "var1.drawLine(0, 307, 240, 307);", "var1.drawLine(-uiX(), 307, 240 + uiX(), 307);", 1),
    # ---------------------------------------------------------------- PC settings: the Options menu page
    ("s", "   private void loadMenuTable() {\n",
     "   private void loadMenuTable() {\n      this.loadMenuTableRaw();\n      menuTable = Port.extendMenu(menuTable);\n   }\n\n   private void loadMenuTableRaw() {\n", 1),
    ("s", "            var1 = 23;", "            var1 = 25;", 1),
    ("s", "                  String var20 = this.getString(var14);\n",
     "                  String var20 = this.getString(var14);\n"
     "                  if (this.arrowBase < 0) {\n                     this.arrowBase = this.iJ;\n                  }\n\n"
     "                  if (var5 == 13 || var5 == 14) {\n"
     "                     var20 = Port.label(var5 - 13);\n"
     "                     this.iJ = Math.max(this.arrowBase, (this.stringWidth(var20) >> 1) + 14);\n"
     "                  } else {\n"
     "                     this.iJ = this.arrowBase;\n"
     "                  }\n", 1),
    ("s", "                     case 12:\n                        if (var4 == menuCursor) {",
     "                     case 12:\n                     case 13:\n                     case 14:\n                        if (var4 == menuCursor) {", 1),
    ("s", "         case 12:\n            if (this.pressedKey == 8 || this.pressedKey == 27) {\n               languageIndex++;",
     "         case 13:\n         case 14:\n            if (this.pressedKey == 8 || this.pressedKey == 27) {\n               Port.change(var3 - 13, 1);\n               this.iB = true;\n            }\n            break;\n"
     "         case 12:\n            if (this.pressedKey == 8 || this.pressedKey == 27) {\n               languageIndex++;", 1),
    # ---------------------------------------------------------------- PC settings: the pause menu
    ("s", "                        if (pauseMenuIndex > 4) {\n                           pauseMenuIndex = 4;",
     "                        if (pauseMenuIndex > 6) {\n                           pauseMenuIndex = 6;", 1),
    ("s", "               } else if (pauseMenuIndex == 4) {\n                  this.soundPlayer.setSoundOn(!this.soundPlayer.isSoundOn());",
     "               } else if (pauseMenuIndex >= 5) {\n                  Port.change(pauseMenuIndex - 5, 1);\n                  this.iB = true;\n               } else if (pauseMenuIndex == 4) {\n                  this.soundPlayer.setSoundOn(!this.soundPlayer.isSoundOn());", 1),
    ("s", "                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);\n               } else if (pauseMenuIndex == 2 && !this.pauseConfirming) {",
     "                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "                  bo[2].draw(var1, 12 - bo[2].width, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "               } else if (pauseMenuIndex >= 5) {\n"
     "                  this.drawString(var1, Port.label(pauseMenuIndex - 5), halfWidth, halfHeight + lineHeight + halfLineHeight, 33);\n"
     "                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "                  if (pauseMenuIndex < 6) {\n"
     "                     bo[2].draw(var1, 12 - bo[2].width, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "                  }\n"
     "               } else if (pauseMenuIndex == 2 && !this.pauseConfirming) {", 1),
]


def apply(name, text):
    if name != "Game.java":
        return text
    for kind, old, new, count in PATCHES:
        n = text.count(old) if kind == "s" else len(re.findall(old, text))
        if n != count:
            raise SystemExit(f"gow_port_patches: expected {count} match(es), found {n} for: {old[:70]!r}")
        text = text.replace(old, new) if kind == "s" else re.sub(old, new, text)
    return text
