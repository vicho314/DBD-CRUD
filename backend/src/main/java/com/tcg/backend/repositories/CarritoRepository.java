package com.tcg.backend.repositories;

import com.tcg.backend.entities.CarritoEntity;

import java.util.List;

public interface CarritoRepository {

    //CREATE

    CarritoEntity create(CarritoEntity carrito);

    //READ
    List<CarritoEntity> findAll();
    CarritoEntity findById(int id_carro);

    //UPDATE
    CarritoEntity update(CarritoEntity carrito, int id_carro);

    //DELETE
    void delete(int id_carro);

}















