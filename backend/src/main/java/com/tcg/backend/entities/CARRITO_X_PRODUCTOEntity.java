package com.tcg.backend.entities;

public class CARRITO_X_PRODUCTOEntity {

    private int id_producto;
    private int id_carro;
    private Boolean disponibilidad;

    public CARRITO_X_PRODUCTOEntity(int id_producto, int id_carro, Boolean disponibilidad){
        this.id_producto = id_producto;
        this.id_carro = id_carro;
        this.disponibilidad = disponibilidad;
    }

    public CARRITO_X_PRODUCTOEntity(){
        this.id_producto = -1;
        this.id_carro = -1;
        this.disponibilidad = null;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}



