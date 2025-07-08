package com.tcg.backend.entities;

import java.util.Date;

public class RankingEntity {

	private int id_ranking;
	private Date fecha_ranking_v;

	public RankingEntity(int id_ranking, Date fecha){
		this.id_ranking = id_ranking;
		this.fecha_ranking_v = fecha;
	}

	public RankingEntity(){
		this.id_ranking = -1;
		this.fecha_ranking_v = null; //FIXME: NOT NULL!
	}

	public int getId_ranking(){
		return id_ranking;
	}

	public void setId_ranking(int id){
		this.id_ranking = id;
	}

	public Date getFecha_ranking_v(){
		return fecha_ranking_v;
	}

	public void setFecha_ranking_v(Date fecha){
		this.fecha_ranking_v = fecha; //FIXME: NOT NULL!
	}

}
