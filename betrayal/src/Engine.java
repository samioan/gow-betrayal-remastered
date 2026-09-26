import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;

// $VF: renamed from: a
public abstract class Engine extends GameCanvas implements Runnable {
   // $VF: renamed from: a int
   public int animDeltaX;
   // $VF: renamed from: b int
   public int animDeltaY;
   // $VF: renamed from: o long
   private long lastFrameStart;
   // $VF: renamed from: c javax.microedition.midlet.MIDlet
   public MIDlet midlet;
   // $VF: renamed from: d d
   public SoundPlayer soundPlayer;
   // $VF: renamed from: p boolean
   private boolean settingsLoaded;
   // $VF: renamed from: e boolean
   public boolean soundEnabled;
   private boolean q;
   // $VF: renamed from: r int
   private int loadedBank = -1;
   // $VF: renamed from: s int[]
   private int[] resourceLengths;
   // $VF: renamed from: t byte[]
   private byte[] bankData;
   // $VF: renamed from: f byte[]
   public byte[] resourceTypes;
   // $VF: renamed from: u int
   private int plteOffset;
   // $VF: renamed from: v byte[]
   private byte[] stringBytes;
   // $VF: renamed from: w short[]
   private short[] stringOffsets;
   // $VF: renamed from: x c[]
   private Sprite[] font;
   // $VF: renamed from: y char[]
   private char[] charBuffer;
   // $VF: renamed from: z javax.microedition.lcdui.Font
   private Font systemFont = Font.getFont(0, 0, 0);
   // $VF: renamed from: A short[]
   private short[] animSetIds;
   // $VF: renamed from: B int[][]
   private int[][] animHeaders;
   // $VF: renamed from: C byte[][]
   private byte[][] animFrameTiming;
   // $VF: renamed from: D int[][]
   private int[][] animFrames;
   // $VF: renamed from: E char[][]
   private char[][] boxStart;
   // $VF: renamed from: F int[][]
   private int[][] frameHeaders;
   // $VF: renamed from: G int[][]
   private int[][] frameParts;
   // $VF: renamed from: H int[][]
   private int[][] boxPos;
   // $VF: renamed from: I char[][]
   private char[][] boxSize;
   // $VF: renamed from: J char[][]
   private char[][] frameDurations;
   // $VF: renamed from: K java.io.DataInputStream
   private DataInputStream loaderStream;
   // $VF: renamed from: L short[]
   private short[] animSlots;
   // $VF: renamed from: M int
   private int currentSet;
   // $VF: renamed from: N byte[]
   private static final byte[] keyCodeTable = new byte[32];
   // $VF: renamed from: g int
   public volatile int keysHeld;
   // $VF: renamed from: h int
   public volatile int keysPressed;
   // $VF: renamed from: O int
   private volatile int pendingPressed;
   // $VF: renamed from: P int
   private volatile int downKeys;
   // $VF: renamed from: Q int
   private volatile int pendingReleased;
   // $VF: renamed from: i boolean
   public boolean soundBeforePause;
   // $VF: renamed from: j boolean
   public boolean mutedByPause;
   // $VF: renamed from: R boolean
   private boolean resumed;
   // $VF: renamed from: k int
   public int frameTime = 10;
   // $VF: renamed from: l int
   public int minFrameTime = 10;
   // $VF: renamed from: m int
   public int maxFrameTime = 100;
   // $VF: renamed from: S boolean
   private boolean resetFrameTiming;
   // $VF: renamed from: T int
   private int viewWidth;
   // $VF: renamed from: U int
   private int viewHeight;
   // $VF: renamed from: V int
   private int viewOffsetX;
   // $VF: renamed from: W int
   private int viewOffsetY;
   // $VF: renamed from: n boolean
   public volatile boolean bordersCleared;
   // $VF: renamed from: X boolean
   private volatile boolean clearBorders;
   // $VF: renamed from: Y java.lang.Thread
   private Thread gameThread;
   // $VF: renamed from: Z boolean
   private volatile boolean threadRunning;
   // $VF: renamed from: aa boolean
   private volatile boolean shuttingDown;
   // $VF: renamed from: ab long
   private volatile long lifecycleTime;
   // $VF: renamed from: ac int
   private volatile int pendingLifecycle = -1;
   // $VF: renamed from: ad int
   private int lifecycleState = 2;
   // $VF: renamed from: ae boolean
   private volatile boolean pendingResume;

