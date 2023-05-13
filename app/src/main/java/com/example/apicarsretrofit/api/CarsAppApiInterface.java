package com.example.apicarsretrofit.api;

import com.example.apicarsretrofit.domain.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CarsAppApiInterface {
    @GET("coches?all=true")
    Call<List<Car>> getCars();
    // Cars

    @GET("coches")
    Call<List<Car>> getCarsByBrand(@Query("marca") String marca);

    @GET("coches")
    Call<List<Car>> getCarsByModel(@Query("modelo") String modelo);

    @GET("coches")
    Call<List<Car>> getCarsByLicense(@Query("matricula") String matricula);

    @DELETE("coches/{id}")
    Call<Void> deleteCar(@Path("id") long id);

    @POST("coches")
    Call<Car> addCar(@Body Car car);

    @PUT("coches/{id}")
    Call<Car> modifyCar(@Path("id") long id, @Body Car car);
 }
