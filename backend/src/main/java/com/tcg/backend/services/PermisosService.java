package com.tcg.backend.services;

import com.tcg.backend.entities.PermisosEntity;
import com.tcg.backend.repositories.PermisosRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisosService {
    @Autowired
    private PermisosRepositoryImp permisosRepo;

    public PermisosEntity getById(int id){
        return permisosRepo.GetPermission(id);
    }
    public List<PermisosEntity> getAll(){
        return permisosRepo.AllPermission();
    }
    public PermisosEntity save(PermisosEntity permisos){
        return permisosRepo.CreatePermission(permisos);
    }
    public PermisosEntity update(PermisosEntity permisos, int id_permisos){
        return permisosRepo.UpdatePermission(permisos, id_permisos);
    }
    public boolean delete(int id_permisos){
        return permisosRepo.DeletePermission(id_permisos);
    }
}