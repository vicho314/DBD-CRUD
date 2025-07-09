package com.tcg.backend.repositories;

import com.tcg.backend.entities.CarritoEntity;

import java.util.List;

public interface CarritoRepository {

    //CREATE

    CarritoEntity Create(CarritoEntity carrito);

    //READ
    List<CarritoEntity> findAll();
    CarritoEntity FindById(int id_carro);

    //UPDATE
    CarritoEntity Update(CarritoEntity carrito, int id_carro);

    //DELETE
    void Delete(int id_carro);

}















