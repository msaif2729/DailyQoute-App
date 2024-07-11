package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class Content extends AppCompatActivity {

    private MaterialToolbar topbar;
    private RecyclerView recycle;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private SessionMaintain sessionMaintain;
    private String[] mainCategories = {
            "Faith & Spirituality",
            "Positive Thinking",
            "Stress & Anxiety",
            "Achieving Goals",
            "Self-Esteem",
            "Relationship",
            "Letting Go",
            "Working Out",
            "Material",
            "Events",
            "Social Issues",
            "Miscellaneous"
    };
    private String[] mainCategoresimg = {
            "praying",
            "positive",
            "brain",
            "achievement",
            "affection",
            "relationship",
            "letgo",
            "barbell",
            "processing",
            "calendar",
            "profile",
            "miscellaneous"
    };


    ArrayList<MyInterest> myInterests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        topbar = (MaterialToolbar) findViewById(R.id.topbar);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        sessionMaintain = new SessionMaintain(Content.this);
        recycle.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycle.setLayoutManager(layoutManager);
        myInterests = new ArrayList<MyInterest>();
        adapter = new MyInterestAdapter(this,myInterests,sessionMaintain.getcategory("key_cat"));

        topbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Animatoo.INSTANCE.animateSlideLeft(Content.this);

            }
        });


        for (int i = 0;i<mainCategories.length;i++) {
            myInterests.add(new MyInterest(mainCategories[i],mainCategoresimg[i]));
        }



        recycle.setAdapter(adapter);
    }
}