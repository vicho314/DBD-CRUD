package com.tcg.backend.repositories;

//import com.tcg.backend.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

        import java.util.List;

@Repository
public class ProductoRepositorylmp implements ProductoRepositorylmp {
    private final Sql2o sql2o;

    @Autowired
    public ProductoRepositorylmp(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    //CREATE
    @Override
    public ProductoRepositorylmp create(ProductoRepositorylmp ProductoRepository) {
        String sql = "INSERT INTO PRODUCTO(id_producto,id_ranking,id_tienda,stock,cantidad_vendida,url)" +
                "VALUES (:id_producto:id_ranking:id_tienda:stock:cantidad_vendida:url)";
        try(Connection conn = sql2o.open()) {
            long id = conn.createQuery(sql,true)
                    .addParameter("id_Producto",ProductoRepository.getIdProducto())
                    .addParameter("id_ranking",ProductoRepository.getid_ranking())
                    .addParameter("id_tienda",ProductoRepository.getid_tienda())
                    .addParameter("stock",ProductoRepository.getstock())
                    .addParameter("cantidad_vendida",ProductoRepository.getcantidad_vendida())
                    .addParameter("url",ProductoRepository.geturl())
                    .executeUpdate()
                    .getKey(Long.class);

            ProductoRepository.setIdProductoCategoria(id_Producto);
            return ProductoRepository;
        }
        catch (Exception e) {
            System.out.println("Error al crear la unión entre producto y categoria"+e.getMessage());
            return null;
        }
    }

    //READ
    @Override
    public List<ProductoRepositorylmp> getAll() {
        String sql = "SELECT * FROM PRODUCTO_CATEGORIAPRODUCTO ORDER BY idProductoCategoriaProducto ASC";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(ProductoRepositorylmp.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar las uniones entre producto y categorias"+e.getMessage());
            return null;
        }
    }

    @Override
    public List<ProductoRepositorylmp> getProductoCategoriaProducto(int id){
        String sql = "SELECT * FROM PRODUCTO_CATEGORIAPRODUCTO WHERE idProductoCategoriaProducto = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(ProductoRepositorylmp.class);
        }
        catch (Exception e) {
            System.out.println("Error al consultar la unión entre el producto y su categoria"+e.getMessage());
            return null;
        }
    }

    //UPDATE
    @Override
    public ProductoRepositorylmp update(ProductoRepositorylmp ProductoRepository, int id) {
        String sql = "UPDATE PRODUCTO_CATEGORIAPRODUCTO SET IdProducto = :IdProducto WHERE idProductoCategoriaProducto = :id";
        try (Connection con = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("IdProducto",ProductoRepository.getIdProducto())
                    .executeUpdate();
            return ProductoRepository;
        }
        catch (Exception e) {
            System.out.println("Error al actualizar la unión entre el producto y su categoria"+e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM PRODUCTO_CATEGORIAPRODUCTO WHERE idProductoCategoriaProducto = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql).addParameter("id",id).executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error al eliminar la unión entre el producto y su categoria"+e.getMessage());
        }
    }
}

