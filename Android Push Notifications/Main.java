/**
 * Created by Kyle on 4/19/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        pushNotificationServer notification = new pushNotificationServer();

        User users[] = generateUsers();
        notification.sendNotification("Hi, there is a Dragon in your way", users);

        notification.sendNotification("Hi, there is a point of interest on your left", users);

        for (int j = 0; j < users.length; j++)
        {
            System.out.println("Notification for user-" + users[j].getID());
            notification.getNotifications(users[j]);
        }

        
        notification.deleteNotifications(users);
    }

    public static User[] generateUsers()
    {
        User users[] = new User[10];

        for (int j =  0; j < users.length; j++)
        {
            int ID = (int)(Math.random() * 10000);
            User user = new User(ID);

            users[j] = user;
        }

        return users;

    }
}
