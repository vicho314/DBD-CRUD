package com.tcg.backend.services;

import com.tcg.backend.entities.RolEntity;
import com.tcg.backend.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepo;

    public RolEntity getById(int id){
        return rolRepo.findById(id);
    }
    public List<RolEntity> getAll(){
        return rolRepo.findAll();
    }
    public RolEntity save(RolEntity rol){
        return rolRepo.save(rol);
    }
    public RolEntity update(int id_rol,int id_usuario, RolEntity nuevo){
        return rolRepo.update(id_rol,id_usuario, nuevo);
    }
    public boolean delete(RolEntity rol){
        return rolRepo.delete(rol);
    }
}