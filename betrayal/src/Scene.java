import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

// $VF: renamed from: b
public final class Scene {
   // $VF: renamed from: a boolean
   private final boolean buffered;
   // $VF: renamed from: b int
   private int viewWidth;
   // $VF: renamed from: c int
   private final int viewHeight;
   // $VF: renamed from: d int
   private int scrollX;
   // $VF: renamed from: e int
   private int scrollY;
   // $VF: renamed from: f javax.microedition.lcdui.Image
   private Image buffer;
   // $VF: renamed from: g int
   private int mapCols;
   // $VF: renamed from: h short[]
   private short[] tileMap;
   // $VF: renamed from: i boolean
   private final boolean noTileSheet;
   // $VF: renamed from: j javax.microedition.lcdui.Image
   private Image tileSheet;
   // $VF: renamed from: k char[]
   private char[] tileSrcX;
   // $VF: renamed from: l char[]
   private char[] tileSrcY;
   // $VF: renamed from: m int
   private int tileWidth;
   // $VF: renamed from: n int
   private int tileHeight;
   // $VF: renamed from: o int
   private int staticCount;
   // $VF: renamed from: p c[]
   private Sprite[] staticSprites;
   // $VF: renamed from: q int[]
   private int[] staticPos;
   // $VF: renamed from: r int[]
   private int[] staticSortKeys;
   // $VF: renamed from: s int
   private int maxStaticExtent;
   // $VF: renamed from: t boolean
   private boolean staticNeedsSort;
   // $VF: renamed from: u boolean
   private boolean sortByY;
   // $VF: renamed from: v int[]
   private int[] visibleScratch;
   // $VF: renamed from: w c[]
   private Sprite[] objSprites;
   // $VF: renamed from: x int[]
   private int[] objPos;
   // $VF: renamed from: y short[]
   private short[] objNext;
   // $VF: renamed from: z short[]
   private short[] objPrev;
   // $VF: renamed from: A int
   private int objHead;
   // $VF: renamed from: B int
   private int objTail;
   // $VF: renamed from: C int
   private int objFree;
   // $VF: renamed from: D boolean
   private boolean objectsOnly;

   // $VF: renamed from: a (int, int) b
   public static Scene create(int var0, int var1) {
      return new Scene(false, false, var0, var1);
   }

   private Scene(boolean var1, boolean var2, int var3, int var4) {
      this.buffered = var1;
      this.viewWidth = var3;
      this.viewHeight = var4;
      if (var1 && this.buffer == null) {
         this.buffer = Image.createImage(var3, var4);
         this.buffer.getGraphics();
      }

      this.noTileSheet = var2;
      this.initObjects(0);
   }

   // $VF: renamed from: b (int, int) void
   public final void setScroll(int var1, int var2) {
      this.scrollX = var1;
      this.scrollY = var2;
   }

   public final void setViewWidth(int var1) {
      this.viewWidth = var1;
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics) void
   public final void draw(Graphics var1) {
      if (!this.buffered) {
         this.drawViewport(var1);
      }
   }

