package com.tcg.backend.services;

import com.tcg.backend.entities.CARRITO_X_PRODUCTOEntity;
import com.tcg.backend.repositories.CARRITO_X_PRODUCTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CARRITO_X_PRODUCTOService {

    @Autowired
    private CARRITO_X_PRODUCTORepository repository;

    public List<CARRITO_X_PRODUCTOEntity> getAll() {
        return repository.findAll();
    }

    public CARRITO_X_PRODUCTOEntity getById(int id_producto, int id_carro) {
        return repository.findById(id_producto, id_carro);
    }

    public CARRITO_X_PRODUCTOEntity create(CARRITO_X_PRODUCTOEntity entity) {
        return repository.save(entity);
    }

    public boolean updateDisponibilidad(int id_producto, int id_carro, boolean disponibilidad) {
        return repository.Updatedisponibilidad(id_producto, id_carro, disponibilidad);
    }

    public boolean delete(int id_producto, int id_carro) {
        return repository.delete(id_producto, id_carro);
    }
}

