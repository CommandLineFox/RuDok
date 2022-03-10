package utils.command;

import gui.MainFrame;
import gui.tree.TreeNode;

import javax.swing.*;

public class RenameCommand extends Command {
    private final TreeNode component;
    private String name;
    private String oldName;

    public RenameCommand(TreeNode component, String name) {
        this.component = component;
        this.name = name;
    }

    @Override
    public void doAction() {
        oldName = component.getNode().getName();
        component.getNode().setName(name);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
    }

    @Override
    public void undoAction() {
        name = component.getNode().getName();
        component.getNode().setName(oldName);
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTreePanel());
    }
}
