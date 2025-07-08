package com.tcg.backend.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity
//@Table(name= "carta")
public class CartaEntity {
    private int id_carta;
    private int posicion_deseada;
    private BigDecimal precio;
    private int stock;
    private String rareza;
    private LocalDate año;
    private String estado;
    private int id_producto;

    public CartaEntity() {
        this.id_carta= -1;
        this.posicion_deseada= -1;
        this.precio = BigDecimal.ZERO;
        this.stock= 0;
        this.rareza= null;
        this.año= null;
        this.estado= null;
        this.id_producto= -1;
    }

    public CartaEntity(int id_carta, int posicion_deseada, BigDecimal precio, int stock,
                       String rareza, LocalDate año, String estado, int id_producto){
        this.id_carta = id_carta;
        this.posicion_deseada = posicion_deseada;
        this.precio = precio;
        this.stock = stock;
        this.rareza = rareza;
        this.año = año;
        this.estado = estado;
        this.id_producto = id_producto;
    }
    public int getId_carta() { return id_carta; }

    public void setId_carta(int id_carta) { this.id_carta = id_carta; }

    public int getPosicion_deseada() { return posicion_deseada; }

    public void setPosicion_deseada(int posicion_deseada){ this.posicion_deseada = posicion_deseada; }

    public BigDecimal getPrecio() { return precio; }

    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public String getRareza() { return rareza; }

    public void setRareza(String rareza) { this.rareza = rareza; }

    public LocalDate getAño(){ return año; }

    public void setAño(LocalDate año){ this.año = año; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public int getId_producto() { return id_producto; }

    public void setId_producto(int id_producto) { this.id_producto = id_producto; }

}