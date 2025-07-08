package com.tcg.backend.repositories;

import com.tcg.backend.entities.UbicacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public class UbicacionRepositoryImp implements UbicacionRepository {

    private Sql2o sql2o;

    @Autowired
    public UbicacionRepositoryImp(Sql2o sql2o) {this.sql2o = sql2o;}

    // CREATE

    @Override
    public UbicacionEntity CreateLocation(UbicacionEntity ubicacion){
        String sql = "INSERT INTO UBICACION(numeracion,ciudad,calle)"
                + "VALUES (:numeracion,:ciudad,:calle))";
        try (Connection con = sql2o.open()) {
            int id_ubicacion = con.createQuery(sql, true)
                    .addParameter("numeracion", ubicacion.getNumeracion())
                    .addParameter("ciudad", ubicacion.getCiudad())
                    .addParameter("calle", ubicacion.getCalle())
                    .addParameter("id_ubicacion", ubicacion.getId_ubicacion())
                    .executeUpdate()
                    .getKey(Long.class);
            ubicacion.setId_ubicacion(id_ubicacion);
            return ubicacion;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // READ

    @Override
    public List<UbicacionEntity> AllLocations() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM UBICACION";
            return  con.createQuery(sql).executeAndFetch(UbicacionEntity.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public List<UbicacionEntity> Location_for_id(int id_ubicacion) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM UBICACION WHERE id_ubicacion = :id_ubicacion";
            return con.createQuery(sql)
                    .addParameter("id_ubicacion", id_ubicacion)
                    .executeAndFetch(UbicacionEntity.class);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // UPDATE
    @Override
    public UbicacionEntity UpdateLocation(UbicacionEntity ubicacion, int id_ubicacion){
        try (Connection con = sql2o.open()) {
            String sql = "UPDATE UBICACION SET numeracion = :numeracion, ciudad = :ciudad, calle = :calle, WHERE id_ubicacion = :id_ubicacion";
            con.createQuery(sql, true)
                    .addParameter("numeracion", ubicacion.getNumeracion())
                    .addParameter("ciudad", ubicacion.getCiudad())
                    .addParameter("calle", ubicacion.getCalle())
                    .addParameter("id_ubicacion", ubicacion.getId_ubicacion())
                    .executeUpdate();
            return ubicacion;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // DELETE

    @Override
    public void DeleteLocation(int id_ubicacion) {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM UBICACION WHERE id_ubicacion = :id_ubicacion";
            con.createQuery(sql).addParameter("id_ubicacion", id_ubicacion).executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
