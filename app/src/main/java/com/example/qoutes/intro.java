package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.textfield.TextInputEditText;

public class intro extends AppCompatActivity {

    private Button continue1;
    private TextInputEditText name;
    private SessionMaintain sessionMaintain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        continue1 = (Button) findViewById(R.id.cont1);
        name = (TextInputEditText) findViewById(R.id.name);
        sessionMaintain = new SessionMaintain(intro.this);

        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!name.getText().toString().equals(""))
                {
                    Intent intent = new Intent(intro.this,intro2.class);
                    sessionMaintain.namesession(name.getText().toString());
                    startActivity(intent);
                    Animatoo.INSTANCE.animateSlideLeft(intro.this);
                }
            }
        });



    }
}