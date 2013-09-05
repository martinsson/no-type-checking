package notification;

public class EmailMessage extends AbstractMessage {

    private String subject;
    private String body;

    public EmailMessage(String message) {
        super(message);
        this.subject = message.split(":")[2];
        this.body = message.split(":")[3];
    }

    public String getSubject() {
        return subject;
    }
    
    public String getBody() {
        return body;
    }

}
