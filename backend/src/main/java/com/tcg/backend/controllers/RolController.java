package com.tcg.backend.controllers;

import com.tcg.backend.entities.RolEntity;
import com.tcg.backend.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
@CrossOrigin("*")
public class RolController {
    //get,save,update,delete,etc
    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public List<RolEntity> getAll(){
        return rolService.getAll();
    }

    @GetMapping("/{id}")
    public RolEntity getById(@PathVariable int id){
        return rolService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public RolEntity save(@RequestBody RolEntity rol){
        RolEntity rolNew = rolService.save(rol);
        return rol;
    }

    @PutMapping("/update/{id_rol}/{id_usuario}")
    public RolEntity update(@PathVariable int id_rol,@PathVariable int id_usuario,@RequestBody RolEntity rol){
        RolEntity rolNew = rolService.update(id_rol,id_usuario,rol);
        return rol;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody RolEntity rol){
        return rolService.delete(rol);
    }
}
