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
   private boolean d;
   // $VF: renamed from: e int
   private int pendingSlot;
   // $VF: renamed from: f int
   private int playingSlot;
   // $VF: renamed from: g int[]
   private int[] loopCounts;
   // $VF: renamed from: h int[]
   private int[] priorities;
   // $VF: renamed from: i javax.microedition.media.Player[]
   private Player[] players;
   // $VF: renamed from: j javax.microedition.media.Player
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
      return !this.shutDown && (this.engine.mutedByPause ? this.engine.soundBeforePause : this.engine.soundEnabled);
   }

   // $VF: renamed from: a (boolean) void
   public final void setSoundOn(boolean var1) {
      if (this.isSoundOn() != var1) {
         if (this.engine.mutedByPause) {
            this.engine.soundBeforePause = var1;
            return;
         }

         this.stop();
         this.engine.soundEnabled = var1;
         this.engine.syncSettings(true);
      }
   }

   // $VF: renamed from: a (byte) java.lang.String
   private static String mimeType(byte var0) {
      return var0 == 14 ? "video/3gp" : "audio/midi";
   }

   // $VF: renamed from: a (byte[], byte, boolean) byte[]
   private byte[] padMidi(byte[] var1, byte var2, boolean var3) {
      if (var2 == 0 && !var3) {
         short var4 = readShort(var1, 10);
         int var5;
         boolean var6;
         int var7;
         if (var6 = (var5 = readShort(var1, 12)) >= 0) {
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
            int var18 = readInt(var1, var29[var17] + 4);
            var29[var17] += 8;
            if (var17 + 1 < var4) {
               var29[var17 + 1] = var29[var17] + var18;
            }

            var9[var17] = readVarLen(var1, var29[var17]);
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

                           for (var22 = readVarLen(var1, var25) + 2; (var1[var25] & 128) != 0; var22++) {
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
                     var20 = readVarLen(var1, var29[var33]) + var9[var33];
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

            int var35 = varLenSize(var34);
            int var36 = (var6 ? 7 : 0) + 10 + var35;
            byte[] var37 = new byte[var1.length + var36];
            int var38 = 14;

            for (int var40 = 0; var40 < var31; var40++) {
               int var44 = readInt(var1, var38 + 4);
               var38 += 8 + var44;
            }

            int var41 = readInt(var1, var38 + 4) + var36;
            writeInt(var1, var38 + 4, var41);
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
            writeVarLen(var37, var45, var34);
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

   // $VF: renamed from: a (byte[], int) short
   private static short readShort(byte[] var0, int var1) {
      int var2 = var0[var1] & 255;
      int var3 = var0[var1 + 1] & 255;
      return (short)((var2 << 8) + (var3 << 0));
   }

   // $VF: renamed from: b (byte[], int) int
   private static int readInt(byte[] var0, int var1) {
      int var2 = var0[var1] & 255;
      int var3 = var0[var1 + 1] & 255;
      int var4 = var0[var1 + 2] & 255;
      int var5 = var0[var1 + 3] & 255;
      return (var2 << 24) + (var3 << 16) + (var4 << 8) + (var5 << 0);
   }

   // $VF: renamed from: a (byte[], int, int) void
   private static void writeInt(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)(var2 >>> 24);
      var0[var1 + 1] = (byte)(var2 >>> 16);
      var0[var1 + 2] = (byte)(var2 >>> 8);
      var0[var1 + 3] = (byte)(var2 >>> 0);
   }

   // $VF: renamed from: c (byte[], int) int
   private static int readVarLen(byte[] var0, int var1) {
      int var2 = 0;
      int var3 = -1;

      do {
         var2 = var2 << 7 | var0[var1 + ++var3] & 127;
      } while (var3 < 3 && (var0[var1 + var3] & 128) != 0);

      return var2;
   }

   // $VF: renamed from: b (byte[], int, int) void
   private static void writeVarLen(byte[] var0, int var1, int var2) {
      int var3 = (varLenSize(var2) - 1) * 7;
      int var4 = 0;

      do {
         var0[var1 + var4] = (byte)(var2 >>> var3 & 127 | (var3 > 0 ? 128 : 0));
         var3 -= 7;
         var4++;
      } while (var3 >= 0);
   }

   // $VF: renamed from: b (int) int
   private static int varLenSize(int var0) {
      byte var1 = 21;

      int var2;
      for (var2 = 4; var1 > 0 && (var0 >>> var1 & 127) == 0; var2--) {
         var1 -= 7;
      }

      return var2;
   }

   public final synchronized void run() {
      if (this.isSoundOn() && this.engine.soundEnabled) {
         int var1 = this.pendingSlot;
         if (this.pendingSlot >= 0) {
            if (this.playingSlot >= 0) {
               this.stop();
            }

            this.pendingSlot = -1;
            Player var2 = this.players[var1];

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
               var2.setLoopCount(this.loopCounts[var1]);
            } catch (Throwable var4) {
            }

            try {
               var2.start();
            } catch (Throwable var3) {
               return;
            }

            this.playingSlot = var1;
            this.currentPlayer = var2;
         }
      }
   }

   // $VF: renamed from: a (int, int, int, int) void
   public final synchronized void load(int var1, int var2, int var3, int var4) {
      if (!this.shutDown) {
         if (this.players[var1] != null) {
            this.unload(var1);
         }

         this.loopCounts[var1] = var3;
         this.priorities[var1] = var4;

         try {
            byte[] var5 = this.engine.getResourceBytesAlias(var2);
            byte var6 = this.engine.resourceTypes[var2 & 1023];
            var5 = this.padMidi(var5, var6, var3 != 1);
            this.players[var1] = Manager.createPlayer(new ByteArrayInputStream(var5), mimeType(this.engine.resourceTypes[var2 & 1023]));
            this.players[var1].realize();
            this.players[var1].prefetch();
            return;
         } catch (Throwable var7) {
         }
      }
   }

   // $VF: renamed from: c (int) void
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
      }
   }

   // $VF: renamed from: a (int) void
   public final void play(int var1) {
      if (this.isSoundOn()
         && this.engine.soundEnabled
         && this.players[var1] != null
         && (this.pendingSlot < 0 || this.priorities[this.pendingSlot] <= this.priorities[var1])) {
         int var2 = this.playingSlot;
         Player var3 = this.currentPlayer;
         if (this.currentPlayer != null && var3.getState() == 400 && this.priorities[var2] > this.priorities[var1]) {
            return;
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
         } catch (Throwable var1) {
         }

         this.currentPlayer = null;
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
      this.players = new Player[var2];
      var1.soundPlayer = this;
   }
}
