package notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import notification.Notifier.UnsupportedProtocol;

import org.junit.Test;

public class NotifierTest {
    private static final String SEPARATOR = ":";
    SmsConnector smsConnector = mock(SmsConnector.class);
    TwitterApi twitterApi = mock(TwitterApi.class);
    Notifier notifier = new Notifier(smsConnector, twitterApi);
    

    @Test public void 
    does_nothing_when_there_is_no_protocol() throws Exception {
        notifier.notify("");
        
        verifyZeroInteractions(smsConnector );
        verifyZeroInteractions(twitterApi);
    }
    
    @Test(expected=UnsupportedProtocol.class) public void 
    throws_UnsupportedProtocol_for_unknown_protocols() throws Exception {
        String protocol = "blabla";
        notifier.notify(protocol + SEPARATOR + "Bonjour");
    }

}
