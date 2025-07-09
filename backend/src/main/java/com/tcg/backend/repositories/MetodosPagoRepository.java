package com.tcg.backend.repositories;

import com.tcg.backend.entities.BoletaEntity;
import com.tcg.backend.entities.MetodosPagoEntity;

import java.util.List;

public interface MetodosPagoRepository {

    //CREATE
    MetodosPagoEntity Create(MetodosPagoEntity metodosPago);


    //READ
    list<MetodosPagoEntity>


    //UPDATE


    //DELETE


}
//READ
List<BoletaEntity> findAll();
List<BoletaEntity> findById(int id_boleta);

//UPDATE
BoletaEntity Update(BoletaEntity boleta, int id_boleta);

//DELETE
void delete(int id_boleta);


//CREATE
BoletaEntity Create(BoletaEntity boleta);