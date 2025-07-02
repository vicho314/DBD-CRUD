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

	public void setDefaultMapping(){
		//O los atributos se llaman igual que en sql, o los mapeamos	
		Map<String, String> colMaps = new HashMap<String,String>();
		colMaps.put("id_tienda", "id");
		colMaps.put("nombre_tienda", "nombre");
		colMaps.put("telefono_tienda", "telefono");
		colMaps.put("calle_tienda", "calle");
		colMaps.put("numero_tienda", "numero");
		colMaps.put("ciudad_tienda", "ciudad");
		sql2o.setDefaultColumnMappings(colMaps);
	}

	public List<TiendaEntity> findAll(){
		setDefaultMapping();
		String sql = 
			"SELECT * " +
			"FROM TIENDA";
		
		try(Connection con = sql2o.open()) {
        		return con.createQuery(sql)
				.executeAndFetch(TiendaEntity.class);
    		}
	}

	//FIXME: revisar CHECK en def. de tabla
	public TiendaEntity save(TiendaEntity tienda){
		setDefaultMapping();
		String insertSql = 
			"INSERT INTO TIENDA (id_ranking, nombre_tienda, telefono_tienda, calle_tienda, numero_tienda, ciudad_tienda)" +
			"VALUES (:id_ranking, :nombre_tienda, :telefono_tienda, :calle_tienda, :numero_tienda, :ciudad_tienda)";

		try (Connection con = sql2o.open()) {
		    int id = con.createQuery(insertSql,true)
			.addParameter("id_ranking", tienda.getId_ranking())
			.addParameter("nombre_tienda", tienda.getNombre())
			.addParameter("telefono_tienda",tienda.getTelefono()) 
			.addParameter("calle_tienda",tienda.getCalle())
			.addParameter("numero_tienda",tienda.getNumero()) 
			.addParameter("ciudad_tienda",tienda.getCiudad())
			.executeUpdate()
			.getKey(Integer.class); //importante: setear id nueva del objeto!
			
		    tienda.setId(id);
	    	    return tienda;	    
		}
	}
}
