package notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import notification.Notifier.UnsupportedProtocol;

import org.junit.Test;

public class NotifierTest {
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
        notifier.notify(protocol + Notifier.SEPARATOR + "Bonjour");
    }
    
    //no separator
    
    @Test public void 
    sends_mobile_messages_to_sms_connector() throws Exception {
        String protocol = "mobile";
        String phone = "00654321012234";
        notifier.notify(protocol + Notifier.SEPARATOR + phone + Notifier.SEPARATOR + "Bonjour");
//        verify(smsConnector).send(phone, "Bonjour");
    }

}
