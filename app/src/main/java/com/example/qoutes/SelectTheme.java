package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.card.MaterialCardView;

public class SelectTheme extends AppCompatActivity {

    private MaterialCardView card1,card2,card3,card4,card5,card6;
    private RelativeLayout selecttheme;
    private SessionMaintain sessionMaintain;
    private Button gotomain;
    private TextView txt1,txt2,txt3,txt4,txt5,txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theme);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);

        selecttheme = findViewById(R.id.selecttheme);
        gotomain = (Button) findViewById(R.id.gotomain);
        sessionMaintain = new SessionMaintain(SelectTheme.this);


        gotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTheme.this,MainActivity.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideLeft(SelectTheme.this);
                finish();
            }
        });


    }

    public void selecttheme(View v)
    {

        if (v.getId() == R.id.card1) {
            card1.setChecked(!card1.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
//            sessionMaintain.themesession("g");
            callalert(txt1.getText().toString());
        } else if (v.getId() == R.id.card2) {
            card2.setChecked(!card2.isChecked());
            card1.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
//            sessionMaintain.themesession("e");
            callalert(txt2.getText().toString());
        } else if (v.getId() == R.id.card3) {
            card3.setChecked(!card3.isChecked());
            card2.setChecked(false);
            card1.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
//            sessionMaintain.themesession("c");
            callalert(txt3.getText().toString());
        } else if (v.getId() == R.id.card4) {
            card4.setChecked(!card4.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card1.setChecked(false);
            card5.setChecked(false);
            card6.setChecked(false);
//            sessionMaintain.themesession("a");
            callalert(txt4.getText().toString());
        } else if (v.getId() == R.id.card5) {
            card5.setChecked(!card5.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card1.setChecked(false);
            card6.setChecked(false);
//            sessionMaintain.themesession("i");
            callalert("White");
        } else if (v.getId() == R.id.card6) {
            card6.setChecked(!card6.isChecked());
            card2.setChecked(false);
            card3.setChecked(false);
            card4.setChecked(false);
            card5.setChecked(false);
            card1.setChecked(false);
//            sessionMaintain.themesession("f");
            callalert(txt6.getText().toString());
        }
    }

    public void callalert(String message)
    {
        LayoutInflater inflater = getLayoutInflater();
        ShowAlert showAlert = new ShowAlert(SelectTheme.this);
        showAlert.showalert(message,inflater);
    }

}