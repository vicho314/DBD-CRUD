package com.tcg.backend.controllers;

import com.tcg.backend.entities.UsuarioEntity;
import com.tcg.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {
    //get,save,update,delete,etc
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<UsuarioEntity> getAll(){
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public UsuarioEntity getById(@PathVariable int id){
        return usuarioService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public UsuarioEntity save(@RequestBody UsuarioEntity usuario){
        UsuarioEntity usuarioNew = usuarioService.save(usuario);
        return usuario;
    }

    @PutMapping("/update/{id}")
    public UsuarioEntity update(@RequestBody UsuarioEntity usuario, @PathVariable int id){
        UsuarioEntity usuarioNew = usuarioService.update(usuario, id);
        return usuario;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id){
        return usuarioService.delete(id);
    }

    @PostMapping("/login")
    public UsuarioEntity login(@RequestBody UsuarioEntity usuario){
        UsuarioEntity usuarioNew = usuarioService.login(usuario);
        return usuario;
    }
}
