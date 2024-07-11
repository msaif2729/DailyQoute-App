package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.appbar.MaterialToolbar;

public class Theme extends AppCompatActivity {

    private MaterialToolbar topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        topbar = (MaterialToolbar) findViewById(R.id.topbar);

        topbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Animatoo.INSTANCE.animateSlideDown(Theme.this);
            }
        });

    }
}