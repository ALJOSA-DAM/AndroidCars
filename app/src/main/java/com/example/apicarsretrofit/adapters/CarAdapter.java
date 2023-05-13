package com.example.apicarsretrofit.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apicarsretrofit.R;
import com.example.apicarsretrofit.domain.Car;

import java.util.List;

public class CarAdapter extends BaseAdapter {
    private Context context;
    private List<Car> carArrayList;
    private LayoutInflater inflater;

    public CarAdapter(Activity context, List<Car> carArrayList) {
        this.context = context;
        this.carArrayList = carArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Car car = (Car) getItem(position);

        convertView = inflater.inflate(R.layout.car_adapter, null);
        ImageView carImage = (ImageView) convertView.findViewById(R.id.client_car_item_imageView);
        TextView carmodel = convertView.findViewById(R.id.client_car_tv1);
        TextView carPlate = convertView.findViewById(R.id.client_car_tv2);

        carmodel.setText(car.getMarca() + " " + car.getModelo());
        carPlate.setText(car.getMatricula());

        return convertView;
    }

    @Override
    public int getCount() {
        return carArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return carArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
