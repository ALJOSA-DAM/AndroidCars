package com.example.apicarsretrofit.contract;

import com.example.apicarsretrofit.domain.Coche;

import java.util.List;

public interface CocheContract {
    interface Model {
        interface OnCocheListener {
            void OnCocheSuccess(List<Coche> coches);
            void OnCocheError(String message);
        }
        void listarCoches(OnCocheListener listener);
    }
}
