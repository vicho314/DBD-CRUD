package com.tcg.backend.repositories;
import com.tcg.backend.entities.MetodosPagoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collections;
import java.util.List;

@Repository
public class MetodosPagoRepositoryimp implements MetodosPagoRepository {

    private Sql2o sql2o;
    @Autowired
    public MetodosPagoRepositoryimp(Sql2o sql2o){
        this.sql2o=sql2o;
    }

    //CREATE
    @Override
    public MetodosPagoEntity create(MetodosPagoEntity metodospago) {
        String sql = "INSERT INTO METODOSPAGO(id_metodo_de_pago, tipo_de_pago, Sbanco, nombre_titular,numero_tarjeta, fecha_vencimiento,codigo_seguridad, rut_titular)" +
                "VALUES(:id_metodo_de_pago, :tipo_de_pago, :banco, :String nombre_titular, :numero_tarjeta, :fecha_vencimiento, :codigo_seguridad, :rut_titular)";
        try (Connection con = sql2o.open()){
            int id_metodo_de_pago = con.createQuery(sql, true)
                    .addParameter("id_metodo_de_pago", metodospago.getId_metodo_de_pago())
                    .addParameter("tipo_de_pago", metodospago.getTipo_de_pago())
                    .addParameter("banco", metodospago.getBanco())
                    .addParameter("nombre_titular", metodospago.getNombre_titular())
                    .addParameter("numero_tarjeta", metodospago.getNumero_tarjeta())
                    .addParameter("fecha_vencimiento", metodospago.getFecha_vencimiento())
                    .addParameter("codigo_seguridad", metodospago.getCodigo_seguridad())
                    .addParameter("rut_titular", metodospago.getRut_titular())
                    .executeUpdate()
                    .getKey(Integer.class);

            metodospago.setId_metodo_de_pago(id_metodo_de_pago);
            return metodospago;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //READ

    @Override
    public List<MetodosPagoEntity> findAll(){
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM METODOSPAGO";
            return con.createQuery(sql).executeAndFetch(MetodosPagoEntity.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public MetodosPagoEntity findById(int id_metodo_de_pago){
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM METODOSPAGO WHERE id_metodo_de_pago = :id_metodo_de_pago";
            return (MetodosPagoEntity) Collections.singletonList(con.createQuery(sql)
                    .addParameter("id_metodo_de_pago", id_metodo_de_pago)
                    .executeAndFetchFirst(MetodosPagoEntity.class));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //UPDATE
    public MetodosPagoEntity update(MetodosPagoEntity metodospago, int id_metodo_de_pago){
        try (Connection con = sql2o.open()){
            String sql = "UPDATE METODOSPAGO SET id_metodo_de_pago = :id_metodo_de_pago, tipo_de_pago = :tipo_de_pago, banco = :banco, nombre_titular = :nombre_titular," +
                    " numero_tarjeta = :numero_tarjeta, fecha_vencimiento = :fecha_vencimiento, codigo_seguridad = :codigo_seguridad, rut_titular = :rut_titular";
            con.createQuery(sql, true)
                    .addParameter("id_metodo_de_pago", metodospago.getId_metodo_de_pago())
                    .addParameter("tipo_de_pago", metodospago.getTipo_de_pago())
                    .addParameter("banco", metodospago.getBanco())
                    .addParameter("nombre_titular", metodospago.getNombre_titular())
                    .addParameter("numero_tarjeta", metodospago.getNumero_tarjeta())
                    .addParameter("fecha_vencimiento", metodospago.getFecha_vencimiento())
                    .addParameter("codigo_seguridad", metodospago.getCodigo_seguridad())
                    .addParameter("rut_titular", metodospago.getRut_titular())
                    .executeUpdate();
            return metodospago;

        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //DELETE

    @Override
    public void delete(int id_metodo_de_pago) {
        String sql = "DELETE FROM METODOSPAGO WHERE id_metodo_de_pago = :id_metodo_de_pago";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id_metodo_de_pago", id_metodo_de_pago).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}


