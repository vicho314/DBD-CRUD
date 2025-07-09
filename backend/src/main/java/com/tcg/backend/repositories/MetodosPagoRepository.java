package com.tcg.backend.repositories;

import com.tcg.backend.entities.MetodosPagoEntity;

import java.util.List;

public interface MetodosPagoRepository {

    //CREATE
    MetodosPagoEntity create(MetodosPagoEntity metodospago);


    //CREATE
    MetodosPagoEntity Create(MetodosPagoEntity metodospago);

    //READ
    List<MetodosPagoEntity>  findAll();
    MetodosPagoEntity findById(int id_metodo_de_pago);


    //UPDATE
    MetodosPagoEntity update(MetodosPagoEntity metodospago,  int id_metodo_de_pago );


    //DELETE
    void delete(int id_metodopago);


}

