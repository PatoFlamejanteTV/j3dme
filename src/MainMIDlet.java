import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class MainMIDlet extends MIDlet {
    private Display display;
    private CubeCanvas canvas;

    public MainMIDlet() {
        display = Display.getDisplay(this);
        canvas = new CubeCanvas();
    }

    public void startApp() {
        display.setCurrent(canvas);
        new Thread(canvas).start();
    }

    public void pauseApp() {}

    public void destroyApp(boolean unconditional) {
        canvas.stop();
    }
}
