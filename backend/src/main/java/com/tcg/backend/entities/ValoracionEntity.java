package com.tcg.backend.entities;

public class ValoracionEntity {

	private int id_valoracion;
	private int id_producto;
	private int id_usuario;
	private int puntuacion; // >= 0
	
	public class ValoracionEntity (int id_valoracion, int id_producto, 
		int id_usuario, int puntuacion) {
		this.id_valoracion = id_valoracion;
		this.id_producto = id_producto;
		this.id_usuario = id_usuario;
		this.puntuacion = puntuacion;
	}

	public class ValoracionEntity () {
		this.id_valoracion = -1;
		this.id_producto = -1;
		this.id_usuario = -1;
		this.puntuacion = 0;
	}

	public getId_valoracion(){
		return id_valoracion;
	}

	public setId_valoracion(int id_valoracion){
		this.id_valoracion = id_valoracion;
	}

	public getId_producto(){
		return id_producto;
	}

	public setId_producto(int id_producto){
		this.id_producto = id_valoracion;
	}

	public getId_usuario(){
		return id_usuario;
	}

	public setId_usuario(int id_usuario){
		this.id_usuario = id_usuario;
	}

	public getPuntuacion(){
		return puntuacion;
	}

	public setPuntuacion throws Exception (int puntuacion){
		if(Puntuacion < 0){
			throw new Exception("Valoracion: Puntuacion menor a 0");
		}
		else{
			this.puntuacion = puntuacion;
		}
	}

}
