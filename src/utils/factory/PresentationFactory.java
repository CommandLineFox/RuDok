package utils.factory;

import components.Node;
import components.Presentation;
import gui.tree.TreeNode;

public class PresentationFactory extends AbstractNodeFactory {

    @Override
    public Node createNode(TreeNode component) {
        return new Presentation(component.getNode(), "New Presentation");
    }
}
