package utils.state.slidestate;

public class SlideStateManager {
    private IState currentState;
    private StateType currentStateType;
    private final EditState editState;
    private final SlideShowState slideShowState;

    public SlideStateManager() {
        editState = new EditState();
        slideShowState = new SlideShowState();

        currentState = editState;
        currentStateType = StateType.EDIT;
    }

    public StateType getCurrentStateType() {
        return currentStateType;
    }

    public void setEditState() {
        currentState = editState;
        currentStateType = StateType.EDIT;
        currentState.changeState();
    }

    public void setSlideShowState() {
        currentState = slideShowState;
        currentStateType = StateType.SLIDESHOW;
        currentState.changeState();
    }
}
