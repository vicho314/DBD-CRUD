package com.tcg.backend.repositories;

import com.tcg.backend.entities.RolEntity;
//import com.tcg.backend.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class RolRepository {
    //Cargar la configuracion automáticamente
    @Autowired
    private Sql2o sql2o;

    public List<RolEntity> findAll(){
        String sql =
                "SELECT * " +
                        "FROM ROL";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(RolEntity.class);
        }
    }

    public RolEntity findById(int id){
        String sql =
                "SELECT * " +
                        "FROM ROL WHERE id_rol = :id_rol";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_rol",id)
                    .executeAndFetchFirst(RolEntity.class); //First retorna el objeto, no List
        }
    }

    //FIXME: revisar CHECK en def. de tabla
    public RolEntity save(RolEntity rol){
        String insertSql =
                "INSERT INTO ROL (id_rol, id_usuario, nombre_rol)" +
                        "VALUES (:id_rol, :id_usuario, :nombre_rol)";

        try (Connection con = sql2o.open()) {
                con.createQuery(insertSql)
                    .addParameter("id_rol", rol.getId_rol())
                    .addParameter("id_usuario",rol.getId_usuario())
                    .addParameter("nombre_rol",rol.getNombre_rol())
                    .executeUpdate();
                     //importante: setear id nueva del objeto!

            return rol;
        }
    }

    // PRIMARY KEYS!!!! id_rol, id_user
    public RolEntity update(int id_rol, int id_usuario, RolEntity nuevo){
        String insertSql =
                "UPDATE ROL + " +
                        "SET id_rol = :id_rol_new, id_usuario = :id_usuario_new, nombre_rol = :nombre_rol_new" +
                        "WHERE id_rol = :id_rol, id_usuario = :id_usuario ";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql,true)
                    .addParameter("id_rol", id_rol)
                    .addParameter("id_usuario",id_usuario)
                    .addParameter("id_rol_new", nuevo.getId_rol())
                    .addParameter("id_usuario_new",nuevo.getId_usuario())
                    .addParameter("nombre_rol_new", nuevo.getNombre_rol())
                    .executeUpdate();

            return con.createQuery("SELECT * FROM ROL WHERE id_rol = :id_rol AND id_usuario = :id_usuario")
                    .addParameter("id_rol",id_rol)
                    .addParameter("id_usuario",id_usuario)
                    .executeAndFetchFirst(RolEntity.class);
        }
    }

    public boolean delete(RolEntity rol){
        String insertSql =
                "DELETE ROL + " +
                        "WHERE id_rol = :id_rol AND id_usuario = :id_usuario";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql)
                    .addParameter("id_rol", rol.getId_rol())
                    .addParameter("id_usuario", rol.getId_usuario())
                    .executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
