package com.tcg.backend.entities;

@Entity
//@Table(name = "TIENDA")
public class TiendaEntity {
    /*Nota: reemplazar por SERIAL en DB!!*/
    private int id;
    private int id_ranking;
    private String nombre_tienda;
    private String telefono_tienda;
    private String calle_tienda;
    private int numero_tienda;

    public TiendaEntity(int id, int id_ranking, String nombre_tienda, String telefono_tienda, String calle_tienda, int numero_tienda) {
        this.id = id;
        this.id_ranking = id_ranking;
        this.nombre_tienda = nombre_tienda;
        this.telefono_tienda = telefono_tienda;
        this.calle_tienda = calle_tienda;
        this.numero_tienda = numero_tienda;
    }

    public TiendaEntity() {
        this.id = -1;
        this.id_ranking = -1;
        this.nombre_tienda = null;
        this.telefono_tienda = null;
        this.calle_tienda = null;
        this.numero_tienda = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(int id_ranking) {
        this.id_ranking = id_ranking;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getTelefono_tienda() {
        return telefono_tienda;
    }

    public void setTelefono_tienda(String telefono_tienda) {
        this.telefono_tienda = telefono_tienda;
    }

    public String getCalle_tienda() {
        return calle_tienda;
    }

    public void setCalle_tienda(String calle_tienda) {
        this.calle_tienda = calle_tienda;
    }

    public int getNumero_tienda() {
        return numero_tienda;
    }

    public void setNumero_tienda(int numero_tienda) {
        this.numero_tienda = numero_tienda;
    }
}