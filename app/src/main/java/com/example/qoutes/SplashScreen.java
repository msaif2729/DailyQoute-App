package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class SplashScreen extends AppCompatActivity {

    private SessionMaintain sessionMaintain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sessionMaintain = new SessionMaintain(SplashScreen.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               if(sessionMaintain.checksession())
               {
                   Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                   startActivity(intent);
                   Animatoo.INSTANCE.animateSlideLeft(SplashScreen.this);
                   finish();
               }
               else
               {
                   Intent intent = new Intent(SplashScreen.this,GetStarted.class);
                   startActivity(intent);
                   Animatoo.INSTANCE.animateSlideLeft(SplashScreen.this);
                   finish();
               }
            }
        },2000);


    }
}