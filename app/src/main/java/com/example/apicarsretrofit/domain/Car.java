package com.example.apicarsretrofit.domain;

public class Car {

    private long id;
    private String marca;
    private String modelo;
    private String matricula;
    private boolean disponible;

    public Car() {
    }

    public Car(String marca, String matricula, boolean disponible) {
        this.marca = marca;
        this.matricula = matricula;
        this.disponible = disponible;
    }

    public long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
