package com.tcg.backend.entities;

//@Entity
//@Table(name = "TIENDA")
public class TiendaEntity {
  /* Nota: reemplazar por SERIAL en DB!! */
  
  //atributos de clase (ej: a.nombre, si nombre fuera "public")
  private int id;
  private int id_ranking;
  private String nombre_tienda;
  private String telefono_tienda;
  private int numeracion;

  //constructor de clase (ej: tienda = new TiendaEntity(...) )
  public TiendaEntity(int id, int id_ranking, String nombre_tienda, String telefono_tienda, int numeracion) {
    this.id = id;
    this.id_ranking = id_ranking;
    this.nombre_tienda = nombre_tienda;
    this.telefono_tienda = telefono_tienda;
    this.numeracion = numeracion;
  }

  public TiendaEntity() {
    this.id = -1;
    this.id_ranking = -1;
    this.nombre_tienda = null;
    this.telefono_tienda = null;
    this.numeracion = -1;
  }

  //getters y setters (ya que los atributos son privados)
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

  public int getNumeracion() {
    return numeracion;
  }

  public void setNumeracion(int numeracion) {
    this.numeracion = numeracion;
  }


  //metodos
  //public int algo(){}
}
