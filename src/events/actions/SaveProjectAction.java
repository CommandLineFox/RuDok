package events.actions;

import components.Node;
import components.Project;
import gui.MainFrame;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;
import utils.serialize.save.SaveNode;

import java.awt.event.ActionEvent;

public class SaveProjectAction extends Action {
    public SaveProjectAction() {
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save currently selected project");
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

        SaveNode saveNode = new SaveNode((Project) node);
        saveNode.save();
    }
}
