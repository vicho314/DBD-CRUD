package com.tcg.backend.controllers;

import com.tcg.backend.entities.BoletaProductoEntity;
import com.tcg.backend.services.BoletaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletaproducto")
@CrossOrigin("*")
public class BoletaProductoController {

    @Autowired
    private BoletaProductoService boletaProductoService;

    @GetMapping("/")
    public List<BoletaProductoEntity> getAll(){return boletaProductoService.getAll();}

    @GetMapping("/{id}")
    public BoletaProductoEntity getById(@PathVariable int id){return boletaProductoService.getById(id);}

    @PostMapping("/save")
    public BoletaProductoEntity save(@RequestBody BoletaProductoEntity boletaProducto) {
        BoletaProductoEntity boletaProductoo=boletaProductoService.save(boletaProducto);
        return boletaProducto;
    }

    @PutMapping("/update")
    public BoletaProductoEntity update(@RequestBody BoletaProductoEntity boletaProducto, @PathVariable int id) {
        BoletaProductoEntity boletaProductoo=boletaProductoService.update(boletaProducto, id);
        return boletaProducto;
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable int id) {boletaProductoService.delete(id);
    }
}
