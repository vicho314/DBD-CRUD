package com.tcg.backend.entities;

public CarritoEntity {

    private int id_carro;
    private int id_metodo_pago;
    private int id_usuario;
    private Boolean estado_carrito;
    private int cantidad_elementos;
    private num total_pago;

    public BoletaEntity( int id_carro, int id_metodo_pago, int id_usuario, Boolean estado_carrito,
    int cantidad_elementos, num total_pago){
        this.id_carro = id_carro;
        this id_metodo_pago = id_metodo_pago;
        this id_usuario = id_usuario;
        this estado_carrito = estado_carrito;
        this.cantidad_elementos = cantidad_elementos;
        this total_pago = total_pago;

    }
    public CarritoEntity() {
        this.id_carro = -1;
        this id_metodo_pago = -1;
        this id_usuario = -1;
        this estado_carrito = null;
        this.cantidad_elementos = -1;
        this total_pago = 0;
    }

    public int getId_carro () {
        return id_carro;
    }
    public void setId_carro ( int id_carro){
        this.id_carro = id_carro;
    }

    public int getId_metodo_pago () {
        return id_metodo_pago;
    }
    public void setId_metodo_pago ( int id_metodo_pago){
        this id_metodo_pago = id_metodo_pago;
    }

    public int getId_usuario () {
        return id_usuario;
    }
    public void setId_usuario ( int id_usuario){
        this id_usuario = id_usuario;
    }

    public int getEstado_carrito () {
        return estado_carrito;
    }
    public void setEstado_carrito (Boolean estado_carrito){
        this estado_carrito = estado_carrito;
    }

    public int getCantidad_elementos () {
        return cantidad_elementos;
    }
    public void setCantidad_elementos ( int cantidad_elementos){
        this.cantidad_elementos = cantidad_elementos;
    }

    public int getTotal_pago () {
        return total_pago;
    }
    public void setTotal_pago (num total_pago){
        this total_pago = total_pago;
    }