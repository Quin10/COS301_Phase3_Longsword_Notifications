package com.example.quint.navup_pushnotification;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView)findViewById(R.id.textView);
        b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Run all netwoking tasks on a new thread
                new Thread(new Runnable(){

                    public void run(){
                        User user = new User(1235); //Created dummy user for testing purposes (Value can be changed in order to switch users)
                        pushNotificationServer pushNotificationServer = new pushNotificationServer(); //Create a new server object

                        //Check if there are any outstanding notifiactions
                        if(pushNotificationServer.isThereNotification(user)) {
                            String[] notifications = pushNotificationServer.getNotifications(user);
                            for (int j = 0; j < notifications.length; j++) {
                                CheckNotifications(notifications[j], j);
                            }
                            pushNotificationServer.deleteNotification(user); //Delete notification once sent through to preserve space
                        }
                        final String text = (pushNotificationServer.isThereNotification(user) + "");

                        //Switch back to main thread
                        runOnUiThread(new Runnable(){
                            public void run(){
                                if(text.equals("true"))
                                    t1.setText("New Notifications Recieved"); 
                                else
                                    t1.setText("No New notifications Recieved");
                            }
                        });
                    }
                }).start();
            }
        });
    }


    //Display pending notifications to the client
    private void CheckNotifications(String message, int NotificationNo) {
        //Construct Notification
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("NavUP")
                        .setContentText(message);

        //Create and set intent to send notification
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        //Send Notification through to the notification manager
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NotificationNo, builder.build());
    }
}
