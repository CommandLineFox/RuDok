package events.actions;

import utils.command.CommandManager;
import utils.command.DeleteCommand;
import components.Node;
import components.NodeComposite;
import components.Workspace;
import utils.error.ErrorFactory;
import utils.error.ErrorType;
import gui.MainFrame;
import gui.tree.TreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends Action {
    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, KeyEvent.CTRL_DOWN_MASK));
        putValue(SMALL_ICON, loadIcon("delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Deletes a node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object component = MainFrame.getInstance().getTreePanel().getSelectedPath();

        if (component == null) {
            ErrorFactory.getInstance().createError(ErrorType.NO_DELETABLE_NODE_SELECTED);
            return;
        }

        Node node = ((TreeNode) component).getNode();
        if (node instanceof Workspace) {
            ErrorFactory.getInstance().createError(ErrorType.DELETE_WORKSPACE);
            return;
        }

        if (node instanceof NodeComposite && ((NodeComposite) node).getChildCount() > 0) {
            ErrorFactory.getInstance().createError(ErrorType.NOT_EMPTY_NODE);
            return;
        }

        CommandManager.getInstance().addCommand(new DeleteCommand((TreeNode) component));
        MainFrame.getInstance().getTreePanel().setSelectedPath(null);
    }
}
