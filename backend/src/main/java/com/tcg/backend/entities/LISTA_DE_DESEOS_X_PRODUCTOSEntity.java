package com.tcg.backend.entities;

public class LISTA_DE_DESEOS_X_PRODUCTOSEntity {

    //atributos de clase (ej: a.nombre, si nombre fuera "public")
    private int id_lista;
    private int id_producto;

    //constructor de clase (ej: tienda = new TiendaEntity(...) )
    public LISTA_DE_DESEOS_X_PRODUCTOSEntity(int id_lista, int id_producto) {
        this.id_lista = id_lista;
        this.id_producto = id_producto;
    }

    public LISTA_DE_DESEOS_X_PRODUCTOSEntity() {
        this.id_lista = -1;
        this.id_producto = -1;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
}
