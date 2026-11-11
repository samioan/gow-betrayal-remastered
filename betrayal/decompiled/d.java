import com.nokia.mid.sound.Sound;
import java.io.ByteArrayInputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public final class d implements Runnable {
   private a a;
   private int b;
   private volatile boolean c;
   private int d;
   private int e;
   private int[] f;
   private int[] g;
   private Sound[] h;
   private Sound i;
   private Player[] j;
   private Player k;

   public final synchronized void a() {
      if (!this.c) {
         this.c = true;
         this.b(-1);
      }
   }

   public final boolean b() {
      this.a.a(false);
      return !this.c && this.a.e;
   }

   public final void a(boolean var1) {
      if (this.b() != var1) {
         this.c();
         this.a.e = var1;
         this.a.a(true);
      }
   }

   private static String a(byte var0) {
      if (var0 == 1) {
         return "audio/x-wav";
      } else if (var0 == 2) {
         return "audio/mpeg";
      } else if (var0 == 3) {
         return "audio/amr";
      } else if (var0 == 4) {
         return "audio/aac";
      } else if (var0 == 7) {
         return "application/vnd.nokia.ringing-tone";
      } else {
         return var0 == 8 ? "audio/x-tone-seq" : "audio/midi";
      }
   }

   public final synchronized void run() {
      if (this.b()) {
         int var1 = this.d;
         if (this.d >= 0) {
            if (this.e >= 0) {
               this.c();
            }

            this.d = -1;
            Player var2;
            if ((var2 = this.j[var1]) != null) {
               try {
                  var2.prefetch();
               } catch (Throwable var8) {
                  return;
               }

               try {
                  var2.setMediaTime(0L);
               } catch (Throwable var7) {
               }

               try {
                  var2.setLoopCount(this.f[var1]);
               } catch (Throwable var6) {
               }

               try {
                  var2.start();
               } catch (Throwable var5) {
                  return;
               }

               this.k = var2;
            } else {
               Sound var3;
               if ((var3 = this.h[var1]) != null) {
                  int var4 = this.f[var1];
                  var3.play(var4 == -1 ? 0 : var4);
               }

               this.i = var3;
            }

            this.e = var1;
         }
      }
   }

   public final synchronized void a(int var1, int var2, int var3, int var4) {
      if (!this.c) {
         if (this.h[var1] != null || this.j[var1] != null) {
            this.b(var1);
         }

         this.f[var1] = var3;
         this.g[var1] = var4;

         try {
            byte[] var5 = this.a.k(var2);
            if (this.a.f[var2 & 1023] == 7) {
               this.h[var1] = new Sound(var5, 1);
               return;
            }

            this.j[var1] = Manager.createPlayer(new ByteArrayInputStream(var5), a(this.a.f[var2 & 1023]));
            this.j[var1].realize();
            this.j[var1].prefetch();
            return;
         } catch (Throwable var7) {
         }
      }
   }

   private synchronized void b(int var1) {
      if (var1 == -1) {
         for (int var2 = 0; var2 < this.b; var2++) {
            this.b(var2);
         }
      } else {
         if (this.e == var1 || this.d == var1) {
            this.c();
         }

         if (this.j[var1] != null) {
            this.j[var1].close();
            this.j[var1] = null;
         }

         if (this.h[var1] != null) {
            this.h[var1].release();
            this.h[var1] = null;
         }
      }
   }

   public final void a(int var1) {
      if (this.b() && (this.h[var1] != null || this.j[var1] != null) && (this.d < 0 || this.g[this.d] <= this.g[var1])) {
         int var2 = this.e;
         if (this.e >= 0) {
            Player var3 = this.k;
            if (this.k != null && var3.getState() == 400 && this.g[var2] > this.g[var1]) {
               return;
            }

            Sound var4 = this.i;
            if (this.i != null && var4.getState() == 0 && this.g[var2] > this.g[var1]) {
               return;
            }
         }

         this.d = var1;
      }
   }

   public final synchronized void c() {
      if (this.k != null) {
         try {
            if (this.k.getState() == 400) {
               this.k.stop();
            }
         } catch (Throwable var2) {
         }

         this.k = null;
      }

      if (this.i != null) {
         try {
            if (this.i.getState() == 0) {
               this.i.stop();
            }
         } catch (Throwable var1) {
         }

         this.i = null;
      }

      this.d = -1;
      this.e = -1;
   }

   public d(a var1, int var2) {
      this.a = var1;
      this.d = -1;
      this.e = -1;
      this.b = var2;
      this.f = new int[var2];
      this.g = new int[var2];
      this.h = new Sound[var2];
      this.j = new Player[var2];
      var1.d = this;
   }
}
