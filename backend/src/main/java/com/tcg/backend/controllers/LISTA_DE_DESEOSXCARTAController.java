package com.tcg.backend.controllers;

import com.tcg.backend.entities.LISTA_DE_DESEOSXCARTAEntity;
import com.tcg.backend.services.LISTA_DE_DESEOSXCARTAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ListaDeseosXCarta")
@CrossOrigin("*")
public class ListaDeseosXCartaController {
    @Autowired
    private LISTA_DE_DESEOSXCARTAService listaDeseosXCartaService;

    @GetMapping("/")
    public List<LISTA_DE_DESEOSXCARTAEntity> getAll() {
        return listaDeseosXCartaService.getAll();
    }

    @GetMapping("{idLista}/{idCarta}")
    public LISTA_DE_DESEOSXCARTAEntity getById(@PathVariable int idLista, @PathVariable int idCarta) {
        return listaDeseosXCartaService.getById(idLista, idCarta);
    }

    @PostMapping("/save")
    public LISTA_DE_DESEOSXCARTAEntity save(@RequestBody LISTA_DE_DESEOSXCARTAEntity entity) {
        return listaDeseosXCartaService.save(entity);
    }
    @DeleteMapping("/delete/{idLista}/{idCarta}")
    public boolean delete(@PathVariable int idLista, @PathVariable int idCarta) {
        return listaDeseosXCartaService.delete(idLista, idCarta);
    }
    @PutMapping("/updateCantidad")
    public boolean updateCantidad(@RequestParam int idLista, @RequestParam int idCarta, @RequestParam int nuevaCantidad) {
        return listaDeseosXCartaService.updateCantidad(idLista, idCarta, nuevaCantidad);
    }
}