package com.tcg.backend.controllers;

import com.tcg.backend.entities.JuegosMesaEntity;
import com.tcg.backend.services.JuegosMesaService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juego")
@CrossOrigin("*")
public class JuegosMesaController {
    //get,save,update,delete,etc
    @Autowired
    private JuegosMesaService juegoService;

    @GetMapping("/")
    public List<JuegosMesaEntity> getAll(){
        return juegoService.getAll();
    }

    @GetMapping("/{id}")
    public JuegosMesaEntity getById(@PathVariable int id){
        return juegoService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public JuegosMesaEntity save(@RequestBody JuegosMesaEntity juego){
        JuegosMesaEntity juegoNew = juegoService.save(juego);
        return juego;
    }

    @PutMapping("/update")
    public JuegosMesaEntity update(@RequestBody JuegosMesaEntity juego){
        JuegosMesaEntity juegoNew = juegoService.update(juego);
        return juego;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody JuegosMesaEntity juego){
        return juegoService.delete(juego);
    }
    //categorizar por tipo
    @GetMapping("/tipo/{tipo}")
    public List<JuegosMesaEntity> getJuegosMesaByTipo(@PathVariable String tipo){
        return juegoService.getJuegosMesaByTipo(tipo);
    }
}
