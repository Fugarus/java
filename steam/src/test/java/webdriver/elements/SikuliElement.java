package webdriver.elements;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SikuliElement {
    private final String path;
    private static Screen screen = new Screen();

    public SikuliElement(String path) {
        this.path = path;
    }

    public void drag() {
        try {
            screen.drag(path);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }

    public void dropAt() {
        try {
            screen.dropAt(path);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }

    public boolean isImagePresent() {
        try {
            screen.find(path);
            return true;
        } catch (FindFailed e) {
            return false;
        }
    }

    public void click() {
        try {
            screen.click(path);
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }
}
