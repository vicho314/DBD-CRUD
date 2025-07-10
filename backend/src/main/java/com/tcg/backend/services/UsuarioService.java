package com.tcg.backend.services;

import com.tcg.backend.entities.UsuarioEntity;
import com.tcg.backend.repositories.UsuarioRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositoryImp usuarioRepo;

    public UsuarioEntity getById(int id){
        return usuarioRepo.getUser(id);
    }
    public List<UsuarioEntity> getAll(){
        return usuarioRepo.getAllUsers();
    }
    public UsuarioEntity save(UsuarioEntity usuario){
        return usuarioRepo.create(usuario);
    }
    public UsuarioEntity update(UsuarioEntity usuario, int id_usuario){
        return usuarioRepo.update(usuario, id_usuario);
    }
    public boolean delete(int id_usuario){
        return usuarioRepo.DeleteUSER(id_usuario);
    }
    public UsuarioEntity login(UsuarioEntity usuario){
        return usuarioRepo.login(usuario);
    }
}