package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class intro2 extends AppCompatActivity {

    Button female,male,other,nottosay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        female = (Button) findViewById(R.id.female);
        male = (Button) findViewById(R.id.male);
        other = (Button) findViewById(R.id.other);
        nottosay = (Button) findViewById(R.id.nottosay);

    }

    public void genderselected(View v)
    {

        Intent intent = new Intent(intro2.this,Customize.class);
        if(v.getId()==R.id.female){
            intent.putExtra("gender","Female");
        } else if (v.getId()==R.id.male) {
            intent.putExtra("gender","Male");
        } else if (v.getId()==R.id.other) {
            intent.putExtra("gender","Other");
        } else{
            intent.putExtra("gender","Nothing");
        }
        startActivity(intent);
        Animatoo.INSTANCE.animateSlideLeft(intro2.this);
        finish();

    }


}