package com.example.apicarsretrofit.contract;

import android.content.Context;

import com.example.apicarsretrofit.domain.Car;

import java.util.List;

public interface CarListContract {

    interface Model {

        interface OnLoadCarsListener {
            void onLoadCarsSuccess(List<Car> cars);

            void onLoadCarsError(String message);
        }

        interface OnDeleteCarListener{
            void onDeleteCarSuccess(String message);

            void onDeleteCarError(String message);
        }

        void startDb(Context context);

        void loadAllCars(OnLoadCarsListener listener);

        void loadCarsByBrand(OnLoadCarsListener listener, String query);

        void loadCarsByModel(OnLoadCarsListener listener, String query);

        void loadCarsByLicensePlate(OnLoadCarsListener listener, String query);

        void delete(OnDeleteCarListener listener, Car car);
    }

    interface View {
        void listCars(List<Car> cars);

        void showMessage(String message);
    }

    interface Presenter {
        void loadAllCars();

        void loadCarsByBrand(String query);

        void loadCarsByModel(String query);

        void loadCarsByLicensePlate(String query);

        void deleteCar(Car car);
    }
}
