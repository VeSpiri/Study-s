package ru.skillbox.notification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PushNotification implements Notification{
    private final String receiver;
    private static final String TITLE = "Successful registration!";
    @Override
    public String formattedMessage() {
        return "PUSH" +
                "\ntitle: " + TITLE +
                "\nreceiver: " + receiver +
                "\n\uD83D\uDC4B" + MESSAGE;
    }
}
