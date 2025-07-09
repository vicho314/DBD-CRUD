package com.tcg.backend.controllers;

import com.tcg.backend.entities.PermisosEntity;
import com.tcg.backend.services.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
@CrossOrigin("*")
public class PermisosController {
    //get,save,update,delete,etc
    @Autowired
    private PermisosService permisosService;

    @GetMapping("/")
    public List<PermisosEntity> getAll(){
        return permisosService.getAll();
    }

    @GetMapping("/{id}")
    public PermisosEntity getById(@PathVariable int id){
        return permisosService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public PermisosEntity save(@RequestBody PermisosEntity permisos){
        PermisosEntity permisosNew = permisosService.save(permisos);
        return permisos;
    }

    @PutMapping("/update/{id}")
    public PermisosEntity update(@RequestBody PermisosEntity permisos, @PathVariable int id){
        PermisosEntity permisosNew = permisosService.update(permisos, id);
        return permisos;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return permisosService.delete(id);
    }
}