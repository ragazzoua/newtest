package i.ua.test;

public class Email {
    private final String to;
    private final String subject;
    private final String emailText;

    public Email(String to, String subject, String emailText) {
        this.to = to;
        this.subject = subject;
        this.emailText = emailText;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmailText() {
        return emailText;
    }
}
