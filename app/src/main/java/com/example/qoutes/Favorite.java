package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.appbar.MaterialToolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Favorite extends AppCompatActivity {



    private RecyclerView recycle;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<FavoriteData> list;
    private MaterialToolbar topbar;
    private DatabaseHandler databaseHandler;
    String formattedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        recycle = (RecyclerView) findViewById(R.id.recycle);
        topbar = (MaterialToolbar) findViewById(R.id.topbar);
        databaseHandler = new DatabaseHandler(Favorite.this);

        topbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Animatoo.INSTANCE.animateSlideDown(Favorite.this);
            }
        });

        recycle.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycle.setLayoutManager(layoutManager);
        list = new ArrayList<FavoriteData>();
        adapter = new MyFavAdapter(this,list);


        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMMM yyyy", Locale.getDefault());
         formattedDate = dateFormat.format(currentDate);

        Cursor res = databaseHandler.getAll();
        while (res.moveToNext())
        {
            list.add(new FavoriteData(res.getString(1),res.getString(2),formattedDate));
        }

        recycle.setAdapter(adapter);



    }
}