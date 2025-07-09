package com.tcg.backend.services;


import com.tcg.backend.entities.CarritoEntity;

import com.tcg.backend.repositories.CarritoRepositoryimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepositoryimp carritoRepo;

    public CarritoEntity getById(int id){return carritoRepo.findById(id); }
    public List<CarritoEntity> getAll() {return carritoRepo.findAll(); }
    public CarritoEntity create(CarritoEntity carrito){return carritoRepo.create(carrito); }
    public CarritoEntity update(CarritoEntity carrito, int id_carro){return carritoRepo.update(carrito, id_carro); }
    public void delete(int id){carritoRepo.delete(id);}

}