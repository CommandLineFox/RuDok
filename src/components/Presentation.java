package components;

import utils.factory.NodeChildType;
import utils.observer.NotificationType;

import java.util.ArrayList;
import java.util.List;

public class Presentation extends NodeComposite {
    private String author;
    private String background;
    private final List<Project> shared;

    public Presentation(Node parent, String name) {
        super(parent, name);
        shared = new ArrayList<>();
        author = "";
        background = "src/assets/default.png";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Override
    public void addChild(Node child) {
        if (child instanceof Slide && !children.contains(child)) {
            children.add(child);

            notifySubscribers(child, NotificationType.CHILD_ADDED);
            setChanged(true);
        }
    }

    public void addShared(Project project) {
        if (shared.contains(project)) {
            return;
        }

        shared.add(project);
    }

    @Override
    public NodeChildType getChildType() {
        return NodeChildType.SLIDE;
    }
}
