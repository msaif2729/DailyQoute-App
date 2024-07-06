package com.example.qoutes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass1 {

    private static final String BASE_URL = "https://api.api-ninjas.com/v1/";
    private static Retrofit retrofit;
    private static final String API_KEY = "/K9AZbkjRsy6XoRv7UDXEw==0Ze4IAyS1Vp6vfaS"; // Replace with your actual API key

    public static synchronized Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface getApiService() {
        return getInstance().create(ApiInterface.class);
    }

    public static String getApiKey() {
        return API_KEY;
    }


}
