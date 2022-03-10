package utils.command;

import utils.factory.AbstractNodeFactory;
import utils.factory.NodeFactory;
import gui.MainFrame;
import gui.tree.TreeNode;

import javax.swing.*;

public class DeleteCommand extends Command {
    private final TreeNode parentNode;
    private final TreeNode component;

    public DeleteCommand(TreeNode component) {
        this.component = component;
        this.parentNode = (TreeNode) component.getParent();
    }

    @Override
    public void doAction() {
        int index = parentNode.getIndex(component);
        parentNode.remove(index);

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
    }

    @Override
    public void undoAction() {
        AbstractNodeFactory nodeFactory = NodeFactory.getFactory(parentNode);
        if (nodeFactory == null) {
            return;
        }

        parentNode.add(component);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
    }
}
