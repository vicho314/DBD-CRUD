package com.tcg.backend.repositories;

import com.tcg.backend.entities.CartaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CartaRepository{
    @Autowired
    private Sql2o sql2o;

    public List<CartaEntity> findAll(){
        String sql = "SELECT * FROM CARTA";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(CartaEntity.class);
        }
    }

    public CartaEntity findById(int id){
        String sql = "SELECT * FROM CARTA WHERE id_carta = :id_carta";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id_carta", id)
                    .executeAndFetchFirst(CartaEntity.class);
        }
    }
    public CartaEntity save (CartaEntity carta){
        String sql = """
                INSERT INTO CARTA (
                    posicion_deseada,
                    precio,
                    stock,
                    rareza, 
                    año,
                    estado,
                    id_producto
                )
                VALUES (
                    :posicion_deseada,
                    :precio,
                    :stock,
                    :rareza,
                    :año,
                    :estado,
                    :id_producto
               )
               """;
        try (Connection con = sql2o.open()){
            int id = con.createQuery(sql, true)
                    .addParameter("posicion_deseada", carta.getPosicion_deseada())
                    .addParameter("precio",  carta.getPrecio())
                    .addParameter("stock", carta.getStock())
                    .addParameter("rareza", carta.getRareza())
                    .addParameter("año", carta.getAño())
                    .addParameter("estado", carta.getEstado())
                    .addParameter("id_producto", carta.getId_producto())
                    .executeUpdate()
                    .getKey(Integer.class);

            carta.setId_carta(id);
            return carta;
        }
    }

    public boolean delete(int id){
        String sql = "DELETE FROM CARTA WHERE id_carta = :id_carta";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id_carta", id)
                    .executeUpdate();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}