   static {
      keyCodeTable[1] = -1;
      keyCodeTable[2] = -3;
      keyCodeTable[3] = 35;
      keyCodeTable[4] = -8;
      keyCodeTable[5] = -4;
      keyCodeTable[6] = -2;
      keyCodeTable[8] = -5;
      keyCodeTable[10] = 42;

      for (int var0 = 0; var0 < 10; var0++) {
         keyCodeTable[16 + var0] = (byte)(48 + var0);
      }

      keyCodeTable[27] = -6;
      keyCodeTable[29] = -7;
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public abstract void render(Graphics var1);

   // $VF: renamed from: a () void
   public abstract void update();

   // $VF: renamed from: a (java.lang.String, int) int
   public static int parseIntOr(String var0, int var1) {
      try {
         return Integer.parseInt(var0);
      } catch (Exception var2) {
         return var1;
      }
   }

   // $VF: renamed from: a (int[], int) void
   public static void sortInts(int[] var0, int var1) {
      int var5 = var1--;

      boolean var2;
      do {
         if (var5 != 1) {
            var5 = var5 * 197 >> 8;
         }

         var2 = false;
         int var3 = var1 - var5;

         for (int var4 = var1; var3 >= 0; var4--) {
            if (var0[var3] > var0[var4]) {
               int var6 = var0[var3];
               var0[var3] = var0[var4];
               var0[var4] = var6;
               var2 = true;
            }

            var3--;
         }
      } while (var2 || var5 > 1);
   }

   // $VF: renamed from: a (int) byte[]
   public static byte[] readRecord(int var0) {
      RecordStore var2 = null;

      byte[] var1;
      try {
         int var3 = (var2 = RecordStore.openRecordStore(String.valueOf(var0), false)).getNumRecords();
         int var4 = 0;

         for (int var5 = 1; var5 <= var3; var5++) {
            var4 += var2.getRecordSize(var5);
         }

         var1 = new byte[var4];
         var4 = 0;

         for (int var9 = 1; var9 <= var3; var9++) {
            var4 += var2.getRecord(var9, var1, var4);
         }
      } catch (Throwable var7) {
         var1 = (byte[])null;
      }

      if (var2 != null) {
         try {
            var2.closeRecordStore();
         } catch (Throwable var6) {
         }
      }

      return var1;
   }

   // $VF: renamed from: a (int, byte[]) boolean
   public static boolean writeRecord(int var0, byte[] var1) {
      String var2 = String.valueOf(var0);
      RecordStore var3 = null;
      boolean var4 = true;

      try {
         String[] var5;
         if ((var5 = RecordStore.listRecordStores()) != null) {
            for (int var6 = 0; var6 < var5.length; var6++) {
               if (var2.equals(var5[var6])) {
                  RecordStore.deleteRecordStore(var2);
                  break;
               }
            }
         }

         if (var1 != null) {
            var3 = RecordStore.openRecordStore(var2, true);
            int var12 = (var1.length + 589824 - 1) / 589824;
            int var7 = 0;

            for (int var8 = 1; var8 <= var12; var8++) {
               int var9;
               if ((var9 = var1.length - var7) > 589824) {
                  var9 = 589824;
               }

               var3.addRecord(var1, var7, var9);
               var7 += var9;
            }
         }
      } catch (Throwable var11) {
         var4 = false;
      }

      if (var3 != null) {
         try {
            var3.closeRecordStore();
         } catch (Throwable var10) {
         }
      }

      return var4;
   }

   // $VF: renamed from: a (boolean) void
   public final synchronized void syncSettings(boolean var1) {
      if (var1 || !this.settingsLoaded) {
         if (var1) {
            byte[] var3;
            (var3 = new byte[3])[0] = (byte)(this.soundEnabled ? 1 : 0);
            var3[1] = (byte)(this.q ? 1 : 0);
            writeRecord(-9, var3);
            return;
         }

         this.settingsLoaded = true;
         byte[] var2;
         if ((var2 = readRecord(-9)) == null || var2.length != 3) {
            var2 = new byte[]{-1, -1, -1};
            writeRecord(-9, var2);
         }

         this.soundEnabled = var2[0] != 0;
         this.q = var2[1] != 0;
      }
   }

   // $VF: renamed from: b (int) c[]
   public final Sprite[] loadSprites(int var1) {
      return this.loadSprites(var1, null);
   }

   // $VF: renamed from: b (int, byte[]) c[]
   public final Sprite[] loadSprites(int var1, byte[] var2) {
      try {
         DataInputStream var6;
         int var3 = (var6 = this.openResource(var1)).readChar();
         var6.readByte();
         int var4 = 0;
         byte[] var7 = new byte[var6.readShort() - 4];
         int var5 = var6.readChar();
         char var8 = var6.readChar();
         var6.readFully(var7);
         boolean[] var9 = new boolean[16];

         for (int var18 = 0; var18 < 16; var18++) {
            var9[var18] = (var5 >> var18 & 1) == 0;
         }

         var5 = 5;
         var4 = 0;
         int[] var10 = new int[10];

         for (int var11 = 0; var11 < 3; var11++) {
            for (int var12 = 0; var12 < (var11 == 0 ? 2 : 4); var12++) {
               var10[var4++] = var9[var11] ? (var9[var5++] ? 2 : 1) : 0;
            }
         }

         Image var24 = this.loadImageAlias(var3, var2);
         short[] var25 = new short[10];
         Sprite[] var13 = new Sprite[var8];

         for (int var14 = 0; var14 < var8; var14++) {
            var13[var14] = new Sprite(var24);
            var5 = 0;

            for (int var15 = 0; var15 < var25.length; var15++) {
               var4 = 0;
               if ((var3 = var10[var15] - 1) >= 0) {
                  var5 += var14 << var3;
                  if (var3 == 0) {
                     var4 = var7[var5];
                     if (var15 > 1 && var15 != 6 && var15 != 7) {
                        var4 &= 255;
                     }
                  } else {
                     var4 = (var7[var5] & 255) << 8 | var7[var5 + 1] & 255;
                  }

                  var5 += var8 - var14 << var3;
               }

               var25[var15] = (short)var4;
            }

            var13[var14].load(var25);
         }

         return var13;
      } catch (Exception var16) {
         return null;
      }
   }

   // $VF: renamed from: c (int, byte[]) javax.microedition.lcdui.Image
   public final Image loadImage(int var1, byte[] var2) {
      Image var3 = null;
      this.selectBank(var1);
      var1 &= 1023;
      int var4 = this.resourceOffset(var1);
      this.swapPngPalette(this.bankData, var4, var2);
      var3 = Image.createImage(this.bankData, var4, this.resourceLengths[var1]);
      this.swapPngPalette(this.bankData, var4, var2);
      return var3;
   }

   // $VF: renamed from: a (byte[], int, byte[]) void
   private void swapPngPalette(byte[] var1, int var2, byte[] var3) {
      if (var3 != null) {
         DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(var1, var2, var1.length - var2));

         try {
            this.findPlteChunk(var4);
            int var5 = 0;
            var2 += this.plteOffset;

            while (var5 < var3.length) {
               byte var6 = var1[var2];
               var1[var2++] = var3[var5];
               var3[var5++] = var6;
            }

            return;
         } catch (IOException var7) {
         }
      }
   }

   // $VF: renamed from: c (java.io.DataInputStream) int
   private int findPlteChunk(DataInputStream var1) throws IOException {
      var1.skip(8L);
      this.plteOffset = 8;

      while (true) {
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         this.plteOffset += 8;
         if (1347179589 == var3) {
            return var2;
         }

         if (1229278788 == var3) {
            return -1;
         }

         var1.skip(var2 + 4);
         this.plteOffset += var2 + 4;
      }
   }

   // $VF: renamed from: c (int) byte[]
   public final byte[] getResourceBytes(int var1) {
      this.selectBank(var1);
      var1 &= 1023;
      byte[] var2 = new byte[this.resourceLengths[var1]];
      System.arraycopy(this.bankData, this.resourceOffset(var1), var2, 0, var2.length);
      return var2;
   }

