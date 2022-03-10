package components;

import utils.factory.NodeChildType;

public class Workspace extends NodeComposite {
    public Workspace(String name) {
        super(null, name);
    }

    @Override
    public void addChild(Node child) {
        if (child instanceof Project && !children.contains(child)) {
            children.add(child);

            setChanged(true);
        }
    }

    @Override
    public NodeChildType getChildType() {
        return NodeChildType.PROJECT;
    }
}
