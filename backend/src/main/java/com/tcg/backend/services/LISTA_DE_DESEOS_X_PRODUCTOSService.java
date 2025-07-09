package com.tcg.backend.services;

import com.tcg.backend.entities.LISTA_DE_DESEOS_X_PRODUCTOSEntity;
import com.tcg.backend.repositories.LISTA_DE_DESEOS_X_PRODUCTOSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LISTA_DE_DESEOS_X_PRODUCTOSService {

    @Autowired
    private LISTA_DE_DESEOS_X_PRODUCTOSRepository repository;

    public List<LISTA_DE_DESEOS_X_PRODUCTOSEntity> getAll() {
        return repository.findAll();
    }

    public LISTA_DE_DESEOS_X_PRODUCTOSEntity getById(int id_lista, int id_producto) {
        return repository.findById(id_lista, id_producto);
    }

    public LISTA_DE_DESEOS_X_PRODUCTOSEntity create(LISTA_DE_DESEOS_X_PRODUCTOSEntity entity) {
        return repository.save(entity);
    }

    public boolean updateProducto(int id_lista, int id_producto, int id_producto_nuevo) {
        return repository.updateProducto(id_lista, id_producto, id_producto_nuevo);
    }

    public boolean delete(int id_lista, int id_producto) {
        return repository.Delete(id_lista, id_producto);
    }
}
