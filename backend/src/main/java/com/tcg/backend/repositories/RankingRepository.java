package com.tcg.backend.repositories;

import com.tcg.backend.entities.RankingEntity;
//import com.tcg.backend.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Repository
public class RankingRepository {
    //Cargar la configuracion automáticamente
    @Autowired
    private Sql2o sql2o;

    public List<RankingEntity> findAll(){
        String sql =
                "SELECT * " +
                        "FROM RANKING";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(RankingEntity.class);
        }
    }

    public RankingEntity findById(int id){
        String sql =
                "SELECT * " +
                        "FROM RANKING WHERE id_ranking = :id_ranking";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_ranking",id)
                    .executeAndFetchFirst(RankingEntity.class); //First retorna el objeto, no List
        }
    }

    //FIXME: revisar CHECK en def. de tabla
    public RankingEntity save(RankingEntity ranking){
        String insertSql =
                "INSERT INTO RANKING (fecha_ranking_v)" +
                        "VALUES (fecha_ranking_v)";

        try (Connection con = sql2o.open()) {
            int id = con.createQuery(insertSql,true)
                    .addParameter("fecha_ranking_v", ranking.getFecha_ranking_v())
                    .executeUpdate()
                    .getKey(Integer.class); //importante: setear id nueva del objeto!

            ranking.setId_ranking(id);
            return ranking;
        }
    }

    public RankingEntity update(RankingEntity ranking){
        String insertSql =
                "UPDATE RANKING + " +
                        "SET fecha_ranking_v = :fecha_ranking_v" +
                        "WHERE id_ranking = :id_ranking";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql,true)
                    .addParameter("id_ranking", ranking.getId_ranking())
                    .addParameter("fecha_ranking_v",ranking.getFecha_ranking_v())
                    .executeUpdate();

            RankingEntity rankingNew = con.createQuery("SELECT * FROM RANKING WHERE id_ranking = :id_ranking ")
                    .addParameter("id_ranking",ranking.getId_ranking())
                    .executeAndFetchFirst(RankingEntity.class);

            return rankingNew;
        }
    }

    public boolean delete(RankingEntity ranking){
        String insertSql =
                "DELETE RANKING + " +
                        "WHERE id_ranking = :id_ranking";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql,true)
                    .addParameter("id_ranking", ranking.getId_ranking())
                    .executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
