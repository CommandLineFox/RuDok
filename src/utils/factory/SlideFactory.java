package utils.factory;

import components.Node;
import components.Slide;
import gui.tree.TreeNode;

public class SlideFactory extends AbstractNodeFactory {

    @Override
    public Node createNode(TreeNode component) {
        return new Slide(component.getNode(), "New Slide");
    }
}
