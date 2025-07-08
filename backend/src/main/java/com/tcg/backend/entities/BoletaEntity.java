package com.tcg.backend.entities;

public class CarritoEntity {

	private int id_boleta;
	private int id_carro;
	private Boolean id_metodo_de_pago;
	private int fecha_boleta;

	public class BoletaEntity(int id_boleta, int id_carro, Boolean id_metodo_de_pago, int fecha_boleta) {
		this.id_boleta =id_boleta;
		this id_carro =id_carro;
		this id_metodo_de_pago =id_metodo_de_pago;
		this fecha_boleta =fecha_boleta;

	}
	public BoletaEntity(){
		this.id_boleta= -1;
		this.id_carro= -1;
		this.id_metodo_de_pago= -1;
		this.fecha_boleta= 0;

	}

	public int getId_boleta() {return id_boleta;}
	public void setId_boleta(int id_boleta) {this.id_boleta =id_boleta;}

	public int getId_carro() {return id_carro;}
	public void setId_carro(int id_carro) {this id_carro =id_carro;}

	public int getId_metodo_de_pago() {return id_metodo_de_pago;}
	public void setId_metodo_de_pago(Boolean id_metodo_de_pago) {this id_metodo_de_pago =id_metodo_de_pago;}

	public int getFecha_boleta() {return fecha_boleta;}
	public void setFecha_boleta(int fecha_boleta) {this fecha_boleta =fecha_boleta;}









