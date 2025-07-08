package com.tcg.backend.entities;

public class UbicacionEntity {

    private int id_ubicacion;
    private int numeracion;
    private String ciudad;
    private String calle;

    public UbicacionEntity(int id_ubicacion, int numeracion, String ciudad, String calle) {
        this.id_ubicacion = id_ubicacion;
        this.numeracion = numeracion;
        this.ciudad = ciudad;
        this.calle = calle;
    }

    public UbicacionEntity(){
        this.id_ubicacion = -1;
        this.numeracion = -1;
        this.ciudad = null;
        this.calle = null;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
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