package com.tcg.backend.repositories;

import com.tcg.backend.entities.ProductoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ProductoRepository {
    @Autowired
    private Sql2o sql2o;

    /*@Autowired
    public ProductoRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }*/

    //CREATE
    public ProductoEntity create(ProductoEntity producto) {
        String sql = "INSERT INTO PRODUCTO(id_ranking,id_tienda,stock,cantidad_vendida,url)" +
                "VALUES (:id_ranking,:id_tienda,:stock,:cantidad_vendida,:url)";
        try(Connection conn = sql2o.open()) {
            int id = conn.createQuery(sql,true)
                    .addParameter("id_ranking",producto.getId_ranking())
                    .addParameter("id_tienda",producto.getId_tienda())
                    .addParameter("stock",producto.getStock())
                    .addParameter("cantidad_vendida",producto.getCantidad_vendida())
                    .addParameter("url",producto.getUrl())
                    .executeUpdate()
                    .getKey(Integer.class);

            producto.setId_producto(id);
            return producto;
        }
        catch (Exception e) {
            System.out.println("Error al crear la unión entre producto y categoria"+e.getMessage());
            return null;
        }
    }

    //READ
    public List<ProductoEntity> getAll() {
        String sql = "SELECT * FROM PRODUCTO";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(ProductoEntity.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar las uniones entre producto y categorias"+e.getMessage());
            return null;
        }
    }

    public ProductoEntity getById(int id){
        String sql = "SELECT * FROM PRODUCTO WHERE id_producto = :id_producto";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id_producto",id)
                    .executeAndFetchFirst(ProductoEntity.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar la unión entre el producto y su categoria"+e.getMessage());
            return null;
        }
    }

    //UPDATE
    public boolean update(ProductoEntity producto) {
        String sql = "UPDATE PRODUCTO SET id_ranking = :id_ranking, id_tienda = :id_tienda, stock = :stock, cant_vendida = :cant_vendida, url = :url WHERE id_producto= :id_producto";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_producto",producto.getId_producto())
                    .addParameter("id_ranking",producto.getId_ranking())
		    .addParameter("id_tienda",producto.getId_tienda())
                    .addParameter("stock",producto.getStock())
                    .addParameter("cant_vendida",producto.getCantidad_vendida())
                    .addParameter("url",producto.getUrl())
                    .executeUpdate();
            return true;
        }
        catch (Exception e) {
            System.out.println("Error al actualizar la unión entre el producto y su categoria"+e.getMessage());
            return false;
        }
    }

    //DELETE
    public void delete(int id) {
        String sql = "DELETE FROM PRODUCTO WHERE id_producto = :id_producto";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id_producto",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar la unión entre el producto y su categoria"+e.getMessage());
        }
    }
}

