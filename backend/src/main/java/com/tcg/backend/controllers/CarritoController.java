package com.tcg.backend.controllers;

import com.tcg.backend.entities.CarritoEntity;
import com.tcg.backend.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin("*")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/")
    public List<CarritoEntity> getAll(){return carritoService.getAll();}

    @GetMapping("/{id}")
    public CarritoEntity getById(@PathVariable int id){return carritoService.getById(id);}

    @PostMapping("/create")
    public CarritoEntity create(@RequestBody CarritoEntity carrito) {
        CarritoEntity carritoo=carritoService.create(carrito);
        return carrito;
    }

    @PutMapping("/update")
    public CarritoEntity update(@RequestBody CarritoEntity carrito, @PathVariable int id) {
        CarritoEntity carritoo=carritoService.update(carrito, id);
        return carrito;
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable int id) {carritoService.delete(id);
    }
}