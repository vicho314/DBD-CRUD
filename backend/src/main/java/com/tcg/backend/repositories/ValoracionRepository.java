package com.tcg.backend.repositories;

import com.tcg.backend.entities.ValoracionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ValoracionRepository {

    @Autowired
    private Sql2o sql2o;

    public List<ValoracionEntity> findAll() {
        String sql =
                "SELECT * " +
                        "FROM VALORACION";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(ValoracionEntity.class);
        }
    }

    public ValoracionEntity findById(int id) {
        String sql =
                "SELECT * " +
                        "FROM VALORACION WHERE id_valoracion = :id_valoracion";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_valoracion", id)
                    .executeAndFetchFirst(ValoracionEntity.class); //First retorna el objeto, no List
        }
    }

    public boolean checkUserProd(int id_user, int id_prod) {
        String sql =
                "SELECT * " +
                        "FROM VALORACION WHERE id_usuario = :id_usuario AND id_producto = :id_producto";

        try (Connection con = sql2o.open()) {
            List<ValoracionEntity> res = con.createQuery(sql)
                    .addParameter("id_usuario", id_user)
                    .addParameter("id_producto", id_prod)
                    .executeAndFetch(ValoracionEntity.class);
            if (res.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
    }
        //FIXME: revisar CHECK en def. de tabla
    public ValoracionEntity save (ValoracionEntity valoracion){
        String insertSql = "INSERT INTO VALORACION (id_producto, id_usuario, puntuacion)" +
                            "VALUES (:id_producto, :id_usuario, :puntuacion)";

        try (Connection con = sql2o.open()) {
            int id = con.createQuery(insertSql, true)
                    .addParameter("id_producto", valoracion.getId_producto())
                    .addParameter("id_usuario", valoracion.getId_usuario())
                    .addParameter("puntuacion", valoracion.getPuntuacion())
                    .executeUpdate()
                    .getKey(Integer.class); //importante: setear id nueva del objeto!

            valoracion.setId_valoracion(id);
            return valoracion;
            }
        }

    public ValoracionEntity update (ValoracionEntity valoracion){
        String insertSql =
                "UPDATE VALORACION + " +
                        "SET id_producto = :id_producto, id_usuario = :id_usuario, puntuacion = :puntuacion" +
                        "WHERE id_valoracion = :id_valoracion";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql, true)
                    .addParameter("id_valoracion", valoracion.getId_valoracion())
                    .addParameter("id_producto", valoracion.getId_producto())
                    .addParameter("id_usuario", valoracion.getId_usuario())
                    .addParameter("puntuacion", valoracion.getPuntuacion())
                    .executeUpdate();

            ValoracionEntity valoracionNew = con.createQuery("SELECT * FROM VALORACION WHERE id_valoracion = :id_valoracion ")
                    .addParameter("id_valoracion", valoracion.getId_valoracion())
                    .executeAndFetchFirst(ValoracionEntity.class);

            return valoracionNew;
        }
    }

    public boolean delete (ValoracionEntity valoracion) {
        String insertSql =
                "DELETE VALORACION + " +
                        "WHERE id_valoracion = :id_valoracion";
        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql, true)
                    .addParameter("id_valoracion", valoracion.getId_valoracion())
                    .executeUpdate();
                return true;
        } catch (Exception e) {
            return false;
        }
    }
}
