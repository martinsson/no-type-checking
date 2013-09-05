package notification;

public abstract class AbstractMessage {

    private String address;

    public AbstractMessage(String message) {
        this.address = message.split(":")[1];
    }

    public String getAddress() {
        return address;
    }

}
