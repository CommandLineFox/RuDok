package gui.tree;

import components.Node;
import components.NodeComposite;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class TreeNode extends DefaultMutableTreeNode {
    private final Node node;

    public TreeNode(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    @Override
    public void add(MutableTreeNode newChild) {
        super.add(newChild);

        Node child = ((TreeNode) newChild).getNode();
        NodeComposite parent = (NodeComposite) child.getParent();

        parent.addChild(((TreeNode) newChild).getNode());
    }

    @Override
    public void remove(int childIndex) {
        TreeNode component = (TreeNode) children.get(childIndex);
        super.remove(childIndex);
        ((NodeComposite) node).removeChild(component.getNode());
    }

    @Override
    public String toString() {
        return node.getName();
    }
}
