package com.tcg.backend.services;

import com.tcg.backend.entities.BoletaProductoEntity;
import com.tcg.backend.repositories.BoletaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BoletaProductoService {

    @Autowired
    private BoletaProductoRepository boletaProductoRepository;

    public BoletaProductoEntity getById(int id){return (BoletaProductoEntity) boletaProductoRepository.findByIdBoleta(id); }
    public List<BoletaProductoEntity> getAll() {return boletaProductoRepository.findAll(); }
    public BoletaProductoEntity save(BoletaProductoEntity boletaProducto){return boletaProductoRepository.save(boletaProducto); }
    public BoletaProductoEntity update(BoletaProductoEntity boletaProducto, int id_boletaProducto){return boletaProductoRepository.update(boletaProducto, id_boletaProducto); }
    public void delete(int id){boletaProductoRepository.delete(id);}

}
