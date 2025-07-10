package com.tcg.backend.controllers;

import com.tcg.backend.entities.CartaEntity;
import com.tcg.backend.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartas")
@CrossOrigin("*")
public class CartaController {
    @Autowired
    private CartaService cartaService;

    @GetMapping("/")
    public List<CartaEntity> getAll() {
        return cartaService.getAll();
    }

    @GetMapping("/{id}")
    public CartaEntity getById(@PathVariable int id) {
        return cartaService.getById(id);
    }

    @PostMapping("/save")
    public CartaEntity save(@RequestBody CartaEntity carta) {
        return cartaService.save(carta);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return cartaService.delete(id);
    }
}