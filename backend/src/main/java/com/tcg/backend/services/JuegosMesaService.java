package com.tcg.backend.services;

import com.tcg.backend.entities.JuegosMesaEntity;
import com.tcg.backend.repositories.JuegosMesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JuegosMesaService {
    @Autowired
    private JuegosMesaRepository juegoRepo;

    public JuegosMesaEntity getById(int id){
        return juegoRepo.findById(id);
    }
    public List<JuegosMesaEntity> getAll(){
        return juegoRepo.findAll();
    }
    public JuegosMesaEntity save(JuegosMesaEntity juego){
        return juegoRepo.save(juego);
    }
    public JuegosMesaEntity update(JuegosMesaEntity juego){
        return juegoRepo.update(juego);
    }
    public boolean delete(JuegosMesaEntity juego){
        return juegoRepo.delete(juego);
    }
    //categorizar por tipo
    public List<JuegosMesaEntity> getJuegosMesaByTipo(String tipo) {
        return juegoRepo.findByTipo(tipo);
    }
}