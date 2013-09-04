package notification;

public class Notifier {

    public Notifier(SmsConnector smsConnector, TwitterApi twitterApi) {
        // TODO Auto-generated constructor stub
    }

    public void notify(String message) throws UnsupportedProtocol {
        if (message.isEmpty()) return;
        throw new UnsupportedProtocol(message);
    }
    
    @SuppressWarnings("serial")
    public class UnsupportedProtocol extends Exception {

        public UnsupportedProtocol(String message) {
            super(message);
        }
        
    }

}
