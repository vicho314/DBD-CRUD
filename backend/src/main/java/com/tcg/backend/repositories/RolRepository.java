package com.tcg.backend.repositories;

import com.tcg.backend.entities.RolEntity;
import java.util.List;

public interface RolRepository {

    // CREATE

    RolEntity CreateRol(RolEntity rol);

    // READ

    List<RolEntity> getAllRol();

    RolEntity GetRol(int rol_id);

    // UPDATE

    RolEntity UpdateRol(RolEntity rol, int rol_id);

    // DELETE

    void DeleteRol(int rol_id);

}