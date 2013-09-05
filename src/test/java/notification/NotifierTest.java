package notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import notification.Notifier.UnsupportedProtocol;

import org.junit.Test;

public class NotifierTest {
    SmsConnector smsConnector = mock(SmsConnector.class);
    EmailApi emailApi = mock(EmailApi.class);
    Notifier notifier = new Notifier(smsConnector, emailApi);
    

    @Test public void 
    does_nothing_when_there_is_no_protocol() throws Exception {
        notifier.notify("");
        
        verifyZeroInteractions(smsConnector );
        verifyZeroInteractions(emailApi);
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
        verify(smsConnector).send(phone, "Bonjour");
    }

    @Test public void 
    sends_emails_to_email_api() throws Exception {
        String protocol = "email";
        String address = "me@my.home";
        String subject = "Whats new?";
        String messageBody = "Hi, how are you? What have you been up to?";
        notifier.notify(protocol + Notifier.SEPARATOR + 
                address + Notifier.SEPARATOR + 
                subject + Notifier.SEPARATOR + messageBody);
        verify(emailApi).email(address, subject, messageBody);
    }

}
