package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.appbar.MaterialToolbar;

public class Profile extends AppCompatActivity {

    EditText name,gender,content,theme,favcount;
    private MaterialToolbar topbar;
    boolean editable = false;
    boolean editable1 = false;
    private DatabaseHandler databaseHandler;
    private SessionMaintain sessionMaintain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (EditText) findViewById(R.id.name);
        gender = (EditText) findViewById(R.id.gender);
        content = (EditText) findViewById(R.id.content);
        theme = (EditText) findViewById(R.id.theme);
        favcount = (EditText) findViewById(R.id.favcount);
        topbar = (MaterialToolbar) findViewById(R.id.topbar);
        sessionMaintain = new SessionMaintain(Profile.this);
        databaseHandler = new DatabaseHandler(Profile.this);


        String[] str = sessionMaintain.getsession("key_name","key_gender");

        name.setText(str[0]);
        gender.setText(str[1]);

        topbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Animatoo.INSTANCE.animateSlideLeft(Profile.this);

            }
        });

        name.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (name.getRight() - name.getCompoundDrawables()[2].getBounds().width())) {
                        Toast.makeText(Profile.this, "Drawable Right clicked", Toast.LENGTH_SHORT).show();
                        Drawable dleft = ContextCompat.getDrawable(Profile.this,R.drawable.person_24px);
                        Drawable dright = ContextCompat.getDrawable(Profile.this,R.drawable.check_24px);
                        Drawable dr = ContextCompat.getDrawable(Profile.this,R.drawable.edit_square_24px);

                        if(!editable)
                        {
                            name.setFocusable(true);
                            name.setFocusableInTouchMode(true);
                            name.setCursorVisible(true);
                            name.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
                            name.requestFocus();
                            name.setSelection(name.getText().length());
                            name.setCompoundDrawablesWithIntrinsicBounds(dleft,null,dright,null);
                            sessionMaintain.namesession(name.getText().toString());
                            editable = true;
                        }
                        else{
                            name.setFocusable(false);
                            name.setFocusableInTouchMode(false);
                            name.setCursorVisible(false);
                            name.setInputType(0);
                            name.requestFocus();
                            name.setCompoundDrawablesWithIntrinsicBounds(dleft,null,dr,null);
                            editable = false;
                            sessionMaintain.namesession(name.getText().toString());
                        }
                        return true;
                    }
                }

                return false;
            }
        });

        gender.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (gender.getRight() - gender.getCompoundDrawables()[2].getBounds().width())) {
                        Toast.makeText(Profile.this, "Drawable Right clicked", Toast.LENGTH_SHORT).show();
                        Drawable dleft = ContextCompat.getDrawable(Profile.this,R.drawable.gendersys);
                        Drawable dright = ContextCompat.getDrawable(Profile.this,R.drawable.check_24px);
                        Drawable dr = ContextCompat.getDrawable(Profile.this,R.drawable.edit_square_24px);

                        if(!editable1)
                        {
                            gender.setFocusable(true);
                            gender.setFocusableInTouchMode(true);
                            gender.setCursorVisible(true);
                            gender.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
                            gender.requestFocus();
                            gender.setSelection(gender.getText().length());
                            gender.setCompoundDrawablesWithIntrinsicBounds(dleft,null,dright,null);
                            sessionMaintain.gendersession(gender.getText().toString());
                            editable1 = true;
                        }
                        else{
                            gender.setFocusable(false);
                            gender.setFocusableInTouchMode(false);
                            gender.setCursorVisible(false);
                            gender.setInputType(0);
                            gender.requestFocus();
                            gender.setCompoundDrawablesWithIntrinsicBounds(dleft,null,dr,null);
                            editable1 = false;
                            sessionMaintain.gendersession(gender.getText().toString());
                        }
                        return true;
                    }
                }

                return false;
            }
        });

        favcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,Favorite.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideRight(Profile.this);
            }
        });


        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,Content.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideLeft(Profile.this);
            }
        });

        theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,SelectTheme.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideLeft(Profile.this);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Cursor res = databaseHandler.getAll();
        String count = String.valueOf(res.getCount());

        favcount.setText("Favourite ( "+count+" )");

    }
}