package utils.error;

import gui.MainFrame;
import utils.observer.IPublisher;
import utils.observer.ISubscriber;
import utils.observer.NotificationType;

import java.util.ArrayList;
import java.util.List;

public class ErrorFactory implements IPublisher {
    List<ISubscriber> subscribers = new ArrayList<>();
    private static ErrorFactory instance;

    public ErrorFactory() {
        addSubscriber(MainFrame.getInstance());
    }

    public void createError(ErrorType errorType) {
        String message = "Something went wrong.";

        switch (errorType) {
            case ADD_CHILD_TO_NOTHING -> message = "You can't add to nothing.";
            case ADD_CHILD_TO_SLIDE -> message = "You can't add a child to a slide.";
            case DELETE_WORKSPACE -> message = "You can't delete a workspace.";
            case EMPTY_NAME -> message = "You can't put an empty name.";
            case NAME_ALREADY_EXISTS -> message = "This name already exists.";
            case NO_DELETABLE_NODE_SELECTED -> message = "You have to select something in order to delete it.";
            case NO_PRESENTATION_SELECTED -> message = "You have to select a presentation.";
            case NO_PROJECT_SELECTED -> message = "You have to select a project.";
            case NOT_EMPTY_NODE -> message = "What you're trying to delete isn't empty.";
            case OPEN_FILE -> message = "There was an error while trying to open this file.";
            case SAVE_FILE -> message = "There was an error while trying to save this file.";
            case UNDEFINED -> message = "Something went wrong.";
        }

        notifySubscribers(new Error(errorType, message), NotificationType.ERROR);
    }

    public static ErrorFactory getInstance() {
        if (instance == null) {
            instance = new ErrorFactory();
        }
        return instance;
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
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

        for (ISubscriber listener : subscribers) {
            listener.update(notification, type);
        }
    }
}
