package notification;

public class MobileMessage extends AbstractMessage {

    private String text;

    public MobileMessage(String message) {
        super(message);
        this.text = message.split(":")[2];
    }

    public String getText() {
        return text;
    }

}
