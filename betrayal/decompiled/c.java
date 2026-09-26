import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class c {
   private Image k;
   public short a;
   public short b;
   public short c;
   public short d;
   public short e;
   public short f;
   public short g;
   public short h;
   public short i;
   public short j;

   public c(Image var1) {
      this.k = var1;
   }

   public final void a(short[] var1) {
      this.a = var1[0];
      this.b = var1[1];
      this.i = var1[2];
      this.j = var1[3];
      this.c = var1[4];
      this.d = var1[5];
      this.e = var1[6];
      this.f = var1[7];
      this.g = var1[8];
      this.h = var1[9];
   }

   public final void a(Graphics var1, int var2, int var3, int var4) {
      var2 += (var4 & 2) == 0 ? this.a : -(this.a + this.c);
      var3 += (var4 & 1) == 0 ? this.b : -(this.b + this.d);
      int var5 = this.c;
      int var6 = this.d;
      short var7 = this.i;
      short var8 = this.j;
      if (var7 < 0) {
         var5 += var7;
         var2 += var7;
         var7 = 0;
      }

      if (var8 < 0) {
         var6 += var8;
         var3 += var8;
         var8 = 0;
      }

      int var9;
      if ((var9 = var7 + var5 - this.k.getWidth()) > 0) {
         var5 -= var9;
      }

      if ((var9 = var8 + var6 - this.k.getHeight()) > 0) {
         var6 -= var9;
      }

      if (var5 > 0 && var6 > 0) {
         var1.drawRegion(this.k, var7, var8, var5, var6, var4, var2, var3, 20);
      }
   }

   public final int a(int var1) {
      return (var1 & 2) == 0 ? this.a : -(this.a + this.c);
   }

   public final int b(int var1) {
      return (var1 & 1) == 0 ? this.b : -(this.b + this.d);
   }
}
