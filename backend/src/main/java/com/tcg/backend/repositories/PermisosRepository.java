package com.tcg.backend.repositories;

import com.tcg.backend.entities.PermisosEntity;
import com.tcg.backend.entities.PermisosEntity;

import java.util.List;

public interface PermisosRepository {

    // CREATE

    PermisosEntity CreatePermission(PermisosEntity permiso);

    // READ

    List<PermisosEntity> AllPermission();

    PermisosEntity GetPermission(int id_permiso);

    // UPDATE

    PermisosEntity UpdatePermission(PermisosEntity permiso, int id_permiso);

    // DELETE

    public void DeletePermission(int id_permiso);
}
