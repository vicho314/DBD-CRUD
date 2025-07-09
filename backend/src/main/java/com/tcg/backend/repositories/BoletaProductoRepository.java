package com.tcg.backend.repositories;

import com.tcg.backend.entities.BoletaProductoEntity;
//import com.tcg.backend.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class BoletaProductoRepository {
    //Cargar la configuracion automáticamente
    @Autowired
    private Sql2o sql2o;

    public List<BoletaProductoEntity> findAll(){
        String sql =
                "SELECT * " +
                        "FROM BOLETA_X_PRODUCTO";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(BoletaProductoEntity.class);
        }
    }

    public List<BoletaProductoEntity> findByIdBoleta(int id_boleta){
        String sql =
                "SELECT * " +
                        "FROM BOLETA_X_PRODUCTO WHERE id_boleta = :id_boleta";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_boletaProducto",id_boleta)
                    .executeAndFetch(BoletaProductoEntity.class); //First retorna el objeto, no List
        }
    }

    public List<BoletaProductoEntity> findByIdProducto(int id_producto){
        String sql =
                "SELECT * " +
                        "FROM BOLETA_X_PRODUCTO WHERE id_producto = :id_producto";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_producto",id_producto)
                    .executeAndFetch(BoletaProductoEntity.class); //First retorna el objeto, no List
        }
    }

    //FIXME: revisar CHECK en def. de tabla
    public BoletaProductoEntity save(BoletaProductoEntity boletaProducto){
        String insertSql =
                "INSERT INTO BOLETA_X_PRODUCTO (id_producto,id_boleta)" +
                        "VALUES (:id_producto, :id_boleta)";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql)
                    .addParameter("id_producto", boletaProducto.getId_producto())
                    .addParameter("id_boleta", boletaProducto.getId_boleta())
                    .executeUpdate();
                    //.getKey(Integer.class); //importante: setear id nueva del objeto!

            return boletaProducto;
        }
    }

    public BoletaProductoEntity update(BoletaProductoEntity boletaProducto, BoletaProductoEntity bpNew){
        String insertSql =
                "UPDATE BOLETA_X_PRODUCTO + " +
                        "SET id_boleta = :id_boleta_new AND id_producto = :id_producto_new" +
                        "WHERE id_boleta = :id_boleta AND id_producto = :id_producto";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql,true)
                    .addParameter("id_producto", boletaProducto.getId_producto())
                    .addParameter("id_boleta", boletaProducto.getId_boleta())
                    .addParameter("id_producto_new", bpNew.getId_producto())
                    .addParameter("id_boleta_new", bpNew.getId_boleta())
                    .executeUpdate();

            BoletaProductoEntity boletaProductoNew = con.createQuery("SELECT * FROM BOLETA_X_PRODUCTO WHERE id_producto = :id_producto AND id_boleta = :id_boleta")
                    .addParameter("id_producto_new", bpNew.getId_producto())
                    .addParameter("id_boleta_new", bpNew.getId_boleta())
                    .executeAndFetchFirst(BoletaProductoEntity.class);

            return boletaProductoNew;
        }
    }

    public boolean delete(BoletaProductoEntity boletaProducto){
        String insertSql =
                "DELETE BOLETA_X_PRODUCTO + " +
                        "WHERE id_boleta = :id_boleta AND id_producto = :id_producto";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql,true)
                    .addParameter("id_producto", boletaProducto.getId_producto())
                    .addParameter("id_boleta", boletaProducto.getId_boleta())
                    .executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

