package ru.skillbox.notification_sender;

import ru.skillbox.notification.SmsNotification;
import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {
    @Override
    public void send(SmsNotification notification) {
        System.out.println(notification.formattedMessage());
    }
    @Override
    public void send(List<SmsNotification> notifications) {
        StringBuilder receivers = new StringBuilder();
        for (SmsNotification notification : notifications) {
            receivers.append(notification.getReceiver()).append(", ");
        }
        receivers.replace(receivers.length() - 2, receivers.length(), "");
        SmsNotification smsNotification = new SmsNotification(receivers.toString());
        send(smsNotification);
    }
}
