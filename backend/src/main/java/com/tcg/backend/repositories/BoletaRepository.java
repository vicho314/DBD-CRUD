package com.tcg.backend.repositories;

import com.tcg.backend.entities.BoletaEntity;

import java.util.List;

public interface BoletaRepository {

    //READ
    List<BoletaEntity> findAll();
    BoletaEntity findById(int id_boleta);

    //UPDATE
    BoletaEntity Update(BoletaEntity boleta, int id_boleta);

    //DELETE
    void Delete(int id_boleta);


    //CREATE
    BoletaEntity Create(BoletaEntity boleta);
}
