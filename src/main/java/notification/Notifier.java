package notification;


public class Notifier {

    public static final String SEPARATOR = ":";
    private static final Logger LOGGER = new Logger();
    private SmsConnector smsConnector;
    private EmailApi emailApi;

    public Notifier(SmsConnector smsConnector, EmailApi emailApi) {
        this.smsConnector = smsConnector;
        this.emailApi = emailApi;
    }

    public void notify(String message) throws UnsupportedProtocol {
        String[] split = message.split(SEPARATOR);
        if (message.isEmpty()) {
            return;
        }

        AbstractMessage msg = makeMessage(message, split);
        LOGGER.log("received message " + message.toString());
        
        if (msg instanceof MobileMessage) {
            MobileMessage mobileMessage = (MobileMessage) msg;
            handleMobileMessage(mobileMessage);
            
        } else if (msg instanceof EmailMessage) {
            EmailMessage emailMessage = (EmailMessage) msg;
            handleEmailMessage(emailMessage);
        } 
    }

    private void handleEmailMessage(EmailMessage emailMessage) {
        emailApi.email(emailMessage.getAddress(), emailMessage.getSubject(), emailMessage.getBody());
    }

    private void handleMobileMessage(MobileMessage mobileMessage) {
        smsConnector.send(mobileMessage.getAddress(), mobileMessage.getText());
    }

    private AbstractMessage makeMessage(String message, String[] split) throws UnsupportedProtocol {
        AbstractMessage msg;
        String protocol = split[0];
        if (protocol.equals("mobile")) {
            msg = new MobileMessage(message);
        } else if (protocol.equals("email")) {
            msg = new EmailMessage(message);
        } else
            throw new UnsupportedProtocol(message);
        return msg;
    }

    @SuppressWarnings("serial")
    public class UnsupportedProtocol extends Exception {

        public UnsupportedProtocol(String message) {
            super(message);
        }

    }

}
