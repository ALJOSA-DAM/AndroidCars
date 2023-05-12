package com.example.apicarsretrofit.contract;

import com.example.apicarsretrofit.domain.Coche;
import com.example.apicarsretrofit.domain.Usuario;

import java.util.List;

public interface UsuarioContract {
    interface Model {
        interface OnUsuarioListener {
            void OnUsuarioSuccess(List<Usuario> usuarios);
            void OnUsuarioError(String message);
        }
        void listarUsuarios(UsuarioContract.Model.OnUsuarioListener listener);
    }
}
