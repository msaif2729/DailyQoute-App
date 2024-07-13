package com.example.qoutes;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        RetrofitClass1.getApiService().getRandomQoute(intent.getStringExtra("query")).enqueue(new Callback<List<MyApiData>>() {
            @Override
            public void onResponse(Call<List<MyApiData>> call, Response<List<MyApiData>> response) {
                if (response.isSuccessful()) {
                    List<MyApiData> data = response.body();
                    NotificationHelper.createNotification(context,data.get(0).getAuthor(),data.get(0).getQuote());
                }
            }


            @Override
            public void onFailure(Call<List<MyApiData>> call, Throwable throwable) {
                Log.d("Mohammed Saif", "failed" + throwable);
            }
        });

    }

}
