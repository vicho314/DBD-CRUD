package com.tcg.backend.controllers;

import com.tcg.backend.entities.ProductoEntity;
import com.tcg.backend.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin("*")
public class ProductoController {
    //get,save,update,delete,etc
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public List<ProductoEntity> getAll(){
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ProductoEntity getById(@PathVariable int id){
        return productoService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public ProductoEntity save(@RequestBody ProductoEntity producto){
        ProductoEntity productoNew = productoService.save(producto);
        return producto;
    }

    @PutMapping("/update")
    public boolean update(@RequestBody ProductoEntity producto){
        return productoService.update(producto);

    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return productoService.delete(id);
    }
}
