package com.tcg.backend.entities;

public class UsuarioEntity {

    private int id_usuario;
    private int id_lista;
    private int id_ubicacion;
    private int id_metodo_pago;
    private String correo_usuario;
    private String contraseña;
    private String nombre_real;
    private String nombre_usuario;

    public UsuarioEntity(int id_usuario, int id_lista, int id_ubicacion, int id_metodo_pago,
                         String correo_usuario, String contraseña, String nombre_real, String nombre_usuario) {

        this.id_usuario = id_usuario;
        this.id_lista = id_lista;
        this.id_ubicacion = id_ubicacion;
        this.id_metodo_pago = id_metodo_pago;
        this.correo_usuario = correo_usuario;
        this.contraseña = contraseña;
        this.nombre_real = nombre_real;
        this.nombre_usuario = nombre_usuario;
    }

    public UsuarioEntity() {
        this.id_usuario = -1;
        this.id_lista = -1;
        this.id_ubicacion = -1;
        this.id_metodo_pago = -1;
        this.correo_usuario = null;
        this.contraseña = null;
        this.nombre_real = null;
        this.nombre_usuario = null;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public void setNombre_real(String nombre_real) {
        this.nombre_real = nombre_real;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
}