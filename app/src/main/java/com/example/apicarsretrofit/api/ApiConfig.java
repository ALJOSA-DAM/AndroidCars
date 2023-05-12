package com.example.apicarsretrofit.api;

import android.content.pm.ApplicationInfo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {


    public static final String BASE_URL = "192.168.1.1";

    public static ApiConfigInterface buildInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiConfigInterface.class);
    }



}
