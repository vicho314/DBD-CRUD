package com.tcg.backend.services;

import com.tcg.backend.entities.ListaDeseosEntity;
import com.tcg.backend.repositories.ListaDeseosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDeseosService {
    @Autowired
    private ListaDeseosRepository listaDeseosRepo;

    public ListaDeseosEntity getById(int id){
        return listaDeseosRepo.findById(id);
    }
    public List<ListaDeseosEntity> getAll(){
        return listaDeseosRepo.findAll();
    }
    public ListaDeseosEntity save(ListaDeseosEntity listaDeseos){
        return listaDeseosRepo.save(listaDeseos);
    }
    public ListaDeseosEntity update(ListaDeseosEntity listaDeseos){
        return listaDeseosRepo.update(listaDeseos);
    }
    public boolean delete(int id){
        return listaDeseosRepo.delete(id);
    }
}