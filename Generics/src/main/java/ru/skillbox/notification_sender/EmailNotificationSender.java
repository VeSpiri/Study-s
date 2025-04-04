package ru.skillbox.notification_sender;

import lombok.Getter;
import ru.skillbox.notification.EmailNotification;

import java.util.List;
@Getter
public class EmailNotificationSender implements NotificationSender<EmailNotification>{
    @Override
    public void send(EmailNotification notification) {
        System.out.println(notification.formattedMessage());
    }
    @Override
    public void send(List<EmailNotification> notifications) {
        StringBuilder receivers = new StringBuilder();
        for (EmailNotification notification : notifications) {
            receivers.append(notification.getReceiver()).append(", ");
        }
        receivers.replace(receivers.length() - 2, receivers.length(), "");
        EmailNotification emailNotification = new EmailNotification(receivers.toString());
        send(emailNotification);
    }
}
