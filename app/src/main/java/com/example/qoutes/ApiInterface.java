package com.example.qoutes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers({
            "X-Api-Key: /K9AZbkjRsy6XoRv7UDXEw==0Ze4IAyS1Vp6vfaS"
    })
    @GET("quotes")
    Call<List<MyApiData>> getRandomQoute(@Query("category") String cat);

}
