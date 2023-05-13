package com.example.apicarsretrofit.api;

import static com.example.apicarsretrofit.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarsAppApi {


    public static CarsAppApiInterface buildInstance() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(CarsAppApiInterface.class);
    }
}
