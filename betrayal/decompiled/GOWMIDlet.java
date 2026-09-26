import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class GOWMIDlet extends MIDlet {
   private a a;

   public void startApp() {
      if (this.a == null) {
         this.a = new e(this);
         Display.getDisplay(this).setCurrent(this.a);
      } else {
         this.a.showNotify();
      }
   }

   public void destroyApp(boolean var1) {
      this.a.j(3);
   }

   public void pauseApp() {
      this.a.hideNotify();
   }
}
