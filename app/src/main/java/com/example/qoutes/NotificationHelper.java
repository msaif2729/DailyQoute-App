package com.example.qoutes;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.app.NotificationChannel;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.Random;

public class NotificationHelper {

    public static final String CHANNEL_ID = "daily_qoutes";

    public static void createchannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (notificationManager != null && notificationManager.getNotificationChannel(CHANNEL_ID) == null) {
                NotificationChannel notificationChannel = new android.app.NotificationChannel(CHANNEL_ID, "Daily Qoutes", NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.setDescription("This channel is for getting daily qoutes");
                notificationChannel.enableVibration(true);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(Color.RED);

                notificationManager.createNotificationChannel(notificationChannel);
            }

        }
    }


    public static void createNotification(Context context,String title, String message) {

        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra("author1",title);
        intent.putExtra("qoute1",message);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(),intent,PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Qoute Of The Day By : "+ title)
                .setContentText(message)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        int res = context.getResources().getIdentifier("cities6","drawable",context.getPackageName());

//        Picasso.get().load(res).into(new Target() {
//            @Override
//            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(bitmap));
//                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
//                if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//                    return;
//                }
//                notificationManagerCompat.notify((int) System.currentTimeMillis(), builder.build());
//
//            }
//
//            @Override
//            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
//
//            }
//
//            @Override
//            public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//            }
//        });

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManagerCompat.notify((int) System.currentTimeMillis(), builder.build());


    }


}
