import com.nokia.mid.sound.Sound;
import java.io.ByteArrayInputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

// $VF: renamed from: d
public final class SoundPlayer implements Runnable {
   // $VF: renamed from: a a
   private Engine engine;
   // $VF: renamed from: b int
   private int slotCount;
   // $VF: renamed from: c boolean
   private volatile boolean shutDown;
   // $VF: renamed from: d int
   private int pendingSlot;
   // $VF: renamed from: e int
   private int playingSlot;
   // $VF: renamed from: f int[]
   private int[] loopCounts;
   // $VF: renamed from: g int[]
   private int[] priorities;
   // $VF: renamed from: h com.nokia.mid.sound.Sound[]
   private Sound[] nokiaSounds;
   // $VF: renamed from: i com.nokia.mid.sound.Sound
   private Sound currentNokiaSound;
   // $VF: renamed from: j javax.microedition.media.Player[]
   private Player[] players;
   // $VF: renamed from: k javax.microedition.media.Player
   private Player currentPlayer;

   // $VF: renamed from: a () void
   public final synchronized void shutdown() {
      if (!this.shutDown) {
         this.shutDown = true;
         this.unload(-1);
      }
   }

   // $VF: renamed from: b () boolean
   public final boolean isSoundOn() {
      this.engine.syncSettings(false);
      return !this.shutDown && this.engine.soundEnabled;
   }

   // $VF: renamed from: a (boolean) void
   public final void setSoundOn(boolean var1) {
      if (this.isSoundOn() != var1) {
         this.stop();
         this.engine.soundEnabled = var1;
         this.engine.syncSettings(true);
      }
   }

   // $VF: renamed from: a (byte) java.lang.String
   private static String mimeType(byte var0) {
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
      if (this.isSoundOn()) {
         int var1 = this.pendingSlot;
         if (this.pendingSlot >= 0) {
            if (this.playingSlot >= 0) {
               this.stop();
            }

            this.pendingSlot = -1;
            Player var2;
            if ((var2 = this.players[var1]) != null) {
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
                  var2.setLoopCount(this.loopCounts[var1]);
               } catch (Throwable var6) {
               }

               try {
                  var2.start();
               } catch (Throwable var5) {
                  return;
               }

               this.currentPlayer = var2;
            } else {
               Sound var3;
               if ((var3 = this.nokiaSounds[var1]) != null) {
                  int var4 = this.loopCounts[var1];
                  var3.play(var4 == -1 ? 0 : var4);
               }

               this.currentNokiaSound = var3;
            }

            this.playingSlot = var1;
         }
      }
   }

   // $VF: renamed from: a (int, int, int, int) void
   public final synchronized void load(int var1, int var2, int var3, int var4) {
      if (!this.shutDown) {
         if (this.nokiaSounds[var1] != null || this.players[var1] != null) {
            this.unload(var1);
         }

         this.loopCounts[var1] = var3;
         this.priorities[var1] = var4;

         try {
            byte[] var5 = this.engine.getResourceBytesAlias(var2);
            if (this.engine.resourceTypes[var2 & 1023] == 7) {
               this.nokiaSounds[var1] = new Sound(var5, 1);
               return;
            }

            this.players[var1] = Manager.createPlayer(new ByteArrayInputStream(var5), mimeType(this.engine.resourceTypes[var2 & 1023]));
            this.players[var1].realize();
            this.players[var1].prefetch();
            return;
         } catch (Throwable var7) {
         }
      }
   }

   // $VF: renamed from: b (int) void
   private synchronized void unload(int var1) {
      if (var1 == -1) {
         for (int var2 = 0; var2 < this.slotCount; var2++) {
            this.unload(var2);
         }
      } else {
         if (this.playingSlot == var1 || this.pendingSlot == var1) {
            this.stop();
         }

         if (this.players[var1] != null) {
            this.players[var1].close();
            this.players[var1] = null;
         }

         if (this.nokiaSounds[var1] != null) {
            this.nokiaSounds[var1].release();
            this.nokiaSounds[var1] = null;
         }
      }
   }

   // $VF: renamed from: a (int) void
   public final void play(int var1) {
      if (this.isSoundOn()
         && (this.nokiaSounds[var1] != null || this.players[var1] != null)
         && (this.pendingSlot < 0 || this.priorities[this.pendingSlot] <= this.priorities[var1])) {
         int var2 = this.playingSlot;
         if (this.playingSlot >= 0) {
            Player var3 = this.currentPlayer;
            if (this.currentPlayer != null && var3.getState() == 400 && this.priorities[var2] > this.priorities[var1]) {
               return;
            }

            Sound var4 = this.currentNokiaSound;
            if (this.currentNokiaSound != null && var4.getState() == 0 && this.priorities[var2] > this.priorities[var1]) {
               return;
            }
         }

         this.pendingSlot = var1;
      }
   }

   // $VF: renamed from: c () void
   public final synchronized void stop() {
      if (this.currentPlayer != null) {
         try {
            if (this.currentPlayer.getState() == 400) {
               this.currentPlayer.stop();
            }
         } catch (Throwable var2) {
         }

         this.currentPlayer = null;
      }

      if (this.currentNokiaSound != null) {
         try {
            if (this.currentNokiaSound.getState() == 0) {
               this.currentNokiaSound.stop();
            }
         } catch (Throwable var1) {
         }

         this.currentNokiaSound = null;
      }

      this.pendingSlot = -1;
      this.playingSlot = -1;
   }

   public SoundPlayer(Engine var1, int var2) {
      this.engine = var1;
      this.pendingSlot = -1;
      this.playingSlot = -1;
      this.slotCount = var2;
      this.loopCounts = new int[var2];
      this.priorities = new int[var2];
      this.nokiaSounds = new Sound[var2];
      this.players = new Player[var2];
      var1.soundPlayer = this;
   }
}
