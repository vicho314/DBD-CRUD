package com.tcg.backend.repositories;

import com.tcg.backend.entities.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {

    private  Sql2o sql2o;
    @Autowired
    public UsuarioRepositoryImp(Sql2o sql2o) {
        this.sql2o = sql2o;

    }

    // CREATE

    @Override
    public UsuarioEntity create(UsuarioEntity usuario) {
        String sql = "INSERT INTO USUARIO(id_lista,id_ubicacion,id_metodo_pago,correo_usuario,contraseña, nombre_real,nombre_usuario)"+
                "VALUES(:id_lista, :id_ubicacion, :id_metodo_pago, :correo_usuario, :contraseña, :nombre_real, :nombre_usuario)";
        try (Connection con = sql2o.open()) {
            int id_usuario = con.createQuery(sql, true)
                    .addParameter("id_lista",usuario.getNombre_usuario())
                    .addParameter("id_ubicacion",usuario.getId_ubicacion())
                    .addParameter("id_metodo_pago",usuario.getId_metodo_pago())
                    .addParameter("correo_usuario", usuario.getCorreo_usuario())
                    .addParameter("Contraseña", usuario.getContraseña())
                    .addParameter("nombre_real", usuario.getNombre_real())
                    .addParameter("nombre_usuario", usuario.getNombre_usuario())
                    .executeUpdate()
                    .getKey(long.class);

            usuario.setId_usuario(id_usuario);
            return usuario;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // READ

    @Override
    public List<UsuarioEntity> getAllUsers() {
        String sql = "SELECT * FROM USUARIO";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(UsuarioEntity.class);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

   @Override
   public List<UsuarioEntity> getUser(int id_usuario) {
        String sql = "SELECT * FROM USUARIO WHERE id_usuario = :id_usuario";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("id_usuario",id_usuario).executeAndFetch(UsuarioEntity.class);

        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
   }

   // UPDATE
    @Override
    public UsuarioEntity update(UsuarioEntity usuario, int id_usuario) {
        String sql = "UPDATE USUARIO SET id_lista = :id_lista, id_ubicacion = :id_ubicacion, id_metodo_pago = :id_metodo_pago, " +
                "correo_usuario = :correo_usuario, \"contraseña\" = :contraseña, nombre_real = :nombre_real, nombre_usuario = :nombre_usuario WHERE id_usuario = :id_usuario ";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql, true)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_lista", usuario.getId_lista())
                    .addParameter("id_ubicacion", usuario.getId_ubicacion())
                    .addParameter("id_metodo_pago", usuario.getId_metodo_pago())
                    .addParameter("correo_usuario", usuario.getCorreo_usuario())
                    .addParameter("contraseña", usuario.getContraseña())
                    .addParameter("nombre_real", usuario.getNombre_real())
                    .addParameter("nombre_usuario", usuario.getNombre_usuario())
                    .executeUpdate();
            return usuario;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // DELETE

    @Override
    public void DeleteUSER(int id_usuario) {
        String sql = "DELETE FROM USUARIO WHERE id_usuario = :id_usuario";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id_usuario",id_usuario).executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}