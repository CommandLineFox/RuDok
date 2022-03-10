package components;

import java.awt.*;
import java.io.Serializable;

public class Slot implements Serializable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private SlotStroke stroke;

    public Slot(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.BLACK;
        this.width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 20;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
