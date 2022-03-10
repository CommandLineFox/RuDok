package events.actions;

import components.Node;
import components.Presentation;
import components.Project;
import gui.MainFrame;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;
import utils.serialize.FileType;
import utils.serialize.open.OpenNode;

import java.awt.event.ActionEvent;

public class OpenPresentationAction extends Action {
    public OpenPresentationAction() {
        putValue(NAME, "Open presentation");
        putValue(SHORT_DESCRIPTION, "Open a saved presentation in the current project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object path = MainFrame.getInstance().getTreePanel().getSelectedPath();
        if (path == null) {
            ErrorFactory.getInstance().createError(ErrorType.NO_PROJECT_SELECTED);
            return;
        }

        Node node = ((TreeNode) path).getNode();
        if (!(node instanceof Project)) {
            ErrorFactory.getInstance().createError(ErrorType.NO_PROJECT_SELECTED);
            return;
        }

        OpenNode openNode = new OpenNode(FileType.PRESENTATION);
        openNode.open();
    }
}