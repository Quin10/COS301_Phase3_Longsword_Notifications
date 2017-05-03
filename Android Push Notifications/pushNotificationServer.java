package com.example.quint.navup_pushnotification; /**
 * Created by Kyle on 4/19/2017.
 */

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to handle all the interactions between the notification server and the android client
 *
 * Each user will have a text file where notifications are place
 * and when they have accessed these notifications they will delete the text file by calling the delete function
 */
public class pushNotificationServer
{
    pushNotificationServer()
    {
    }

    /**
     * To send a notification to multiple users
     * @param notification The notification that needs to be sent
     * @param users The list of users the notification needs to be sent to
     */
    public void sendNotification(String notification, User users[])
    {
        try
        {
            for (int j = 0; j < users.length; j++)
            {
                // open a connection to the site
                URL url = new URL("http://www.unhinged.co.za/Demo/COS301/pushNotificationServer.php");

                URLConnection con = url.openConnection();
                con.setDefaultUseCaches(false);
                con.setUseCaches(false);
                con.setDoOutput(true);
                PrintStream ps = new PrintStream(con.getOutputStream());

                // Add the filename to the request
                ps.print("&filename=notification" + users[j].getID() + ".txt");

                // Add the notification to the request
                ps.print("&notification=" + notification + "#END#");

                // we have to get the input stream in order to actually send the request
                con.getInputStream();

                // close the print stream
                ps.close();
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * To send a notification to a single user
     * @param notification The notification that needs to be sent
     * @param user The list of users the notification needs to be sent to
     */
    public void sendNotification(String notification, User user)
    {
        try
        {
            // open a connection to the site
            URL url = new URL("http://www.unhinged.co.za/Demo/COS301/pushNotificationServer.php");
            URLConnection con = url.openConnection();
            con.setDefaultUseCaches(false);
            con.setUseCaches(false);
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());

            // Add the filename to the request
            ps.print("&filename=notification" + user.getID() + ".txt");

            // Add the notification to the request
            ps.print("&notification=" + notification + "#END#");

            // we have to get the input stream in order to actually send the request
            con.getInputStream();

            // close the print stream
            ps.close();

        } catch (Exception e)
        {
            System.out.println(e);
        }


    }

    /**
     * To check for notifications
     * @param user The user we need to check for
     * @return boolean
     */
    public boolean isThereNotification(User user)
    {
       try
        {
            URL url = new URL("http://www.unhinged.co.za/Demo/COS301/notification" + user.getID() + ".txt");
            URLConnection con = url.openConnection();
            con.setDefaultUseCaches(false);
            con.setUseCaches(false);
            Scanner scanner = new Scanner(url.openStream());

            if (scanner.next() == "")
            {
                return false;
            } else
            {
                return true;
            }
        } catch (Exception e)
        {

        }

        return false;
    }

    /**
     * Gets all the notifications and returns them as a string[]
     * @param user The user we have to check for
     * @return The notifications as an String[]
     */
    public String[] getNotifications(User user)
    {
        try
        {
            ArrayList<String> list = new ArrayList<>();

            URL url = new URL("http://www.unhinged.co.za/Demo/COS301/notification" + user.getID() + ".txt");
            URLConnection con = url.openConnection();
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);
            Scanner scanner = new Scanner(url.openStream()).useDelimiter("#END#");

            while (scanner.hasNext())
            {
                list.add(scanner.next());
            }

            String notifications[] = new String[list.size()];

            for (int j = 0; j < notifications.length; j++)
            {
                notifications[j] = list.get(j);
            }

            return notifications;

        } catch (Exception e)
        {
            System.out.println(e);
        }

        return null;
    }

    /**
     * A function to delete the text files for all the users when they're done
     * @param users
     */
    public void deleteNotifications(User users[])
    {
        try
        {
            for (int j = 0; j < users.length; j++)
            {
                // open a connection to the site
                URL url = new URL("http://www.unhinged.co.za/Demo/COS301/pushNotificationServer.php");
                URLConnection con = url.openConnection();
                con.setDefaultUseCaches(false);
                con.setUseCaches(false);
                con.setDoOutput(true);
                PrintStream ps = new PrintStream(con.getOutputStream());

                // Add the filename to the request
                ps.print("&filename=notification" + users[j].getID() + ".txt");

                // Tell the server to delete by adding this to the request
                ps.print("&deleteFile=true");

                // we have to get the input stream in order to actually send the request
                con.getInputStream();

                // close the print stream
                ps.close();
            }

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * A function to delete the text files for all the user when he/she are done
     * @param user
     */
    public void deleteNotification(User user)
    {
        try
        {
            // open a connection to the site
            URL url = new URL("http://www.unhinged.co.za/Demo/COS301/pushNotificationServer.php");
            URLConnection con = url.openConnection();
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);
            con.setDoOutput(true);
            PrintStream ps = new PrintStream(con.getOutputStream());

            // Add the filename to the request
            ps.print("&filename=notification" + user.getID() + ".txt");

            // Tell the server to delete by adding this to the request
            ps.print("&deleteFile=true");

            // we have to get the input stream in order to actually send the request
            con.getInputStream();

            // close the print stream
            ps.close();

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
