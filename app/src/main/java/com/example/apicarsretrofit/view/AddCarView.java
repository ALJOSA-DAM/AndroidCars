package com.example.apicarsretrofit.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apicarsretrofit.R;
import com.example.apicarsretrofit.contract.AddCarContract;
import com.example.apicarsretrofit.domain.Car;
import com.example.apicarsretrofit.presenter.AddCarPresenter;

public class AddCarView extends AppCompatActivity implements AddCarContract.View {


    private Car car;
    private Button addButton;
    private ImageView carImage;
    private Switch availableSwitch;
    private EditText etBrand;
    private EditText etModel;
    private EditText etLicensePlate;
    private Intent intent = getIntent();
    private AddCarPresenter presenter;
    private boolean modifyCar;

    public Button getAddButton() {
        return addButton;
    }

    public void setModifyCar(boolean modifyCar) {
        this.modifyCar = modifyCar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        availableSwitch = findViewById(R.id.available_car);
        carImage = findViewById(R.id.car_imageView);
        etBrand = findViewById(R.id.brand_edittext_add_car);
        etModel = findViewById(R.id.model_edittext_add_car);
        etLicensePlate = findViewById(R.id.license_plate_edittext_add_car);
        addButton = findViewById(R.id.add_car_button);

        presenter = new AddCarPresenter(this);
        car = new Car();

        intent();
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    private void intent() {
        intent = getIntent();
        modifyCar = intent.getBooleanExtra("modify_car", false);
        Log.i("MOD", "modificar: " + modifyCar);
        if (modifyCar) {
            Log.i("MOD AÑADIR", "id antes intent: " + car.getId());
            car.setId(intent.getLongExtra("id", 0));
            Log.i("MOD AÑADIR", "id despues intent: " + car.getId());
            etBrand.setText(intent.getStringExtra("marca"));
            etModel.setText(intent.getStringExtra("modelo"));
            etLicensePlate.setText(intent.getStringExtra("matricula"));
            car.setDisponible(intent.getBooleanExtra("disponible", false));

            addButton.setText(R.string.modify_capital);
        }
    }

    @Override
    public void addCar(View view) {

        car.setMarca(etBrand.getText().toString().trim());
        car.setModelo(etModel.getText().toString().trim());
        car.setMatricula(etLicensePlate.getText().toString().trim());
        availableSwitch.setChecked(intent.getBooleanExtra("disponible", false));
        Log.i("MOD AÑADIR", "id: " + car.getId());
        Log.i("MOD AÑADIR", "marca: " + car.getMarca());
        Log.i("MOD AÑADIR", "modelo: " + car.getModelo());
        Log.i("MOD AÑADIR", "matricula: " + car.getMatricula());
        Log.i("MOD AÑADIR", "disponible: " + car.isDisponible());
        presenter.addOrModifyCar(car, modifyCar);

    }

    /**
     * Cambia el texto del switch y el valor booleano DISPONIBLE del coche
     *
     * @param view
     */
    public void switchVip(View view) {

        if (availableSwitch.isChecked()) {
            availableSwitch.setText(R.string.available_car);
            car.setDisponible(true);
        } else {
            availableSwitch.setText(R.string.not_available_car);
            car.setDisponible(false);
        }

    }

    @Override
    public void cleanForm() {

        carImage.setImageResource(R.drawable.lambo);
        etBrand.setText("");
        etModel.setText("");
        etLicensePlate.setText("");

    }

    @Override
    public void showMessage(int stringRes) {
        Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show();
    }

}
