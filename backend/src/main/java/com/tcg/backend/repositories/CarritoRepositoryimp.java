package com.tcg.backend.repositories;

import com.tcg.backend.entities.CarritoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Collections;
import java.util.List;

@Repository
public abstract class CarritoRepositoryimp implements CarritoRepository {

    private Sql2o sql2o;
    @Autowired
    public CarritoRepositoryimp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE
    @Override
    public CarritoEntity create(CarritoEntity carrito){
        String sql = "INSERT INTO CARRITO( id_carro,id_metodo_pago, id_usuario,  estado_carrito, cantidad_elementos, total_pago) " +
                "VALUES(:id_carro, :id_metodo_pago, :id_usuario, :estado_carrito, :cantidad_elementos, :otal_pago)";

        try(Connection con = sql2o.open()){
            int id_carro = con.createQuery(sql, true)
                    .addParameter("id_carro",carrito.getId_carro())
                    .addParameter("id_metodo_pago",carrito.getId_metodo_pago())
                    .addParameter("id_usuario",carrito.getId_usuario())
                    .addParameter("estado_carrito",carrito.getEstado_carrito())
                    .addParameter("cantidad_elementos",carrito.getCantidad_elementos())
                    .addParameter("total_pago",carrito.getTotal_pago())
                    .executeUpdate()
                    .getKey(Integer.class);

            carrito.setId_carro(id_carro);
            return carrito;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


    //READ
    public List<CarritoEntity> findAll(){
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM CARRITO";
            return  con.createQuery(sql).executeAndFetch(CarritoEntity.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    @Override
    public CarritoEntity findById(int id_carro) {
        try(Connection con = sql2o.open()){
            String sql = "SELECT * FROM CARRITO WHERE id_carro = :id_carro";
            return (CarritoEntity) Collections.singletonList(con.createQuery(sql)
                    .addParameter("id_carro", id_carro)
                    .executeAndFetchFirst(CarritoEntity.class));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //UPDATE
    public CarritoEntity update(CarritoEntity carrito, int id_carro){
        try(Connection con = sql2o.open()){
            String sql = "UPDATE CARRITO SET id_carro = :id_carro, id_metodo_pago = :id_metodo_pago, id_usuario = :id_usuario," +
            " estado_carrito = :estado_carrito, cantidad_elementos = :cantidad_elementos, total_pago = :total_pago";
            con.createQuery(sql, true)
                    .addParameter("id_carro", carrito.getId_carro())
                    .addParameter("id_metodo_pago", carrito.getId_metodo_pago())
                    .addParameter("id_usuario", carrito.getId_usuario())
                    .addParameter("estado_carrito", carrito.getEstado_carrito())
                    .addParameter("cantidad_elementos", carrito.getCantidad_elementos())
                    .addParameter("total_pago", carrito.getTotal_pago())
                    .executeUpdate();
            return carrito;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


    //DELETE
    @Override
    public void delete(int id_carro) {
        String sql = "DELETE FROM CARRITO WHERE id_carro = :id_carro";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id_carro", id_carro).executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}

