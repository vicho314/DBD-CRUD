package com.tcg.backend.repositories;

import com.tcg.backend.entities.ListaDeseosEntity;
import com.tcg.backend.entities.TiendaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ListaDeseosRepository{
    @Autowired
    private Sql2o sql2o;

    public List<ListaDeseosEntity> findAll(){
        String sql = "SELECT * FROM lista_de_deseos";
        try  (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(ListaDeseosEntity.class);
        }
    }

    public ListaDeseosEntity findById(int id){
        String sql = "SELECT * FROM lista_de_deseos WHERE id_lista = :id_lista";
        try  (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_lista", id)
                    .executeAndFetchFirst(ListaDeseosEntity.class);
        }
    }

    public ListaDeseosEntity save(ListaDeseosEntity lista) {
        String sql = """
                INSERT INTO lista_de_deseos (nombre_lista)
                VALUES (:nombre_lista)
        """;
        try  (Connection con = sql2o.open()) {
            int id = con.createQuery(sql, true)
                    .addParameter("nombre_lista", lista.getNombre_lista())
                    .executeUpdate()
                    .getKey(Integer.class);

            lista.setId_lista(id);
            return lista;
        }
    }

    public ListaDeseosEntity update(ListaDeseosEntity lista) {
        String sql = """
                UPDATE lista_de_deseos
                SET nombre_lista = :nombre_lista
                WHERE id_lista = :id_lista 
        """;
        try  (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("nombre_lista", lista.getNombre_lista())
                    .addParameter("id_lista", lista.getId_lista())
                    .executeUpdate();

            return lista;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM lista_de_deseos WHERE id_lista = :id_lista";
        try  (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_lista", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}