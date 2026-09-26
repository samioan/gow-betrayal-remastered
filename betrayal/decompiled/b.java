import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class b {
   private final boolean a;
   private final int b;
   private final int c;
   private int d;
   private int e;
   private Image f;
   private Graphics g;
   private int h;
   private int i;
   private boolean j;
   private int k;
   private short[] l;
   private final boolean m;
   private Image n;
   private char[] o;
   private char[] p;
   private int q;
   private int r;
   private int s;
   private c[] t;
   private int[] u;
   private int[] v;
   private int w;
   private boolean x;
   private boolean y;
   private int[] z;
   private c[] A;
   private int[] B;
   private short[] C;
   private short[] D;
   private int E;
   private int F;
   private int G;
   private int H;
   private char[] I;
   private int J;
   private boolean K;

   public static b a(int var0, int var1) {
      return new b(true, false, var0, var1);
   }

   private b(boolean var1, boolean var2, int var3, int var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      if (var1 && this.f == null) {
         this.f = Image.createImage(var3, var4);
         this.g = this.f.getGraphics();
      }

      this.m = var2;
      this.a(0);
   }

   public final void b(int var1, int var2) {
      this.d = var1;
      this.e = var2;
   }

   public final void a(Graphics var1) {
      if (this.a) {
         this.b(var1);
      }
   }

   private void b(Graphics var1) {
      this.a();
      this.c(var1);
   }

   private void c(Graphics var1) {
      int var2 = this.d % this.b;
      int var3 = this.e % this.c;
      if (var2 == 0) {
         if (var3 == 0) {
            a.a(this.f, 0, 0, this.b, this.c, var1, 0, 0);
         } else {
            int var7 = this.c - var3;
            a.a(this.f, 0, var3, this.b, var7, var1, 0, 0);
            a.a(this.f, 0, 0, this.b, var3, var1, 0, var7);
         }
      } else if (var3 == 0) {
         int var6 = this.b - var2;
         a.a(this.f, var2, 0, var6, this.c, var1, 0, 0);
         a.a(this.f, 0, 0, var2, this.c, var1, var6, 0);
      } else {
         int var4 = this.c - var3;
         int var5 = this.b - var2;
         a.a(this.f, var2, var3, var5, var4, var1, 0, 0);
         a.a(this.f, 0, var3, var2, var4, var1, var5, 0);
         a.a(this.f, var2, 0, var5, var3, var1, 0, var4);
         a.a(this.f, 0, 0, var2, var3, var1, var5, var4);
      }
   }

   private void b(int var1) {
      int var4 = this.d + this.b;
      int var5 = this.e + this.c;

      while (var1 >= 0) {
         int var3;
         int var2 = (var3 = this.B[var1]) >> 17;
         var3 = (short)(var3 >> 1) >> 1;
         c var6;
         if (var2 < var4 && var3 < var5 && this.d < var2 + (var6 = this.A[var1]).c && this.e < var3 + var6.d) {
            this.I[this.J++] = (char)var1;
         }

         var1 = this.C[var1];
      }
   }

   private void a() {
      int var1 = this.H;
      if (this.H >= 0) {
         if (!this.j) {
            this.K = true;
            this.a(this.h, this.i, this.b, this.c);
            this.K = false;
         }

         this.H = -1;
      }

      if (this.j) {
         this.j = false;
         this.h = this.d - this.b;
         this.i = this.e - this.c;
      }

      if (this.h == this.d && this.i == this.e) {
         this.b(var1);
      } else {
         int var2 = this.d;
         int var3 = Math.min(this.b, Math.abs(this.h - this.d));
         if (this.h < this.d) {
            var2 += this.b - var3;
         }

         this.h = this.d;
         int var4 = this.e;
         int var5 = Math.min(this.c, Math.abs(this.i - this.e));
         if (this.i < this.e) {
            var4 += this.c - var5;
         }

         this.i = this.e;
         this.J = 0;
         this.b(this.E);
         if (var3 == this.b && var5 == this.c) {
            this.a(this.d, this.e, var3, var5);
         } else {
            if (var3 > 0) {
               this.a(var2, this.e, var3, this.c);
            }

            if (var5 > 0) {
               this.a(this.d, var4, this.b, var5);
            }
         }
      }
   }

   private void a(int var1, int var2, int var3, int var4) {
      int var5 = var1 % this.b;
      int var6 = var2 % this.c;
      int var7 = var5 + var3 - this.b;
      int var8 = var6 + var4 - this.c;
      if (var7 <= 0) {
         if (var8 <= 0) {
            this.a(this.g, var1, var2, var5, var6, var3, var4);
         } else {
            var4 -= var8;
            this.a(this.g, var1, var2, var5, var6, var3, var4);
            var2 += var4;
            this.a(this.g, var1, var2, var5, 0, var3, var8);
         }
      } else {
         var3 -= var7;
         if (var8 <= 0) {
            this.a(this.g, var1, var2, var5, var6, var3, var4);
            var1 += var3;
            this.a(this.g, var1, var2, 0, var6, var7, var4);
         } else {
            var4 -= var8;
            this.a(this.g, var1, var2, var5, var6, var3, var4);
            var2 += var4;
            this.a(this.g, var1, var2, var5, 0, var3, var8);
            var1 += var3;
            this.a(this.g, var1, var2, 0, 0, var7, var8);
            var2 -= var4;
            this.a(this.g, var1, var2, 0, var6, var7, var4);
         }
      }
   }

   private void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (!this.K) {
         if (this.l != null) {
            this.b(var1, var2, var3, var4, var5, var6, var7);
         }

         if (this.s > 0) {
            this.a(var2, var3, var4, var5, var6, var7, var1);
         }
      }

      if (this.E >= 0) {
         this.a(var2, var3, var4, var5, var6, var7, this.K, var1);
      }
   }

   private void b(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8;
      int var9 = (var8 = (var2 + var6 - 1) / this.q) - var2 / this.q;
      int var10 = (var3 + var7 - 1) / this.r;
      var8 += var10 * this.k;
      var10 -= var3 / this.r;
      var2 %= this.q;
      var3 %= this.r;
      int var11 = var2;
      int var12 = var3;
      int var13;
      if ((var13 = -(var2 + var6) % this.q) < 0) {
         var13 += this.q;
      }

      int var14;
      if ((var14 = -(var3 + var7) % this.r) < 0) {
         var14 += this.r;
      }

      var2 = var4 - var2 + this.q * var9;
      var3 = var5 - var3 + this.r * var10;

      for (int var25 = var10; var25 >= 0; var25--) {
         for (int var24 = var9; var24 >= 0; var24--) {
            int var15;
            if ((var15 = this.l[var8--] & 4095) > 0) {
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

               if (!this.m) {
                  var1.drawRegion(
                     this.n, this.o[var15] + var4, this.p[var15] + var5, this.q - var4 - var16, this.r - var5 - var17, 0, var2 + var4, var3 + var5, 20
                  );
               }
            }

            var2 -= this.q;
         }

         var8 += 1 + var9 - this.k;
         var2 += this.q * (var9 + 1);
         var3 -= this.r;
      }
   }

   public final void a(int var1, int var2, Image var3, int var4, int var5) {
      this.b();
      this.k = var1;
      this.l = new short[var1 * var2];
      this.q = var4;
      this.r = var5;
      var4 = var3.getWidth();
      var5 = var3.getHeight();
      int var6 = var4 / this.q * (var5 / this.r);
      var4 -= this.q;
      var5 -= this.r;
      if (!this.m) {
         this.n = var3;
         this.o = new char[var6];
         this.p = new char[var6];
         int var7 = 0;

         for (int var8 = 0; var8 <= var5; var8 += this.r) {
            for (int var9 = 0; var9 <= var4; var9 += this.q) {
               this.o[var7] = (char)var9;
               this.p[var7] = (char)var8;
               var7++;
            }
         }
      }
   }

   private void b() {
      this.l = null;
      if (!this.m) {
         this.n = null;
         this.o = null;
         this.p = null;
      }
   }

   public final void a(int var1, int var2, int var3) {
      this.l[var2 * this.k + var1] = (short)var3;
      this.j = true;
   }

   public final void a(int var1, boolean var2) {
      this.s = 0;
      this.t = null;
      this.u = null;
      this.v = null;
      this.w = 0;
      this.x = true;
      this.z = null;
      this.j = true;
      if (var1 > 0) {
         this.y = var2;
         this.t = new c[var1];
         this.u = new int[var1];
         this.v = new int[var1];
         this.z = new int[var1];
      }
   }

   public final void a(c var1, int var2, int var3, int var4) {
      this.t[this.s] = var1;
      var2 += var1.a(var4);
      var3 += var1.b(var4);
      this.u[this.s] = var2 << 17 | var3 << 17 >>> 15 | var4;
      this.v[this.s] = (this.y ? var3 : var2) << 16 | this.s;
      this.w = Math.max(this.w, this.y ? var1.d : var1.c);
      this.s++;
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, Graphics var7) {
      int var8 = var7.getClipX();
      int var9 = var7.getClipY();
      int var10 = var7.getClipWidth();
      int var11 = var7.getClipHeight();
      var7.setClip(var3, var4, var5, var6);
      if (this.x) {
         a.a(this.v, this.s);
         this.x = false;
      }

      var5 += var1;
      var6 += var2;
      int var12 = this.y ? var6 : var5;
      int var16 = 0;

      int var13;
      for (int var18 = a.a(this.v, this.s - 1, (this.y ? var2 : var1) - this.w << 16); var18 < this.s && (var13 = this.v[var18]) >> 16 < var12; var18++) {
         var13 &= 65535;
         int var15;
         int var14 = (var15 = this.u[var13]) >> 17;
         var15 = (short)(var15 >> 1) >> 1;
         c var17;
         if (var14 < var5 && var15 < var6 && var1 < var14 + (var17 = this.t[var13]).c && var2 < var15 + var17.d) {
            this.z[var16++] = var13;
         }
      }

      a.a(this.z, var16);
      var1 -= var3;
      var2 -= var4;

      for (int var23 = 0; var23 < var16; var23++) {
         var13 = this.z[var23];
         c var29 = this.t[var13];
         int var26;
         int var28 = (var26 = this.u[var13]) & 3;
         var29.a(var7, (var26 >> 17) - var29.a(var28) - var1, ((short)(var26 >> 1) >> 1) - var29.b(var28) - var2, var28);
      }

      var7.setClip(var8, var9, var10, var11);
   }

   public final void a(int var1) {
      this.A = null;
      this.B = null;
      this.C = null;
      this.D = null;
      this.E = -1;
      this.F = -1;
      this.G = -1;
      this.j = true;
      this.H = -1;
      this.I = null;
      this.J = 0;
      if (var1 > 0) {
         this.A = new c[var1];
         this.B = new int[var1];
         this.C = new short[var1];
         int var2 = 0;

         while (var2 < var1 - 1) {
            this.C[var2++] = (short)var2;
         }

         this.C[var1 - 1] = -1;
         this.D = new short[var1];
         this.G = 0;
         if (this.a) {
            this.I = new char[var1];
         }
      }
   }

   public final int b(c var1, int var2, int var3, int var4) {
      int var5 = this.G;
      this.G = this.C[var5];
      if (this.E < 0) {
         this.E = var5;
      } else {
         this.C[this.F] = (short)var5;
      }

      this.C[var5] = -1;
      this.D[var5] = (short)this.F;
      this.F = var5;
      if (this.H < 0) {
         this.H = var5;
      }

      this.A[var5] = var1;
      var2 += var1.a(var4);
      var3 += var1.b(var4);
      this.B[var5] = var2 << 17 | var3 << 17 >>> 15 | var4;
      return var5;
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, Graphics var8) {
      int var9 = var8.getClipX();
      int var10 = var8.getClipY();
      int var11 = var8.getClipWidth();
      int var12 = var8.getClipHeight();
      var8.setClip(var3, var4, var5, var6);
      int var13 = 0;
      boolean var14 = false;
      if (var7) {
         var13 = this.H;
      } else if (this.a) {
         var14 = true;
      }

      int var15 = 0;
      var5 += var1;
      var6 += var2;
      int var18 = var1 - var3;
      int var19 = var2 - var4;

      while (true) {
         if (var14) {
            if (var13 == this.J) {
               break;
            }

            var15 = this.I[var13++];
         } else {
            if (var13 < 0) {
               break;
            }

            var15 = var13;
            var13 = this.C[var13];
         }

         int var17;
         var3 = (var17 = this.B[var15]) >> 17;
         var4 = (short)(var17 >> 1) >> 1;
         c var16;
         if (var3 < var5 && var4 < var6 && var1 < var3 + (var16 = this.A[var15]).c && var2 < var4 + var16.d) {
            var17 &= 3;
            var16.a(var8, var3 - var16.a(var17) - var18, var4 - var16.b(var17) - var19, var17);
         }
      }

      var8.setClip(var9, var10, var11, var12);
   }
}
