package gui.tree;

import javax.swing.tree.DefaultTreeModel;

public class FileTreeModel extends DefaultTreeModel {
    private final TreeNode treeNode;

    public FileTreeModel(TreeNode treeNode) {
        super(treeNode);
        this.treeNode = treeNode;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }
}
