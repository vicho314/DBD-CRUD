package com.tcg.backend.entities;

//@Entity
//@Table(name = "TIENDA")
public class TiendaEntity {
  /* Nota: reemplazar por SERIAL en DB!! */
  
  //atributos de clase (ej: a.nombre, si nombre fuera "public")
  private int id;
  private int id_ranking;
  private String nombre;
  private String telefono;
  private String calle;
  private int numero;
  private String ciudad;

  //constructor de clase (ej: tienda = new TiendaEntity(...) )
  public TiendaEntity(int id, int id_ranking, String nombre, String telefono, String calle,
      int numero,String ciudad) {
    this.id = id;
    this.id_ranking = id_ranking;
    this.nombre = nombre;
    this.telefono = telefono;
    this.calle = calle;
    this.numero = numero;
    this.ciudad = ciudad;
  }

  public TiendaEntity() {
    this.id = -1;
    this.id_ranking = -1;
    this.nombre = null;
    this.telefono = null;
    this.calle = null;
    this.numero = -1;
    this.ciudad = null;
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

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  //metodos
  //public int algo(){}
}
