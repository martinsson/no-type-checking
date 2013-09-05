package notification;

public class Notifier {

    public static final String SEPARATOR = ":";
    private SmsConnector smsConnector;
    private EmailApi emailApi;

    public Notifier(SmsConnector smsConnector, EmailApi emailApi) {
        this.smsConnector = smsConnector;
        this.emailApi = emailApi;
    }

    public void notify(String message) throws UnsupportedProtocol {
        if (message.isEmpty())
            return;
        String[] split = message.split(SEPARATOR);
        if (split[0].equals("mobile")) {
            smsConnector.send(split[1], split[2]);
        } else if (split[0].equals("email")) {
            emailApi.email(split[1], split[2], split[3]);
        } else
            throw new UnsupportedProtocol(message);
    }

    @SuppressWarnings("serial")
    public class UnsupportedProtocol extends Exception {

        public UnsupportedProtocol(String message) {
            super(message);
        }

    }

}
