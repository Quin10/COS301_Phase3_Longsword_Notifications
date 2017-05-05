/**
 * Created by fred on 2017/03/23.
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/*import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;*/

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Notifications extends ActionBarActivity
{

    public class User{
        private List<String> userEmailAddresses;
        private List<String> userNumbers;

        User(){
            userEmailAddresses = userNumbers = new List<String>() {
                public int size() {
                    return 0;
                }

                public boolean isEmpty() {
                    return false;
                }

                public boolean contains(Object o) {
                    return false;
                }

                public Iterator<String> iterator() {
                    return null;
                }

                public Object[] toArray() {
                    return new Object[0];
                }

                public <T> T[] toArray(T[] a) {
                    return null;
                }

                public boolean add(String s) {
                    return false;
                }

                public boolean remove(Object o) {
                    return false;
                }

                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                public boolean addAll(Collection<? extends String> c) {
                    return false;
                }

                public boolean addAll(int index, Collection<? extends String> c) {
                    return false;
                }

                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                public boolean retainAll(Collection<?> c) {
                    return false;
                }

                public void clear() {

                }

                public String get(int index) {
                    return null;
                }

                public String set(int index, String element) {
                    return null;
                }

                public void add(int index, String element) {

                }
                

                public String remove(int index) {
                    return null;
                }

                public int indexOf(Object o) {
                    return 0;
                }

                public int lastIndexOf(Object o) {
                    return 0;
                }

                public ListIterator<String> listIterator() {
                    return null;
                }

                public ListIterator<String> listIterator(int index) {
                    return null;
                }

                public List<String> subList(int fromIndex, int toIndex) {
                    return null;
                }
            };
        }

        private String retrieveEmailOfAUsers(String username){
            return "dummyemail@gmail.com";
        }

        private List<String> retrieveEmailOfManyUsers(List<String> usernames){
            userEmailAddresses.clear();
            userEmailAddresses.add("oneemailaddress@gmail.com");
            userEmailAddresses.add("twoemailaddresses@gmail.com");
            return userEmailAddresses;
        }

        private List<String> retrieveEmailOfAllUsers(){
            userEmailAddresses.clear();
            userEmailAddresses.add("oneemailaddress@gmail.com");
            userEmailAddresses.add("twoemailaddresses@gmail.com");
            return userEmailAddresses;
        }

        private List<String> retrieveNumbersOfManyUsers(List<String> usernames){
            userNumbers.clear();
            userNumbers.add("0715587777");
            userNumbers.add("0715587778");
            return userNumbers;
        }

        private List<String> retrieveNumbersOfAllUsers(){
            userNumbers.clear();
            userNumbers.add("07155887777");
            userNumbers.add("07155887778");
            return userNumbers;
        }
    }
    /**
     * param String notification - The notification we wish to push
     */
    public boolean PushNotificationToAll (String notification)
    {
        try{
            //Push Notifcation to current user in list
             /* NotificationManager NM;
                NM=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notify = new Notification(android.R.drawable.stat_notify_more,"NEW EVENT,System.currentTimeMillis());
                PendingIntent pending = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(),0);
                notify.setLatestEventInfo(getApplicationContext(), subject, notification, body,pending);
                NM.notify(0, notify);	*/
        }catch(Exception e){
            return false; //Return false if error occurs whilst pushing notification
        }

        return true; //Return true if no errors occurred whilst pushing notification
    }

    /**
     * param String notification - The notification we wish to push
     * param List<User> users - The users we want to send the notification to
     */
    public boolean PushTargetedNotification (List<User> users, String notification)
    {
        try{
            for(int i = 0; i < users.size(); i++){
                //Push Notifcation to current user in list
                //Use googles firebase if needed
            }
        }catch(Exception e){
            return false; //Return false if error occurs whilst pushing notification
        }

        return true; //Return true if no errors occured whilst pushing notification
    }

    /**
     * param String notification - The notification we wish to send via email
     */
    public String SendEmailToAll(String notification) {
        /*if (notification == "") {
            return false;
        } else {

            //Query to get all users on the system
            List<User> users = null;

            String from = "longswordNotification@gmail.com";//change accordingly
            final String username = "longswordNotification@gmail.com";//change accordingly
            final String password = "longsword";//change accordingly

            //email through relay.jangosmtp.net
            String host = "smtp.gmail.com";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            // Get the Session object.
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });



            for (int i = 0; i < users.size(); i++) {

                //Recipient's email ID will be set to email of each user in system
                User n = users.get(i);
                String to = n.userEmailAddresses.get(i);//"xyz@gmail.com";//change accordingly

                //Sender's email ID needs to be mentioned
                try {

                    Message message = new MimeMessage(session);


                    message.setFrom(new InternetAddress(from));


                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(to));


                    message.setSubject("Testing Email");


                    message.setText(notification);


                    Transport.send(message);

                    System.out.println("Sent message successfully....");
                }catch (MessagingException e) {

                    throw new RuntimeException(e);

                }
                return true;
            }
        }
        return false;*/
        return "";
    }

    /**
     * param String notification - The notification we wish to send via email
     * param List<User> users - The users we want to send the notification to
     */
    public String SendTargetedEmail(String email, String subject, String body) {

        String to = email;//"xyz@gmail.com";
        String from = "longswordNotification@gmail.com";
        final String username = "longswordNotification";
        final String password = "longsword";

        //Email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            //set message to passed message
            message.setText(body);

            // Send message
            Transport.send(message);

            return "{'Success':'true', 'Error':'None'";
        } catch (MessagingException e) {

            return "{'Success':'true', 'Error':"+ e + "}";
        }
    }

    /**
     * param String notification - The notification we wish to send via sms
     */
    public boolean SendSmsToAll (String notification)
    {
        if (notification == null){
            return false;
        }
        else{
            return true;
        }

        // For the SMS feature we decided www.twilio.com offers a simple API. This would allow us to sms our users.

        //To use the api we would need to import
        /*
        * import com.twilio.Twilio;
        * import com.twilio.rest.api.v2010.account.Message;
        * import com.twilio.type.PhoneNumber;
        * */

        //The code below is an example of the system
        try{
        /*
        * String accountSid = "ACXXXXXX"; // Your Account SID from www.twilio.com/user/account
        * String authToken = "XXXXXXXX"; // Your Auth Token from www.twilio.com/user/account
        * Twilio.init(accountSid, authToken);
        *
        * Message message = Message.creator(
        *   new PhoneNumber("+15558881234"),  // To number
        *   new PhoneNumber("+15559994321"),  // From number
        *   "Hello world!"                    // SMS body
        * ).create();
        * System.out.println(message.getSid())
        * */

        // An example of how we would implement this in our system
        /*
        * List<User> users = Data.getAllUsers();
        *
        * for (int j = 0; j < Users.size(); j++)
        * {
        *   Message message = Message.creator(
        *       new PhoneNumber(users.get(j).getCellPhoneNumber,  // To number
        *       new PhoneNumber("+15559994321"),  // From number
        *       notification                   // SMS body
        *   ).create();
        * }
        *
        * */
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * param String notification - The notification we wish to send via sms
     * param List<User> users - The users we want to send the notification to
     */
    public boolean SendTargetedSms (List<User> users, String notification)
    {
        // As explained above
        // An example of how we would implement this in our system
        try{
        /*
        * for (int j = 0; j < Users.size(); j++)
        * {
        *   Message message = Message.creator(
        *       new PhoneNumber(users.get(j).getCellPhoneNumber,  // To number
        *       new PhoneNumber("+15559994321"),  // From number
        *       notification                   // SMS body
        *   ).create();
        * }
        *
        * */
          if (notification == null){
              return false;
          }
          else{
              return true;
          }
        }catch(Exception e){
            return false;
        }
    }
}
