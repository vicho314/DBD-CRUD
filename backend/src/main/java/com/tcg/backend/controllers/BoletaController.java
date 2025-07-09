package com.tcg.backend.controllers;

import com.tcg.backend.entities.BoletaEntity;
import com.tcg.backend.services.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boleta")
@CrossOrigin("*")
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @GetMapping("/")
    public List<BoletaEntity> getAll(){return boletaService.getAll();}

    @GetMapping("/{id}")
    public BoletaEntity getById(@PathVariable int id){return boletaService.getById(id);}

    @PostMapping("/create")
    public BoletaEntity create(@RequestBody BoletaEntity boleta) {
        BoletaEntity boletaa=boletaService.create(boleta);
        return boleta;
    }

    @PutMapping("/update")
    public BoletaEntity update(@RequestBody BoletaEntity boleta, @PathVariable int id) {
        BoletaEntity boletaa=boletaService.update(boleta, id);
        return boleta;
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable int id) {boletaService.delete(id);
    }
}