package com.example.qoutes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView txt;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);

        Random random = new Random();
        int randint = random.nextInt(categories.length);


       RetrofitClass1.getApiService().getRandomQoute(categories[randint]).enqueue(new Callback<List<MyApiData>>() {
            @Override
            public void onResponse(Call<List<MyApiData>> call, Response<List<MyApiData>> response) {
                if(response.isSuccessful())
                {
                    List<MyApiData> data = response.body();
                    Log.d("Mohammed Saif",data.toString());
                    Toast.makeText(MainActivity.this, categories[randint], Toast.LENGTH_SHORT).show();
                    txt.setText(response.body().get(0).getQuote());
                }
            }

            @Override
            public void onFailure(Call<List<MyApiData>> call, Throwable throwable) {
                Log.d("Mohammed Saif","failed"+throwable);

            }
        });





    }
}