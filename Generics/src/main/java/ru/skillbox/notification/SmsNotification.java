package ru.skillbox.notification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SmsNotification implements Notification {
    private final String receiver;
    @Override
    public String formattedMessage() {
        return "SMS" +
                "\nreceiver: " + receiver +
                "\nmessage: " + MESSAGE;
    }
}
