package com.tcg.backend.repositories;

import com.tcg.backend.entities.UsuarioEntity;
import java.util.List;

public interface UsuarioRepository {

    // CREATE
    UsuarioEntity create(UsuarioEntity usuario);

    // READ
    List<UsuarioEntity> getAllUsers();

    UsuarioEntity getUser(int id_usuario);

    // UPDATE
    UsuarioEntity update(UsuarioEntity usuario, int id_usuario);

    // DELETE
    void DeleteUSER(int id_usuario);
}
