package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Customize extends AppCompatActivity {

    private Button continue2;
    private SessionMaintain sessionMaintain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        continue2 = (Button) findViewById(R.id.cont2);
        sessionMaintain = new SessionMaintain(Customize.this);
        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        sessionMaintain.gendersession(gender);

        continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Customize.this,SelectTheme.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideLeft(Customize.this);
            }
        });

    }
}