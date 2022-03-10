package utils.factory;

import components.Node;
import components.NodeComposite;
import gui.tree.TreeNode;
import utils.error.ErrorFactory;
import utils.error.ErrorType;

public class NodeFactory {
    private static final ProjectFactory projectFactory = new ProjectFactory();
    private static final PresentationFactory presentationFactory = new PresentationFactory();
    private static final SlideFactory slideFactory = new SlideFactory();

    public static AbstractNodeFactory getFactory(TreeNode component) {
        Node parent = component.getNode();
        if (!(parent instanceof NodeComposite)) {
            ErrorFactory.getInstance().createError(ErrorType.ADD_CHILD_TO_SLIDE);
            return null;
        }

        switch (((NodeComposite) parent).getChildType()) {
            case PROJECT -> {
                return projectFactory;
            }
            case PRESENTATION -> {
                return presentationFactory;
            }
            case SLIDE -> {
                return slideFactory;
            }
            default -> {
                return null;
            }
        }
    }
}

