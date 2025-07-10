package com.tcg.backend.services;

import com.tcg.backend.entities.CartaEntity;
import com.tcg.backend.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartaService {
    @Autowired
    private CartaRepository cartaRepo;

    public List<CartaEntity> getAll(){
        return cartaRepo.findAll();
    }

    public CartaEntity getById(int id){
        return cartaRepo.findById(id);
    }
    public CartaEntity save(CartaEntity carta){
        return cartaRepo.save(carta);
    }
    public boolean delete(int id) {
        return cartaRepo.delete(id);
    }
    //Categorizacion
    public List<CartaEntity> getCartasByRareza(String rareza) {
        return cartaRepo.findByRareza(rareza);
    }
    public List<CartaEntity> getCartasByEstado(String estado) {
        return cartaRepo.findByEstado(estado);
    }
    public List<CartaEntity> getCartasByAño(LocalDate año) {
        return cartaRepo.findByAño(año);
    }
}
