package com.tcg.backend.controllers;

import com.tcg.backend.entities.CARRITO_X_PRODUCTOEntity;
import com.tcg.backend.services.CARRITO_X_PRODUCTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito-producto")
public class CARRITO_X_PRODUCTOController {

    // GET,CREATE,UPDATE,DELETE,ETC.
    @Autowired
    private CARRITO_X_PRODUCTOService service;

    @GetMapping
    public List<CARRITO_X_PRODUCTOEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id_producto}/{id_carro}")
    public CARRITO_X_PRODUCTOEntity getById(@PathVariable int id_producto, @PathVariable int id_carro) {
        return service.getById(id_producto, id_carro);
    }

    @PostMapping
    public CARRITO_X_PRODUCTOEntity create(@RequestBody CARRITO_X_PRODUCTOEntity entity) {
        return service.create(entity);
    }

    @PutMapping("/{id_producto}/{id_carro}")
    public boolean updateDisponibilidad(@PathVariable int id_producto, @PathVariable int id_carro,
                                        @RequestParam boolean disponibilidad) {
        return service.updateDisponibilidad(id_producto, id_carro, disponibilidad);
    }

    @DeleteMapping("/{id_producto}/{id_carro}")
    public boolean delete(@PathVariable int id_producto, @PathVariable int id_carro) {
        return service.delete(id_producto, id_carro);
    }
}