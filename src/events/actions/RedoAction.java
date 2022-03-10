package events.actions;

import utils.command.CommandManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends Action {
    public RedoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo an action");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager.getInstance().redo();
    }
}
