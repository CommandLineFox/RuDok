package utils.state.slotstate;

import components.Slide;
import components.Slot;

public class AddSlotState extends SlotState {
    @Override
    public void mousePressed(int x, int y, Slide slide) {
        Slot slot = new Slot(x, y);
        
    }
}
