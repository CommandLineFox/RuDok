package utils.observer;

public interface ISubscriber {
    void update(Object notification, NotificationType notificationType);
}
