package com.tcg.backend.controllers;

import com.tcg.backend.entities.LISTA_DE_DESEOSXCARTAEntity;
import com.tcg.backend.services.LISTA_DE_DESEOSXCARTAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ListaDeseosXCarta")
@CrossOrigin("*")
public class LISTA_DE_DESEOSXCARTAController {
    @Autowired
    private LISTA_DE_DESEOSXCARTAService LISTA_DE_DESEOSXCARTAService;

    @GetMapping("/")
    public List<LISTA_DE_DESEOSXCARTAEntity> getAll() {
        return LISTA_DE_DESEOSXCARTAService.getAll();
    }

    @GetMapping("{id_lista}/{id_carta}")
    public LISTA_DE_DESEOSXCARTAEntity getById(@PathVariable int id_lista, @PathVariable int id_carta) {
        return LISTA_DE_DESEOSXCARTAService.getById(id_lista, id_carta);
    }

    @PostMapping("/save")
    public LISTA_DE_DESEOSXCARTAEntity save(@RequestBody LISTA_DE_DESEOSXCARTAEntity entity) {
        return LISTA_DE_DESEOSXCARTAService.save(entity);
    }
    @DeleteMapping("/delete/{id_lista}/{id_carta}")
    public boolean delete(@PathVariable int id_lista, @PathVariable int id_carta) {
        return LISTA_DE_DESEOSXCARTAService.delete(id_lista, id_carta);
    }
    @PutMapping("/updateCantidad")
    public boolean updateCantidad(@RequestParam int id_lista, @RequestParam int id_carta, @RequestParam int nuevaCantidad) {
        return LISTA_DE_DESEOSXCARTAService.updateCantidad(id_lista, id_carta, nuevaCantidad);
    }
}