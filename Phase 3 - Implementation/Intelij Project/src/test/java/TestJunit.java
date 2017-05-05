import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit{
    @Test

    public void testEmailAllSentSuccessful(){
        String greeting = "Good Day";
        String username = "John Wick";
        String body = "This email is a test to see if you are awesome";

        String message = greeting + ' ' + username + ' ' +body;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,true);
    }

    public void testEmailAllSentFail(){
        String message = null;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,false);
    }

    public void testEmailTargettedSentSuccessful(){
        String greeting = "Good Day";
        String username = "John Wick";
        String body = "This email is a test to see if you are awesome";

        String message = greeting + ' ' + username + ' ' +body;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,true);
    }

    public void testEmailTargetedSentFail(){
        String message = null;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,false);
    }

    public void testSmsAllSentSuccessful(){
        String greeting = "Good Day";
        String username = "John Wick";
        String body = "This email is a test to see if you are awesome";

        String message = greeting + ' ' + username + ' ' +body;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,true);
    }

    public void testSmsAllSentFail(){
        String message = null;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,false);
    }

    public void testSmsTargettedSentSuccessful(){
        String greeting = "Good Day";
        String username = "John Wick";
        String body = "This email is a test to see if you are awesome";

        String message = greeting + ' ' + username + ' ' +body;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,true);
    }

    public void testSmsTargetedSentFail(){
        String message = null;
        Notifications notify = new Notifications();
        boolean success = notify.SendEmailToAll(message);
        assertEquals(success,false);
    }
}
