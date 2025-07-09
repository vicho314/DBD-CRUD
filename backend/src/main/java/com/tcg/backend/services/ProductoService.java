package com.tcg.backend.services;

import com.tcg.backend.entities.ProductoEntity;
import com.tcg.backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepo;

    public ProductoEntity getById(int id){
        return productoRepo.findById(id);
    }
    public List<ProductoEntity> getAll(){
        return productoRepo.findAll();
    }
    public ProductoEntity save(ProductoEntity producto){
        return productoRepo.create(producto);
    }
    public boolean update(ProductoEntity producto){
        return productoRepo.update(producto);
    }
    public boolean delete(int id){
        return productoRepo.delete(id);
    }
}