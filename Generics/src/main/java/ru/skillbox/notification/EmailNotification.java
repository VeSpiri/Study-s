package ru.skillbox.notification;
import lombok.RequiredArgsConstructor;
import lombok.Getter;

@RequiredArgsConstructor
@Getter
public class EmailNotification implements Notification{
    private static final String SUBJECT = "Successful registration!";
    private final String receiver;
    @Override
    public String formattedMessage() {
            return "Email" +
                    "\nsubject: " + SUBJECT +
                    "\nreceivers: " + receiver +
                    "\n<p>" + MESSAGE + "</p>";
    }
}
