package com.tcg.backend.entities;

public class UbicacionEntity {

    private int numeracion;
    private String ciudad;
    private String calle;

    public UbicacionEntity(int numeracion, String ciudad, String calle) {
        this.numeracion = numeracion;
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public UbicacionEntity(){
        this.numeracion = -1;
        this.ciudad = null;
        this.calle = null;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
}