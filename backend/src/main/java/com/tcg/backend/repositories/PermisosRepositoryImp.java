package com.tcg.backend.repositories;

import com.tcg.backend.entities.PermisosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public class PermisosRepositoryImp implements PermisosRepository {

    private Sql2o sql2o;

    @Autowired
    public PermisosRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    // CREATE

    @Override
    public PermisosEntity CreatePermission(PermisosEntity permiso) {
        String sql = "INSERT INTO PERMISOS(id_rol, id_usuario) " +
                "VALUES (:id_rol, :id_usuario)";
        try (Connection con = sql2o.open()) {
            int id_permiso = con.createQuery(sql, true)
                    .addParameter("id_rol", permiso.getId_rol())
                    .addParameter("id_usuario", permiso.getId_usuario())
                    .addParameter("id_permiso", permiso.getId_permiso())
                    .executeUpdate()
                    .getKey(Long.class);
            permiso.setId_permiso(id_permiso);
            return permiso;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // READ

    @Override
    public List<PermisosEntity> AllPermission(){
        String sql = "SELECT * FROM PERMISOS";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(PermisosEntity.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public PermisosEntity GetPermission(int id_permiso) {
        String sql = "SELECT * FROM PERMISOS WHERE id_permiso = :id_permiso";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_permiso",id_permiso)
                    .executeAndFetchFirst(PermisosEntity.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // UPDATE
    @Override
    public  PermisosEntity UpdatePermission(PermisosEntity permiso, int id_permiso) {
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE UBICACION SET id_rol = :id_rol, id_usuario = :id_usuario WHERE id_permiso = :id_permiso";
            con.createQuery(sql,true)
                    .addParameter("id_rol", permiso.getId_rol())
                    .addParameter("id_usuario", permiso.getId_usuario())
                    .addParameter("id_permiso", permiso.getId_permiso())
                    .executeUpdate();
            return permiso;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // DELETE

    @Override
    public void DeletePermission(int id_permiso) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM PERMISOS WHERE id_permiso = :id_permiso";
            con.createQuery(sql)
                    .addParameter("id_permiso", id_permiso)
                    .executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}