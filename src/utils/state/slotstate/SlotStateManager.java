package utils.state.slotstate;

public class SlotStateManager {
    private SlotState currentState;
    private final AddSlotState addSlotState;
    private final DeleteSlotState deleteSlotState;
    private final MoveSlotState moveSlotState;

    public SlotStateManager() {
        addSlotState = new AddSlotState();
        deleteSlotState = new DeleteSlotState();
        moveSlotState = new MoveSlotState();

        currentState = addSlotState;
    }

    public SlotState getCurrentState() {
        return currentState;
    }

    public void setAddSlotState() {
        currentState = addSlotState;
    }

    public void setDeleteSlotState() {
        currentState = deleteSlotState;
    }

    public void setMoveSlotState() {
        currentState = moveSlotState;
    }
}
