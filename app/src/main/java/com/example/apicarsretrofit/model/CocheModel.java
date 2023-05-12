package com.example.apicarsretrofit.model;

import com.example.apicarsretrofit.api.ApiConfig;
import com.example.apicarsretrofit.api.ApiConfigInterface;
import com.example.apicarsretrofit.contract.CocheContract;
import com.example.apicarsretrofit.domain.Coche;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CocheModel implements CocheContract.Model {


    @Override
    public void listarCoches(OnCocheListener listener) {
        ApiConfigInterface api = ApiConfig.buildInstance();
        Call<List<Coche>> lstCoches = api.getCoches();
        lstCoches.enqueue(new Callback<List<Coche>>() {
            @Override
            public void onResponse(Call<List<Coche>> call, Response<List<Coche>> response) {
                List<Coche> coches = response.body();
                listener.OnCocheSuccess(coches);
            }

            @Override
            public void onFailure(Call<List<Coche>> call, Throwable t) {
                t.printStackTrace();
                String message = "Error en la operación";
                listener.OnCocheError(message);

            }
        });

    }
}
