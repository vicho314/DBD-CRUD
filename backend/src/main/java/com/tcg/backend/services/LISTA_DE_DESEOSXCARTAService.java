package com.tcg.backend.services;

import com.tcg.backend.entities.LISTA_DE_DESEOSXCARTAEntity;
import com.tcg.backend.repositories.LISTA_DE_DESEOSXCARTARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LISTA_DE_DESEOSXCARTAService {
    @Autowired
    private LISTA_DE_DESEOSXCARTARepository listaDeseosXCartaRepo;

    public List<LISTA_DE_DESEOSXCARTAEntity> getAll(){
        return listaDeseosXCartaRepo.findAll();
    }

    public LISTA_DE_DESEOSXCARTAEntity getById(int idLista, int idCarta){
        return listaDeseosXCartaRepo.findById(idLista, idCarta);
    }
    public LISTA_DE_DESEOSXCARTAEntity save(LISTA_DE_DESEOSXCARTAEntity entity){
        return listaDeseosXCartaRepo.save(entity);
    }
    public boolean delete(int idLista, int idCarta) {
        return listaDeseosXCartaRepo.delete(idLista, idCarta);
    }
    public boolean updateCantidad(int idLista, int idCarta, int nuevaCantidad) {
        return listaDeseosXCartaRepo.updateCantidad(idLista, idCarta, nuevaCantidad);
    }
}