   // $VF: renamed from: b (javax.microedition.lcdui.Graphics) void
   private void drawViewport(Graphics var1) {
      int var3 = this.scrollX;
      int var4 = this.scrollY;
      int var5 = 0;
      int var6 = 0;
      int var7 = this.viewWidth;
      int var8 = this.viewHeight;
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
         this.drawLayers(var1, var3, var4, var5, var6, var7, var8);
      }
   }

   // $VF: renamed from: a (javax.microedition.lcdui.Graphics, int, int, int, int, int, int) void
   private void drawLayers(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (!this.objectsOnly) {
         if (this.tileMap != null) {
            this.drawTiles(var1, var2, var3, var4, var5, var6, var7);
         }

         if (this.staticCount > 0) {
            this.drawStaticSprites(var2, var3, var4, var5, var6, var7, var1);
         }
      }

      if (this.objHead >= 0) {
         this.drawObjects(var2, var3, var4, var5, var6, var7, this.objectsOnly, var1);
      }
   }

   // $VF: renamed from: b (javax.microedition.lcdui.Graphics, int, int, int, int, int, int) void
   private void drawTiles(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8;
      int var9 = (var8 = (var2 + var6 - 1) / this.tileWidth) - var2 / this.tileWidth;
      int var10 = (var3 + var7 - 1) / this.tileHeight;
      var8 += var10 * this.mapCols;
      var10 -= var3 / this.tileHeight;
      var2 %= this.tileWidth;
      var3 %= this.tileHeight;
      int var11 = var2;
      int var12 = var3;
      int var13;
      if ((var13 = -(var2 + var6) % this.tileWidth) < 0) {
         var13 += this.tileWidth;
      }

      int var14;
      if ((var14 = -(var3 + var7) % this.tileHeight) < 0) {
         var14 += this.tileHeight;
      }

      var2 = var4 - var2 + this.tileWidth * var9;
      var3 = var5 - var3 + this.tileHeight * var10;

      for (int var25 = var10; var25 >= 0; var25--) {
         for (int var24 = var9; var24 >= 0; var24--) {
            int var15;
            if ((var15 = this.tileMap[var8--] & 4095) > 0) {
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

               if (!this.noTileSheet) {
                  var1.drawRegion(
                     this.tileSheet,
                     this.tileSrcX[var15] + var4,
                     this.tileSrcY[var15] + var5,
                     this.tileWidth - var4 - var16,
                     this.tileHeight - var5 - var17,
                     0,
                     var2 + var4,
                     var3 + var5,
                     20
                  );
               }
            }

            var2 -= this.tileWidth;
         }

         var8 += 1 + var9 - this.mapCols;
         var2 += this.tileWidth * (var9 + 1);
         var3 -= this.tileHeight;
      }
   }

   // $VF: renamed from: a (int, int, javax.microedition.lcdui.Image, int, int) void
   public final void setTileMap(int var1, int var2, Image var3, int var4, int var5) {
      this.clearTileMap();
      this.mapCols = var1;
      this.tileMap = new short[var1 * var2];
      this.tileWidth = var4;
      this.tileHeight = var5;
      var4 = var3.getWidth();
      var5 = var3.getHeight();
      int var6 = var4 / this.tileWidth * (var5 / this.tileHeight);
      var4 -= this.tileWidth;
      var5 -= this.tileHeight;
      if (!this.noTileSheet) {
         this.tileSheet = var3;
         this.tileSrcX = new char[var6];
         this.tileSrcY = new char[var6];
         int var7 = 0;

         for (int var8 = 0; var8 <= var5; var8 += this.tileHeight) {
            for (int var9 = 0; var9 <= var4; var9 += this.tileWidth) {
               this.tileSrcX[var7] = (char)var9;
               this.tileSrcY[var7] = (char)var8;
               var7++;
            }
         }
      }
   }

   // $VF: renamed from: a () void
   private void clearTileMap() {
      this.tileMap = null;
      if (!this.noTileSheet) {
         this.tileSheet = null;
         this.tileSrcX = null;
         this.tileSrcY = null;
      }
   }

   // $VF: renamed from: a (int, int, int) void
   public final void setTile(int var1, int var2, int var3) {
      this.tileMap[var2 * this.mapCols + var1] = (short)var3;
   }

   // $VF: renamed from: a (int, boolean) void
   public final void initStaticSprites(int var1, boolean var2) {
      this.staticCount = 0;
      this.staticSprites = null;
      this.staticPos = null;
      this.staticSortKeys = null;
      this.maxStaticExtent = 0;
      this.staticNeedsSort = true;
      this.visibleScratch = null;
      if (var1 > 0) {
         this.sortByY = var2;
         this.staticSprites = new Sprite[var1];
         this.staticPos = new int[var1];
         this.staticSortKeys = new int[var1];
         this.visibleScratch = new int[var1];
      }
   }

   // $VF: renamed from: a (c, int, int, int) void
   public final void addStaticSprite(Sprite var1, int var2, int var3, int var4) {
      this.staticSprites[this.staticCount] = var1;
      var2 += var1.anchorOffsetX(var4);
      var3 += var1.anchorOffsetY(var4);
      this.staticPos[this.staticCount] = var2 << 17 | var3 << 17 >>> 15 | var4;
      this.staticSortKeys[this.staticCount] = (this.sortByY ? var3 : var2) << 16 | this.staticCount;
      this.maxStaticExtent = Math.max(this.maxStaticExtent, this.sortByY ? var1.height : var1.width);
      this.staticCount++;
   }

   // $VF: renamed from: a (int, int, int, int, int, int, javax.microedition.lcdui.Graphics) void
   private void drawStaticSprites(int var1, int var2, int var3, int var4, int var5, int var6, Graphics var7) {
      int var8 = var7.getClipX();
      int var9 = var7.getClipY();
      int var10 = var7.getClipWidth();
      int var11 = var7.getClipHeight();
      var7.setClip(var3, var4, var5, var6);
      if (this.staticNeedsSort) {
         Engine.sortInts(this.staticSortKeys, this.staticCount);
         this.staticNeedsSort = false;
      }

      var5 += var1;
      var6 += var2;
      int var12 = this.sortByY ? var6 : var5;
      int var16 = 0;

      int var13;
      for (int var18 = Engine.binarySearch(this.staticSortKeys, this.staticCount - 1, (this.sortByY ? var2 : var1) - this.maxStaticExtent << 16);
         var18 < this.staticCount && (var13 = this.staticSortKeys[var18]) >> 16 < var12;
         var18++
      ) {
         var13 &= 65535;
         int var15;
         int var14 = (var15 = this.staticPos[var13]) >> 17;
         var15 = (short)(var15 >> 1) >> 1;
         Sprite var17;
         if (var14 < var5 && var15 < var6 && var1 < var14 + (var17 = this.staticSprites[var13]).width && var2 < var15 + var17.height) {
            this.visibleScratch[var16++] = var13;
         }
      }

      Engine.sortInts(this.visibleScratch, var16);
      var1 -= var3;
      var2 -= var4;

      for (int var23 = 0; var23 < var16; var23++) {
         var13 = this.visibleScratch[var23];
         Sprite var29 = this.staticSprites[var13];
         int var26;
         int var28 = (var26 = this.staticPos[var13]) & 3;
         var29.draw(var7, (var26 >> 17) - var29.anchorOffsetX(var28) - var1, ((short)(var26 >> 1) >> 1) - var29.anchorOffsetY(var28) - var2, var28);
      }

      var7.setClip(var8, var9, var10, var11);
   }

   // $VF: renamed from: a (int) void
   public final void initObjects(int var1) {
      this.objSprites = null;
      this.objPos = null;
      this.objNext = null;
      this.objPrev = null;
      this.objHead = -1;
      this.objTail = -1;
      this.objFree = -1;
      if (var1 > 0) {
         this.objSprites = new Sprite[var1];
         this.objPos = new int[var1];
         this.objNext = new short[var1];
         int var2 = 0;

         while (var2 < var1 - 1) {
            this.objNext[var2++] = (short)var2;
         }

         this.objNext[var1 - 1] = -1;
         this.objPrev = new short[var1];
         this.objFree = 0;
      }
   }

   // $VF: renamed from: b (c, int, int, int) int
   public final int addObject(Sprite var1, int var2, int var3, int var4) {
      int var5 = this.objFree;
      this.objFree = this.objNext[var5];
      if (this.objHead < 0) {
         this.objHead = var5;
      } else {
         this.objNext[this.objTail] = (short)var5;
      }

      this.objNext[var5] = -1;
      this.objPrev[var5] = (short)this.objTail;
      this.objTail = var5;
      this.objSprites[var5] = var1;
      var2 += var1.anchorOffsetX(var4);
      var3 += var1.anchorOffsetY(var4);
      this.objPos[var5] = var2 << 17 | var3 << 17 >>> 15 | var4;
      return var5;
   }

   // $VF: renamed from: a (int, int, int, int, int, int, boolean, javax.microedition.lcdui.Graphics) void
   private void drawObjects(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, Graphics var8) {
      int var9 = var8.getClipX();
      int var10 = var8.getClipY();
      int var11 = var8.getClipWidth();
      int var12 = var8.getClipHeight();
      var8.setClip(var3, var4, var5, var6);
      int var13 = 0;
      if (!var7 && !this.buffered) {
         var13 = this.objHead;
      }

      int var14 = 0;
      var5 += var1;
      var6 += var2;
      int var17 = var1 - var3;
      int var18 = var2 - var4;

      while (var13 >= 0) {
         var14 = var13;
         var13 = this.objNext[var13];
         int var16;
         var3 = (var16 = this.objPos[var14]) >> 17;
         var4 = (short)(var16 >> 1) >> 1;
         Sprite var15;
         if (var3 < var5 && var4 < var6 && var1 < var3 + (var15 = this.objSprites[var14]).width && var2 < var4 + var15.height) {
            var16 &= 3;
            var15.draw(var8, var3 - var15.anchorOffsetX(var16) - var17, var4 - var15.anchorOffsetY(var16) - var18, var16);
         }
      }

      var8.setClip(var9, var10, var11, var12);
   }
}
