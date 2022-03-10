package components;

import utils.factory.NodeChildType;
import utils.observer.NotificationType;

public class Project extends NodeComposite {
    public Project(Node parent, String name) {
        super(parent, name);
    }

    @Override
    public void addChild(Node child) {
        if (child instanceof Presentation && !children.contains(child)) {
            children.add(child);

            notifySubscribers(child, NotificationType.CHILD_ADDED);
            setChanged(true);
        }
    }

    @Override
    public NodeChildType getChildType() {
        return NodeChildType.PRESENTATION;
    }
}
