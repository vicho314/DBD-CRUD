package com.tcg.backend.repositories;

import com.tcg.backend.entities.LISTA_DE_DESEOSXCARTAEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class LISTA_DE_DESEOSXCARTARepository {
    @Autowired
    private Sql2o sql2o;

    public List<LISTA_DE_DESEOSXCARTAEntity> findAll() {
        String sql = "SELECT * FROM LISTA_DE_DESEOSXCARTA";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(LISTA_DE_DESEOSXCARTAEntity.class);
        }
    }

    public LISTA_DE_DESEOSXCARTAEntity findById(int idLista, int idCarta) {
        String sql = """
                SELECT * FROM LISTA_DE_DESEOSXCARTA
                WHERE id_lista = :id_lista AND id_carta = :id_carta
                """;
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_lista", idLista)
                    .addParameter("id_carta", idCarta)
                    .executeAndFetchFirst(LISTA_DE_DESEOSXCARTAEntity.class);
        }
    }

    public LISTA_DE_DESEOSXCARTAEntity save(LISTA_DE_DESEOSXCARTAEntity entity) {
        String sql = """
                 INSERT INTO LISTA_DE_DESEOSXCARTA (
                     id_lista,
                     id_carta,
                     cantidad_veces_agregada
                 )
                 VALUES (
                     :id_lista,
                     :id_carta,
                     :cantidad_veces_agregada
                )
                """;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_lista", entity.getId_lista())
                    .addParameter("id_carta", entity.getId_carta())
                    .addParameter("cantidad_veces_agregada", entity.getCantidad_veces_agregada())
                    .executeUpdate();
            return entity;
        }
    }

    public boolean delete(int id_lista, int id_carta) {
        String sql = """
                DELETE FROM LISTA_DE_DESEOSXCARTA 
                WHERE id_lista = :id_lista AND id_carta = :id_carta
                """;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_lista", id_lista)
                    .addParameter("id_carta", id_carta)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCantidad(int idlista, int idcarta, int nuevaCantidad) {
        String sql = """
                UPDATE LISTA_DE_DESEOSXCARTA 
                SET cantidad_veces_agregada = :cantidad
                WHERE id_lista = :id_lista AND id_carta = :id_carta
                """;
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("cantidad", nuevaCantidad)
                    .addParameter("id_lista", idlista)
                    .addParameter("id_carta", idcarta)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}