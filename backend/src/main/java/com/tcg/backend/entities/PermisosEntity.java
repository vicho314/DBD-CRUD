package com.tcg.backend.entities;

public class PermisosEntity {

    private int id_permiso;
    private int id_rol;
    private int id_usuario;

    public PermisosEntity(int id_permiso, int id_rol, int id_usuario) {
        this.id_permiso = id_permiso;
        this.id_rol = id_rol;
        this.id_usuario = id_usuario;
    }

    public PermisosEntity() {

        this.id_permiso = -1;
        this.id_rol = -1;
        this.id_usuario = -1;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
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
}