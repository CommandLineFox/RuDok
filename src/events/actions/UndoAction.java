package events.actions;

import utils.command.CommandManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends Action {
    public UndoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("undo.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo an action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager.getInstance().undo();
    }
}
