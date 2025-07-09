package com.tcg.backend.repositories;

import com.tcg.backend.entities.TiendaEntity;
//import com.tcg.backend.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class TiendaRepository {
	//Cargar la configuracion automáticamente
	@Autowired
	private Sql2o sql2o;

	public List<TiendaEntity> findAll(){
		String sql =
			"SELECT * " +
			"FROM TIENDA";

		try(Connection con = sql2o.open()) {
        		return con.createQuery(sql)
				.executeAndFetch(TiendaEntity.class);
    		}
	}

	public TiendaEntity findById(int id){
		String sql =
				"SELECT * " +
						"FROM TIENDA WHERE id_tienda = :id_tienda";

		try(Connection con = sql2o.open()) {
			return con.createQuery(sql)
				.addParameter("id_tienda",id)
				.executeAndFetchFirst(TiendaEntity.class); //First retorna el objeto, no List
		}
	}

	//FIXME: revisar CHECK en def. de tabla
	public TiendaEntity save(TiendaEntity tienda){
		String insertSql =
			"INSERT INTO TIENDA (numeracion, id_ranking, nombre_tienda, telefono_tienda, id_ubicacion)" +
			"VALUES (:numeracion, :id_ranking, :nombre_tienda, :telefono_tienda, :id_ubicacion)";

		try (Connection con = sql2o.open()) {
		    int id = con.createQuery(insertSql,true)
			.addParameter("id_ranking", tienda.getId_ranking())
			.addParameter("nombre_tienda", tienda.getNombre_tienda())
			.addParameter("telefono_tienda",tienda.getTelefono_tienda())
			.addParameter("id_ubicacion",tienda.getId_ubicacion())
			.executeUpdate()
			.getKey(Integer.class); //importante: setear id nueva del objeto!

		    tienda.setId_tienda(id);
	    	    return tienda;
		}
	}

	public TiendaEntity update(TiendaEntity tienda){
		String insertSql =
				"UPDATE TIENDA + " +
						"SET id_ubicacion = :id_ubicacion, id_ranking = :id_ranking, nombre_tienda = :nombre_tienda, telefono_tienda = :telefono_tienda" +
						"WHERE id_tienda = :id_tienda";

		try (Connection con = sql2o.open()) {
			con.createQuery(insertSql,true)
					.addParameter("id_tienda", tienda.getId_tienda())
					.addParameter("id_ubicacion",tienda.getId_ubicacion())
					.addParameter("id_ranking", tienda.getId_ranking())
					.addParameter("nombre_tienda", tienda.getNombre_tienda())
					.addParameter("telefono_tienda",tienda.getTelefono_tienda())
					.executeUpdate();

			TiendaEntity tiendaNew = con.createQuery("SELECT * FROM TIENDA WHERE id_tienda = :id_tienda ")
					.addParameter("id_tienda",tienda.getId_tienda())
					.executeAndFetchFirst(TiendaEntity.class);

			return tiendaNew;
		}
	}

	public boolean delete(TiendaEntity tienda){
		String insertSql =
				"DELETE TIENDA + " +
						"WHERE id_tienda = :id_tienda";

		try (Connection con = sql2o.open()) {
			con.createQuery(insertSql,true)
					.addParameter("id_tienda", tienda.getId_tienda())
					.executeUpdate();

			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
