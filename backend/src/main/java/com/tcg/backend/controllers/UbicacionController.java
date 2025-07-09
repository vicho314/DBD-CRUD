package com.tcg.backend.controllers;

import com.tcg.backend.entities.UbicacionEntity;
import com.tcg.backend.services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicacion")
@CrossOrigin("*")
public class UbicacionController {
    //get,save,update,delete,etc
    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/")
    public List<UbicacionEntity> getAll(){
        return ubicacionService.getAll();
    }

    @GetMapping("/{id}")
    public UbicacionEntity getById(@PathVariable int id){
        return ubicacionService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public UbicacionEntity save(@RequestBody UbicacionEntity ubicacion){
        UbicacionEntity ubicacionNew = ubicacionService.save(ubicacion);
        return ubicacion;
    }

    @PutMapping("/update/{id}")
    public UbicacionEntity update(@RequestBody UbicacionEntity ubicacion, @PathVariable int id){
        UbicacionEntity ubicacionNew = ubicacionService.update(ubicacion, id);
        return ubicacion;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return ubicacionService.delete(id);
    }
}
