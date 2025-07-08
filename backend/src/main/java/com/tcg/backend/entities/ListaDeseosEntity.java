package com.tcg.backend.entities;

//@Entity
//@Table(name=lista_de_deseos")
public class ListaDeDeseosEntity {
    private int id_lista;
    private String nombre_lista;

    public ListaDeDeseosEntity() {
        this.id_lista = -1;
        this.nombre_lista = null;
    }
    public ListaDeDeseosEntity(int id_lista, String nombre_lista) {
        this.id_lista = id_lista;
        this.nombre_lista = nombre_lista;
    }
    public int getId_lista() { return id_lista; }

    public void setId_lista(int id_lista) { this.id_lista = id_lista; }

    public String getNombre_lista() { return nombre_lista; }

    public void setNombre_lista(String nombre_lista) { this.nombre_lista = nombre_lista; }
}