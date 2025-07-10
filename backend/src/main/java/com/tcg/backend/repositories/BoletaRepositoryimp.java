package com.tcg.backend.repositories;
import com.tcg.backend.entities.BoletaEntity;
import com.tcg.backend.entities.MetodosPagoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collections;
import java.util.List;

@Repository
public class BoletaRepositoryimp implements BoletaRepository {

    private Sql2o sql2o;
    @Autowired
    public BoletaRepositoryimp(Sql2o sql2o){
        this.sql2o=sql2o;
    }

    //CREATE
    @Override
    public BoletaEntity create(BoletaEntity boleta) {
        String sql = "INSERT INTO BOLETA(id_boleta, id_carro, id_metodo_de_pago,fecha_boleta)" +
                "VALUES(:id_boleta, :id_carro, :id_metodo_de_pago, :fecha_boleta)";
        try (Connection con = sql2o.open()){
            int id_boleta = con.createQuery(sql, true)
                    .addParameter("id_boleta",boleta.getId_boleta())
                    .addParameter("id_carro",boleta.getId_carro())
                    .addParameter("id_metodo_de_pago",boleta.getId_metodo_de_pago())
                    .addParameter("fecha_boleta",boleta.getFecha_boleta())
                    .executeUpdate()
                    .getKey(Integer.class);

            boleta.setId_boleta(id_boleta);
            return boleta;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    //READ

    @Override
    public List<BoletaEntity> findAll(){
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM BOLETA";
            return con.createQuery(sql).executeAndFetch(BoletaEntity.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public BoletaEntity findById(int id_boleta){
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM BOLETA WHERE id_boleta = :id_boleta";
            return (BoletaEntity) Collections.singletonList(con.createQuery(sql)
                    .addParameter("id_boleta", id_boleta)
                    .executeAndFetchFirst(MetodosPagoEntity.class));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //UPDATE
    @Override
    public BoletaEntity update(BoletaEntity boleta, int id_boleta){
        try (Connection con = sql2o.open()){
            String sql = "UPDATE BOLETA SET id_boleta = :id_boleta,  id_carro = : id_carro, id_metodo_de_pago = :id_metodo_de_pago," +
                    " fecha_boleta = :fecha_boleta)";
            con.createQuery(sql, true)
                    .addParameter("id_boleta",boleta.getId_boleta())
                    .addParameter("id_carro",boleta.getId_carro())
                    .addParameter("id_metodo_de_pago",boleta.getId_metodo_de_pago())
                    .addParameter("fecha_boleta",boleta.getFecha_boleta())
                    .executeUpdate();
            return boleta;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //DELETE

    @Override
    public void delete(int id_boleta){
        String sql = "DELETE FROM BOLETA WHERE id_boleta = :id_boleta";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id_boleta", id_boleta).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
