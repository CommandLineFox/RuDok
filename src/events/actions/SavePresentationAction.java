package events.actions;

import components.Node;
import components.Presentation;
import gui.MainFrame;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;
import utils.serialize.save.SaveNode;

import java.awt.event.ActionEvent;

public class SavePresentationAction extends Action {
    public SavePresentationAction() {
        putValue(NAME, "Save presentation");
        putValue(SHORT_DESCRIPTION, "Save currently selected presentation");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object path = MainFrame.getInstance().getTreePanel().getSelectedPath();
        if (path == null) {
            ErrorFactory.getInstance().createError(ErrorType.NO_PRESENTATION_SELECTED);
            return;
        }

        Node node = ((TreeNode) path).getNode();
        if (!(node instanceof Presentation)) {
            ErrorFactory.getInstance().createError(ErrorType.NO_PRESENTATION_SELECTED);
            return;
        }

        SaveNode saveNode = new SaveNode((Presentation) node);
        saveNode.save();
    }
}
