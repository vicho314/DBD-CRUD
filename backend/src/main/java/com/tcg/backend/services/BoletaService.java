package com.tcg.backend.services;

import com.tcg.backend.entities.BoletaEntity;
import com.tcg.backend.repositories.BoletaRepositoryimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaService {
    @Autowired
    private BoletaRepositoryimp boletaRepo;

    public BoletaEntity getById(int id){return boletaRepo.findById(id); }
    public List<BoletaEntity> getAll() {return boletaRepo.findAll(); }
    public BoletaEntity create(BoletaEntity boleta){return boletaRepo.create(boleta); }
    public BoletaEntity update(BoletaEntity boleta, int id_boleta){return boletaRepo.update(boleta, id_boleta); }
    public void delete(int id){boletaRepo.delete(id);}

}
