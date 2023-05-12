package com.example.apicarsretrofit.contract;

import com.example.apicarsretrofit.domain.Coche;
import com.example.apicarsretrofit.domain.Oficina;

import java.util.List;

public interface OficinaContract {
    interface Model {
        interface OnOficinaListener {
            void OnOficinaSuccess(List<Oficina> oficinas);
            void OnOficinaError(String message);
        }
        void listarOficinas(OficinaContract.Model.OnOficinaListener listener);
    }
}
