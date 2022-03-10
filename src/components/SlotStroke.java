package components;

import java.awt.*;
import java.io.Serializable;

public class SlotStroke implements Stroke, Serializable {
    @Override
    public Shape createStrokedShape(Shape p) {
        return p;
    }
}
