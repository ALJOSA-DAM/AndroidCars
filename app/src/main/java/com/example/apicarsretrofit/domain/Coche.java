package com.example.apicarsretrofit.domain;

public class Coche {

    private long id;
    private String marca;
    private String matricula;
    private Boolean disponible;

    public Coche() {
    }

    public Coche(String marca, String matricula, Boolean disponible) {
        this.marca = marca;
        this.matricula = matricula;
        this.disponible = disponible;
    }

    public long getId() {
        return id;
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

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
