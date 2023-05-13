package com.example.apicarsretrofit.model;

import android.content.Context;

import com.example.apicarsretrofit.api.CarsAppApi;
import com.example.apicarsretrofit.api.CarsAppApiInterface;
import com.example.apicarsretrofit.contract.CarListContract;
import com.example.apicarsretrofit.domain.Car;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarListModel implements CarListContract.Model {

    private Context context;
    private CarsAppApiInterface api;
    private List<Car> cars;

    @Override
    public void startDb(Context context) {
        this.context = context;
        cars = new ArrayList<>();
        api = CarsAppApi.buildInstance();
    }

    @Override
    public void loadAllCars(OnLoadCarsListener listener) {
        cars.clear();

        Call<List<Car>> carCall = api.getCars();

        loadCarsCallEnqueue(listener, carCall);
    }

    @Override
    public void loadCarsByBrand(OnLoadCarsListener listener, String query) {
        cars.clear();

        Call<List<Car>> carCall = api.getCarsByBrand(query);

        loadCarsCallEnqueue(listener, carCall);
    }

    @Override
    public void loadCarsByModel(OnLoadCarsListener listener, String query) {
        cars.clear();

        Call<List<Car>> carCall = api.getCarsByModel(query);

        loadCarsCallEnqueue(listener, carCall);
    }

    @Override
    public void loadCarsByLicensePlate(OnLoadCarsListener listener, String query) {
        cars.clear();

        Call<List<Car>> carsCall = api.getCarsByLicense(query);

        loadCarsCallEnqueue(listener, carsCall);
    }

    /**
     * Envía la solicitud de forma asíncrona y notifica la devolución de llamada de su respuesta
     * o si se produjo un error al hablar con el servidor, crear la solicitud o procesar la respuesta.
     *
     * @param listener OnLoadCarsListener
     * @param call     Lista de Cars
     */
    private void loadCarsCallEnqueue(final OnLoadCarsListener listener, Call<List<Car>> call) {
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                cars = response.body();
                listener.onLoadCarsSuccess(cars);
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                listener.onLoadCarsError("Se ha producido un error");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void delete(final OnDeleteCarListener listener, Car car) {
        Call<Void> carCall = api.deleteCar(car.getId());
        // db.carDao().delete(car);
        carCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                listener.onDeleteCarSuccess("Moto eliminada correctamente");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onDeleteCarError("No se ha podido eliminar la moto");
                t.printStackTrace();
            }
        });
    }
}
