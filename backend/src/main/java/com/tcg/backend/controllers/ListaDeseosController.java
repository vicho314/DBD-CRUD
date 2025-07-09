package com.tcg.backend.controllers;

import com.tcg.backend.entities.ListaDeseosEntity;
import com.tcg.backend.services.ListaDeseosService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listaDeseos")
@CrossOrigin("*")
public class ListaDeseosController {
    //get,save,update,delete,etc
    @Autowired
    private ListaDeseosService listaDeseosService;

    @GetMapping("/")
    public List<ListaDeseosEntity> getAll(){
        return listaDeseosService.getAll();
    }

    @GetMapping("/{id}")
    public ListaDeseosEntity getById(@PathVariable int id){
        return listaDeseosService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public ListaDeseosEntity save(@RequestBody ListaDeseosEntity listaDeseos){
        ListaDeseosEntity listaDeseosNew = listaDeseosService.save(listaDeseos);
        return listaDeseos;
    }

    @PutMapping("/update")
    public ListaDeseosEntity update(@RequestBody ListaDeseosEntity listaDeseos){
        ListaDeseosEntity listaDeseosNew = listaDeseosService.update(listaDeseos);
        return listaDeseos;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return listaDeseosService.delete(id);
    }
}
