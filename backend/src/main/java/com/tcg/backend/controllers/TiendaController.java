package com.tcg.backend.controllers;

import com.tcg.backend.entities.TiendaEntity;
import com.tcg.backend.services.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tienda")
@CrossOrigin("*")
public class TiendaController {
	//get,save,update,delete,etc
	@Autowired
	private TiendaService tiendaService;

	@GetMapping("/")
	public List<TiendaEntity> getAll(){
		return tiendaService.getAll();
	}

	@GetMapping("/{id}")
	public TiendaEntity getById(@PathVariable int id){
		return tiendaService.getById(id);
	}

	//FIXME: manejo de errores!
	@PostMapping("/save")
	public TiendaEntity save(@RequestBody TiendaEntity tienda){
		TiendaEntity tiendaNew = tiendaService.save(tienda);
		return tienda;
	}

	@PutMapping("/update")
	public TiendaEntity update(@RequestBody TiendaEntity tienda){
		TiendaEntity tiendaNew = tiendaService.update(tienda);
		return tienda;
	}

	@DeleteMapping("/delete")
	public boolean delete(@RequestBody TiendaEntity tienda){
		return tiendaService.delete(tienda);
	}
}
