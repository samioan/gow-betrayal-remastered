import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class b {
   private final boolean a;
   private final int b;
   private final int c;
   private int d;
   private int e;
   private Image f;
   private int g;
   private short[] h;
   private final boolean i;
   private Image j;
   private char[] k;
   private char[] l;
   private int m;
   private int n;
   private int o;
   private c[] p;
   private int[] q;
   private int[] r;
   private int s;
   private boolean t;
   private boolean u;
   private int[] v;
   private c[] w;
   private int[] x;
   private short[] y;
   private short[] z;
   private int A;
   private int B;
   private int C;
   private boolean D;

   public static b a(int var0, int var1) {
      return new b(false, false, var0, var1);
   }

   private b(boolean var1, boolean var2, int var3, int var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      if (var1 && this.f == null) {
         this.f = Image.createImage(var3, var4);
         this.f.getGraphics();
      }

      this.i = var2;
      this.a(0);
   }

   public final void b(int var1, int var2) {
      this.d = var1;
      this.e = var2;
   }

   public final void a(Graphics var1) {
      if (!this.a) {
         this.b(var1);
      }
   }

   private void b(Graphics var1) {
      int var3 = this.d;
      int var4 = this.e;
      int var5 = 0;
      int var6 = 0;
      int var7 = this.b;
      int var8 = this.c;
      int var2;
      if ((var2 = var1.getClipX()) > 0) {
         var3 += var2;
         var7 -= var2;
         var5 = var2;
      }

      if ((var2 = var5 + var7 - (var2 + var1.getClipWidth())) > 0) {
         var7 -= var2;
      }

      if ((var2 = var1.getClipY()) > 0) {
         var4 += var2;
         var8 -= var2;
         var6 = var2;
      }

      if ((var2 = var6 + var8 - (var2 + var1.getClipHeight())) > 0) {
         var8 -= var2;
      }

      if (var7 > 0 && var8 > 0) {
         this.a(var1, var3, var4, var5, var6, var7, var8);
      }
   }

   private void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (!this.D) {
         if (this.h != null) {
            this.b(var1, var2, var3, var4, var5, var6, var7);
         }

         if (this.o > 0) {
            this.a(var2, var3, var4, var5, var6, var7, var1);
         }
      }

      if (this.A >= 0) {
         this.a(var2, var3, var4, var5, var6, var7, this.D, var1);
      }
   }

   private void b(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8;
      int var9 = (var8 = (var2 + var6 - 1) / this.m) - var2 / this.m;
      int var10 = (var3 + var7 - 1) / this.n;
      var8 += var10 * this.g;
      var10 -= var3 / this.n;
      var2 %= this.m;
      var3 %= this.n;
      int var11 = var2;
      int var12 = var3;
      int var13;
      if ((var13 = -(var2 + var6) % this.m) < 0) {
         var13 += this.m;
      }

      int var14;
      if ((var14 = -(var3 + var7) % this.n) < 0) {
         var14 += this.n;
      }

      var2 = var4 - var2 + this.m * var9;
      var3 = var5 - var3 + this.n * var10;

      for (int var25 = var10; var25 >= 0; var25--) {
         for (int var24 = var9; var24 >= 0; var24--) {
            int var15;
            if ((var15 = this.h[var8--] & 4095) > 0) {
               var15--;
               var4 = 0;
               var5 = 0;
               int var16 = 0;
               int var17 = 0;
               if (var24 == 0) {
                  var4 = var11;
               }

               if (var24 == var9) {
                  var16 = var13;
               }

               if (var25 == 0) {
                  var5 = var12;
               }

               if (var25 == var10) {
                  var17 = var14;
               }

               if (!this.i) {
                  var1.drawRegion(
                     this.j, this.k[var15] + var4, this.l[var15] + var5, this.m - var4 - var16, this.n - var5 - var17, 0, var2 + var4, var3 + var5, 20
                  );
               }
            }

            var2 -= this.m;
         }

         var8 += 1 + var9 - this.g;
         var2 += this.m * (var9 + 1);
         var3 -= this.n;
      }
   }

   public final void a(int var1, int var2, Image var3, int var4, int var5) {
      this.a();
      this.g = var1;
      this.h = new short[var1 * var2];
      this.m = var4;
      this.n = var5;
      var4 = var3.getWidth();
      var5 = var3.getHeight();
      int var6 = var4 / this.m * (var5 / this.n);
      var4 -= this.m;
      var5 -= this.n;
      if (!this.i) {
         this.j = var3;
         this.k = new char[var6];
         this.l = new char[var6];
         int var7 = 0;

         for (int var8 = 0; var8 <= var5; var8 += this.n) {
            for (int var9 = 0; var9 <= var4; var9 += this.m) {
               this.k[var7] = (char)var9;
               this.l[var7] = (char)var8;
               var7++;
            }
         }
      }
   }

   private void a() {
      this.h = null;
      if (!this.i) {
         this.j = null;
         this.k = null;
         this.l = null;
      }
   }

   public final void a(int var1, int var2, int var3) {
      this.h[var2 * this.g + var1] = (short)var3;
   }

   public final void a(int var1, boolean var2) {
      this.o = 0;
      this.p = null;
      this.q = null;
      this.r = null;
      this.s = 0;
      this.t = true;
      this.v = null;
      if (var1 > 0) {
         this.u = var2;
         this.p = new c[var1];
         this.q = new int[var1];
         this.r = new int[var1];
         this.v = new int[var1];
      }
   }

   public final void a(c var1, int var2, int var3, int var4) {
      this.p[this.o] = var1;
      var2 += var1.a(var4);
      var3 += var1.b(var4);
      this.q[this.o] = var2 << 17 | var3 << 17 >>> 15 | var4;
      this.r[this.o] = (this.u ? var3 : var2) << 16 | this.o;
      this.s = Math.max(this.s, this.u ? var1.d : var1.c);
      this.o++;
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, Graphics var7) {
      int var8 = var7.getClipX();
      int var9 = var7.getClipY();
      int var10 = var7.getClipWidth();
      int var11 = var7.getClipHeight();
      var7.setClip(var3, var4, var5, var6);
      if (this.t) {
         a.a(this.r, this.o);
         this.t = false;
      }

      var5 += var1;
      var6 += var2;
      int var12 = this.u ? var6 : var5;
      int var16 = 0;

      int var13;
      for (int var18 = a.a(this.r, this.o - 1, (this.u ? var2 : var1) - this.s << 16); var18 < this.o && (var13 = this.r[var18]) >> 16 < var12; var18++) {
         var13 &= 65535;
         int var15;
         int var14 = (var15 = this.q[var13]) >> 17;
         var15 = (short)(var15 >> 1) >> 1;
         c var17;
         if (var14 < var5 && var15 < var6 && var1 < var14 + (var17 = this.p[var13]).c && var2 < var15 + var17.d) {
            this.v[var16++] = var13;
         }
      }

      a.a(this.v, var16);
      var1 -= var3;
      var2 -= var4;

      for (int var23 = 0; var23 < var16; var23++) {
         var13 = this.v[var23];
         c var29 = this.p[var13];
         int var26;
         int var28 = (var26 = this.q[var13]) & 3;
         var29.a(var7, (var26 >> 17) - var29.a(var28) - var1, ((short)(var26 >> 1) >> 1) - var29.b(var28) - var2, var28);
      }

      var7.setClip(var8, var9, var10, var11);
   }

   public final void a(int var1) {
      this.w = null;
      this.x = null;
      this.y = null;
      this.z = null;
      this.A = -1;
      this.B = -1;
      this.C = -1;
      if (var1 > 0) {
         this.w = new c[var1];
         this.x = new int[var1];
         this.y = new short[var1];
         int var2 = 0;

         while (var2 < var1 - 1) {
            this.y[var2++] = (short)var2;
         }

         this.y[var1 - 1] = -1;
         this.z = new short[var1];
         this.C = 0;
      }
   }

   public final int b(c var1, int var2, int var3, int var4) {
      int var5 = this.C;
      this.C = this.y[var5];
      if (this.A < 0) {
         this.A = var5;
      } else {
         this.y[this.B] = (short)var5;
      }

      this.y[var5] = -1;
      this.z[var5] = (short)this.B;
      this.B = var5;
      this.w[var5] = var1;
      var2 += var1.a(var4);
      var3 += var1.b(var4);
      this.x[var5] = var2 << 17 | var3 << 17 >>> 15 | var4;
      return var5;
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, Graphics var8) {
      int var9 = var8.getClipX();
      int var10 = var8.getClipY();
      int var11 = var8.getClipWidth();
      int var12 = var8.getClipHeight();
      var8.setClip(var3, var4, var5, var6);
      int var13 = 0;
      if (!var7 && !this.a) {
         var13 = this.A;
      }

      int var14 = 0;
      var5 += var1;
      var6 += var2;
      int var17 = var1 - var3;
      int var18 = var2 - var4;

      while (var13 >= 0) {
         var14 = var13;
         var13 = this.y[var13];
         int var16;
         var3 = (var16 = this.x[var14]) >> 17;
         var4 = (short)(var16 >> 1) >> 1;
         c var15;
         if (var3 < var5 && var4 < var6 && var1 < var3 + (var15 = this.w[var14]).c && var2 < var4 + var15.d) {
            var16 &= 3;
            var15.a(var8, var3 - var15.a(var16) - var17, var4 - var15.b(var16) - var18, var16);
         }
      }

      var8.setClip(var9, var10, var11, var12);
   }
}