   // $VF: renamed from: d (int) java.io.DataInputStream
   public final DataInputStream openResource(int var1) {
      this.selectBank(var1);
      var1 &= 1023;
      return new DataInputStream(new ByteArrayInputStream(this.bankData, this.resourceOffset(var1), this.resourceLengths[var1]));
   }

   // $VF: renamed from: l (int) int
   private int resourceOffset(int var1) {
      int var2 = 0;

      while (--var1 >= 0) {
         var2 += this.resourceLengths[var1];
      }

      return var2;
   }

   // $VF: renamed from: m (int) void
   private void selectBank(int var1) {
      if ((var1 = var1 >> 10) != 0 && var1 != this.loadedBank) {
         if (var1 > 0) {
            try {
               DataInputStream var2 = new DataInputStream(this.getClass().getResourceAsStream("/RP" + var1));
               this.parseBankAlias(var2);
               var2.close();
            } catch (Exception var3) {
            }
         } else {
            this.parseBank(null);
         }

         this.loadedBank = var1;
      }
   }

   // $VF: renamed from: a (java.io.DataInputStream) boolean
   public final boolean parseBank(DataInputStream var1) {
      this.resourceLengths = null;
      this.resourceTypes = null;
      this.bankData = null;
      if (var1 == null) {
         this.loadedBank = -1;
         return false;
      }

      this.loadedBank = 0;

      try {
         int var4 = var1.read();
         int var2 = 1 + (var4 & 1) << 1;
         char var9 = var1.readChar();
         byte[] var5 = new byte[var2 * var9];
         var1.readFully(var5);
         this.resourceLengths = new int[var9];
         int var3 = 0;

         for (int var6 = 0; var6 < var9; var6++) {
            for (int var7 = var2 - 1; var7 >= 0; var7--) {
               this.resourceLengths[var6] = this.resourceLengths[var6] | (255 & var5[var3++]) << (var7 << 3);
            }
         }

         this.resourceTypes = new byte[var9];
         var1.readFully(this.resourceTypes);
         this.bankData = new byte[var1.readInt()];
         var1.readFully(this.bankData);
         return true;
      } catch (Exception var8) {
         return false;
      }
   }

   // $VF: renamed from: e (int) java.lang.String
   public final String getString(int var1) {
      short var2 = this.stringOffsets[var1];

      try {
         return new String(this.stringBytes, var2, this.stringOffsets[var1 + 1] - var2, "UTF-8");
      } catch (Exception var3) {
         return null;
      }
   }

