package events.actions;

import utils.command.CommandManager;
import utils.command.NewCommand;
import gui.MainFrame;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends Action {
    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("new.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "Creates a new node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object component = MainFrame.getInstance().getTreePanel().getSelectedPath();

        if (component == null) {
            ErrorFactory.getInstance().createError(ErrorType.ADD_CHILD_TO_NOTHING);
            return;
        }

        CommandManager.getInstance().addCommand(new NewCommand((TreeNode) component));
    }
}
