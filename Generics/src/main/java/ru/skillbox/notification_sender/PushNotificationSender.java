package ru.skillbox.notification_sender;

import ru.skillbox.notification.PushNotification;
import java.util.List;

public class PushNotificationSender implements NotificationSender<PushNotification>{
    @Override
    public void send(PushNotification notification) {
        System.out.println(notification.formattedMessage());
    }

    @Override
    public void send(List<PushNotification> notifications) {
        StringBuilder receivers = new StringBuilder();
        for (PushNotification notification : notifications) {
            receivers.append(notification.getReceiver()).append(", ");
        }
        receivers.replace(receivers.length() - 2, receivers.length(), "");
        PushNotification pushNotification  = new PushNotification(receivers.toString());
        send(pushNotification);
    }
}
