package com.tcg.backend.services;



import com.tcg.backend.entities.MetodosPagoEntity;
import com.tcg.backend.repositories.MetodosPagoRepositoryimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodosPagoService {

    @Autowired
    private MetodosPagoRepositoryimp metodospagoRepo;

    public MetodosPagoEntity getById(int id){return metodospagoRepo.findById(id); }
    public List<MetodosPagoEntity> getAll() {return metodospagoRepo.findAll(); }
    public MetodosPagoEntity create(MetodosPagoEntity metodosPago){return metodospagoRepo.create(metodosPago); }
    public MetodosPagoEntity update(MetodosPagoEntity metodosPago, int id_metodo_de_pago){return metodospagoRepo.update(metodosPago, id_metodo_de_pago); }
    public void delete(int id){metodospagoRepo.delete(id);}

}