   // $VF: renamed from: f (int) void
   public final void loadStringTable(int var1) {
      if (var1 == -1) {
         this.stringBytes = null;
         this.stringOffsets = null;
      } else {
         try {
            DataInputStream var2 = this.openResource(var1);
            this.stringOffsets = new short[var2.readShort() + 1];
            int var3 = this.resourceLengths[var1 & 1023];
            this.stringBytes = new byte[var3 - (this.stringOffsets.length << 1)];
            short var4 = 0;

            int var5;
            for (var5 = 0; var5 < this.stringOffsets.length - 1; var5++) {
               this.stringOffsets[var5] = var4;
               short var7;
               if ((var7 = var2.readShort()) > 0) {
                  var2.readFully(this.stringBytes, var4, var7);
               }

               var4 += var7;
            }

            this.stringOffsets[var5] = var4;
         } catch (Exception var6) {
         }
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int[], int, int, int, int, int, int, boolean) void
   public static void drawRgbAlias(Graphics var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      drawRgb(var0, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   // $VF: renamed from: b (javax.microedition.lcdui.Graphics, int[], int, int, int, int, int, int, boolean) void
   public static void drawRgb(Graphics var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      var0.drawRGB(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   // $VF: renamed from: a (c[]) void
   public final void setFont(Sprite[] var1) {
      this.font = var1;
      if (this.font != null && var1[3].metric == 255) {
         var1[3].metric = 0;
         short var2 = 0;

         for (int var3 = 0; var3 < var1.length; var3++) {
            Sprite var4 = var1[var3];
            var2 = (short)(var2 + (var4.offsetX << 8) + (var4.offsetY & 255));
            var4.offsetX = var4.charCode;
            var4.offsetY = var4.f;
            var4.charCode = var2;
         }
      }
   }

   // $VF: renamed from: n (int) void
   private void ensureCharBuffer(int var1) {
      if (this.charBuffer == null || this.charBuffer.length < var1) {
         this.charBuffer = new char[var1];
      }
   }

   // $VF: renamed from: a (java.lang.String) int
   public final int stringWidth(String var1) {
      return this.stringWidth(var1, 0, var1.length());
   }

   // $VF: renamed from: a (java.lang.String, int, int) int
   public final int stringWidth(String var1, int var2, int var3) {
      this.ensureCharBuffer(var3);

      for (int var4 = 0; var4 < var3; var4++) {
         this.charBuffer[var4] = var1.charAt(var2 + var4);
      }

      return this.charsWidth(this.charBuffer, 0, var3);
   }

   // $VF: renamed from: a (char) int
   public final int charWidth(char var1) {
      this.ensureCharBuffer(1);
      this.charBuffer[0] = var1;
      return this.charsWidth(this.charBuffer, 0, 1);
   }

   // $VF: renamed from: a (char[], int, int) int
   public final int charsWidth(char[] var1, int var2, int var3) {
      if (this.font != null) {
         var3 += var2;
         short var4 = 0;

         while (var2 < var3) {
            Sprite var5 = this.findGlyph(var1[var2]);
            var4 += var5 != null ? var5.advance : this.font[2].metric;
            var2++;
         }

         return var4;
      } else {
         return var3 == 0 ? 0 : this.systemFont.charsWidth(var1, var2, var3);
      }
   }

   // $VF: renamed from: b (char) c
   private Sprite findGlyph(char var1) {
      int var2 = 0;
      int var3 = this.font.length - 1;

      while (var2 <= var3) {
         int var4 = var2 + var3 >> 1;
         char var5;
         if ((var5 = (char)this.font[var4].charCode) < var1) {
            var2 = var4 + 1;
         } else {
            if (var5 <= var1) {
               return this.font[var4];
            }

            var3 = var4 - 1;
         }
      }

      return null;
   }

   // $VF: renamed from: b () int
   public final int fontBaseline() {
      return this.font != null ? this.font[1].metric : this.systemFont.getBaselinePosition();
   }

   // $VF: renamed from: c () int
   public final int fontHeight() {
      return this.font != null ? this.font[0].metric : this.systemFont.getHeight();
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, java.lang.String, int, int, int) void
   public final void drawString(Graphics var1, String var2, int var3, int var4, int var5) {
      this.drawString(var1, var2, 0, var2.length(), var3, var4, var5);
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, java.lang.String, int, int, int, int, int) void
   public final void drawString(Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      this.ensureCharBuffer(var4);

      for (int var8 = 0; var8 < var4; var8++) {
         this.charBuffer[var8] = var2.charAt(var3 + var8);
      }

      this.drawString(var1, this.charBuffer, 0, var4, var5, var6, var7);
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, char[], int, int, int, int, int) void
   public final void drawString(Graphics var1, char[] var2, int var3, int var4, int var5, int var6, int var7) {
      if ((var7 & 64) != 0) {
         var6 -= this.fontBaseline();
      } else if ((var7 & 32) != 0) {
         var6 -= this.fontHeight();
      }

      if ((var7 & 9) != 0) {
         var5 -= this.charsWidth(var2, var3, var4) >> (var7 & 1);
      }

      if (this.font != null) {
         for (int var9 = var4 + var3; var3 < var9; var3++) {
            Sprite var8;
            if ((var8 = this.findGlyph(var2[var3])) != null) {
               var8.draw(var1, var5, var6, 0);
               var5 += var8.advance;
            } else {
               var5 += this.font[2].metric;
            }
         }
      } else {
         if (var4 != 0) {
            if (var1.getFont() != this.systemFont) {
               var1.setFont(this.systemFont);
            }

            var1.drawChars(var2, var3, var4, var5, var6, 20);
         }
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Image, int, int, int, int, javax.microedition.lcdui.Graphics, int, int) void
   public static void drawImageRegion(Image var0, int var1, int var2, int var3, int var4, Graphics var5, int var6, int var7) {
      var5.drawRegion(var0, var1, var2, var3, var4, 0, var6, var7, 20);
   }

   // $VF: renamed from: a (int[], int, int) int
   public static int binarySearch(int[] var0, int var1, int var2) {
      int var3 = 0;

      while (var3 <= var1) {
         int var4 = var3 + var1 >> 1;
         int var5;
         if ((var5 = var0[var4]) < var2) {
            var3 = var4 + 1;
         } else {
            if (var5 <= var2) {
               return var4;
            }

            var1 = var4 - 1;
         }
      }

      return var1 + 1;
   }

   // $VF: renamed from: g (int) void
   public final void loadAnimSet(int var1) {
      if (this.animSetIds != null) {
         for (int var2 = 0; var2 < this.animSetIds.length; var2++) {
            if (var1 == (this.animSetIds[var2] & 32767)) {
               return;
            }
         }
      }

      this.animSetIds = a(this.animSetIds, (short)var1);
      int var3 = this.animSetIds.length - 1;

      try {
         this.loaderStream = this.openResource(var1);
         this.loaderStream.read();
         int var4 = this.loaderStream.readChar();
         this.animHeaders = a(this.animHeaders, var4);
         int[] var5 = this.animHeaders[var3];
         var1 = this.readRunLengths(var5);

         for (int var14 = 0; var14 < var4; var14++) {
            var5[var14] |= (63 & this.readSigned()) << 10;
         }

         this.animFrameTiming = a(this.animFrameTiming, var1);
         byte[] var6 = this.animFrameTiming[var3];
         this.animFrames = a(this.animFrames, var1);
         var5 = this.animFrames[var3];

         for (int var15 = 0; var15 < var1; var15++) {
            var4 = this.readUnsigned();
            var6[var15] = (byte)var4;
            var5[var15] = var4 >> 8;
         }

         this.readPackedOffsets(var5);
         char var7 = this.loaderStream.readChar();
         this.boxStart = a(this.boxStart, var7);
         this.frameHeaders = a(this.frameHeaders, var7);
         var1 = this.readRunLengths(this.frameHeaders[var3]);
         this.frameParts = a(this.frameParts, var1);
         var5 = this.frameParts[var3];
         byte var8 = 0;

         for (int var16 = 0; var16 < var1; var16++) {
            if (var8 == 0) {
               var4 = this.readUnsigned();
               var8 = 8;
            }

            var8 -= 2;
            var5[var16] = 3 & var4 >> var8;
         }

         this.readPackedOffsets(var5);
         var1 = 0;

         for (int var17 = 0; var17 < var7; var17++) {
            var4 = this.readUnsigned();
            this.frameHeaders[var3][var17] = this.frameHeaders[var3][var17] | var4 << 8;
            this.boxStart[var3][var17] = (char)var1;
            var1 += var4;
         }

         this.boxPos = a(this.boxPos, var1);
         this.boxSize = a(this.boxSize, var1);
         var5 = this.boxPos[var3];
         char[] var9 = this.boxSize[var3];
         int var18 = 0;

         while (var18 < var1) {
            var5[var18++] = this.readSigned() << 21;
         }

         var18 = 0;

         while (var18 < var1) {
            var5[var18++] |= this.readSigned() << 21 >>> 11;
         }

         var18 = 0;

         while (var18 < var1) {
            var5[var18++] |= this.readUnsigned();
         }

         var18 = 0;

         while (var18 < var1) {
            var9[var18++] = (char)(this.readUnsigned() << 6);
         }

         var18 = 0;

         while (var18 < var1) {
            var9[var18++] |= (char)this.readUnsigned();
         }

         char var25 = this.loaderStream.readChar();
         this.frameDurations = a(this.frameDurations, var25);

         for (int var23 = 0; var23 < var25; var23++) {
            this.frameDurations[var3][var23] = (char)this.readUnsigned();
         }
      } catch (Exception var10) {
      }

      this.loaderStream = null;
   }

   // $VF: renamed from: a (int[]) int
   private int readRunLengths(int[] var1) throws Exception {
      int var2 = 0;
      int var4 = 0;

      while (var4 < var1.length) {
         int var3 = this.readUnsigned();
         var1[var4++] = var2 << 16 | var3;
         var2 += var3;
      }

      return var2;
   }

   // $VF: renamed from: b (int[]) void
   private void readPackedOffsets(int[] var1) throws Exception {
      int var2 = var1.length;
      int var3 = 0;

      while (var3 < var2) {
         var1[var3++] |= this.readUnsigned() << 22;
      }

      var3 = 0;

      while (var3 < var2) {
         var1[var3++] |= this.readSigned() << 22 >>> 10;
      }

      var3 = 0;

      while (var3 < var2) {
         var1[var3++] |= this.readSigned() << 22 >>> 20;
      }
   }

   // $VF: renamed from: k () int
   private int readUnsigned() throws Exception {
      int var1;
      return (var1 = this.loaderStream.read()) == 255 ? this.loaderStream.readChar() : var1;
   }

   // $VF: renamed from: l () int
   private int readSigned() throws Exception {
      byte var1;
      return (var1 = this.loaderStream.readByte()) == -128 ? this.loaderStream.readShort() : var1;
   }

   private static short[] a(short[] var0, short var1) {
      if (var0 == null) {
         var0 = new short[0];
      }

      short[] var2 = new short[var0.length + 1];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      var2[var0.length] = var1;
      return var2;
   }

   private static int[][] a(int[][] var0, int var1) {
      if (var0 == null) {
         var0 = new int[0][];
      }

      int[][] var2 = new int[var0.length + 1][];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      var2[var0.length] = new int[var1];
      return var2;
   }

   private static byte[][] a(byte[][] var0, int var1) {
      if (var0 == null) {
         var0 = new byte[0][];
      }

      byte[][] var2 = new byte[var0.length + 1][];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      var2[var0.length] = new byte[var1];
      return var2;
   }

   private static char[][] a(char[][] var0, int var1) {
      if (var0 == null) {
         var0 = new char[0][];
      }

      char[][] var2 = new char[var0.length + 1][];
      System.arraycopy(var0, 0, var2, 0, var0.length);
      var2[var0.length] = new char[var1];
      return var2;
   }

   private static short[] a(short[] var0, int var1) {
      if (var0 == null) {
         var0 = new short[0];
      }

      if (var1 > var0.length) {
         short[] var2 = new short[var1];
         System.arraycopy(var0, 0, var2, 0, var0.length);
         var0 = var2;
      }

      return var0;
   }

   // $VF: renamed from: a (int, boolean) void
   public final void setAnimSetPersistent(int var1, boolean var2) {
      int var3 = 0;

      while (var1 != (this.animSetIds[var3] & 32767)) {
         var3++;
      }

      if (var2) {
         this.animSetIds[var3] = (short)(this.animSetIds[var3] | 32768);
      } else {
         this.animSetIds[var3] = (short)(this.animSetIds[var3] & 32767);
      }
   }

   private static void a(Object[] var0, char[] var1, Object[] var2) {
      for (int var3 = 0; var3 < var1.length; var3++) {
         var2[var3] = var0[var1[var3]];
      }
   }

   // $VF: renamed from: d () void
   public final void releaseTransientAnimSets() {
      int var2 = 0;
      if (this.animSetIds != null) {
         for (int var1 = 0; var1 < this.animSetIds.length; var1++) {
            if (this.animSetIds[var1] < 0) {
               var2++;
            }
         }
      }

      if (var2 > 0) {
         char[] var3 = new char[var2];
         short[] var4 = this.animSetIds;
         this.animSetIds = new short[var2];
         int var6 = 0;

         for (int var5 = 0; var5 < var4.length; var5++) {
            if (var4[var5] < 0) {
               var3[var6] = (char)var5;
               this.animSetIds[var6++] = var4[var5];
            }
         }

         a(this.animHeaders, var3, this.animHeaders = new int[var2][]);
         a(this.animFrameTiming, var3, this.animFrameTiming = new byte[var2][]);
         a(this.animFrames, var3, this.animFrames = new int[var2][]);
         a(this.boxStart, var3, this.boxStart = new char[var2][]);
         a(this.frameHeaders, var3, this.frameHeaders = new int[var2][]);
         a(this.frameParts, var3, this.frameParts = new int[var2][]);
         a(this.boxPos, var3, this.boxPos = new int[var2][]);
         a(this.boxSize, var3, this.boxSize = new char[var2][]);
         a(this.frameDurations, var3, this.frameDurations = new char[var2][]);
      } else {
         this.animSetIds = null;
         this.animHeaders = null;
         this.animFrameTiming = null;
         this.animFrames = null;
         this.boxStart = null;
         this.frameHeaders = null;
         this.frameParts = null;
         this.boxPos = null;
         this.boxSize = null;
         this.frameDurations = null;
         this.animSlots = null;
      }
   }

   // $VF: renamed from: h (int) void
   public final void ensureAnimSlots(int var1) {
      this.animSlots = a(this.animSlots, var1 * 8);
   }

   // $VF: renamed from: a (int, int, int) void
   public final void startAnim(int var1, int var2, int var3) {
      int var4 = 0;

      while (var2 != (this.animSetIds[var4] & 32767)) {
         var4++;
      }

      var1 *= 8;
      this.animSlots = a(this.animSlots, var1 + 8);
      this.animSlots[var1 + 0] = (short)var4;
      this.animSlots[var1 + 1] = (short)var3;
      this.animSlots[var1 + 2] = 0;
      this.animSlots[var1 + 3] = (short)(this.animHeaders[var4][var3] << 16 >> 26);
      this.animSlots[var1 + 4] = 0;
      this.animSlots[var1 + 5] = 0;
      this.animSlots[var1 + 6] = 0;
      this.animSlots[var1 + 7] = 0;
   }

   // $VF: renamed from: a (int, int) void
   public final void copyAnimSlot(int var1, int var2) {
      var1 *= 8;
      var2 *= 8;
      this.animSlots = a(this.animSlots, var2 + 8);
      System.arraycopy(this.animSlots, var1, this.animSlots, var2, 8);
   }

   // $VF: renamed from: b (int, int) boolean
   public final boolean stepAnim(int var1, int var2) {
      var1 *= 8;
      int var3;
      if ((var3 = this.animSlots[var1 + 3]) == 0) {
         this.animDeltaX = 0;
         this.animDeltaY = 0;
         return false;
      }

      short var4 = this.animSlots[var1 + 0];
      int var5 = this.animSlots[var1 + 2];
      var2 += this.animSlots[var1 + 4] & '\uffff';
      int var6 = this.animSlots[var1 + 5];
      int var7 = this.animSlots[var1 + 6];
      int var8;
      int var9 = (var8 = this.animHeaders[var4][this.animSlots[var1 + 1]]) >>> 16;
      int var10 = var8 & 1023;
      int var11 = var5;
      int var13 = var5 == this.animSlots[var1 + 7] ? 0 : this.animFrameTiming[var4][var9 + var11] >> 6 & 3;

      char var12;
      while (var2 >= (var12 = this.frameDurations[var4][this.animFrameTiming[var4][var9 + var5] & 63])) {
         var2 -= var12;
         if (++var5 == var10) {
            if (var3 > 0) {
               if (--var3 == 0) {
                  var5--;
                  var2 = var12;
                  break;
               }
            }

            var5 = 0;
            var8 = this.animFrames[var4][var9 + (var10 - 1)];
            var6 -= var8 << 10 >> 22;
            var7 -= var8 << 20 >> 22;
         }

         int var14;
         if ((var14 = this.animFrameTiming[var4][var9 + var5] >> 6 & 3) >= var13) {
            var13 = var14;
            var11 = var5;
         }
      }

      int var26 = (var8 = this.animFrames[var4][var9 + var5]) << 10 >> 22;
      int var15 = var8 << 20 >> 22;
      if ((var8 & 3) > 0 && var3 != 0 && (var5 + 1 != var10 || var3 != 1)) {
         int var16;
         int var17;
         if (var5 + 1 == var10) {
            var16 = (var8 = this.animFrames[var4][var9 + var5]) << 10 >> 22;
            var17 = var8 << 20 >> 22;
            var8 = 0;
         } else {
            var16 = 0;
            var17 = 0;
            var8 = var5 + 1;
         }

         var8 = this.animFrames[var4][var9 + var8];
         var16 += var8 << 10 >> 22;
         var17 += var8 << 20 >> 22;
         int var18 = (var2 << 12) / var12;
         var26 += (var16 - var26) * var18 >> 12;
         var15 += (var17 - var15) * var18 >> 12;
      }

      this.animDeltaX = var26 - var6;
      this.animDeltaY = var15 - var7;
      this.animSlots[var1 + 2] = (short)var5;
      this.animSlots[var1 + 3] = (short)var3;
      this.animSlots[var1 + 4] = (short)var2;
      this.animSlots[var1 + 5] = (short)var26;
      this.animSlots[var1 + 6] = (short)var15;
      this.animSlots[var1 + 7] = (short)var11;
      return var3 != 0;
   }

   // $VF: renamed from: a (c[], int, int, int, int, int[]) void
   public final void getFrameBounds(Sprite[] var1, int var2, int var3, int var4, int var5, int[] var6) {
      var2 = this.resolveFrame(var2);
      int var19;
      int var7 = (var19 = this.frameHeaders[this.currentSet][var2]) >>> 16;
      int[] var8 = this.frameParts[this.currentSet];
      int var9 = var7 + (var19 & 0xFF);
      int var10 = Integer.MAX_VALUE;
      int var11 = Integer.MAX_VALUE;
      int var12 = Integer.MIN_VALUE;
      int var13 = Integer.MIN_VALUE;

      while (var7 < var9) {
         int var14 = (var2 = var8[var7++]) & 3 ^ var5;
         Sprite var15;
         int var16 = (var15 = var1[var2 >>> 22]).offsetX + (var2 << 10 >> 22);
         if ((var14 & 2) != 0) {
            var16 = -(var16 + var15.width);
         }

         int var17 = var15.offsetY + (var2 << 20 >> 22);
         if ((var14 & 1) != 0) {
            var17 = -(var17 + var15.height);
         }

         var10 = Math.min(var10, var16);
         var11 = Math.min(var11, var17);
         var12 = Math.max(var12, var16 + var15.width);
         var13 = Math.max(var13, var17 + var15.height);
      }

      var6[0] = var3 + var10;
      var6[1] = var4 + var11;
      var6[2] = var12 - var10;
      var6[3] = var13 - var11;
   }

   // $VF: renamed from: a (short[], int, int) int
   public final int getFrameParts(short[] var1, int var2, int var3) {
      var2 = this.resolveFrame(var2);
      int var11;
      int var4 = (var11 = this.frameHeaders[this.currentSet][var2]) >>> 16;
      int[] var5 = this.frameParts[this.currentSet];
      int var6 = var11 & 0xFF;
      int var7 = var4 + var6;
      int var8 = 0;

      while (var4 < var7 && var8 + 3 < var1.length) {
         var2 = var5[var4++];
         var1[var8++] = (short)(var2 >>> 22);
         int var9 = var2 & 3 ^ var3;
         var1[var8++] = (short)(((var9 & 2) == 0 ? 1 : -1) * (var2 << 10 >> 22));
         var1[var8++] = (short)(((var9 & 1) == 0 ? 1 : -1) * (var2 << 20 >> 22));
         var1[var8++] = (short)var9;
      }

      return var6;
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, c[], int, int, int, int) void
   public final void drawFrame(Graphics var1, Sprite[] var2, int var3, int var4, int var5, int var6) {
      this.drawFrameNow(var1, var2, this.resolveFrame(var3), var4, var5, var6);
   }

   // $VF: renamed from: b (javax.microedition.lcdui.Graphics, c[], int, int, int, int) void
   public final void drawFrameNow(Graphics var1, Sprite[] var2, int var3, int var4, int var5, int var6) {
      int var13;
      int var7 = (var13 = this.frameHeaders[this.currentSet][var3]) >>> 16;
      int[] var8 = this.frameParts[this.currentSet];
      int var9 = var7 + (var13 & 0xFF);

      while (var7 < var9) {
         int var10 = (var3 = var8[var7++]) << 10 >> 22;
         int var11 = var3 << 20 >> 22;
         Sprite var12;
         Sprite var10000 = var12 = var2[var3 >>> 22];
         var10000.offsetX = (short)(var10000.offsetX + var10);
         var12.offsetY = (short)(var12.offsetY + var11);
         var12.draw(var1, var4, var5, var3 & 3 ^ var6);
         var12.offsetX = (short)(var12.offsetX - var10);
         var12.offsetY = (short)(var12.offsetY - var11);
      }
   }

   // $VF: renamed from: b (short[], int, int) int
   public final int getFrameBoxes(short[] var1, int var2, int var3) {
      var2 = this.resolveFrame(var2);
      int var4 = this.boxStart[this.currentSet][var2];
      int var5 = this.frameHeaders[this.currentSet][var2] >> 8 & 0xFF;
      int var6 = var4 + var5;
      int var7 = 0;

      while (var4 < var6 && var7 + 4 < var1.length) {
         int var8 = (var2 = this.boxPos[this.currentSet][var4]) >> 21;
         int var9 = var2 << 11 >> 21;
         int var10 = var2 & 1023;
         char var15;
         int var11 = (var15 = this.boxSize[this.currentSet][var4++]) >> 6;
         int var12 = var15 & '?';
         if ((var3 & 2) != 0) {
            var8 = -(var8 + var10);
         }

         if ((var3 & 1) != 0) {
            var9 = -(var9 + var11);
         }

         var1[var7++] = (short)var8;
         var1[var7++] = (short)var9;
         var1[var7++] = (short)var10;
         var1[var7++] = (short)var11;
         var1[var7++] = (short)var12;
      }

      return var5;
   }

   // $VF: renamed from: o (int) int
   private int resolveFrame(int var1) {
      var1 *= 8;
      this.currentSet = this.animSlots[var1 + 0];
      int var2 = this.animSlots[var1 + 1];
      var2 = (this.animHeaders[this.currentSet][var2] >>> 16) + this.animSlots[var1 + 7];
      return this.animFrames[this.currentSet][var2] >>> 22;
   }

   // $VF: renamed from: e () void
   public final synchronized void clearKeys() {
      this.pendingPressed = 0;
      this.downKeys = 0;
      this.pendingReleased = this.pendingReleased | this.keysHeld;
      this.keysPressed = 0;
      this.keysHeld = 0;
   }

   // $VF: renamed from: f () void
   public final synchronized void pollKeys() {
      this.keysPressed = this.pendingPressed;
      this.pendingPressed = 0;
      this.pendingReleased = this.pendingReleased & this.downKeys;
      this.downKeys = this.downKeys & ~this.pendingReleased;
      this.keysHeld = this.keysPressed | this.downKeys;
      this.pendingReleased = 0;
      this.pendingReleased = this.pendingReleased | this.downKeys & 939524096;
      this.pendingReleased = this.pendingReleased | this.downKeys & 16;
   }

   // $VF: renamed from: b (int, boolean) void
   private void handleKey(int var1, boolean var2) {
      if (var1 != 0) {
         synchronized (this) {
            for (int var4 = 1; var4 < keyCodeTable.length; var4++) {
               if (keyCodeTable[var4] == var1) {
                  int var5 = 1 << var4;
                  if (var2) {
                     this.pendingPressed |= var5;
                     this.downKeys |= var5;
                     this.pendingReleased &= ~var5;
                  } else {
                     this.pendingReleased |= var5;
                  }
               }
            }
         }
      }
   }

   public void keyPressed(int var1) {
      if (this.mutedByPause && this.resumed) {
         this.mutedByPause = false;
         this.soundEnabled = this.soundBeforePause;
         this.pendingResume = true;
      }

      this.handleKey(var1, true);
      super.keyPressed(var1);
   }

   public void keyReleased(int var1) {
      this.handleKey(var1, false);
      super.keyReleased(var1);
   }

   public void keyRepeated(int var1) {
      super.keyRepeated(var1);
   }

   // $VF: renamed from: g () void
   public final void resetFrameTimer() {
      this.frameTime = this.minFrameTime;
      this.resetFrameTiming = true;
   }

   // $VF: renamed from: c (javax.microedition.lcdui.Graphics) void
   private void paintFrame(Graphics var1) {
      if (var1 == null) {
         this.clearBorders = true;
      } else {
         if (240 != this.viewWidth || 320 != this.viewHeight) {
            if (this.bordersCleared) {
               int var3 = 320 - this.viewHeight + 1 >>> 1;
               var1.setColor(-16777216);
               if (var3 > 0) {
                  if (this.viewOffsetY > 0) {
                     var1.fillRect(0, 0, 240, this.viewOffsetY);
                  }

                  var1.fillRect(0, 320 - var3, 240, var3);
               }

               if ((var3 = 240 - this.viewWidth + 1 >>> 1) > 0) {
                  if (this.viewOffsetX > 0) {
                     var1.fillRect(0, this.viewOffsetY, this.viewOffsetX, this.viewHeight);
                  }

                  var1.fillRect(240 - var3, this.viewOffsetY, var3, this.viewHeight);
               }
            }

            var1.translate(this.viewOffsetX, this.viewOffsetY);
         }

         this.resetClip(var1);
         this.render(var1);
      }
   }

   // $VF: renamed from: c (int, int) void
   public final void setViewSize(int var1, int var2) {
      this.clearBorders = true;
      if (var1 <= 0) {
         var1 = 240;
      }

      if (var2 <= 0) {
         var2 = 320;
      }

      this.viewWidth = var1;
      this.viewHeight = var2;
      this.viewOffsetX = 240 - var1;
      this.viewOffsetY = 320 - var2;
      if (this.viewOffsetX < 0) {
         this.viewOffsetX++;
      }

      if (this.viewOffsetY < 0) {
         this.viewOffsetY++;
      }

      this.viewOffsetX >>= 1;
      this.viewOffsetY >>= 1;
   }

   // $VF: renamed from: b (javax.microedition.lcdui.Graphics) void
   public final void resetClip(Graphics var1) {
      var1.setClip(0, 0, this.viewWidth, this.viewHeight);
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int) void
   public final void setClip(Graphics var1, int var2, int var3, int var4, int var5) {
      if ((this.viewOffsetX | this.viewOffsetY) != 0) {
         if (var2 < 0) {
            var4 += var2;
            var2 = 0;
         }

         int var6;
         if ((var6 = var2 + var4 - this.viewWidth) > 0) {
            var4 -= var6;
         }

         if (var3 < 0) {
            var5 += var3;
            var3 = 0;
         }

         int var7;
         if ((var7 = var3 + var5 - this.viewHeight) > 0) {
            var5 -= var7;
         }
      }

      var1.setClip(var2, var3, var4, var5);
   }

   // $VF: renamed from: h () void
   public final void requestClear() {
      this.clearBorders = true;
   }

   // $VF: renamed from: i (int) void
   public void onLifecycle(int var1) {
      if (var1 == 3) {
         if (this.soundPlayer != null) {
            this.soundPlayer.shutdown();
         }

         this.shuttingDown = true;
         this.midlet.notifyDestroyed();
      } else if (var1 == 2) {
         try {
            Thread.sleep(100L);
         } catch (Exception var2) {
         }
      }

      if (var1 == 0 || var1 == 1 || var1 == 2) {
         this.clearBorders = true;
         this.resetFrameTiming = true;
         this.clearKeys();
      }
   }

   public final void hideNotify() {
      this.postLifecycle(1);
   }

   public final void showNotify() {
      this.postLifecycle(2);
      if (this.gameThread == null) {
         this.gameThread = new Thread(this);
         this.gameThread.start();
      }
   }

   // $VF: renamed from: j (int) void
   public final synchronized void postLifecycle(int var1) {
      if (var1 == 3) {
         this.onLifecycle(var1);
      } else if (this.threadRunning && (var1 == 1 || var1 == 2)) {
         if (var1 == 1) {
            this.resumed = false;
            if (!this.mutedByPause) {
               this.mutedByPause = true;
               this.soundBeforePause = this.soundEnabled;
               this.soundEnabled = false;
            }
         }

         synchronized (this.gameThread) {
            this.pendingLifecycle = var1;
            this.lifecycleTime = System.currentTimeMillis();
         }
      }
   }

   // $VF: renamed from: m () void
   private void processLifecycle() {
      while (this.pendingLifecycle != -1) {
         if (this.lifecycleState != 1) {
            if (this.soundPlayer != null) {
               this.soundPlayer.stop();
            }

            this.onLifecycle(1);
            this.lifecycleState = 1;
         }

         synchronized (this.gameThread) {
            if (this.pendingLifecycle == 1) {
               this.pendingLifecycle = -1;
            }
         }

         while (this.pendingLifecycle == 2 && this.isShown()) {
            if ((int)(System.currentTimeMillis() - this.lifecycleTime) < 750) {
               try {
                  Thread.sleep(250L);
                  Thread.yield();
               } catch (Exception var3) {
               }
            } else {
               synchronized (this.gameThread) {
                  if (this.pendingLifecycle != 2) {
                     continue;
                  }

                  this.pendingLifecycle = -1;
               }

               if (this.soundPlayer != null) {
                  this.soundPlayer.stop();
               }

               this.onLifecycle(2);
               this.lifecycleState = 2;
               this.resumed = true;
            }
         }
      }

      if (this.pendingResume) {
         this.pendingResume = false;
         this.onLifecycle(5);
      }
   }

   // $VF: renamed from: i () void
   public final void releaseAnimSetsAlias() {
      this.releaseTransientAnimSets();
   }

   // $VF: renamed from: j () void
   public final void resetFrameTimerAlias() {
      this.resetFrameTimer();
   }

   // $VF: renamed from: d (int, byte[]) javax.microedition.lcdui.Image
   public final Image loadImageAlias(int var1, byte[] var2) {
      return this.loadImage(var1, var2);
   }

   // $VF: renamed from: k (int) byte[]
   public final byte[] getResourceBytesAlias(int var1) {
      return this.getResourceBytes(var1);
   }

   // $VF: renamed from: b (java.io.DataInputStream) boolean
   public final boolean parseBankAlias(DataInputStream var1) {
      return this.parseBank(var1);
   }

   public final void run() {
      this.threadRunning = true;
      this.onLifecycle(0);

      for (; !this.shuttingDown; Thread.yield()) {
         this.processLifecycle();
         if (this.isShown()) {
            long var1 = System.currentTimeMillis();
            if (this.resetFrameTiming) {
               this.resetFrameTiming = false;
               this.frameTime = this.minFrameTime;
            } else {
               int var3;
               if ((var3 = (int)(var1 - this.lastFrameStart)) > 4000) {
                  this.postLifecycle(2);
               }

               if (var3 > this.maxFrameTime || var3 < 0) {
                  var3 = this.maxFrameTime;
               }

               this.frameTime = var3;
               if (this.frameTime < this.minFrameTime) {
                  int var4;
                  if ((var4 = this.minFrameTime - this.frameTime) < 10) {
                     var4 = 10;
                  }

                  this.frameTime = this.minFrameTime;

                  try {
                     Thread.sleep(var4);
                  } catch (Exception var6) {
                  }
               }
            }

            this.lastFrameStart = var1;
            this.update();
            if (this.soundPlayer != null) {
               this.soundPlayer.run();
            }

            if (this.shuttingDown) {
               return;
            }

            if (this.isShown()) {
               this.bordersCleared = this.clearBorders;
               this.clearBorders = false;
               this.paintFrame(this.getGraphics());
               this.flushGraphics();
            }
         } else {
            try {
               Thread.sleep(100L);
            } catch (Exception var5) {
            }

            this.resetFrameTiming = true;
         }
      }
   }

   public Engine(MIDlet var1) {
      super(false);
      this.setFullScreenMode(true);
      this.midlet = var1;
      this.setViewSize(240, 320);
   }
}
