package com.example.qoutes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txt,txt1;
    private SessionMaintain sessionMaintain;
    private DatabaseHandler databaseHandler;
    private DrawerLayout parentRelative;
    boolean liked = false;
    private ImageView like,share,gotheme,gomore,gofav,heart;
    private MaterialToolbar topbar;
    public String[] cats;
    RelativeLayout relative;
    ArrayList<String> ogcat = new ArrayList<String>();

    String[] categories = {
            "age", "alone", "amazing", "anger", "architecture", "art", "attitude", "beauty",
            "best", "birthday", "business", "car", "change", "communication", "computers",
            "cool", "courage", "dad", "dating", "death", "design", "dreams", "education",
            "environmental", "equality", "experience", "failure", "faith", "family", "famous",
            "fear", "fitness", "food", "forgiveness", "freedom", "friendship", "funny",
            "future", "god", "good", "government", "graduation", "great", "happiness",
            "health", "history", "home", "hope", "humor", "imagination", "inspirational",
            "intelligence", "jealousy", "knowledge", "leadership", "learning", "legal",
            "life", "love", "marriage", "medical", "men", "mom", "money", "morning",
            "movies", "success"
    };

    // Faith & Spirituality
    String[] faithAndSpirituality = {
            "faith", "god", "hope"
    };

    // Positive Thinking
    String[] positiveThinking = {
            "amazing", "beauty", "best", "cool", "courage", "freedom",
            "funny", "good", "great", "happiness", "hope", "imagination", "inspirational"
    };

    // Stress & Anxiety
    String[] stressAndAnxiety = {
            "alone", "anger", "fear", "jealousy"
    };

    // Achieving Goals
    String[] achievingGoals = {
            "business", "change", "communication", "dreams", "education", "experience",
            "failure", "future", "graduation", "intelligence", "knowledge", "leadership",
            "learning", "life", "success"
    };

    // Self-Esteem
    String[] selfEsteem = {
            "attitude", "courage", "fitness", "health"
    };

    // Relationship
    String[] relationship = {
            "dad", "dating", "family", "friendship", "love", "marriage", "men", "mom"
    };

    // Letting Go
    String[] lettingGo = {
            "death", "forgiveness"
    };

    // Working Out
    String[] workingOut = {
            "fitness", "health"
    };

    // Material
    String[] material = {
            "architecture", "art", "car", "computers", "design", "home", "money"
    };

    // Events
    String[] events = {
            "birthday", "morning"
    };

    // Social Issues
    String[] socialIssues = {
            "environmental", "equality", "legal"
    };

    // Miscellaneous
    String[] miscellaneous = {
            "age", "history", "medical", "movies"
    };

     String[] mainCategories = {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        txt1 = (TextView) findViewById(R.id.txt1);
        sessionMaintain = new SessionMaintain(MainActivity.this);
        databaseHandler = new DatabaseHandler(MainActivity.this);
        parentRelative = (DrawerLayout) findViewById(R.id.parentRelative);
        share = (ImageView) findViewById(R.id.share);
        like = (ImageView) findViewById(R.id.like);
        gofav = (ImageView) findViewById(R.id.gofav);
        gomore = (ImageView) findViewById(R.id.gomore);
        gotheme = (ImageView) findViewById(R.id.gotheme);
        topbar = (MaterialToolbar) findViewById(R.id.topbar);
        relative = (RelativeLayout) findViewById(R.id.relative);
        relative.setVisibility(View.GONE);
        heart = (ImageView) findViewById(R.id.heart);

        allofthing();

    }

    public void allofthing()
    {
        show();
        Log.d("Mohammed Saif",Arrays.toString(ogcat.toArray()));
        Toast.makeText(this, Arrays.toString(ogcat.toArray()), Toast.LENGTH_SHORT).show();

        gomore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,More.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideUp(MainActivity.this);
            }
        });

        gofav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Favorite", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Favorite.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideUp(MainActivity.this);
            }
        });

        gotheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Theme", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SelectTheme.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideUp(MainActivity.this);
                finish();




            }
        });

        topbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Profile.class);
                startActivity(intent);
                Animatoo.INSTANCE.animateSlideLeft(MainActivity.this);
                return false;
            }
        });


        theme();

        Random random = new Random();
        int randint = random.nextInt(ogcat.size());



        RetrofitClass1.getApiService().getRandomQoute(ogcat.get(randint)).enqueue(new Callback<List<MyApiData>>() {
            @Override
            public void onResponse(Call<List<MyApiData>> call, Response<List<MyApiData>> response) {
                if(response.isSuccessful())
                {
                    relative.setVisibility(View.VISIBLE);
                    List<MyApiData> data = response.body();
//                    Toast.makeText(MainActivity.this, categories[randint], Toast.LENGTH_SHORT).show();
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
        Share.sharingqoute(MainActivity.this,txt.getText().toString());
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
//            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
        else {
            like.setImageResource(R.drawable.favorite_24px);
            String str = databaseHandler.delliked(txt.getText().toString());
//            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            liked = false;
        }
    }

    public void show()
    {
        if(sessionMaintain.getcategory("key_cat")!=null)
        {
            String str = sessionMaintain.getcategory("key_cat").substring(1,sessionMaintain.getcategory("key_cat").length()-1);
            cats = str.split(", ");
            ogcat.clear();
            for(int i=0;i<cats.length;i++)
            {
                switch (cats[i]) {
                    case "Faith & Spirituality":
                        // Code for Faith & Spirituality
                        ogcat.addAll(Arrays.asList(faithAndSpirituality));
                        break;
                    case "Positive Thinking":
                        // Code for Positive Thinking
                        ogcat.addAll(Arrays.asList(positiveThinking));
                        break;
                    case "Stress & Anxiety":
                        // Code for Stress & Anxiety
                        ogcat.addAll(Arrays.asList(stressAndAnxiety));
                        break;
                    case "Achieving Goals":
                        // Code for Achieving Goals
                        ogcat.addAll(Arrays.asList(achievingGoals));
                        break;
                    case "Self-Esteem":
                        // Code for Self-Esteem
                        ogcat.addAll(Arrays.asList(selfEsteem));
                        break;
                    case "Relationship":
                        // Code for Relationship
                        ogcat.addAll(Arrays.asList(relationship));
                        break;
                    case "Letting Go":
                        // Code for Letting Go
                        ogcat.addAll(Arrays.asList(lettingGo));
                        break;
                    case "Working Out":
                        // Code for Working Out
                        ogcat.addAll(Arrays.asList(workingOut));
                        break;
                    case "Material":
                        // Code for Material
                        ogcat.addAll(Arrays.asList(material));
                        break;
                    case "Events":
                        // Code for Events
                        ogcat.addAll(Arrays.asList(events));
                        break;
                    case "Social Issues":
                        // Code for Social Issues
                        ogcat.addAll(Arrays.asList(socialIssues));
                        break;
                    case "Miscellaneous":
                        // Code for Miscellaneous
                        ogcat.addAll(Arrays.asList(miscellaneous));

                        break;
                    default:
                        // Code for unknown category
                        ogcat.addAll(Arrays.asList(categories));
                        break;
                }
            }
        }
        else {
            ogcat.addAll(Arrays.asList(categories));
        }

    }


    @Override
    protected void onStart() {
        super.onStart();
//        allofthing();
//        liked = false;
//        Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();
    }

    public void theme()
    {
        int imgresource=0;
        String theme = sessionMaintain.getTheme("key_theme");
        if(theme.equals("purple")||theme.equals("pink")||theme.equals("cream")||theme.equals("yellow")||theme.equals("bottlegreen")||theme.equals("blue"))
        {
            imgresource = MainActivity.this.getResources().getIdentifier(theme,"color",getPackageName());
        }
        else {
            imgresource = MainActivity.this.getResources().getIdentifier(theme,"drawable",getPackageName());
        }
        parentRelative.setBackgroundResource(imgresource);
    }

}