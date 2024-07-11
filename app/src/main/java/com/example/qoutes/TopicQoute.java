package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicQoute extends AppCompatActivity {

    TextView txt,txt1;
    private SessionMaintain sessionMaintain;
    private DatabaseHandler databaseHandler;
    private DrawerLayout parentRelative;
    boolean liked = false;
    private ImageView like,share,heart;
    private MaterialToolbar topbar;
    RelativeLayout relative;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_qoute);

        txt = (TextView) findViewById(R.id.txt);
        txt1 = (TextView) findViewById(R.id.txt1);
        sessionMaintain = new SessionMaintain(TopicQoute.this);
        databaseHandler = new DatabaseHandler(TopicQoute.this);
        parentRelative = (DrawerLayout) findViewById(R.id.parentRelative);
        share = (ImageView) findViewById(R.id.share);
        like = (ImageView) findViewById(R.id.like);
        heart = (ImageView) findViewById(R.id.heart);
        topbar = (MaterialToolbar) findViewById(R.id.topbar);
        relative = (RelativeLayout) findViewById(R.id.relative);
        relative.setVisibility(View.GONE);

        allofthing();
    }

    public void allofthing()
    {

        Intent intent = getIntent();
        String str = intent.getStringExtra("topic");

        topbar.setTitle(str);

        topbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Animatoo.INSTANCE.animateSlideRight(TopicQoute.this);
            }
        });


        String theme = sessionMaintain.getTheme("key_theme");
        int imgresource = TopicQoute.this.getResources().getIdentifier(theme,"drawable",getPackageName());
        parentRelative.setBackgroundResource(imgresource);


        RetrofitClass1.getApiService().getRandomQoute(str).enqueue(new Callback<List<MyApiData>>() {
            @Override
            public void onResponse(Call<List<MyApiData>> call, Response<List<MyApiData>> response) {
                if(response.isSuccessful())
                {
                    relative.setVisibility(View.VISIBLE);
                    List<MyApiData> data = response.body();
//                    Toast.makeText(TopicQoute.this, categories[randint], Toast.LENGTH_SHORT).show();
                    txt.setText(response.body().get(0).getQuote());
                    txt1.setText("-"+response.body().get(0).getAuthor());
                }
            }

            @Override
            public void onFailure(Call<List<MyApiData>> call, Throwable throwable) {
                Log.d("Mohammed Saif","failed"+throwable);
            }
        });

    }
    public void share(View v)
    {
        Toast.makeText(this, "SHARE", Toast.LENGTH_SHORT).show();
        Share.sharingqoute(TopicQoute.this,txt.getText().toString());
    }

    public void like(View v)
    {
        if(!liked)
        {
            heart.setImageResource(R.drawable.likepop);
            heart.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    heart.setImageResource(0);
                    heart.setVisibility(View.GONE);
                }
            },1300);
            like.setImageResource(R.drawable.redfavorite_24px);
            liked = true;
            String str = databaseHandler.addliked(txt.getText().toString(),txt1.getText().toString(),"liked");
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
        else {
            like.setImageResource(R.drawable.favorite_24px);
            String str = databaseHandler.delliked(txt.getText().toString());
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            liked = false;
        }
    }


}