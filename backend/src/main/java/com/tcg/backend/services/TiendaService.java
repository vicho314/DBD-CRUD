package com.tcg.backend.services;

import com.tcg.backend.entities.TiendaEntity;
import com.tcg.backend.repositories.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaService {
	@Autowired
	private TiendaRepository tiendaRepo;

	public List<TiendaEntity> getAll(){
		return tiendaRepo.findAll();
	}

	public TiendaEntity save(TiendaEntity tienda){
		return tiendaRepo.save(tienda);
	}
}
