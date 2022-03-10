package components;

import java.util.ArrayList;
import java.util.List;

public class Slide extends Node {
    private final List<Slot> slots;

    public Slide(Node parent, String name) {
        super(parent, name);
        slots = new ArrayList<>();
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void addSlot(Slot slot) {
        if (slots.contains(slot)) {
            return;
        }

        slots.add(slot);
        setChanged(true);
    }

    public void removeSlot(Slot slot) {
        slots.remove(slot);
    }
}
