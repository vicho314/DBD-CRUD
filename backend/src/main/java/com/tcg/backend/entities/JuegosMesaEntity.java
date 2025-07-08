package com.tcg.backend.entities;

public class JuegosMesaEntity {

	//FIXME: verificar NOT NULLs (?)
	private int id_juego;
	private int id_producto;
	private Float precio;		// NOT NULL
	private String nombre_juego;	// NOT NULL
	private String tipo;		// varchar(10) NOT NULL
	
	public JuegosMesaEntity (int id_juego, int id_producto, Float precio, String nombre_juego, String tipo) {
		this.id_juego = id_juego;	
		this.id_producto = id_producto;
		this.precio = precio;
		this.nombre_juego = nombre_juego;
		this.tipo = tipo;
	}

	public JuegosMesaEntity (){
		this.id_juego = -1;	
		this.id_producto = -1;
		this.precio = null;
		this.nombre_juego = null;
		this.tipo = null;
	}

	public int getId_juego() {
		return id_juego;
	}

	public void setId_juego(int id_juego) {
		this.id_juego = id_juego;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getNombre_juego() {
		return nombre_juego;
	}

	public void setNombre_juego(String nombre_juego) {
		this.nombre_juego = nombre_juego;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
