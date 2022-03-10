package utils.command;

import utils.factory.AbstractNodeFactory;
import utils.factory.NodeFactory;
import gui.MainFrame;
import gui.tree.TreeNode;

import javax.swing.*;

public class NewCommand extends Command {
    private final TreeNode parentNode;
    private TreeNode component;

    public NewCommand(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public void doAction() {
        AbstractNodeFactory nodeFactory = NodeFactory.getFactory(parentNode);
        if (nodeFactory == null) {
            return;
        }

        if (component == null) {
            component = nodeFactory.getNode(parentNode);
        }

        parentNode.add(component);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
    }

    @Override
    public void undoAction() {
        int index = parentNode.getIndex(component);
        parentNode.remove(index);

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
    }
}
