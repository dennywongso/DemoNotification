package com.example.a15017096.demonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int requestCode = 123;
    int notificationID =888;
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btnNotify1);
        btn2 = (Button)findViewById(R.id.btnNotify2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);
                builder.setPriority(Notification.PRIORITY_HIGH);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, n);
                finish();
            }
        });
    }
}
