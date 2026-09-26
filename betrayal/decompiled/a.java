import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;

public abstract class a extends GameCanvas implements Runnable {
   public int a;
   public int b;
   private long o;
   public MIDlet c;
   public d d;
   private boolean p;
   public boolean e;
   private boolean q;
   private int r = -1;
   private int[] s;
   private byte[] t;
   public byte[] f;
   private int u;
   private byte[] v;
   private short[] w;
   private c[] x;
   private char[] y;
   private Font z = Font.getFont(0, 0, 0);
   private short[] A;
   private int[][] B;
   private byte[][] C;
   private int[][] D;
   private char[][] E;
   private int[][] F;
   private int[][] G;
   private int[][] H;
   private char[][] I;
   private char[][] J;
   private DataInputStream K;
   private short[] L;
   private int M;
   private static final byte[] N = new byte[32];
   public volatile int g;
   public volatile int h;
   private volatile int O;
   private volatile int P;
   private volatile int Q;
   public boolean i;
   public boolean j;
   private boolean R;
   public int k = 10;
   public int l = 10;
   public int m = 100;
   private boolean S;
   private int T;
   private int U;
   private int V;
   private int W;
   public volatile boolean n;
   private volatile boolean X;
   private Thread Y;
   private volatile boolean Z;
   private volatile boolean aa;
   private volatile long ab;
   private volatile int ac = -1;
   private int ad = 2;
   private volatile boolean ae;

   static {
      N[1] = -1;
      N[2] = -3;
      N[3] = 35;
      N[4] = -8;
      N[5] = -4;
      N[6] = -2;
      N[8] = -5;
      N[10] = 42;

      for (int var0 = 0; var0 < 10; var0++) {
         N[16 + var0] = (byte)(48 + var0);
      }

      N[27] = -6;
      N[29] = -7;
   }

   public abstract void a(Graphics var1);

   public abstract void a();

   public static int a(String var0, int var1) {
      try {
         return Integer.parseInt(var0);
      } catch (Exception var2) {
         return var1;
      }
   }

