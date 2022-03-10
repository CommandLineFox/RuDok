package events.actions;

import components.Node;
import components.Presentation;
import components.Project;
import gui.MainFrame;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SharePresentationAction extends Action {
    private TreeNode current;
    private TreeNode target;

    public SharePresentationAction() {
        putValue(SMALL_ICON, loadIcon("share.png"));
        putValue(NAME, "Share");
        putValue(SHORT_DESCRIPTION, "Share a presentation to another project");

        current = null;
        target = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object path = MainFrame.getInstance().getTreePanel().getSelectedPath();
        if (path == null) {
            ErrorFactory.getInstance().createError(ErrorType.NO_PRESENTATION_SELECTED);
            return;
        }

        TreeNode node = (TreeNode) path;
        if (current == null) {
            if (!(node.getNode() instanceof Presentation)) {
                ErrorFactory.getInstance().createError(ErrorType.NO_PRESENTATION_SELECTED);
                return;
            }

            current = node;
        } else if (target == null) {
            if (!(node.getNode() instanceof Project)) {
                ErrorFactory.getInstance().createError(ErrorType.NO_PROJECT_SELECTED);
                return;
            }

            target = node;

            ((Presentation) current.getNode()).addShared((Project) target.getNode());
            TreeNode shared = new TreeNode(current.getNode());
            target.add(shared);
            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());

            current = null;
            target = null;
        }
    }
}
