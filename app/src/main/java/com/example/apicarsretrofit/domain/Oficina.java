package com.example.apicarsretrofit.domain;

public class Oficina {
    private long id;
    private int numTrabajadores;
    private String direccion;
    private String telefono;

    public Oficina(int numTrabajadores, String direccion, String telefono) {
        this.numTrabajadores = numTrabajadores;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Oficina() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumTrabajadores() {
        return numTrabajadores;
    }

    public void setNumTrabajadores(int numTrabajadores) {
        this.numTrabajadores = numTrabajadores;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
