package com.example.apicarsretrofit.presenter;

import com.example.apicarsretrofit.contract.CarListContract;
import com.example.apicarsretrofit.domain.Car;
import com.example.apicarsretrofit.model.CarListModel;
import com.example.apicarsretrofit.view.CarListView;

import java.util.List;

public class CarListPresenter implements CarListContract.Presenter, CarListContract.Model.OnLoadCarsListener,
        CarListContract.Model.OnDeleteCarListener {

    private CarListModel model;
    private CarListView view;

    public CarListPresenter(CarListView view) {
        model = new CarListModel();
        model.startDb(view.getApplicationContext());

        this.view = view;
    }

    @Override
    public void loadAllCars() {
        model.loadAllCars(this);
    }

    @Override
    public void loadCarsByBrand(String query) {
        model.loadCarsByBrand(this, query);
    }

    @Override
    public void loadCarsByModel(String query) {
        model.loadCarsByModel(this, query);
    }

    @Override
    public void loadCarsByLicensePlate(String query) {
        model.loadCarsByLicensePlate(this, query);
    }

    @Override   // OnLoadCarsListener SUCCESS
    public void onLoadCarsSuccess(List<Car> cars) {
        view.listCars(cars);
    }

    @Override   // OnLoadCarsListener ERROR
    public void onLoadCarsError(String message) {
        view.showMessage(message);
    }

    @Override
    public void deleteCar(Car car) {
        model.delete(this, car);
    }

    @Override   // OnDeleteCarsListener SUCCESS
    public void onDeleteCarSuccess(String message) {
        view.showMessage(message);
    }

    @Override   // OnDeleteCarsListener ERROR
    public void onDeleteCarError(String message) {
        view.showMessage(message);
    }

}
