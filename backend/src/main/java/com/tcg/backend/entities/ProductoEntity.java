package com.tcg.backend.entities;

//@Entity

public class ProductoEntity{
    /* Nota: reemplazar por SERIAL en DB!! */

    //atributos de clase (ej: a.nombre, si nombre fuera "public")
    private int id_producto;
    private int id_ranking;
    private int id_tienda;
    private int stock;
    private int cantidad_vendida;
    private String url;

    //constructor de clase (ej: tienda = new TiendaEntity(...) )
    public ProductoEntity(int id_producto, int id_ranking,int id_tienda,int stock,int cantidad_vendida,String url){
        this.id_producto = id_producto;
        this.id_ranking = id_ranking;
        this.id_tienda = id_tienda;
        this.stock = stock;
        this.cantidad_vendida = cantidad_vendida;
        this.url = url;
    }

    public ProductoEntity() {
        this.id_producto= -1;
        this.id_ranking = -1;
        this.id_tienda = -1;
        this.stock = -1;
        this.cantidad_vendida= -1;
        this.url = null;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

