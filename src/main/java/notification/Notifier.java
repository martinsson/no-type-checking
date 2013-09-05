package notification;

public class Notifier {

    public static final String SEPARATOR = ":";
    private SmsConnector smsConnector;

    public Notifier(SmsConnector smsConnector, TwitterApi twitterApi) {
        this.smsConnector = smsConnector;
    }

    public void notify(String message) throws UnsupportedProtocol {
        if (message.isEmpty()) return;
        String[] split = message.split(SEPARATOR);
        if (split[0].equals("mobile")) {
            smsConnector.send(split[1], split[2]);
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
