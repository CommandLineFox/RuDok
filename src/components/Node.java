package components;

import utils.observer.IPublisher;
import utils.observer.ISubscriber;
import utils.observer.NotificationType;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Node implements IPublisher, Serializable {
    private transient List<ISubscriber> subscribers;
    private Node parent;
    private String name;
    private File file;
    private transient boolean changed;

    public Node(Node parent, String name) {
        this.subscribers = new ArrayList<>();
        this.parent = parent;
        this.name = name;
        this.file = null;
        this.changed = false;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        if (this.changed && changed) {
            return;
        }

        this.changed = changed;
        setName((changed ? "* " : "") + name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;

        notifySubscribers(this, NotificationType.UPDATED);
        if (!isChanged()) {
            setChanged(true);
        }
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if (subscriber == null) {
            return;
        }
        if (this.subscribers == null) {
            this.subscribers = new ArrayList<>();
        }
        if (this.subscribers.contains(subscriber)) {
            return;
        }

        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        if (subscriber == null || this.subscribers == null || !this.subscribers.contains(subscriber))
            return;
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(Object notification, NotificationType type) {
        if (subscribers == null || subscribers.isEmpty()) {
            return;
        }

        for (ISubscriber subscriber : subscribers) {
            subscriber.update(notification, type);
        }
    }
}
