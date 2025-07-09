package com.tcg.backend.controllers;

import com.tcg.backend.entities.ValoracionEntity;
import com.tcg.backend.services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valoracion")
@CrossOrigin("*")
public class ValoracionController {
    //get,save,update,delete,etc
    @Autowired
    private ValoracionService valoracionService;

    @GetMapping("/")
    public List<ValoracionEntity> getAll(){
        return valoracionService.getAll();
    }

    @GetMapping("/{id}")
    public ValoracionEntity getById(@PathVariable int id){
        return valoracionService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public ValoracionEntity save(@RequestBody ValoracionEntity valoracion){
        ValoracionEntity valoracionNew = valoracionService.save(valoracion);
        return valoracion;
    }

    @PutMapping("/update")
    public ValoracionEntity update(@RequestBody ValoracionEntity valoracion){
        ValoracionEntity valoracionNew = valoracionService.update(valoracion);
        return valoracion;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody ValoracionEntity valoracion){
        return valoracionService.delete(valoracion);
    }
}
