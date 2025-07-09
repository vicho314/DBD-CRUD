package com.tcg.backend.entities;

public class Lista_de_deseosXCartaEntity {
    private int id_lista;
    private int id_carta;
    private int cantidad_veces_agregada;

    public Lista_de_deseosXCartaEntity() {
        this.id_lista= -1;
        this.id_carta= -1;
        this.cantidad_veces_agregada = 0;
    }

    public Lista_de_deseosXCartaEntity(int id_lista, int id_carta, int cantidad_veces_agregada) {
        this.id_lista = id_lista;
        this.id_carta = id_carta;
        this.cantidad_veces_agregada = cantidad_veces_agregada;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_carta() {
        return id_carta;
    }

    public void setId_carta(int id_carta){
        this.id_carta = id_carta;
    }

    public int  getCantidad_veces_agregada() {
        return cantidad_veces_agregada;
    }

    public void setCantidad_veces_agregada(int Cantidad_veces_agregada) {
        this.cantidad_veces_agregada = Cantidad_veces_agregada;
    }
}