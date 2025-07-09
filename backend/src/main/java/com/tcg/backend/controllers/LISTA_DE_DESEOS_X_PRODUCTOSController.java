package com.tcg.backend.controllers;

import com.tcg.backend.entities.LISTA_DE_DESEOS_X_PRODUCTOSEntity;
import com.tcg.backend.services.LISTA_DE_DESEOS_X_PRODUCTOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lista-deseos-productos")
public class LISTA_DE_DESEOS_X_PRODUCTOSController {

    @Autowired
    private LISTA_DE_DESEOS_X_PRODUCTOSService service;

    @GetMapping
    public List<LISTA_DE_DESEOS_X_PRODUCTOSEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id_lista}/{id_producto}")
    public LISTA_DE_DESEOS_X_PRODUCTOSEntity getById(@PathVariable int id_lista, @PathVariable int id_producto) {
        return service.getById(id_lista, id_producto);
    }

    @PostMapping
    public LISTA_DE_DESEOS_X_PRODUCTOSEntity create(@RequestBody LISTA_DE_DESEOS_X_PRODUCTOSEntity entity) {
        return service.create(entity);
    }

    @PutMapping("/{id_lista}/{id_producto}")
    public boolean updateProducto(@PathVariable int id_lista, @PathVariable int id_producto,
                                  @RequestParam int id_producto_nuevo) {
        return service.updateProducto(id_lista, id_producto, id_producto_nuevo);
    }

    @DeleteMapping("/{id_lista}/{id_producto}")
    public boolean delete(@PathVariable int id_lista, @PathVariable int id_producto) {
        return service.delete(id_lista, id_producto);
    }
}