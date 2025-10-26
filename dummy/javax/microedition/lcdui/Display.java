package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

public class Display {
    public static Display getDisplay(MIDlet m) {
        return new Display();
    }
    public void setCurrent(Canvas c) {}
}
