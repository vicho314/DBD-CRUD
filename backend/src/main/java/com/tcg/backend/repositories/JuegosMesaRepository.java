package com.tcg.backend.repositories;

import com.tcg.backend.entities.JuegosMesaEntity;
//import com.tcg.backend.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

//import java.util.HashMap;
//import java.util.Map;
import java.util.List;

@Repository
public class JuegosMesaRepository {
    //Cargar la configuracion automáticamente
    @Autowired
    private Sql2o sql2o;

    public List<JuegosMesaEntity> findAll(){
        String sql =
                "SELECT * " +
                        "FROM JUEGO";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(JuegosMesaEntity.class);
        }
    }

    public JuegosMesaEntity findById(int id){
        String sql =
                "SELECT * " +
                        "FROM JUEGO WHERE id_juego = :id_juego";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_juego",id)
                    .executeAndFetchFirst(JuegosMesaEntity.class); //First retorna el objeto, no List
        }
    }

    //FIXME: revisar CHECK en def. de tabla
    public JuegosMesaEntity save(JuegosMesaEntity juego){
        String insertSql =
                "INSERT INTO JUEGO (id_producto, precio, nombre_juego, tipo)" +
                        "VALUES (:id_producto, :precio, :nombre_juego, :tipo)";

        try (Connection con = sql2o.open()) {
            int id = con.createQuery(insertSql,true)
                    .addParameter("id_producto", juego.getId_producto())
                    .addParameter("precio", juego.getPrecio())
                    .addParameter("nombre_juego",juego.getNombre_juego())
                    .addParameter("id_ubicacion",juego.getTipo())
                    .executeUpdate()
                    .getKey(Integer.class); //importante: setear id nueva del objeto!

            juego.setId_juego(id);
            return juego;
        }
    }

    public JuegosMesaEntity update(JuegosMesaEntity juego){
        String insertSql =
                "UPDATE JUEGO + " +
                        "SET id_producto = :id_producto, precio = :precio, nombre_juego = :nombre_juego, tipo = :tipo" +
                        "WHERE id_juego = :id_juego";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql,true)
                    .addParameter("id_juego", juego.getId_juego())
                    .addParameter("id_producto", juego.getId_producto())
                    .addParameter("precio", juego.getPrecio())
                    .addParameter("nombre_juego",juego.getNombre_juego())
                    .addParameter("id_ubicacion",juego.getTipo())
                    .executeUpdate();

            JuegosMesaEntity juegoNew = con.createQuery("SELECT * FROM JUEGO WHERE id_juego = :id_juego ")
                    .addParameter("id_juego",juego.getId_juego())
                    .executeAndFetchFirst(JuegosMesaEntity.class);

            return juegoNew;
        }
    }

    public boolean delete(JuegosMesaEntity juego){
        String insertSql =
                "DELETE JUEGO + " +
                        "WHERE id_juego = :id_juego";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql,true)
                    .addParameter("id_juego", juego.getId_juego())
                    .executeUpdate();

            return true;
        }
    }
}
