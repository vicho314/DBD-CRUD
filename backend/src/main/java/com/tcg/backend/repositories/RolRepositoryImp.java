package com.tcg.backend.repositories;

import com.tcg.backend.entities.PermisosEntity;
import com.tcg.backend.entities.RolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public class RolRepositoryImp implements RolRepository {

    private Sql2o sql2o;

    @Autowired
    public RolRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    // CREATE

    @Override
    public RolEntity CreateRol(RolEntity rol) {
        String sql = "INSERT INTO ROL(id_rol,id_usuario,id_tienda,nombre_rol) " +
                "VALUES (:id_rol,:id_usuario,:id_tienda,:nombre_rol)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_usuario", rol.getId_usuario())
                    .addParameter("id_tienda", rol.getId_tienda())
                    .addParameter("nombre_rol", rol.getNombre_rol())
                    .addParameter("id_rol", rol.getId_rol())
                    .executeUpdate();
            return rol;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // READ

    @Override
    public List<RolEntity> getAllRol() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM ROL";
            return  con.createQuery(sql).executeAndFetch(RolEntity.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public RolEntity GetRol(int id_rol) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM ROL WHERE id_rol = :id_rol";
            return con.createQuery(sql)
                    .addParameter("id_rol", id_rol)
                    .executeAndFetchFirst(RolEntity.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // UPDATE

    @Override
    public RolEntity UpdateRol(RolEntity rol, int id_rol) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE ROL SET id_usuario = :id_usuario, id_tienda = :id_tienda, nombre_rol = :nombre_rol " +
                    "WHERE id_rol = :id_rol";
            con.createQuery(sql)
                    .addParameter("id_usuario", rol.getId_usuario())
                    .addParameter("id_tienda", rol.getId_tienda())
                    .addParameter("nombre_rol", rol.getNombre_rol())
                    .addParameter("id_rol", rol.getId_rol())
                    .executeUpdate();
            return rol;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // DELETE

    @Override
    public void DeleteRol(int id_rol) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM ROL WHERE id_rol = :id_rol";
            con.createQuery(sql)
                    .addParameter("id_rol", id_rol)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

