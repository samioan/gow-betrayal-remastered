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

# Render interpolation for the FPS option (docs/PORT_ROADMAP.md, "FPS"): logic runs at 25 steps/s; every step the
# positions of everything that moves are recorded (interpSnapshot: the state *before* the step, interpApply: the
# state *after* it, collected at draw time). A frame drawn a fraction alpha (0..255) of the way to the next step
# blends the two, writes the blended positions into the game's own fields, lets the normal render code draw, and
# puts the real ones back (interpRestore). Moves larger than a threshold (respawns, teleports, camera cuts) and
# entities whose identity changed are not blended. Layout: 4 header values, then 186 (identity, x, y) triples.
INTERP = """   // ---- render interpolation (tools/gow_port_patches.py)
   public static int lastBlendX = 0;
   private static int[] iPrev = new int[640];
   private static int[] iCur = new int[640];
   private static int[] iBlend = new int[640];
   private static boolean iValid = false;

   private boolean interpCollect(int[] var1) {
      if (this.scene == null || !(state == 100 || state == 101 || state == 102 || state == 104 || state == 105 || state == 108)) {
         return false;
      }

      var1[0] = cameraX;
      var1[1] = cameraY;
      var1[2] = this.playerX;
      var1[3] = this.playerY;
      int var2 = 4;

      for (int var3 = 0; var3 < 15; var3++) {
         var1[var2] = this.enemyClass[var3] * 2 + (this.enemyId[var3] >= 0 ? 1 : 0);
         var1[var2 + 1] = enemyX[var3];
         var1[var2 + 2] = this.enemyY[var3];
         var2 += 3;
      }

      for (int var4 = 0; var4 < 20; var4++) {
         for (int var5 = 0; var5 < 4; var5++) {
            var1[var2] = pickupKind[var4] + 1;
            var1[var2 + 1] = pickupTrailX[(var4 << 2) + var5];
            var1[var2 + 2] = pickupTrailY[(var4 << 2) + var5];
            var2 += 3;
         }
      }

      for (int var6 = 0; var6 < 20; var6++) {
         var1[var2] = 0;
         var1[var2 + 1] = bZ[var6];
         var1[var2 + 2] = ca[var6];
         var2 += 3;
      }

      for (int var7 = 0; var7 < 20; var7++) {
         var1[var2] = 0;
         var1[var2 + 1] = this.cg[var7];
         var1[var2 + 2] = ch[var7];
         var2 += 3;
      }

      for (int var8 = 0; var8 < 10; var8++) {
         var1[var2] = 0;
         var1[var2 + 1] = bP[var8];
         var1[var2 + 2] = this.bQ[var8];
         var2 += 3;
      }

      for (int var9 = 0; var9 < 10; var9++) {
         var1[var2] = 0;
         var1[var2 + 1] = dl[var9];
         var1[var2 + 2] = dm[var9];
         var2 += 3;
      }

      for (int var10 = 0; var10 < 15; var10++) {
         var1[var2] = 0;
         var1[var2 + 1] = hazardX[var10];
         var1[var2 + 2] = this.hazardY[var10];
         var2 += 3;
      }

      int var11 = this.pushX == null || this.pushY == null ? 0 : (this.pushX.length < 16 ? this.pushX.length : 16);

      for (int var12 = 0; var12 < 16; var12++) {
         var1[var2] = var12 < var11 ? 0 : 1;
         var1[var2 + 1] = var12 < var11 ? this.pushX[var12] : 0;
         var1[var2 + 2] = var12 < var11 ? this.pushY[var12] : 0;
         var2 += 3;
      }

      return true;
   }

   private void interpPut(int[] var1) {
      cameraX = var1[0];
      cameraY = var1[1];
      this.playerX = var1[2];
      this.playerY = var1[3];
      this.scene.setScroll(cameraX, cameraY);
      int var2 = 4;

      for (int var3 = 0; var3 < 15; var3++) {
         enemyX[var3] = var1[var2 + 1];
         this.enemyY[var3] = var1[var2 + 2];
         var2 += 3;
      }

      for (int var4 = 0; var4 < 20; var4++) {
         for (int var5 = 0; var5 < 4; var5++) {
            pickupTrailX[(var4 << 2) + var5] = var1[var2 + 1];
            pickupTrailY[(var4 << 2) + var5] = var1[var2 + 2];
            var2 += 3;
         }
      }

      for (int var6 = 0; var6 < 20; var6++) {
         bZ[var6] = var1[var2 + 1];
         ca[var6] = var1[var2 + 2];
         var2 += 3;
      }

      for (int var7 = 0; var7 < 20; var7++) {
         this.cg[var7] = var1[var2 + 1];
         ch[var7] = var1[var2 + 2];
         var2 += 3;
      }

      for (int var8 = 0; var8 < 10; var8++) {
         bP[var8] = var1[var2 + 1];
         this.bQ[var8] = var1[var2 + 2];
         var2 += 3;
      }

      for (int var9 = 0; var9 < 10; var9++) {
         dl[var9] = var1[var2 + 1];
         dm[var9] = var1[var2 + 2];
         var2 += 3;
      }

      for (int var10 = 0; var10 < 15; var10++) {
         hazardX[var10] = var1[var2 + 1];
         this.hazardY[var10] = var1[var2 + 2];
         var2 += 3;
      }

      int var11 = this.pushX == null || this.pushY == null ? 0 : (this.pushX.length < 16 ? this.pushX.length : 16);

      for (int var12 = 0; var12 < 16; var12++) {
         if (var12 < var11) {
            this.pushX[var12] = var1[var2 + 1];
            this.pushY[var12] = var1[var2 + 2];
         }

         var2 += 3;
      }
   }

   private static int interpLerp(int var0, int var1, int var2, int var3) {
      int var4 = var1 - var0;
      return var4 > var3 || var4 < -var3 ? var1 : var0 + (var4 * var2 >> 8);
   }

   public final void interpSnapshot() {
      iValid = this.interpCollect(iPrev);
   }

   public final boolean interpApply(int var1) {
      if (!iValid || !this.interpCollect(iCur)) {
         return false;
      }

      iBlend[0] = interpLerp(iPrev[0], iCur[0], var1, 96);
      iBlend[1] = interpLerp(iPrev[1], iCur[1], var1, 96);
      iBlend[2] = interpLerp(iPrev[2], iCur[2], var1, 64);
      iBlend[3] = interpLerp(iPrev[3], iCur[3], var1, 64);

      for (int var2 = 4; var2 < 562; var2 += 3) {
         iBlend[var2] = iCur[var2];
         if (iPrev[var2] == iCur[var2]) {
            iBlend[var2 + 1] = interpLerp(iPrev[var2 + 1], iCur[var2 + 1], var1, 64);
            iBlend[var2 + 2] = interpLerp(iPrev[var2 + 2], iCur[var2 + 2], var1, 64);
         } else {
            iBlend[var2 + 1] = iCur[var2 + 1];
            iBlend[var2 + 2] = iCur[var2 + 2];
         }
      }

      lastBlendX = iBlend[0];
      this.interpPut(iBlend);
      return true;
   }

   public final void interpRestore() {
      this.interpPut(iCur);
   }

"""

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
         if (this.maxCameraX >= 0 && cameraX > this.maxCameraX) {
            cameraX = this.maxCameraX;
         }
      }
   }

   static {
"""

RENDER_WRAPPER = """   public final void render(Graphics var1) {
      boolean var2 = true;
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
     INTERP + FIELDS + "      // (obfuscator dead code removed: arrays built and discarded, see rename_gow.py)\n", 1),
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
    # the status-effect overlay animation is stepped inside the draw code: it must advance once per logic step,
    # not once per (interpolated) frame
    ("s", "this.stepAnim(137, this.frameDelta);", "this.stepAnim(137, Engine.tickFrame ? this.frameDelta : 0);", 1),
    # ---------------------------------------------------------------- widescreen: camera
    ("s", "cameraX = this.playerX - 120 - ((facingRight ? 1 : -1) * 240 >> 2);",
     "cameraX = this.playerX - (viewW >> 1) - ((facingRight ? 1 : -1) * 240 >> 2);", 2),
    ("s", "int var6 = var2 - 120 + var4;", "int var6 = var2 - (viewW >> 1) + var4;", 1),
    ("s", "this.maxCameraX = this.bu - 240;", "this.maxCameraX = this.bu - viewW;", 1),
    # camera lock / scroll-stop rectangles (both orientations) and the break-crate camera stop: all three
    # engage exactly when they did on the phone, i.e. the trigger point has to be inside the centred 240 px
    # column, not merely somewhere in the wider view. The original computes both branches from one shared
    # "cameraX, cameraY, 240, 320" test (never scaled by the phone's own screen width to begin with), so every
    # copy here is rewritten the same way -- an earlier pass only special-cased the vertical-lock branch and
    # left the horizontal-lock and break-crate stops testing against the full widened view, which let a lock
    # rect far off to the side keep re-engaging as the camera scrolled past it (e.g. a ladder near a lock in
    # Catacombs: the camera kept fighting to recentre while climbing).
    ("s",
     "            if (pointInRect(this.lockX[var12], this.lockY[var12], cameraX, cameraY, 240, 320)) {\n"
     "               if (!this.lockVertical[var12]) {\n"
     "                  var10 = true;\n"
     "                  int var13 = this.aK * this.frameDelta >> 8;\n"
     "                  if (this.lockReverse[var12]) {\n"
     "                     this.aI -= var13;\n"
     "                  } else {\n"
     "                     this.aI += var13;\n"
     "                  }\n"
     "\n"
     "                  if (!pointInRect(this.lockX[var12], this.lockY[var12], cameraX + this.aI, cameraY + this.aJ, 240, 320)) {\n"
     "                     this.aI = this.lockX[var12] - cameraX - (this.lockReverse[var12] ? 240 : 0);\n"
     "                  }\n"
     "               } else {\n"
     "                  var11 = true;\n"
     "                  int var18 = this.aK * this.frameDelta >> 8;\n"
     "                  if (this.lockReverse[var12]) {\n"
     "                     this.aJ -= var18;\n"
     "                  } else {\n"
     "                     this.aJ += var18;\n"
     "                  }\n"
     "\n"
     "                  if (!pointInRect(this.lockX[var12], this.lockY[var12], cameraX + this.aI, cameraY + this.aJ, 240, 320)) {\n"
     "                     this.aJ = this.lockY[var12] - cameraY - (this.lockReverse[var12] ? 320 : 0);\n"
     "                  }\n"
     "               }\n"
     "            }",
     "            if (pointInRect(this.lockX[var12], this.lockY[var12], cameraX + uiX(), cameraY, 240, 320)) {\n"
     "               if (!this.lockVertical[var12]) {\n"
     "                  var10 = true;\n"
     "                  int var13 = this.aK * this.frameDelta >> 8;\n"
     "                  if (this.lockReverse[var12]) {\n"
     "                     this.aI -= var13;\n"
     "                  } else {\n"
     "                     this.aI += var13;\n"
     "                  }\n"
     "\n"
     "                  if (!pointInRect(this.lockX[var12], this.lockY[var12], cameraX + this.aI + uiX(), cameraY + this.aJ, 240, 320)) {\n"
     "                     this.aI = this.lockX[var12] - cameraX - uiX() - (this.lockReverse[var12] ? 240 : 0);\n"
     "                  }\n"
     "               } else {\n"
     "                  var11 = true;\n"
     "                  int var18 = this.aK * this.frameDelta >> 8;\n"
     "                  if (this.lockReverse[var12]) {\n"
     "                     this.aJ -= var18;\n"
     "                  } else {\n"
     "                     this.aJ += var18;\n"
     "                  }\n"
     "\n"
     "                  if (!pointInRect(this.lockX[var12], this.lockY[var12], cameraX + this.aI + uiX(), cameraY + this.aJ, 240, 320)) {\n"
     "                     this.aJ = this.lockY[var12] - cameraY - (this.lockReverse[var12] ? 320 : 0);\n"
     "                  }\n"
     "               }\n"
     "            }", 1),
    ("s",
     "               && pointInRect(breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0), this.breakY[var17], cameraX, cameraY, 240, 320)) {",
     "               && pointInRect(breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0), this.breakY[var17], cameraX + uiX(), cameraY, 240, 320)) {", 1),
    ("s",
     "               if (!pointInRect(\n"
     "                  breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0), this.breakY[var17], cameraX + this.aI, cameraY + this.aJ, 240, 320\n"
     "               )) {\n"
     "                  this.aI = breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0) - cameraX - (breakCameraRight[var17] ? 240 : 0);\n"
     "               }",
     "               if (!pointInRect(\n"
     "                  breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0), this.breakY[var17], cameraX + this.aI + uiX(), cameraY + this.aJ, 240, 320\n"
     "               )) {\n"
     "                  this.aI = breakX[var17] + (breakCameraRight[var17] ? breakWidth[var17] : 0) - cameraX - uiX() - (breakCameraRight[var17] ? 240 : 0);\n"
     "               }", 1),
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
    # ---------------------------------------------------------------- widescreen: edge-anchored UI
    # the top HUD (health, magic, weapon, orbs) sits in the top-left corner of the screen
    ("s", "            if (state != 101) {\n               this.drawHud(var1);\n            }\n",
     "            if (state != 101) {\n               var1.translate(-uiX(), 0);\n               this.drawHud(var1);\n               var1.translate(uiX(), 0);\n            }\n", 1),
    # the attack prompt at the bottom-left follows the left edge
    ("s", "this.drawFrame(var1, this.aU, 131, 12, this.screenHeight - 25, 0);",
     "this.drawFrame(var1, this.aU, 131, 12 - uiX(), this.screenHeight - 25, 0);", 1),
    # soft-key labels: left key in the bottom-left corner, right key in the bottom-right corner
    ("s", "this.drawSoftKeyLabel(var1, 0, var2, 2);", "this.drawSoftKeyLabel(var1, -uiX(), var2, 2);", 1),
    ("s", "this.drawSoftKeyLabel(var1, 240, var3, 0);", "this.drawSoftKeyLabel(var1, 240 + uiX(), var3, 0);", 1),
    # dialogue / story text panels span the whole width (wrapping and the portrait use the widened panel)
    ("s", "   private void a(int[] var1, byte[] var2, int var3, int var4, int var5, int var6, int var7) {\n",
     "   private void a(int[] var1, byte[] var2, int var3, int var4, int var5, int var6, int var7) {\n      var3 -= uiX();\n      var5 += uiX() << 1;\n", 1),
    ("s", "      this.setClip(var1, 0, hT, 240, hV);", "      this.setClip(var1, -uiX(), hT, viewW, hV);", 1),
    ("s", "      ic = var3 == hZ;\n      this.resetClip(var1);\n", "      ic = var3 == hZ;\n      this.setClip(var1, -uiX(), 0, viewW, 320);\n", 1),
    ("s", "   private void v(Graphics var1) {\n      this.resetClip(var1);\n", "   private void v(Graphics var1) {\n      this.setClip(var1, -uiX(), 0, viewW, 320);\n", 1),
    ("s", "      this.iC = false;\n      var1.fillRect(0, 0, 240, 320);", "      this.iC = false;\n      var1.fillRect(-uiX(), 0, viewW, 320);", 1),
    # main menu: the fire spans the whole width and Kratos sits in the bottom-right corner
    ("s", "      int var2 = 240 - (this.iu - (this.iu >> 2));\n      if (fireHeat == null) {",
     "      int var2 = viewW - (this.iu - (this.iu >> 2));\n      if (fireHeat == null || fireHeat.length != var2 * 140) {", 1),
    ("s", "Engine.drawRgbAlias(var1, firePixels, 0, 240 - (this.iu - (this.iu >> 2)), var3, var4, 240 - (this.iu - (this.iu >> 2) + 1), 140, false);",
     "Engine.drawRgbAlias(var1, firePixels, 0, viewW - (this.iu - (this.iu >> 2)), var3 - uiX(), var4, viewW - (this.iu - (this.iu >> 2) + 1), 140, false);", 1),
    ("s", "this.screenWidth + 0, var13 < 2 ? 0 : this.screenHeight, 0);", "this.screenWidth + uiX(), var13 < 2 ? 0 : this.screenHeight, 0);", 1),
    ("s", "this.setClip(var1, 0, 166, 240, 140);", "this.setClip(var1, -uiX(), 166, viewW, 140);", 1),
    # every remaining "reset the clip" means the whole (widened) canvas
    ("s", "this.resetClip(var1);", "this.setClip(var1, -uiX(), 0, viewW, 320);", 3),
    # ---------------------------------------------------------------- PC settings: the Options menu page
    ("s", "   private void loadMenuTable() {\n",
     "   private void loadMenuTable() {\n      this.loadMenuTableRaw();\n      menuTable = Port.extendMenu(menuTable);\n   }\n\n   private void loadMenuTableRaw() {\n", 1),
    ("s", "            var1 = 23;", "            var1 = 26;", 1),
    ("s", "                  String var20 = this.getString(var14);\n",
     "                  String var20 = this.getString(var14);\n"
     "                  if (this.arrowBase < 0) {\n                     this.arrowBase = this.iJ;\n                  }\n\n"
     "                  if (var5 >= 13 && var5 <= 15) {\n"
     "                     var20 = Port.label(var5 - 13);\n"
     "                     this.iJ = Math.max(this.arrowBase, (this.stringWidth(var20) >> 1) + 14);\n"
     "                  } else {\n"
     "                     this.iJ = this.arrowBase;\n"
     "                  }\n", 1),
    ("s", "                     case 12:\n                        if (var4 == menuCursor) {",
     "                     case 12:\n                     case 13:\n                     case 14:\n                     case 15:\n                        if (var4 == menuCursor) {", 1),
    ("s", "         case 12:\n            if (this.pressedKey == 8 || this.pressedKey == 27) {\n               languageIndex++;",
     "         case 13:\n         case 14:\n         case 15:\n            if (this.pressedKey == 8 || this.pressedKey == 27) {\n               Port.change(var3 - 13, 1);\n               this.iB = true;\n            }\n            break;\n"
     "         case 12:\n            if (this.pressedKey == 8 || this.pressedKey == 27) {\n               languageIndex++;", 1),
    # ---------------------------------------------------------------- PC settings: the pause menu
    ("s", "                        if (pauseMenuIndex > 4) {\n                           pauseMenuIndex = 4;",
     "                        if (pauseMenuIndex > 7) {\n                           pauseMenuIndex = 7;", 1),
    ("s", "               } else if (pauseMenuIndex == 4) {\n                  this.soundPlayer.setSoundOn(!this.soundPlayer.isSoundOn());",
     "               } else if (pauseMenuIndex >= 5) {\n                  Port.change(pauseMenuIndex - 5, 1);\n                  this.iB = true;\n               } else if (pauseMenuIndex == 4) {\n                  this.soundPlayer.setSoundOn(!this.soundPlayer.isSoundOn());", 1),
    ("s", "                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);\n               } else if (pauseMenuIndex == 2 && !this.pauseConfirming) {",
     "                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "                  bo[2].draw(var1, 12 - bo[2].width, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "               } else if (pauseMenuIndex >= 5) {\n"
     "                  this.drawString(var1, Port.label(pauseMenuIndex - 5), halfWidth, halfHeight + lineHeight + halfLineHeight, 33);\n"
     "                  bo[3].draw(var1, this.screenWidth - 5 - 7, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "                  if (pauseMenuIndex < 7) {\n"
     "                     bo[2].draw(var1, 12 - bo[2].width, halfHeight + (lineHeight >> 1) + 4, 0);\n"
     "                  }\n"
     "               } else if (pauseMenuIndex == 2 && !this.pauseConfirming) {", 1),
    # pause / game-over option arrows sit at the screen edges
    ("s", "this.screenWidth - 5 - 7,", "this.screenWidth - 5 - 7 + uiX(),", 4),
    ("s", "12 - bo[2].width,", "12 - bo[2].width - uiX(),", 5),
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
