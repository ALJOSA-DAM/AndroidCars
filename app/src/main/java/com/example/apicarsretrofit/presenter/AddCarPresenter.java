package com.example.apicarsretrofit.presenter;

import android.content.Context;

import com.example.apicarsretrofit.R;
import com.example.apicarsretrofit.contract.AddCarContract;
import com.example.apicarsretrofit.domain.Car;
import com.example.apicarsretrofit.model.AddCarModel;
import com.example.apicarsretrofit.view.AddCarView;

public class AddCarPresenter implements AddCarContract.Presenter, AddCarContract.Model.OnAddCarListener,
        AddCarContract.Model.OnModifyCarListener {

    private AddCarModel model;
    private AddCarView view;
    private Context context;

    public AddCarPresenter(AddCarView view) {
        this.context = view.getApplicationContext();
        this.view = view;

        model = new AddCarModel();
        model.startDb(context);
    }

    @Override
    public void addOrModifyCar(Car car, boolean modifyCar) {

        if ((car.getMarca().equals("")) || (car.getModelo().equals("")) || (car.getMatricula().equals(""))) {
            view.showMessage(R.string.complete_all_fields);
        } else {
            if (modifyCar) {
                view.setModifyCar(false);
                view.getAddButton().setText(R.string.add_button);
                model.modifyCar(this, car);
            } else {
                car.setId(0);
                model.addCar(this, car);
            }
        }

    }

    @Override
    public void onAddCarSuccess(int message) {
        view.showMessage(message);
        view.cleanForm();
    }

    @Override
    public void onAddCarError(int message) {
        view.showMessage(message);
    }

    @Override
    public void onModifyCarSuccess(int message) {
        view.showMessage(message);
        view.cleanForm();
    }

    @Override
    public void onModifyCarError(int message) {
        view.showMessage(message);
    }

}
