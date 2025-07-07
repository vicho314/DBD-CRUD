package com.tcg.backend.entities;

public class RolEntity {

    private int numeracion;
    private String ciudad;
    private int calle;

    public RolEntity(int numeracion, String ciudad, int calle) {
        this.numeracion = numeracion;
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public RolEntity() {
        this.numeracion = -1;
        this.ciudad = null;
        this.calle = -1;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCalle() {
        return calle;
    }

    public void setCalle(int calle) {
        this.calle = calle;
    }
}