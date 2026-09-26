import java.io.ByteArrayInputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public final class d implements Runnable {
   private a a;
   private int b;
   private volatile boolean c;
   private boolean d;
   private int e;
   private int f;
   private int[] g;
   private int[] h;
   private Player[] i;
   private Player j;

   public final synchronized void a() {
      if (!this.c) {
         this.c = true;
         this.c(-1);
      }
   }

   public final boolean b() {
      this.a.a(false);
      return !this.c && (this.a.j ? this.a.i : this.a.e);
   }

   public final void a(boolean var1) {
      if (this.b() != var1) {
         if (this.a.j) {
            this.a.i = var1;
            return;
         }

         this.c();
         this.a.e = var1;
         this.a.a(true);
      }
   }

   private static String a(byte var0) {
      return var0 == 14 ? "video/3gp" : "audio/midi";
   }

   private byte[] a(byte[] var1, byte var2, boolean var3) {
      if (var2 == 0 && !var3) {
         short var4 = a(var1, 10);
         short var5;
         boolean var6;
         int var7;
         if (var6 = (var5 = a(var1, 12)) >= 0) {
            var7 = 500000;
            var5 *= 1000;
         } else {
            var7 = 1000000;
            int var8;
            if ((var8 = -(var5 & 0xFF00) >> 8) == 29) {
               var8 = 299700;
            } else {
               var8 *= 1000;
            }

            var5 = var8 * (var5 & 0xFF);
         }

         int[] var29 = new int[var4];
         int[] var9 = new int[var4];
         byte[] var10 = new byte[var4];
         long var11 = 0L;
         long var13 = 0L;
         long var15 = 0L;
         var29[0] = 14;

         for (int var17 = 0; var17 < var29.length; var17++) {
            int var18 = b(var1, var29[var17] + 4);
            var29[var17] += 8;
            if (var17 + 1 < var4) {
               var29[var17 + 1] = var29[var17] + var18;
            }

            var9[var17] = c(var1, var29[var17]);
         }

         int var31 = 0;
         int var32 = var4;

         while (var32 > 0 && var11 >= 0L) {
            var11 = -1L;

            for (int var19 = 0; var19 < var4; var19++) {
               if (var9[var19] >= 0 && (var11 < 0L || var9[var19] < var11)) {
                  var11 = var9[var19];
               }
            }

            for (int var33 = 0; var33 < var4; var33++) {
               int var20 = var9[var33];
               boolean var21 = false;

               while (var20 == var11) {
                  while ((var1[var29[var33]] & 128) != 0) {
                     var29[var33]++;
                  }

                  var29[var33]++;
                  int var22 = 2;
                  byte var23;
                  if (((var23 = var1[var29[var33]]) & 128) == 0) {
                     var23 = var10[var33];
                  } else {
                     var10[var33] = var23;
                     var29[var33]++;
                  }

                  byte var24;
                  if ((var24 = (byte)(var23 & 240)) != -64 && var24 != -48) {
                     if (var24 == -16) {
                        if (var23 == -1) {
                           int var25 = var29[var33] + 1;

                           for (var22 = c(var1, var25) + 2; (var1[var25] & 128) != 0; var22++) {
                              var25++;
                           }
                        } else if (var23 == -16) {
                           do {
                              var29[var33]++;
                           } while (var1[var29[var33]] != -9);
                        } else if (var23 != -15 && var23 != -13) {
                           var22 = 0;
                        } else {
                           var22 = 1;
                        }
                     }
                  } else {
                     var22 = 1;
                  }

                  if (var23 == -1) {
                     byte var42;
                     if ((var42 = var1[var29[var33]]) == 47) {
                        var21 = true;
                     } else if (var42 == 81) {
                        var15 += (var11 - var13) * var7 / var5;
                        if (var6) {
                           var7 = (var1[var29[var33] + 2] & 255) << 16 | (var1[var29[var33] + 3] & 255) << 8 | var1[var29[var33] + 4] & 255;
                        }

                        var13 = var11;
                     }
                  }

                  if (var21) {
                     var29[var33] = -1;
                     var20 = -1;
                     var9[var33] = -1;
                     if (--var32 == 1) {
                        for (int var43 = 0; var43 < var4; var43++) {
                           if (var29[var43] >= 0) {
                              var31 = var43;
                           }
                        }
                     }
                  } else {
                     var29[var33] += var22;
                     var20 = c(var1, var29[var33]) + var9[var33];
                     var9[var33] = var20;
                  }
               }
            }
         }

         var15 += (var11 - var13) * var7 / var5;
         int var34;
         if ((var34 = (int)((600000L - var15) * var5 / 1000000L) + 1) > 0 && var15 < 600000L) {
            if (var7 == 1000000) {
               var6 = false;
            }

            int var35 = b(var34);
            int var36 = (var6 ? 7 : 0) + 10 + var35;
            byte[] var37 = new byte[var1.length + var36];
            int var38 = 14;

            for (int var40 = 0; var40 < var31; var40++) {
               int var44 = b(var1, var38 + 4);
               var38 += 8 + var44;
            }

            int var41 = b(var1, var38 + 4) + var36;
            a(var1, var38 + 4, var41);
            var38 += 8 + var41 - var36 - 3;

            int var45;
            for (var45 = 0; var45 < var38; var45++) {
               var37[var45] = var1[var45];
            }

            if (var6) {
               var37[var45++] = -1;
               var37[var45++] = 81;
               var37[var45++] = 3;
               var37[var45++] = 15;
               var37[var45++] = 66;
               var37[var45++] = 64;
               var37[var45++] = 0;
            }

            var37[var45++] = -80;
            var37[var45++] = 7;
            var37[var45++] = 1;
            var37[var45++] = 0;
            var37[var45++] = -112;
            var37[var45++] = 0;
            var37[var45++] = 1;
            b(var37, var45, var34);
            var45 += var35;
            var37[var45++] = 0;
            var37[var45++] = 0;
            var37[var45++] = 0;
            int var26 = var1.length;

            do {
               var37[var45++] = var1[var38++];
            } while (var38 < var26);

            var1 = var37;
            if (!this.d) {
               this.d = true;
               this.d = false;
            }
         }
      }

      return var1;
   }

   private static short a(byte[] var0, int var1) {
      int var2 = var0[var1] & 255;
      int var3 = var0[var1 + 1] & 255;
      return (short)((var2 << 8) + (var3 << 0));
   }

   private static int b(byte[] var0, int var1) {
      int var2 = var0[var1] & 255;
      int var3 = var0[var1 + 1] & 255;
      int var4 = var0[var1 + 2] & 255;
      int var5 = var0[var1 + 3] & 255;
      return (var2 << 24) + (var3 << 16) + (var4 << 8) + (var5 << 0);
   }

   private static void a(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)(var2 >>> 24);
      var0[var1 + 1] = (byte)(var2 >>> 16);
      var0[var1 + 2] = (byte)(var2 >>> 8);
      var0[var1 + 3] = (byte)(var2 >>> 0);
   }

   private static int c(byte[] var0, int var1) {
      int var2 = 0;
      int var3 = -1;

      do {
         var2 = var2 << 7 | var0[var1 + ++var3] & 127;
      } while (var3 < 3 && (var0[var1 + var3] & 128) != 0);

      return var2;
   }

   private static void b(byte[] var0, int var1, int var2) {
      int var3 = (b(var2) - 1) * 7;
      int var4 = 0;

      do {
         var0[var1 + var4] = (byte)(var2 >>> var3 & 127 | (var3 > 0 ? 128 : 0));
         var3 -= 7;
         var4++;
      } while (var3 >= 0);
   }

   private static int b(int var0) {
      byte var1 = 21;

      int var2;
      for (var2 = 4; var1 > 0 && (var0 >>> var1 & 127) == 0; var2--) {
         var1 -= 7;
      }

      return var2;
   }

   public final synchronized void run() {
      if (this.b() && this.a.e) {
         int var1 = this.e;
         if (this.e >= 0) {
            if (this.f >= 0) {
               this.c();
            }

            this.e = -1;
            Player var2 = this.i[var1];

            try {
               var2.prefetch();
            } catch (Throwable var6) {
               return;
            }

            try {
               var2.setMediaTime(0L);
            } catch (Throwable var5) {
            }

            try {
               var2.setLoopCount(this.g[var1]);
            } catch (Throwable var4) {
            }

            try {
               var2.start();
            } catch (Throwable var3) {
               return;
            }

            this.f = var1;
            this.j = var2;
         }
      }
   }

   public final synchronized void a(int var1, int var2, int var3, int var4) {
      if (!this.c) {
         if (this.i[var1] != null) {
            this.c(var1);
         }

         this.g[var1] = var3;
         this.h[var1] = var4;

         try {
            byte[] var5 = this.a.k(var2);
            byte var6 = this.a.f[var2 & 1023];
            var5 = this.a(var5, var6, var3 != 1);
            this.i[var1] = Manager.createPlayer(new ByteArrayInputStream(var5), a(this.a.f[var2 & 1023]));
            this.i[var1].realize();
            this.i[var1].prefetch();
            return;
         } catch (Throwable var7) {
         }
      }
   }

   private synchronized void c(int var1) {
      if (var1 == -1) {
         for (int var2 = 0; var2 < this.b; var2++) {
            this.c(var2);
         }
      } else {
         if (this.f == var1 || this.e == var1) {
            this.c();
         }

         if (this.i[var1] != null) {
            this.i[var1].close();
            this.i[var1] = null;
         }
      }
   }

   public final void a(int var1) {
      if (this.b() && this.a.e && this.i[var1] != null && (this.e < 0 || this.h[this.e] <= this.h[var1])) {
         int var2 = this.f;
         Player var3 = this.j;
         if (this.j != null && var3.getState() == 400 && this.h[var2] > this.h[var1]) {
            return;
         }

         this.e = var1;
      }
   }

   public final synchronized void c() {
      if (this.j != null) {
         try {
            if (this.j.getState() == 400) {
               this.j.stop();
            }
         } catch (Throwable var1) {
         }

         this.j = null;
      }

      this.e = -1;
      this.f = -1;
   }

   public d(a var1, int var2) {
      this.a = var1;
      this.e = -1;
      this.f = -1;
      this.b = var2;
      this.g = new int[var2];
      this.h = new int[var2];
      this.i = new Player[var2];
      var1.d = this;
   }
}
