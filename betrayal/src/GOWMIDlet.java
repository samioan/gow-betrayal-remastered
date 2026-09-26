import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class GOWMIDlet extends MIDlet {
   // $VF: renamed from: a a
   private Engine game;

   public void startApp() {
      if (this.game == null) {
         this.game = new Game(this);
         Display.getDisplay(this).setCurrent(this.game);
      } else {
         this.game.showNotify();
      }
   }

   public void destroyApp(boolean var1) {
      this.game.postLifecycle(3);
   }

   public void pauseApp() {
      this.game.hideNotify();
   }
}
