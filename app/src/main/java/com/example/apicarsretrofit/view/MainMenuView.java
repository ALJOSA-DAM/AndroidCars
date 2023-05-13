package com.example.apicarsretrofit.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apicarsretrofit.R;

public class MainMenuView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void addCar(View view) {
        Intent intent = new Intent(this, AddCarView.class);
        startActivity(intent);
    }

    public void viewCar(View view) {
        Intent intent = new Intent(this, CarListView.class);
        startActivity(intent);
    }
}