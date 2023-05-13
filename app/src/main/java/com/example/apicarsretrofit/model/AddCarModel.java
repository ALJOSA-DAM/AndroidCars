package com.example.apicarsretrofit.model;

import android.content.Context;

import com.example.apicarsretrofit.R;

import com.example.apicarsretrofit.api.CarsAppApi;
import com.example.apicarsretrofit.api.CarsAppApiInterface;
import com.example.apicarsretrofit.contract.AddCarContract;
import com.example.apicarsretrofit.domain.Car;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCarModel implements AddCarContract.Model {
    
    private CarsAppApiInterface api;

    @Override
    public void startDb(Context context) {
        api = CarsAppApi.buildInstance();
    }

    @Override
    public void addCar(final OnAddCarListener listener, Car car) {

        Call<Car> carDTOCall = api.addCar(car);

        carDTOCall.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                listener.onAddCarSuccess(R.string.added_car_success);
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                listener.onAddCarError(R.string.added_car_error);
            }
        });
    }

    @Override
    public void modifyCar(final OnModifyCarListener listener, Car car) {

        Call<Car> carDTOCall = api.modifyCar(car.getId(), car);

        carDTOCall.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                listener.onModifyCarSuccess(R.string.modified_car_success);
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                listener.onModifyCarError(R.string.modified_car_error);
            }
        });
    }

}
