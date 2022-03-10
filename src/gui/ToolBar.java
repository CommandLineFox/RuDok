package gui;

import events.actions.ActionManager;

import javax.swing.*;

public class ToolBar extends JToolBar {
    public ToolBar() {
        add(ActionManager.getInstance().getNewAction());
        add(ActionManager.getInstance().getEditAction());
        add(ActionManager.getInstance().getSharePresentationAction());
        add(ActionManager.getInstance().getDeleteAction());
        add(ActionManager.getInstance().getUndoAction());
        add(ActionManager.getInstance().getRedoAction());
        add(new JSeparator());

        add(ActionManager.getInstance().getInfoAction());

        setFloatable(false);
    }
}
