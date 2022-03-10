package events.actions;

public class ActionManager {
    private static ActionManager instance = null;
    private final AddSlotAction addSlotAction;
    private final ChangeSlideAction changeSlideAction;
    private final DeleteAction deleteAction;
    private final DeleteSlotAction deleteSlotAction;
    private final EditAction editAction;
    private final ExitAction exitAction;
    private final InfoAction infoAction;
    private final MoveSlotAction moveSlotAction;
    private final NewAction newAction;
    private final OpenPresentationAction openPresentationAction;
    private final OpenProjectAction openProjectAction;
    private final OpenWorkspaceAction openWorkspaceAction;
    private final RedoAction redoAction;
    private final SavePresentationAction savePresentationAction;
    private final SaveProjectAction saveProjectAction;
    private final SaveWorkspaceAction saveWorkspaceAction;
    private final SharePresentationAction sharePresentationAction;
    private final UndoAction undoAction;

    public ActionManager() {
        this.addSlotAction = new AddSlotAction();
        this.changeSlideAction = new ChangeSlideAction();
        this.deleteAction = new DeleteAction();
        this.deleteSlotAction = new DeleteSlotAction();
        this.editAction = new EditAction();
        this.exitAction = new ExitAction();
        this.infoAction = new InfoAction();
        this.moveSlotAction = new MoveSlotAction();
        this.newAction = new NewAction();
        this.openPresentationAction = new OpenPresentationAction();
        this.openProjectAction = new OpenProjectAction();
        this.openWorkspaceAction = new OpenWorkspaceAction();
        this.redoAction = new RedoAction();
        this.savePresentationAction = new SavePresentationAction();
        this.saveProjectAction = new SaveProjectAction();
        this.saveWorkspaceAction = new SaveWorkspaceAction();
        this.sharePresentationAction = new SharePresentationAction();
        this.undoAction = new UndoAction();
    }

    public static ActionManager getInstance() {
        if (instance == null) {
            instance = new ActionManager();
        }
        return instance;
    }

    public AddSlotAction getAddSlotAction() {
        return addSlotAction;
    }

    public ChangeSlideAction getChangeSlideAction() {
        return changeSlideAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public MoveSlotAction getMoveSlotAction() {
        return moveSlotAction;
    }

    public NewAction getNewAction() {
        return newAction;
    }

    public OpenPresentationAction getOpenPresentationAction() {
        return openPresentationAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public OpenWorkspaceAction getOpenWorkspaceAction() {
        return openWorkspaceAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public SavePresentationAction getSavePresentationAction() {
        return savePresentationAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }

    public SharePresentationAction getSharePresentationAction() {
        return sharePresentationAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }
}
