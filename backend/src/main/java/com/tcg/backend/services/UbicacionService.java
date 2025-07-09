package com.tcg.backend.services;

import com.tcg.backend.entities.UbicacionEntity;
import com.tcg.backend.repositories.UbicacionRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionRepositoryImp ubicacionRepo;

    public UbicacionEntity getById(int id){
        return ubicacionRepo.Location_for_id(id);
    }
    public List<UbicacionEntity> getAll(){
        return ubicacionRepo.AllLocations();
    }
    public UbicacionEntity save(UbicacionEntity ubicacion){
        return ubicacionRepo.CreateLocation(ubicacion);
    }
    public UbicacionEntity update(UbicacionEntity ubicacion, int id_ubicacion){
        return ubicacionRepo.UpdateLocation(ubicacion, id_ubicacion);
    }
    public boolean delete(int id_ubicacion){
        return ubicacionRepo.DeleteLocation(id_ubicacion);
    }
}