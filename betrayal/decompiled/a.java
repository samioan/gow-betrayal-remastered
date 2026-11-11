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
   private long m;
   public MIDlet c;
   public d d;
   private boolean n;
   public boolean e;
   private boolean o;
   private int p = -1;
   private int[] q;
   private byte[] r;
   public byte[] f;
   private int s;
   private byte[] t;
   private short[] u;
   private c[] v;
   private char[] w;
   private Font x = Font.getFont(0, 0, 0);
   private short[] y;
   private int[][] z;
   private byte[][] A;
   private int[][] B;
   private char[][] C;
   private int[][] D;
   private int[][] E;
   private int[][] F;
   private char[][] G;
   private char[][] H;
   private DataInputStream I;
   private short[] J;
   private int K;
   private static final byte[] L = new byte[32];
   public volatile int g;
   public volatile int h;
   private volatile int M;
   private volatile int N;
   private volatile int O;
   public int i = 10;
   public int j = 10;
   public int k = 100;
   private boolean P;
   private int Q;
   private int R;
   private int S;
   private int T;
   public volatile boolean l;
   private volatile boolean U;
   private Thread V;
   private volatile boolean W;
   private volatile boolean X;
   private volatile long Y;
   private volatile int Z = -1;
   private int aa = 2;

   static {
      L[1] = -1;
      L[2] = -3;
      L[3] = 35;
      L[4] = -8;
      L[5] = -4;
      L[6] = -2;
      L[8] = -5;
      L[10] = 42;
      L[15] = -11;

      for (int var0 = 0; var0 < 10; var0++) {
         L[16 + var0] = (byte)(48 + var0);
      }

      L[27] = -6;
      L[29] = -7;
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
            int var12 = (var1.length + 786432 - 1) / 786432;
            int var7 = 0;

            for (int var8 = 1; var8 <= var12; var8++) {
               int var9;
               if ((var9 = var1.length - var7) > 786432) {
                  var9 = 786432;
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
      if (var1 || !this.n) {
         if (var1) {
            byte[] var3;
            (var3 = new byte[3])[0] = (byte)(this.e ? 1 : 0);
            var3[1] = (byte)(this.o ? 1 : 0);
            a(-9, var3);
            return;
         }

         this.n = true;
         byte[] var2;
         if ((var2 = a(-9)) == null || var2.length != 3) {
            var2 = new byte[]{-1, -1, -1};
            a(-9, var2);
         }

         this.e = var2[0] != 0;
         this.o = var2[1] != 0;
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
      this.a(this.r, var4, var2);
      var3 = Image.createImage(this.r, var4, this.q[var1]);
      this.a(this.r, var4, var2);
      return var3;
   }

   private void a(byte[] var1, int var2, byte[] var3) {
      if (var3 != null) {
         DataInputStream var4 = new DataInputStream(new ByteArrayInputStream(var1, var2, var1.length - var2));

         try {
            this.c(var4);
            int var5 = 0;
            var2 += this.s;

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
      this.s = 8;

      while (true) {
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         this.s += 8;
         if (1347179589 == var3) {
            return var2;
         }

         if (1229278788 == var3) {
            return -1;
         }

         var1.skip(var2 + 4);
         this.s += var2 + 4;
      }
   }

   public final byte[] c(int var1) {
      this.m(var1);
      var1 &= 1023;
      byte[] var2 = new byte[this.q[var1]];
      System.arraycopy(this.r, this.l(var1), var2, 0, var2.length);
      return var2;
   }

   public final DataInputStream d(int var1) {
      this.m(var1);
      var1 &= 1023;
      return new DataInputStream(new ByteArrayInputStream(this.r, this.l(var1), this.q[var1]));
   }

   private int l(int var1) {
      int var2 = 0;

      while (--var1 >= 0) {
         var2 += this.q[var1];
      }

      return var2;
   }

   private void m(int var1) {
      if ((var1 = var1 >> 10) != 0 && var1 != this.p) {
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

         this.p = var1;
      }
   }

   public final boolean a(DataInputStream var1) {
      this.q = null;
      this.f = null;
      this.r = null;
      if (var1 == null) {
         this.p = -1;
         return false;
      }

      this.p = 0;

      try {
         int var4 = var1.read();
         int var2 = 1 + (var4 & 1) << 1;
         char var9 = var1.readChar();
         byte[] var5 = new byte[var2 * var9];
         var1.readFully(var5);
         this.q = new int[var9];
         int var3 = 0;

         for (int var6 = 0; var6 < var9; var6++) {
            for (int var7 = var2 - 1; var7 >= 0; var7--) {
               this.q[var6] = this.q[var6] | (255 & var5[var3++]) << (var7 << 3);
            }
         }

         this.f = new byte[var9];
         var1.readFully(this.f);
         this.r = new byte[var1.readInt()];
         var1.readFully(this.r);
         return true;
      } catch (Exception var8) {
         return false;
      }
   }

   private static String a(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var7 = 0;
      int var8 = 0;

      int var4;
      while (var7 < var2 && (var4 = var0[var1 + var7] & 255) <= 127) {
         var7++;
         var3[var8++] = (char)var4;
      }

      while (var7 < var2) {
         switch ((var4 = var0[var1 + var7] & 255) >> 4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
               var7++;
               var3[var8++] = (char)var4;
            case 8:
            case 9:
            case 10:
            case 11:
            default:
               break;
            case 12:
            case 13:
               var7 += 2;
               byte var10 = var0[var1 + var7 - 1];
               var3[var8++] = (char)((var4 & 31) << 6 | var10 & 63);
               break;
            case 14:
               var7 += 3;
               byte var5 = var0[var1 + var7 - 2];
               byte var6 = var0[var1 + var7 - 1];
               var3[var8++] = (char)((var4 & 15) << 12 | (var5 & 63) << 6 | (var6 & 63) << 0);
         }
      }

      return new String(var3, 0, var8);
   }

   public final String e(int var1) {
      short var2 = this.u[var1];

      try {
         return a(this.t, var2, this.u[var1 + 1] - var2);
      } catch (Exception var3) {
         return null;
      }
   }

   public final void f(int var1) {
      if (var1 == -1) {
         this.t = null;
         this.u = null;
      } else {
         try {
            DataInputStream var2 = this.d(var1);
            this.u = new short[var2.readShort() + 1];
            int var3 = this.q[var1 & 1023];
            this.t = new byte[var3 - (this.u.length << 1)];
            short var4 = 0;

            int var5;
            for (var5 = 0; var5 < this.u.length - 1; var5++) {
               this.u[var5] = var4;
               short var7;
               if ((var7 = var2.readShort()) > 0) {
                  var2.readFully(this.t, var4, var7);
               }

               var4 += var7;
            }

            this.u[var5] = var4;
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
      this.v = var1;
      if (this.v != null && var1[3].h == 255) {
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
      if (this.w == null || this.w.length < var1) {
         this.w = new char[var1];
      }
   }

   public final int a(String var1) {
      return this.a(var1, 0, var1.length());
   }

   public final int a(String var1, int var2, int var3) {
      this.n(var3);

      for (int var4 = 0; var4 < var3; var4++) {
         this.w[var4] = var1.charAt(var2 + var4);
      }

      return this.a(this.w, 0, var3);
   }

   public final int a(char var1) {
      this.n(1);
      this.w[0] = var1;
      return this.a(this.w, 0, 1);
   }

   public final int a(char[] var1, int var2, int var3) {
      if (this.v != null) {
         var3 += var2;
         short var4 = 0;

         while (var2 < var3) {
            c var5 = this.b(var1[var2]);
            var4 += var5 != null ? var5.g : this.v[2].h;
            var2++;
         }

         return var4;
      } else {
         return var3 == 0 ? 0 : this.x.charsWidth(var1, var2, var3);
      }
   }

   private c b(char var1) {
      int var2 = 0;
      int var3 = this.v.length - 1;

      while (var2 <= var3) {
         int var4 = var2 + var3 >> 1;
         char var5;
         if ((var5 = (char)this.v[var4].e) < var1) {
            var2 = var4 + 1;
         } else {
            if (var5 <= var1) {
               return this.v[var4];
            }

            var3 = var4 - 1;
         }
      }

      return null;
   }

   public final int b() {
      return this.v != null ? this.v[1].h : this.x.getBaselinePosition();
   }

   public final int c() {
      return this.v != null ? this.v[0].h : this.x.getHeight();
   }

   public final void a(Graphics var1, String var2, int var3, int var4, int var5) {
      this.a(var1, var2, 0, var2.length(), var3, var4, var5);
   }

   public final void a(Graphics var1, String var2, int var3, int var4, int var5, int var6, int var7) {
      this.n(var4);

      for (int var8 = 0; var8 < var4; var8++) {
         this.w[var8] = var2.charAt(var3 + var8);
      }

      this.a(var1, this.w, 0, var4, var5, var6, var7);
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

      if (this.v != null) {
         for (int var9 = var4 + var3; var3 < var9; var3++) {
            c var8;
            if ((var8 = this.b(var2[var3])) != null) {
               var8.a(var1, var5, var6, 0);
               var5 += var8.g;
            } else {
               var5 += this.v[2].h;
            }
         }
      } else {
         if (var4 != 0) {
            if (var1.getFont() != this.x) {
               var1.setFont(this.x);
            }

            var1.drawChars(var2, var3, var4, var5, var6, 20);
         }
      }
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
      if (this.y != null) {
         for (int var2 = 0; var2 < this.y.length; var2++) {
            if (var1 == (this.y[var2] & 32767)) {
               return;
            }
         }
      }

      this.y = a(this.y, (short)var1);
      int var3 = this.y.length - 1;

      try {
         this.I = this.d(var1);
         this.I.read();
         int var4 = this.I.readChar();
         this.z = a(this.z, var4);
         int[] var5 = this.z[var3];
         var1 = this.a(var5);

         for (int var14 = 0; var14 < var4; var14++) {
            var5[var14] |= (63 & this.l()) << 10;
         }

         this.A = a(this.A, var1);
         byte[] var6 = this.A[var3];
         this.B = a(this.B, var1);
         var5 = this.B[var3];

         for (int var15 = 0; var15 < var1; var15++) {
            var4 = this.k();
            var6[var15] = (byte)var4;
            var5[var15] = var4 >> 8;
         }

         this.b(var5);
         char var7 = this.I.readChar();
         this.C = a(this.C, var7);
         this.D = a(this.D, var7);
         var1 = this.a(this.D[var3]);
         this.E = a(this.E, var1);
         var5 = this.E[var3];
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
            this.D[var3][var17] = this.D[var3][var17] | var4 << 8;
            this.C[var3][var17] = (char)var1;
            var1 += var4;
         }

         this.F = a(this.F, var1);
         this.G = a(this.G, var1);
         var5 = this.F[var3];
         char[] var9 = this.G[var3];
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

         char var25 = this.I.readChar();
         this.H = a(this.H, var25);

         for (int var23 = 0; var23 < var25; var23++) {
            this.H[var3][var23] = (char)this.k();
         }
      } catch (Exception var10) {
      }

      this.I = null;
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
      return (var1 = this.I.read()) == 255 ? this.I.readChar() : var1;
   }

   private int l() throws Exception {
      byte var1;
      return (var1 = this.I.readByte()) == -128 ? this.I.readShort() : var1;
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

      while (var1 != (this.y[var3] & 32767)) {
         var3++;
      }

      if (var2) {
         this.y[var3] = (short)(this.y[var3] | 32768);
      } else {
         this.y[var3] = (short)(this.y[var3] & 32767);
      }
   }

   private static void a(Object[] var0, char[] var1, Object[] var2) {
      for (int var3 = 0; var3 < var1.length; var3++) {
         var2[var3] = var0[var1[var3]];
      }
   }

   public final void d() {
      int var2 = 0;
      if (this.y != null) {
         for (int var1 = 0; var1 < this.y.length; var1++) {
            if (this.y[var1] < 0) {
               var2++;
            }
         }
      }

      if (var2 > 0) {
         char[] var3 = new char[var2];
         short[] var4 = this.y;
         this.y = new short[var2];
         int var6 = 0;

         for (int var5 = 0; var5 < var4.length; var5++) {
            if (var4[var5] < 0) {
               var3[var6] = (char)var5;
               this.y[var6++] = var4[var5];
            }
         }

         a(this.z, var3, this.z = new int[var2][]);
         a(this.A, var3, this.A = new byte[var2][]);
         a(this.B, var3, this.B = new int[var2][]);
         a(this.C, var3, this.C = new char[var2][]);
         a(this.D, var3, this.D = new int[var2][]);
         a(this.E, var3, this.E = new int[var2][]);
         a(this.F, var3, this.F = new int[var2][]);
         a(this.G, var3, this.G = new char[var2][]);
         a(this.H, var3, this.H = new char[var2][]);
      } else {
         this.y = null;
         this.z = null;
         this.A = null;
         this.B = null;
         this.C = null;
         this.D = null;
         this.E = null;
         this.F = null;
         this.G = null;
         this.H = null;
         this.J = null;
      }
   }

   public final void h(int var1) {
      this.J = a(this.J, var1 * 8);
   }

   public final void a(int var1, int var2, int var3) {
      int var4 = 0;

      while (var2 != (this.y[var4] & 32767)) {
         var4++;
      }

      var1 *= 8;
      this.J = a(this.J, var1 + 8);
      this.J[var1 + 0] = (short)var4;
      this.J[var1 + 1] = (short)var3;
      this.J[var1 + 2] = 0;
      this.J[var1 + 3] = (short)(this.z[var4][var3] << 16 >> 26);
      this.J[var1 + 4] = 0;
      this.J[var1 + 5] = 0;
      this.J[var1 + 6] = 0;
      this.J[var1 + 7] = 0;
   }

   public final void a(int var1, int var2) {
      var1 *= 8;
      var2 *= 8;
      this.J = a(this.J, var2 + 8);
      System.arraycopy(this.J, var1, this.J, var2, 8);
   }

   public final boolean b(int var1, int var2) {
      var1 *= 8;
      int var3;
      if ((var3 = this.J[var1 + 3]) == 0) {
         this.a = 0;
         this.b = 0;
         return false;
      }

      short var4 = this.J[var1 + 0];
      int var5 = this.J[var1 + 2];
      var2 += this.J[var1 + 4] & '\uffff';
      int var6 = this.J[var1 + 5];
      int var7 = this.J[var1 + 6];
      int var8;
      int var9 = (var8 = this.z[var4][this.J[var1 + 1]]) >>> 16;
      int var10 = var8 & 1023;
      int var11 = var5;
      int var13 = var5 == this.J[var1 + 7] ? 0 : this.A[var4][var9 + var11] >> 6 & 3;

      char var12;
      while (var2 >= (var12 = this.H[var4][this.A[var4][var9 + var5] & 63])) {
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
            var8 = this.B[var4][var9 + (var10 - 1)];
            var6 -= var8 << 10 >> 22;
            var7 -= var8 << 20 >> 22;
         }

         int var14;
         if ((var14 = this.A[var4][var9 + var5] >> 6 & 3) >= var13) {
            var13 = var14;
            var11 = var5;
         }
      }

      int var26 = (var8 = this.B[var4][var9 + var5]) << 10 >> 22;
      int var15 = var8 << 20 >> 22;
      if ((var8 & 3) > 0 && var3 != 0 && (var5 + 1 != var10 || var3 != 1)) {
         int var16;
         int var17;
         if (var5 + 1 == var10) {
            var16 = (var8 = this.B[var4][var9 + var5]) << 10 >> 22;
            var17 = var8 << 20 >> 22;
            var8 = 0;
         } else {
            var16 = 0;
            var17 = 0;
            var8 = var5 + 1;
         }

         var8 = this.B[var4][var9 + var8];
         var16 += var8 << 10 >> 22;
         var17 += var8 << 20 >> 22;
         int var18 = (var2 << 12) / var12;
         var26 += (var16 - var26) * var18 >> 12;
         var15 += (var17 - var15) * var18 >> 12;
      }

      this.a = var26 - var6;
      this.b = var15 - var7;
      this.J[var1 + 2] = (short)var5;
      this.J[var1 + 3] = (short)var3;
      this.J[var1 + 4] = (short)var2;
      this.J[var1 + 5] = (short)var26;
      this.J[var1 + 6] = (short)var15;
      this.J[var1 + 7] = (short)var11;
      return var3 != 0;
   }

   public final void a(c[] var1, int var2, int var3, int var4, int var5, int[] var6) {
      var2 = this.o(var2);
      int var19;
      int var7 = (var19 = this.D[this.K][var2]) >>> 16;
      int[] var8 = this.E[this.K];
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
      int var4 = (var11 = this.D[this.K][var2]) >>> 16;
      int[] var5 = this.E[this.K];
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
      int var7 = (var13 = this.D[this.K][var3]) >>> 16;
      int[] var8 = this.E[this.K];
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
      int var4 = this.C[this.K][var2];
      int var5 = this.D[this.K][var2] >> 8 & 0xFF;
      int var6 = var4 + var5;
      int var7 = 0;

      while (var4 < var6 && var7 + 4 < var1.length) {
         int var8 = (var2 = this.F[this.K][var4]) >> 21;
         int var9 = var2 << 11 >> 21;
         int var10 = var2 & 1023;
         char var15;
         int var11 = (var15 = this.G[this.K][var4++]) >> 6;
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
      this.K = this.J[var1 + 0];
      int var2 = this.J[var1 + 1];
      var2 = (this.z[this.K][var2] >>> 16) + this.J[var1 + 7];
      return this.B[this.K][var2] >>> 22;
   }

   public final synchronized void e() {
      this.M = 0;
      this.N = 0;
      this.O = this.O | this.g;
      this.h = 0;
      this.g = 0;
   }

   public final synchronized void f() {
      this.h = this.M;
      this.M = 0;
      this.O = this.O & this.N;
      this.N = this.N & ~this.O;
      this.g = this.h | this.N;
      this.O = 0;
   }

   private void b(int var1, boolean var2) {
      if (var1 != 0) {
         synchronized (this) {
            for (int var4 = 1; var4 < L.length; var4++) {
               if (L[var4] == var1) {
                  int var5 = 1 << var4;
                  if (var2) {
                     this.M |= var5;
                     this.N |= var5;
                     this.O &= ~var5;
                  } else {
                     this.O |= var5;
                  }
               }
            }
         }
      }
   }

   public void keyPressed(int var1) {
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
      this.i = this.j;
      this.P = true;
   }

   private void c(Graphics var1) {
      if (var1 == null) {
         this.U = true;
      } else {
         if (240 != this.Q || 320 != this.R) {
            if (this.l) {
               int var3 = 320 - this.R + 1 >>> 1;
               var1.setColor(-16777216);
               if (var3 > 0) {
                  if (this.T > 0) {
                     var1.fillRect(0, 0, 240, this.T);
                  }

                  var1.fillRect(0, 320 - var3, 240, var3);
               }

               if ((var3 = 240 - this.Q + 1 >>> 1) > 0) {
                  if (this.S > 0) {
                     var1.fillRect(0, this.T, this.S, this.R);
                  }

                  var1.fillRect(240 - var3, this.T, var3, this.R);
               }
            }

            var1.translate(this.S, this.T);
         }

         this.b(var1);
         this.a(var1);
      }
   }

   public final void c(int var1, int var2) {
      this.U = true;
      if (var1 <= 0) {
         var1 = 240;
      }

      if (var2 <= 0) {
         var2 = 320;
      }

      this.Q = var1;
      this.R = var2;
      this.S = 240 - var1;
      this.T = 320 - var2;
      if (this.S < 0) {
         this.S++;
      }

      if (this.T < 0) {
         this.T++;
      }

      this.S >>= 1;
      this.T >>= 1;
   }

   public final void b(Graphics var1) {
      var1.setClip(0, 0, this.Q, this.R);
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5) {
      if ((this.S | this.T) != 0) {
         if (var2 < 0) {
            var4 += var2;
            var2 = 0;
         }

         int var6;
         if ((var6 = var2 + var4 - this.Q) > 0) {
            var4 -= var6;
         }

         if (var3 < 0) {
            var5 += var3;
            var3 = 0;
         }

         int var7;
         if ((var7 = var3 + var5 - this.R) > 0) {
            var5 -= var7;
         }
      }

      var1.setClip(var2, var3, var4, var5);
   }

   public final void h() {
      this.U = true;
   }

   public void i(int var1) {
      if (var1 == 3) {
         if (this.d != null) {
            this.d.a();
         }

         this.X = true;
         this.c.notifyDestroyed();
      }

      if (var1 == 0 || var1 == 1 || var1 == 2) {
         this.U = true;
         this.P = true;
         this.e();
      }
   }

   public final void hideNotify() {
      this.j(1);
   }

   public final void showNotify() {
      this.j(2);
      if (this.V == null) {
         this.V = new Thread(this);
         this.V.start();
      }
   }

   public final synchronized void j(int var1) {
      if (var1 == 3) {
         this.i(var1);
      } else if (this.W && (var1 == 1 || var1 == 2)) {
         if (var1 == 1) {
            if (this.d != null) {
               this.d.c();
            }
         } else if (this.d != null) {
            this.d.c();
         }

         synchronized (this.V) {
            this.Z = var1;
            this.Y = System.currentTimeMillis();
         }
      }
   }

   private void m() {
      while (this.Z != -1) {
         if (this.aa != 1) {
            this.i(1);
            this.aa = 1;
         }

         synchronized (this.V) {
            if (this.Z == 1) {
               this.Z = -1;
            }
         }

         while (this.Z == 2 && this.isShown()) {
            if ((int)(System.currentTimeMillis() - this.Y) < 750) {
               try {
                  Thread.sleep(250L);
                  Thread.yield();
               } catch (Exception var3) {
               }
            } else {
               synchronized (this.V) {
                  if (this.Z != 2) {
                     continue;
                  }

                  this.Z = -1;
               }

               this.i(2);
               this.aa = 2;
               this.i(5);
            }
         }
      }
   }

   public final boolean b(String var1) {
      if (this.d != null) {
         this.d.c();
      }

      try {
         if (this.c.platformRequest(var1)) {
            this.j(3);
         }

         return true;
      } catch (Throwable var2) {
         return false;
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
      this.W = true;
      this.i(0);

      for (; !this.X; Thread.yield()) {
         this.m();
         if (this.isShown()) {
            long var1 = System.currentTimeMillis();
            if (this.P) {
               this.P = false;
               this.i = this.j;
            } else {
               int var3;
               if ((var3 = (int)(var1 - this.m)) > this.k || var3 < 0) {
                  var3 = this.k;
               }

               this.i = var3;
               if (this.i < this.j) {
                  int var4;
                  if ((var4 = this.j - this.i) < 10) {
                     var4 = 10;
                  }

                  this.i = this.j;

                  try {
                     Thread.sleep(var4);
                  } catch (Exception var6) {
                  }
               }
            }

            this.m = var1;
            this.a();
            if (this.d != null) {
               this.d.run();
            }

            if (this.X) {
               return;
            }

            if (this.isShown()) {
               this.l = this.U;
               this.U = false;
               this.c(this.getGraphics());
               this.flushGraphics();
            }
         } else {
            try {
               Thread.sleep(100L);
            } catch (Exception var5) {
            }

            this.P = true;
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
