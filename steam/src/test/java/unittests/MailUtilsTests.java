package unittests;

import junit.framework.Assert;
import org.testng.annotations.Test;
import webdriver.Logger;
import webdriver.utils.MailUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtilsTests {

    private static final String GMAIL_COM = "gmail.com";
    private static final String GMAIL_PASS = "testInCrowd123456";
    private static final String GMAIL_LOGIN = "testincrowd@gmail.com";
    private static final String MAILRU_LOGIN = "ivahkog@mail.ru";
    private static final String MAILRU_PASS = "qwaszx@1";
    private static final String RAMBLERRU_LOGIN = "ivashkogg@rambler.ru";
    private static final String RAMBLERRU_PASS = "qwaszx@1";
    private static Logger logger = Logger.getInstance();
    private static final String SUBJECT = "Hello ivashko!";
    private static final String BODY = "Body of email";
    private static final String INBOX = "INBOX";


    @Test
    public void testMailUtilsGmail() throws MessagingException {
        MailUtils m = new MailUtils(GMAIL_LOGIN, GMAIL_PASS);
        m.deleteAllMessages(INBOX);
        sendEmail(GMAIL_LOGIN, GMAIL_LOGIN, GMAIL_PASS, SUBJECT, BODY);
        waitAndAsserMessage(m);
    }

    @Test
    public void testMailUtilsMailRu() throws MessagingException {
        MailUtils m = new MailUtils(MAILRU_LOGIN, MAILRU_PASS);
        m.deleteAllMessages(INBOX);
        sendEmail(MAILRU_LOGIN, GMAIL_LOGIN, GMAIL_PASS, SUBJECT, BODY);
        waitAndAsserMessage(m);
    }

    @Test(enabled = false)
    public void testMailUtilsRamblerRu() throws MessagingException {
        MailUtils m = new MailUtils(RAMBLERRU_LOGIN, RAMBLERRU_PASS);
        m.deleteAllMessages(INBOX);
        sendEmail(RAMBLERRU_LOGIN, GMAIL_LOGIN, GMAIL_PASS, SUBJECT, BODY);
        waitAndAsserMessage(m);
    }


    @Test
    public void testMailUtilsInitBy2Strings() {
        MailUtils m = new MailUtils(GMAIL_LOGIN, GMAIL_PASS);
        Assert.assertTrue(m.isConnected());
    }

    @Test
    public void testMailUtilsInitBy3Strings() {
        String gMailAccountLogin = GMAIL_LOGIN.split("@")[0];
        MailUtils m = new MailUtils(GMAIL_COM, gMailAccountLogin, GMAIL_PASS);
        Assert.assertTrue(m.isConnected());
    }

    @Test
    public void testMailUtilsInitBy4Strings() {
        String gMailAccountLogin = GMAIL_LOGIN.split("@")[0];
        MailUtils m = new MailUtils(GMAIL_COM, gMailAccountLogin, GMAIL_PASS, "mail.properties");
        Assert.assertTrue(m.isConnected());
    }

    /**
     * Send email
     *
     * @param to
     * @param from
     * @param password
     * @param subject
     * @param body
     */
    public void sendEmail(String to, String from, final String password, String subject, String body) throws MessagingException {
        final String username = from;
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);
        Transport.send(message);
    }

    private void waitAndAsserMessage(MailUtils m) {
        String gotSubj = "", gotBody = "";
        try {
            m.waitForLetter(INBOX, SUBJECT);
        } catch (Exception e) {
            logger.debug(this, e);
            logger.warn(e.getMessage());
        }
        try {
            gotSubj = m.getMessages(INBOX)[0].getSubject();
            gotBody = ((String) m.getMessages(INBOX)[0].getContent()).trim();
        } catch (Exception e) {
            logger.debug(this, e);
            logger.warn(e.getMessage());
        }
        Assert.assertEquals(SUBJECT, gotSubj);
        Assert.assertEquals(BODY, gotBody);
    }

}
