package ru.skillbox;

import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;
import ru.skillbox.notification_sender.EmailNotificationSender;
import ru.skillbox.notification_sender.PushNotificationSender;
import ru.skillbox.notification_sender.SmsNotificationSender;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TODO: написать работу с уведомлениями и удалить эту строку
        EmailNotification emailNotification = new EmailNotification("vespiriv@gmail.com");
        EmailNotificationSender emailNotificationSender = new EmailNotificationSender();
        List<EmailNotification> emailNotificationList = new ArrayList<>();

        SmsNotification smsNotification = new SmsNotification("+79219823530");
        SmsNotificationSender smsNotificationSender = new SmsNotificationSender();
        List<SmsNotification> smsNotificationList = new ArrayList<>();

        PushNotification pushNotification = new PushNotification("v.spiridenko");
        PushNotificationSender pushNotificationSender = new PushNotificationSender();
        List<PushNotification> pushNotificationList = new ArrayList<>();

        emailNotificationList.add(new EmailNotification("yileuttimeupri-1884@yopmail.com"));
        emailNotificationList.add(new EmailNotification("queissaunejouvu-4111@yopmail.com"));

        smsNotificationList.add(new SmsNotification("89219800089"));
        smsNotificationList.add(new SmsNotification("89217423120"));

        pushNotificationList.add(new PushNotification("o.ivan"));
        pushNotificationList.add(new PushNotification("p.petr"));

        emailNotificationSender.send(emailNotification);
        smsNotificationSender.send(smsNotification);
        pushNotificationSender.send(pushNotification);

        emailNotificationSender.send(emailNotificationList);
        smsNotificationSender.send(smsNotificationList);
        pushNotificationSender.send(pushNotificationList);

    }
}
