package utils.factory;

import components.Node;
import gui.tree.TreeNode;

public abstract class AbstractNodeFactory {
    public TreeNode getNode(TreeNode component) {
        Node node;
        node = createNode(component);

        return new TreeNode(node);
    }

    public abstract Node createNode(TreeNode component);
}
