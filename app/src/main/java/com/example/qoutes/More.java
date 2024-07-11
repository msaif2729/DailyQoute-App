package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class More extends AppCompatActivity {

    private RecyclerView parentrecycle;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ParentItem> parentItems;
    private MaterialToolbar topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        topbar = (MaterialToolbar) findViewById(R.id.topbar);

        topbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Animatoo.INSTANCE.animateSlideDown(More.this);
            }
        });

        parentrecycle = (RecyclerView) findViewById(R.id.parentrecycle);
        parentrecycle.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(More.this);
        parentrecycle.setLayoutManager(layoutManager);
        parentItems = new ArrayList<ParentItem>();
        adapter = new ParentItemAdapter(More.this,parentItems);

        MainActivity mainActivity = new MainActivity();

        for (String category : mainActivity.mainCategories) {
            List<ChildItem> childItemList = new ArrayList<>();
            switch (category) {
                case "Faith & Spirituality":
                    // Code for Faith & Spirituality
                    for (String subcategory : mainActivity.faithAndSpirituality)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Positive Thinking":
                    // Code for Positive Thinking
                    for (String subcategory : mainActivity.positiveThinking)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Stress & Anxiety":
                    // Code for Stress & Anxiety
                    for (String subcategory : mainActivity.stressAndAnxiety)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Achieving Goals":
                    // Code for Achieving Goals
                    for (String subcategory : mainActivity.achievingGoals)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Self-Esteem":
                    // Code for Self-Esteem
                    for (String subcategory : mainActivity.selfEsteem)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Relationship":
                    // Code for Relationship
                    for (String subcategory : mainActivity.relationship)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Letting Go":
                    // Code for Letting Go
                    for (String subcategory : mainActivity.lettingGo)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Working Out":
                    // Code for Working Out
                    for (String subcategory : mainActivity.workingOut)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Material":
                    // Code for Material
                    for (String subcategory : mainActivity.material)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Events":
                    // Code for Events
                    for (String subcategory : mainActivity.events)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Social Issues":
                    // Code for Social Issues
                    for (String subcategory : mainActivity.socialIssues)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                case "Miscellaneous":
                    // Code for Miscellaneous
                    for (String subcategory : mainActivity.miscellaneous)
                        childItemList.add(new ChildItem(titleCase(subcategory)));
                    break;
                default:
                    // Code for unknown category
                    break;
            }
            parentItems.add(new ParentItem(category, childItemList));
        }

        parentrecycle.setAdapter(adapter);

    }
    
    public String titleCase(String str)
    {
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    
}