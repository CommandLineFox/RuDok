package components;

import utils.factory.IChildType;
import utils.factory.NodeChildType;
import utils.observer.NotificationType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class NodeComposite extends Node implements IChildType, Serializable {
    List<Node> children;

    public NodeComposite(Node parent, String name) {
        super(parent, name);
        children = new ArrayList<>();
    }

    public abstract void addChild(Node child);

    public void removeChild(Node child) {
        notifySubscribers(child, NotificationType.CHILD_REMOVED);
        children.remove(child);

        setChanged(true);
    }

    public List<Node> getChildren() {
        return children;
    }

    public int getChildCount() {
        return children.size();
    }

    public int getChildIndex(Node child) {
        for (int i = 0; i < getChildCount(); i++) {
            if (child.equals(children.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public abstract NodeChildType getChildType();
}
