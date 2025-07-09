package com.tcg.backend.controllers;

import com.tcg.backend.entities.MetodosPagoEntity;
import com.tcg.backend.services.MetodosPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodospago")
@CrossOrigin("*")
public class MetodosPagoController {

    @Autowired
    private MetodosPagoService metodosPagoService;

    @GetMapping("/")
    public List<MetodosPagoEntity> getAll(){return metodosPagoService.getAll();}

    @GetMapping("/{id}")
    public MetodosPagoEntity getById(@PathVariable int id){return metodosPagoService.getById(id);}

    @PostMapping("/create")
    public MetodosPagoEntity create(@RequestBody MetodosPagoEntity metodosPago) {
        MetodosPagoEntity metodospagoo=metodosPagoService.create(metodosPago);
        return metodosPago;
    }

    @PutMapping("/update")
    public MetodosPagoEntity update(@RequestBody MetodosPagoEntity metodosPago, @PathVariable int id) {
        MetodosPagoEntity metodosPagoo=metodosPagoService.update(metodosPago, id);
        return metodosPago;
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable int id) {metodosPagoService.delete(id);
    }
}