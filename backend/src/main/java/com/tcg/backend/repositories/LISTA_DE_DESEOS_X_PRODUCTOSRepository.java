package com.tcg.backend.repositories;

import com.tcg.backend.entities.LISTA_DE_DESEOS_X_PRODUCTOSEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class LISTA_DE_DESEOS_X_PRODUCTOSRepository {
    @Autowired
    private Sql2o sql2o;

    // READ

    public List<LISTA_DE_DESEOS_X_PRODUCTOSEntity> findAll() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM LISTA_DE_DESEOS_X_PRODUCTOS";
            return con.createQuery(sql).executeAndFetch(LISTA_DE_DESEOS_X_PRODUCTOSEntity.class);
        }
    }

    public LISTA_DE_DESEOS_X_PRODUCTOSEntity findById(int id_lista,int id_producto) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM LISTA_DE_DESEOS_X_PRODUCTOS " +
                    "WHERE id_lista = :id_lista AND id_producto = :id_producto";
            return con.createQuery(sql)
                    .addParameter("id_lista",id_lista)
                    .addParameter("id_producto",id_producto)
                    .executeAndFetchFirst(LISTA_DE_DESEOS_X_PRODUCTOSEntity.class);
        }
    }

    // CRUD

    public LISTA_DE_DESEOS_X_PRODUCTOSEntity save(LISTA_DE_DESEOS_X_PRODUCTOSEntity entity) {
        String sql = "INSERT INTO LISTA_DE_DESEOS_X_PRODUCTOS(id_lista,id_producto) " +
                "VALUES (:id_lista,:id_producto)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_lista",entity.getId_lista())
                    .addParameter("id_producto",entity.getId_producto())
                    .executeUpdate();
            return entity;
        }
    }

    // UPDATE

    public boolean updateProducto(int id_lista, int id_producto, int id_producto_nuevo) {
        String sql = "UPDATE LISTA_DE_DESEOS_X_PRODUCTOS " +
                "SET id_producto = :nuevo_id_producto " +
                "WHERE id_lista = :id_lista AND id_producto = :id_producto";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_producto_nuevo", id_producto_nuevo)
                    .addParameter("id_lista", id_lista)
                    .addParameter("id_producto", id_producto)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // DELETE

    public boolean Delete(int id_lista,int id_producto){
        String sql = " DELETE FROM LISTA_DE_DESEOS_X_PRODUCTOS " +
                "WHERE id_lista = :id_lista AND id_producto = :id_producto";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_lista",id_lista)
                    .addParameter("id_producto",id_producto)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
