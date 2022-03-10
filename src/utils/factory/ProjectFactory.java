package utils.factory;

import components.Node;
import components.Project;
import gui.tree.TreeNode;

public class ProjectFactory extends AbstractNodeFactory {
    @Override
    public Node createNode(TreeNode component) {
        return new Project(component.getNode(), "New Project");
    }
}
