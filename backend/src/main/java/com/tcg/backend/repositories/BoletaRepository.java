package com.tcg.backend.repositories;

import com.tcg.backend.entities.BoletaEntity;

import java.util.List;

public interface BoletaRepository {

    //CREATE
    BoletaEntity create(BoletaEntity boleta);

    //READ
    List<BoletaEntity> findAll();
    BoletaEntity findById(int id_boleta);

    //UPDATE
    BoletaEntity update(BoletaEntity boleta, int id_boleta);

    //DELETE
    void delete(int id_boleta);




}
