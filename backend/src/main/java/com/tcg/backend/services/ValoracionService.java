package com.tcg.backend.services;

import com.tcg.backend.entities.ValoracionEntity;
import com.tcg.backend.repositories.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {
    @Autowired
    private ValoracionRepository valoracionRepo;

    public ValoracionEntity getById(int id){
        return valoracionRepo.findById(id);
    }
    public List<ValoracionEntity> getAll(){
        return valoracionRepo.findAll();
    }
    public ValoracionEntity save(ValoracionEntity valoracion){
        return valoracionRepo.save(valoracion);
    }
    public ValoracionEntity update(ValoracionEntity valoracion){
        return valoracionRepo.update(valoracion);
    }
    public boolean delete(ValoracionEntity valoracion){
        return valoracionRepo.delete(valoracion);
    }
}