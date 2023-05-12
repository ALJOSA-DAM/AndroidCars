package com.example.apicarsretrofit.api;

import com.example.apicarsretrofit.domain.Coche;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConfigInterface {
    @GET("coche")
    Call<List<Coche>> getCoches();
 }
