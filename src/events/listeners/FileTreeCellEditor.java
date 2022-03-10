package events.listeners;

import utils.command.CommandManager;
import utils.command.RenameCommand;
import components.Node;
import components.NodeComposite;
import components.Workspace;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;

public class FileTreeCellEditor extends DefaultTreeCellEditor {
    private TreeNode treeNode = null;

    public FileTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree tree, Object treeNode, boolean isSelected, boolean expanded, boolean leaf, int row) {
        super.getTreeCellEditorComponent(tree, treeNode, isSelected, expanded, leaf, row);
        this.treeNode = (TreeNode) treeNode;
        JTextField editField = new JTextField(((TreeNode) treeNode).getNode().getName());
        editField.addActionListener(this);
        return editField;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent) {
            return ((MouseEvent) arg0).getClickCount() == 3;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("")) {
            ErrorFactory.getInstance().createError(ErrorType.EMPTY_NAME);
            return;
        }

        Node node = treeNode.getNode();
        if (node instanceof Workspace) {
            return;
        }

        Node parent = node.getParent();
        List<Node> children = ((NodeComposite) parent).getChildren();
        for (Node child : children) {
            if (child.getName().equals(e.getActionCommand())) {
                ErrorFactory.getInstance().createError(ErrorType.NAME_ALREADY_EXISTS);
                return;
            }
        }

        CommandManager.getInstance().addCommand(new RenameCommand(treeNode, e.getActionCommand()));
    }
}
