package com.tcg.backend.repositories;

import com.tcg.backend.entities.CARRITO_X_PRODUCTOEntity;
import com.tcg.backend.entities.LISTA_DE_DESEOSXCARTAEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CARRITO_X_PRODUCTORepository {
    @Autowired
    private Sql2o sql2o;

    // READ

    public List<CARRITO_X_PRODUCTOEntity> findAll() {
        String sql = "SELECT * FROM CARRITO_X_PRODUCTO";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(CARRITO_X_PRODUCTOEntity.class);
        }
    }

    public CARRITO_X_PRODUCTOEntity findById(int id_producto, int id_carro) {
        String sql = "SELECT * FROM CARRITO_X_PRODUCTO " +
                "WHERE id_producto= :id_producto AND id_carrito=:id_carro";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_producto",id_producto)
                    .addParameter("id_carro", id_carro)
                    .executeAndFetchFirst(CARRITO_X_PRODUCTOEntity.class);
        }
    }

    // CREATE

    public CARRITO_X_PRODUCTOEntity save(CARRITO_X_PRODUCTOEntity entity) {
        String sql = "INSERT INTO CARRITO_X_PRODUCTO(id_producto,id_carro,disponibilidad)" +
                "VALUES(:id_producto,:id_carro,:disponibilidad)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_producto", entity.getId_producto())
                    .addParameter("id_carro", entity.getId_carro())
                    .addParameter("disponibilidad", entity.getDisponibilidad())
                    .executeUpdate();
            return entity;
        }
    }

    // UPDATE

    public boolean Updatedisponibilidad(int id_producto, int id_carro, boolean disponibilidad) {
        String sql = "UPDATE CARRITO_X_PRODUCTO " +
                "SET disponibilidad = :disponibilidad " +
                "WHERE id_producto= :id_producto AND id_carro=:id_carro";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("disponibilidad", disponibilidad)
                    .addParameter("id_producto", id_producto)
                    .addParameter("id_carro", id_carro)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    // DELETE

    public boolean delete(int id_producto, int id_carro) {
        String sql = "DELETE FROM CARRITO_X_PRODUCTO" +
                "WHERE id_producto= :id_producto AND id_carro=:id_carro";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_producto", id_producto)
                    .addParameter("id_carro", id_carro)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}