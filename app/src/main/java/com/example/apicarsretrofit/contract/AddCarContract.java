package com.example.apicarsretrofit.contract;

import android.content.Context;

import com.example.apicarsretrofit.domain.Car;

public interface AddCarContract {
    interface Model {
        // CARS
        interface OnAddCarListener {
            void onAddCarSuccess(int message);

            void onAddCarError(int message);
        }

        interface OnModifyCarListener {
            void onModifyCarSuccess(int message);

            void onModifyCarError(int message);
        }

        void startDb(Context context);

        void addCar(OnAddCarListener listener, Car car);

        void modifyCar(OnModifyCarListener listener, Car car);

    }

    interface View {

        void addCar(android.view.View view);

        void cleanForm();

        void showMessage(int message);

    }

    interface Presenter {

        void addOrModifyCar(Car car, boolean modifyCar);

    }
}
