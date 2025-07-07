package com.tcg.backend.entities;

public class RolEntity {

    public int id_rol;
    public int id_usuario;
    public int id_tienda;
    public int id_ranking;
    public String nombre_rol;

    public RolEntity(int id_rol, int id_usuario, int id_tienda,
                     int id_ranking, String nombre_rol) {

        this.id_rol = id_rol;
        this.id_usuario = id_usuario;
        this.id_tienda = id_tienda;
        this.id_ranking = id_ranking;
        this.nombre_rol = nombre_rol;
    }

    public RolEntity() {

        this.id_rol = -1;
        this.id_usuario = -1;
        this.id_tienda = -1;
        this.id_ranking = -1;
        this.nombre_rol = null;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
}