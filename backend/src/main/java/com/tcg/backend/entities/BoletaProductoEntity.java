package com.tcg.backend.entities;

public class BoletaProductoEntity {
    private int id_producto;
    private int id_boleta;

    public BOLETA_X_PRODUCTO(int id_producto,int id_boleta){
        this.id_producto = id_producto;
        this.id_boleta = id_boleta;
    }

    public BOLETA_X_PRODUCTO(){
        this.id_producto = -1;
        this.id_boleta = -1;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(int id_boleta) {
        this.id_boleta = id_boleta;
    }
}
