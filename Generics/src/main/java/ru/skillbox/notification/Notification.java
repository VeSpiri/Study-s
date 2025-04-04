package ru.skillbox.notification;

/**
 * Уведомления для пользователей
 */
public interface Notification {
    String MESSAGE = "Thanks for registration on services!";
    /**
     * @return форматированные тело сообщений
     */
    String formattedMessage();
}
