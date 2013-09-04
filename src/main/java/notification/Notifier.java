package notification;

public class Notifier {

    public static final String SEPARATOR = ":";

    public Notifier(SmsConnector smsConnector, TwitterApi twitterApi) {
        // TODO Auto-generated constructor stub
    }

    public void notify(String message) throws UnsupportedProtocol {
        if (message.isEmpty()) return;
        String[] split = message.split(SEPARATOR);
        if (split[0].equals("mobile")) {
            
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