   public static void a(int[] var0, int var1) {
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

   public static byte[] a(int var0) {
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

   public static boolean a(int var0, byte[] var1) {
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

   public final synchronized void a(boolean var1) {
      if (var1 || !this.p) {
         if (var1) {
            byte[] var3;
            (var3 = new byte[3])[0] = (byte)(this.e ? 1 : 0);
            var3[1] = (byte)(this.q ? 1 : 0);
            a(-9, var3);
            return;
         }

         this.p = true;
         byte[] var2;
         if ((var2 = a(-9)) == null || var2.length != 3) {
            var2 = new byte[]{-1, -1, -1};
            a(-9, var2);
         }

         this.e = var2[0] != 0;
         this.q = var2[1] != 0;
      }
   }

   public final c[] b(int var1) {
      return this.b(var1, null);
   }

   public final c[] b(int var1, byte[] var2) {
      try {
         DataInputStream var6;
         int var3 = (var6 = this.d(var1)).readChar();
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

         Image var24 = this.d(var3, var2);
         short[] var25 = new short[10];
         c[] var13 = new c[var8];

         for (int var14 = 0; var14 < var8; var14++) {
            var13[var14] = new c(var24);
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

            var13[var14].a(var25);
         }

         return var13;
      } catch (Exception var16) {
         return null;
      }
   }

   public final Image c(int var1, byte[] var2) {
      Image var3 = null;
      this.m(var1);
      var1 &= 1023;
      int var4 = this.l(var1);
      this.a(this.t, var4, var2);
      var3 = Image.createImage(this.t, var4, this.s[var1]);
      this.a(this.t, var4, var2);
      return var3;
   }

   private void a(byte[] var1, int var2, byte[] var3) {
      if (var3 != null) {
         DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(var1, var2, var1.length - var2));

         try {
            this.c(var4);
            int var5 = 0;
            var2 += this.u;

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

   private int c(DataInputStream var1) throws IOException {
      var1.skip(8L);
      this.u = 8;

      while (true) {
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         this.u += 8;
         if (1347179589 == var3) {
            return var2;
         }

         if (1229278788 == var3) {
            return -1;
         }

         var1.skip(var2 + 4);
         this.u += var2 + 4;
      }
   }

   public final byte[] c(int var1) {
      this.m(var1);
      var1 &= 1023;
      byte[] var2 = new byte[this.s[var1]];
      System.arraycopy(this.t, this.l(var1), var2, 0, var2.length);
      return var2;
   }

   public final DataInputStream d(int var1) {
      this.m(var1);
      var1 &= 1023;
      return new DataInputStream(new ByteArrayInputStream(this.t, this.l(var1), this.s[var1]));
   }

   private int l(int var1) {
      int var2 = 0;

      while (--var1 >= 0) {
         var2 += this.s[var1];
      }

      return var2;
   }

   private void m(int var1) {
      if ((var1 = var1 >> 10) != 0 && var1 != this.r) {
         if (var1 > 0) {
            try {
               DataInputStream var2 = new DataInputStream(this.getClass().getResourceAsStream("/RP" + var1));
               this.b(var2);
               var2.close();
            } catch (Exception var3) {
            }
         } else {
            this.a((DataInputStream)null);
         }

         this.r = var1;
      }
   }

   public final boolean a(DataInputStream var1) {
      this.s = null;
      this.f = null;
      this.t = null;
      if (var1 == null) {
         this.r = -1;
         return false;
      }

      this.r = 0;

      try {
         int var4 = var1.read();
         int var2 = 1 + (var4 & 1) << 1;
         char var9 = var1.readChar();
         byte[] var5 = new byte[var2 * var9];
         var1.readFully(var5);
         this.s = new int[var9];
         int var3 = 0;

         for (int var6 = 0; var6 < var9; var6++) {
            for (int var7 = var2 - 1; var7 >= 0; var7--) {
               this.s[var6] = this.s[var6] | (255 & var5[var3++]) << (var7 << 3);
            }
         }

         this.f = new byte[var9];
         var1.readFully(this.f);
         this.t = new byte[var1.readInt()];
         var1.readFully(this.t);
         return true;
      } catch (Exception var8) {
         return false;
      }
   }

   public final String e(int var1) {
      short var2 = this.w[var1];

      try {
         return new String(this.v, var2, this.w[var1 + 1] - var2, "UTF-8");
      } catch (Exception var3) {
         return null;
      }
   }

   public final void f(int var1) {
      if (var1 == -1) {
         this.v = null;
         this.w = null;
      } else {
         try {
            DataInputStream var2 = this.d(var1);
            this.w = new short[var2.readShort() + 1];
            int var3 = this.s[var1 & 1023];
            this.v = new byte[var3 - (this.w.length << 1)];
            short var4 = 0;

            int var5;
            for (var5 = 0; var5 < this.w.length - 1; var5++) {
               this.w[var5] = var4;
               short var7;
               if ((var7 = var2.readShort()) > 0) {
                  var2.readFully(this.v, var4, var7);
               }

               var4 += var7;
            }

            this.w[var5] = var4;
         } catch (Exception var6) {
         }
      }
   }

   public static void a(Graphics var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      b(var0, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public static void b(Graphics var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      var0.drawRGB(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public final void a(c[] var1) {
      this.x = var1;
      if (this.x != null && var1[3].h == 255) {
         var1[3].h = 0;
         short var2 = 0;

         for (int var3 = 0; var3 < var1.length; var3++) {
            c var4 = var1[var3];
            var2 = (short)(var2 + (var4.a << 8) + (var4.b & 255));
            var4.a = var4.e;
            var4.b = var4.f;
            var4.e = var2;
         }
      }
   }

   private void n(int var1) {
      if (this.y == null || this.y.length < var1) {
         this.y = new char[var1];
      }
   }

   public final int a(String var1) {
      return this.a(var1, 0, var1.length());
   }

   public final int a(String var1, int var2, int var3) {
      this.n(var3);

      for (int var4 = 0; var4 < var3; var4++) {
         this.y[var4] = var1.charAt(var2 + var4);
      }

      return this.a(this.y, 0, var3);
   }

   public final int a(char var1) {
      this.n(1);
      this.y[0] = var1;
      return this.a(this.y, 0, 1);
   }

   public final int a(char[] var1, int var2, int var3) {
      if (this.x != null) {
         var3 += var2;
         short var4 = 0;

         while (var2 < var3) {
            c var5 = this.b(var1[var2]);
            var4 += var5 != null ? var5.g : this.x[2].h;
            var2++;
         }

         return var4;
      } else {
         return var3 == 0 ? 0 : this.z.charsWidth(var1, var2, var3);
      }
   }

   private c b(char var1) {
      int var2 = 0;
      int var3 = this.x.length - 1;

      while (var2 <= var3) {
         int var4 = var2 + var3 >> 1;
         char var5;
         if ((var5 = (char)this.x[var4].e) < var1) {
            var2 = var4 + 1;
         } else {
            if (var5 <= var1) {
               return this.x[var4];
            }

            var3 = var4 - 1;
         }
      }

      return null;
   }

   public final int b() {
      return this.x != null ? this.x[1].h : this.z.getBaselinePosition();
   }

   public final int c() {
      return this.x != null ? this.x[0].h : this.z.getHeight();
   }

   public final void a(Graphics var1, String var2, int var3, int var4, int var5) {
      this.a(var1, var2, 0, var2.length(), var3, var4, var5);
   }

   public final void a(Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      this.n(var4);

      for (int var8 = 0; var8 < var4; var8++) {
         this.y[var8] = var2.charAt(var3 + var8);
      }

      this.a(var1, this.y, 0, var4, var5, var6, var7);
   }

   public final void a(Graphics var1, char[] var2, int var3, int var4, int var5, int var6, int var7) {
      if ((var7 & 64) != 0) {
         var6 -= this.b();
      } else if ((var7 & 32) != 0) {
         var6 -= this.c();
      }

      if ((var7 & 9) != 0) {
         var5 -= this.a(var2, var3, var4) >> (var7 & 1);
      }

      if (this.x != null) {
         for (int var9 = var4 + var3; var3 < var9; var3++) {
            c var8;
            if ((var8 = this.b(var2[var3])) != null) {
               var8.a(var1, var5, var6, 0);
               var5 += var8.g;
            } else {
               var5 += this.x[2].h;
            }
         }
      } else {
         if (var4 != 0) {
            if (var1.getFont() != this.z) {
               var1.setFont(this.z);
            }

            var1.drawChars(var2, var3, var4, var5, var6, 20);
         }
      }
   }

   public static void a(Image var0, int var1, int var2, int var3, int var4, Graphics var5, int var6, int var7) {
      var5.drawRegion(var0, var1, var2, var3, var4, 0, var6, var7, 20);
   }

   public static int a(int[] var0, int var1, int var2) {
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

   public final void g(int var1) {
      if (this.A != null) {
         for (int var2 = 0; var2 < this.A.length; var2++) {
            if (var1 == (this.A[var2] & 32767)) {
               return;
            }
         }
      }

      this.A = a(this.A, (short)var1);
      int var3 = this.A.length - 1;

      try {
         this.K = this.d(var1);
         this.K.read();
         int var4 = this.K.readChar();
         this.B = a(this.B, var4);
         int[] var5 = this.B[var3];
         var1 = this.a(var5);

         for (int var14 = 0; var14 < var4; var14++) {
            var5[var14] |= (63 & this.l()) << 10;
         }

         this.C = a(this.C, var1);
         byte[] var6 = this.C[var3];
         this.D = a(this.D, var1);
         var5 = this.D[var3];

         for (int var15 = 0; var15 < var1; var15++) {
            var4 = this.k();
            var6[var15] = (byte)var4;
            var5[var15] = var4 >> 8;
         }

         this.b(var5);
         char var7 = this.K.readChar();
         this.E = a(this.E, var7);
         this.F = a(this.F, var7);
         var1 = this.a(this.F[var3]);
         this.G = a(this.G, var1);
         var5 = this.G[var3];
         byte var8 = 0;

         for (int var16 = 0; var16 < var1; var16++) {
            if (var8 == 0) {
               var4 = this.k();
               var8 = 8;
            }

            var8 -= 2;
            var5[var16] = 3 & var4 >> var8;
         }

         this.b(var5);
         var1 = 0;

         for (int var17 = 0; var17 < var7; var17++) {
            var4 = this.k();
            this.F[var3][var17] = this.F[var3][var17] | var4 << 8;
            this.E[var3][var17] = (char)var1;
            var1 += var4;
         }

         this.H = a(this.H, var1);
         this.I = a(this.I, var1);
         var5 = this.H[var3];
         char[] var9 = this.I[var3];
         int var18 = 0;

         while (var18 < var1) {
            var5[var18++] = this.l() << 21;
         }

         var18 = 0;

         while (var18 < var1) {
            var5[var18++] |= this.l() << 21 >>> 11;
         }

         var18 = 0;

         while (var18 < var1) {
            var5[var18++] |= this.k();
         }

         var18 = 0;

         while (var18 < var1) {
            var9[var18++] = (char)(this.k() << 6);
         }

         var18 = 0;

         while (var18 < var1) {
            var9[var18++] |= (char)this.k();
         }

         char var25 = this.K.readChar();
         this.J = a(this.J, var25);

         for (int var23 = 0; var23 < var25; var23++) {
            this.J[var3][var23] = (char)this.k();
         }
      } catch (Exception var10) {
      }

      this.K = null;
   }

   private int a(int[] var1) throws Exception {
      int var2 = 0;
      int var4 = 0;

      while (var4 < var1.length) {
         int var3 = this.k();
         var1[var4++] = var2 << 16 | var3;
         var2 += var3;
      }

      return var2;
   }

   private void b(int[] var1) throws Exception {
      int var2 = var1.length;
      int var3 = 0;

      while (var3 < var2) {
         var1[var3++] |= this.k() << 22;
      }

      var3 = 0;

      while (var3 < var2) {
         var1[var3++] |= this.l() << 22 >>> 10;
      }

      var3 = 0;

      while (var3 < var2) {
         var1[var3++] |= this.l() << 22 >>> 20;
      }
   }

   private int k() throws Exception {
      int var1;
      return (var1 = this.K.read()) == 255 ? this.K.readChar() : var1;
   }

   private int l() throws Exception {
      byte var1;
      return (var1 = this.K.readByte()) == -128 ? this.K.readShort() : var1;
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

   public final void a(int var1, boolean var2) {
      int var3 = 0;

      while (var1 != (this.A[var3] & 32767)) {
         var3++;
      }

      if (var2) {
         this.A[var3] = (short)(this.A[var3] | 32768);
      } else {
         this.A[var3] = (short)(this.A[var3] & 32767);
      }
   }

   private static void a(Object[] var0, char[] var1, Object[] var2) {
      for (int var3 = 0; var3 < var1.length; var3++) {
         var2[var3] = var0[var1[var3]];
      }
   }

   public final void d() {
      int var2 = 0;
      if (this.A != null) {
         for (int var1 = 0; var1 < this.A.length; var1++) {
            if (this.A[var1] < 0) {
               var2++;
            }
         }
      }

      if (var2 > 0) {
         char[] var3 = new char[var2];
         short[] var4 = this.A;
         this.A = new short[var2];
         int var6 = 0;

         for (int var5 = 0; var5 < var4.length; var5++) {
            if (var4[var5] < 0) {
               var3[var6] = (char)var5;
               this.A[var6++] = var4[var5];
            }
         }

         a(this.B, var3, this.B = new int[var2][]);
         a(this.C, var3, this.C = new byte[var2][]);
         a(this.D, var3, this.D = new int[var2][]);
         a(this.E, var3, this.E = new char[var2][]);
         a(this.F, var3, this.F = new int[var2][]);
         a(this.G, var3, this.G = new int[var2][]);
         a(this.H, var3, this.H = new int[var2][]);
         a(this.I, var3, this.I = new char[var2][]);
         a(this.J, var3, this.J = new char[var2][]);
      } else {
         this.A = null;
         this.B = null;
         this.C = null;
         this.D = null;
         this.E = null;
         this.F = null;
         this.G = null;
         this.H = null;
         this.I = null;
         this.J = null;
         this.L = null;
      }
   }

   public final void h(int var1) {
      this.L = a(this.L, var1 * 8);
   }

   public final void a(int var1, int var2, int var3) {
      int var4 = 0;

      while (var2 != (this.A[var4] & 32767)) {
         var4++;
      }

      var1 *= 8;
      this.L = a(this.L, var1 + 8);
      this.L[var1 + 0] = (short)var4;
      this.L[var1 + 1] = (short)var3;
      this.L[var1 + 2] = 0;
      this.L[var1 + 3] = (short)(this.B[var4][var3] << 16 >> 26);
      this.L[var1 + 4] = 0;
      this.L[var1 + 5] = 0;
      this.L[var1 + 6] = 0;
      this.L[var1 + 7] = 0;
   }

   public final void a(int var1, int var2) {
      var1 *= 8;
      var2 *= 8;
      this.L = a(this.L, var2 + 8);
      System.arraycopy(this.L, var1, this.L, var2, 8);
   }

   public final boolean b(int var1, int var2) {
      var1 *= 8;
      int var3;
      if ((var3 = this.L[var1 + 3]) == 0) {
         this.a = 0;
         this.b = 0;
         return false;
      }

      short var4 = this.L[var1 + 0];
      int var5 = this.L[var1 + 2];
      var2 += this.L[var1 + 4] & '\uffff';
      int var6 = this.L[var1 + 5];
      int var7 = this.L[var1 + 6];
      int var8;
      int var9 = (var8 = this.B[var4][this.L[var1 + 1]]) >>> 16;
      int var10 = var8 & 1023;
      int var11 = var5;
      int var13 = var5 == this.L[var1 + 7] ? 0 : this.C[var4][var9 + var11] >> 6 & 3;

      char var12;
      while (var2 >= (var12 = this.J[var4][this.C[var4][var9 + var5] & 63])) {
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
            var8 = this.D[var4][var9 + (var10 - 1)];
            var6 -= var8 << 10 >> 22;
            var7 -= var8 << 20 >> 22;
         }

         int var14;
         if ((var14 = this.C[var4][var9 + var5] >> 6 & 3) >= var13) {
            var13 = var14;
            var11 = var5;
         }
      }

      int var26 = (var8 = this.D[var4][var9 + var5]) << 10 >> 22;
      int var15 = var8 << 20 >> 22;
      if ((var8 & 3) > 0 && var3 != 0 && (var5 + 1 != var10 || var3 != 1)) {
         int var16;
         int var17;
         if (var5 + 1 == var10) {
            var16 = (var8 = this.D[var4][var9 + var5]) << 10 >> 22;
            var17 = var8 << 20 >> 22;
            var8 = 0;
         } else {
            var16 = 0;
            var17 = 0;
            var8 = var5 + 1;
         }

         var8 = this.D[var4][var9 + var8];
         var16 += var8 << 10 >> 22;
         var17 += var8 << 20 >> 22;
         int var18 = (var2 << 12) / var12;
         var26 += (var16 - var26) * var18 >> 12;
         var15 += (var17 - var15) * var18 >> 12;
      }

      this.a = var26 - var6;
      this.b = var15 - var7;
      this.L[var1 + 2] = (short)var5;
      this.L[var1 + 3] = (short)var3;
      this.L[var1 + 4] = (short)var2;
      this.L[var1 + 5] = (short)var26;
      this.L[var1 + 6] = (short)var15;
      this.L[var1 + 7] = (short)var11;
      return var3 != 0;
   }

   public final void a(c[] var1, int var2, int var3, int var4, int var5, int[] var6) {
      var2 = this.o(var2);
      int var19;
      int var7 = (var19 = this.F[this.M][var2]) >>> 16;
      int[] var8 = this.G[this.M];
      int var9 = var7 + (var19 & 0xFF);
      int var10 = Integer.MAX_VALUE;
      int var11 = Integer.MAX_VALUE;
      int var12 = Integer.MIN_VALUE;
      int var13 = Integer.MIN_VALUE;

      while (var7 < var9) {
         int var14 = (var2 = var8[var7++]) & 3 ^ var5;
         c var15;
         int var16 = (var15 = var1[var2 >>> 22]).a + (var2 << 10 >> 22);
         if ((var14 & 2) != 0) {
            var16 = -(var16 + var15.c);
         }

         int var17 = var15.b + (var2 << 20 >> 22);
         if ((var14 & 1) != 0) {
            var17 = -(var17 + var15.d);
         }

         var10 = Math.min(var10, var16);
         var11 = Math.min(var11, var17);
         var12 = Math.max(var12, var16 + var15.c);
         var13 = Math.max(var13, var17 + var15.d);
      }

      var6[0] = var3 + var10;
      var6[1] = var4 + var11;
      var6[2] = var12 - var10;
      var6[3] = var13 - var11;
   }

   public final int a(short[] var1, int var2, int var3) {
      var2 = this.o(var2);
      int var11;
      int var4 = (var11 = this.F[this.M][var2]) >>> 16;
      int[] var5 = this.G[this.M];
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

   public final void a(Graphics var1, c[] var2, int var3, int var4, int var5, int var6) {
      this.b(var1, var2, this.o(var3), var4, var5, var6);
   }

   public final void b(Graphics var1, c[] var2, int var3, int var4, int var5, int var6) {
      int var13;
      int var7 = (var13 = this.F[this.M][var3]) >>> 16;
      int[] var8 = this.G[this.M];
      int var9 = var7 + (var13 & 0xFF);

      while (var7 < var9) {
         int var10 = (var3 = var8[var7++]) << 10 >> 22;
         int var11 = var3 << 20 >> 22;
         c var12;
         c var10000 = var12 = var2[var3 >>> 22];
         var10000.a = (short)(var10000.a + var10);
         var12.b = (short)(var12.b + var11);
         var12.a(var1, var4, var5, var3 & 3 ^ var6);
         var12.a = (short)(var12.a - var10);
         var12.b = (short)(var12.b - var11);
      }
   }

   public final int b(short[] var1, int var2, int var3) {
      var2 = this.o(var2);
      int var4 = this.E[this.M][var2];
      int var5 = this.F[this.M][var2] >> 8 & 0xFF;
      int var6 = var4 + var5;
      int var7 = 0;

      while (var4 < var6 && var7 + 4 < var1.length) {
         int var8 = (var2 = this.H[this.M][var4]) >> 21;
         int var9 = var2 << 11 >> 21;
         int var10 = var2 & 1023;
         char var15;
         int var11 = (var15 = this.I[this.M][var4++]) >> 6;
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

   private int o(int var1) {
      var1 *= 8;
      this.M = this.L[var1 + 0];
      int var2 = this.L[var1 + 1];
      var2 = (this.B[this.M][var2] >>> 16) + this.L[var1 + 7];
      return this.D[this.M][var2] >>> 22;
   }

   public final synchronized void e() {
      this.O = 0;
      this.P = 0;
      this.Q = this.Q | this.g;
      this.h = 0;
      this.g = 0;
   }

   public final synchronized void f() {
      this.h = this.O;
      this.O = 0;
      this.Q = this.Q & this.P;
      this.P = this.P & ~this.Q;
      this.g = this.h | this.P;
      this.Q = 0;
      this.Q = this.Q | this.P & 939524096;
      this.Q = this.Q | this.P & 16;
   }

   private void b(int var1, boolean var2) {
      if (var1 != 0) {
         synchronized (this) {
            for (int var4 = 1; var4 < N.length; var4++) {
               if (N[var4] == var1) {
                  int var5 = 1 << var4;
                  if (var2) {
                     this.O |= var5;
                     this.P |= var5;
                     this.Q &= ~var5;
                  } else {
                     this.Q |= var5;
                  }
               }
            }
         }
      }
   }

   public void keyPressed(int var1) {
      if (this.j && this.R) {
         this.j = false;
         this.e = this.i;
         this.ae = true;
      }

      this.b(var1, true);
      super.keyPressed(var1);
   }

   public void keyReleased(int var1) {
      this.b(var1, false);
      super.keyReleased(var1);
   }

   public void keyRepeated(int var1) {
      super.keyRepeated(var1);
   }

   public final void g() {
      this.k = this.l;
      this.S = true;
   }

   private void c(Graphics var1) {
      if (var1 == null) {
         this.X = true;
      } else {
         if (240 != this.T || 320 != this.U) {
            if (this.n) {
               int var3 = 320 - this.U + 1 >>> 1;
               var1.setColor(-16777216);
               if (var3 > 0) {
                  if (this.W > 0) {
                     var1.fillRect(0, 0, 240, this.W);
                  }

                  var1.fillRect(0, 320 - var3, 240, var3);
               }

               if ((var3 = 240 - this.T + 1 >>> 1) > 0) {
                  if (this.V > 0) {
                     var1.fillRect(0, this.W, this.V, this.U);
                  }

                  var1.fillRect(240 - var3, this.W, var3, this.U);
               }
            }

            var1.translate(this.V, this.W);
         }

         this.b(var1);
         this.a(var1);
      }
   }

   public final void c(int var1, int var2) {
      this.X = true;
      if (var1 <= 0) {
         var1 = 240;
      }

      if (var2 <= 0) {
         var2 = 320;
      }

      this.T = var1;
      this.U = var2;
      this.V = 240 - var1;
      this.W = 320 - var2;
      if (this.V < 0) {
         this.V++;
      }

      if (this.W < 0) {
         this.W++;
      }

      this.V >>= 1;
      this.W >>= 1;
   }

   public final void b(Graphics var1) {
      var1.setClip(0, 0, this.T, this.U);
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5) {
      if ((this.V | this.W) != 0) {
         if (var2 < 0) {
            var4 += var2;
            var2 = 0;
         }

         int var6;
         if ((var6 = var2 + var4 - this.T) > 0) {
            var4 -= var6;
         }

         if (var3 < 0) {
            var5 += var3;
            var3 = 0;
         }

         int var7;
         if ((var7 = var3 + var5 - this.U) > 0) {
            var5 -= var7;
         }
      }

      var1.setClip(var2, var3, var4, var5);
   }

   public final void h() {
      this.X = true;
   }

   public void i(int var1) {
      if (var1 == 3) {
         if (this.d != null) {
            this.d.a();
         }

         this.aa = true;
         this.c.notifyDestroyed();
      } else if (var1 == 2) {
         try {
            Thread.sleep(100L);
         } catch (Exception var2) {
         }
      }

      if (var1 == 0 || var1 == 1 || var1 == 2) {
         this.X = true;
         this.S = true;
         this.e();
      }
   }

   public final void hideNotify() {
      this.j(1);
   }

   public final void showNotify() {
      this.j(2);
      if (this.Y == null) {
         this.Y = new Thread(this);
         this.Y.start();
      }
   }

   public final synchronized void j(int var1) {
      if (var1 == 3) {
         this.i(var1);
      } else if (this.Z && (var1 == 1 || var1 == 2)) {
         if (var1 == 1) {
            this.R = false;
            if (!this.j) {
               this.j = true;
               this.i = this.e;
               this.e = false;
            }
         }

         synchronized (this.Y) {
            this.ac = var1;
            this.ab = System.currentTimeMillis();
         }
      }
   }

   private void m() {
      while (this.ac != -1) {
         if (this.ad != 1) {
            if (this.d != null) {
               this.d.c();
            }

            this.i(1);
            this.ad = 1;
         }

         synchronized (this.Y) {
            if (this.ac == 1) {
               this.ac = -1;
            }
         }

         while (this.ac == 2 && this.isShown()) {
            if ((int)(System.currentTimeMillis() - this.ab) < 750) {
               try {
                  Thread.sleep(250L);
                  Thread.yield();
               } catch (Exception var3) {
               }
            } else {
               synchronized (this.Y) {
                  if (this.ac != 2) {
                     continue;
                  }

                  this.ac = -1;
               }

               if (this.d != null) {
                  this.d.c();
               }

               this.i(2);
               this.ad = 2;
               this.R = true;
            }
         }
      }

      if (this.ae) {
         this.ae = false;
         this.i(5);
      }
   }

   public final void i() {
      this.d();
   }

   public final void j() {
      this.g();
   }

   public final Image d(int var1, byte[] var2) {
      return this.c(var1, var2);
   }

   public final byte[] k(int var1) {
      return this.c(var1);
   }

   public final boolean b(DataInputStream var1) {
      return this.a(var1);
   }

   public final void run() {
      this.Z = true;
      this.i(0);

      for (; !this.aa; Thread.yield()) {
         this.m();
         if (this.isShown()) {
            long var1 = System.currentTimeMillis();
            if (this.S) {
               this.S = false;
               this.k = this.l;
            } else {
               int var3;
               if ((var3 = (int)(var1 - this.o)) > 4000) {
                  this.j(2);
               }

               if (var3 > this.m || var3 < 0) {
                  var3 = this.m;
               }

               this.k = var3;
               if (this.k < this.l) {
                  int var4;
                  if ((var4 = this.l - this.k) < 10) {
                     var4 = 10;
                  }

                  this.k = this.l;

                  try {
                     Thread.sleep(var4);
                  } catch (Exception var6) {
                  }
               }
            }

            this.o = var1;
            this.a();
            if (this.d != null) {
               this.d.run();
            }

            if (this.aa) {
               return;
            }

            if (this.isShown()) {
               this.n = this.X;
               this.X = false;
               this.c(this.getGraphics());
               this.flushGraphics();
            }
         } else {
            try {
               Thread.sleep(100L);
            } catch (Exception var5) {
            }

            this.S = true;
         }
      }
   }

   public a(MIDlet var1) {
      super(false);
      this.setFullScreenMode(true);
      this.c = var1;
      this.c(240, 320);
   }
}
