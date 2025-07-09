package com.tcg.backend.services;

import com.tcg.backend.entities.ValoracionEntity;
import com.tcg.backend.repositories.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {
    @Autowired
    private ValoracionRepository valoracionRepo;

    public ValoracionEntity getById(int id){
        return valoracionRepo.findById(id);
    }
    public List<ValoracionEntity> getAll(){
        return valoracionRepo.findAll();
    }
    public ValoracionEntity save(ValoracionEntity valoracion){
        return valoracionRepo.save(valoracion);
    }

    public boolean check(int id_user, int id_prod){
	return valoracionRepo.checkUserProd(id_user, id_prod);
    }

    public ValoracionEntity make(ValoracionEntity valoracion){
	    int id_user = valoracion.getId_usuario();
	    int id_prod = valoracion.getId_producto();
	    ValoracionEntity valNew = new ValoracionEntity();
	    if(!valoracionRepo.checkUserProd(id_user,id_prod)){
		    valNew = valoracionRepo.save(valoracion);
        }
	    return valNew;
    }

    public ValoracionEntity update(ValoracionEntity valoracion){
        return valoracionRepo.update(valoracion);
    }
    public boolean delete(ValoracionEntity valoracion){
        return valoracionRepo.delete(valoracion);
    }
}
