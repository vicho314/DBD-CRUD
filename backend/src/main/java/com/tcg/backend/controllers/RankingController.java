package com.tcg.backend.controllers;

import com.tcg.backend.entities.RankingEntity;
import com.tcg.backend.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
@CrossOrigin("*")
public class RankingController {
    //get,save,update,delete,etc
    @Autowired
    private RankingService rankingService;

    @GetMapping("/")
    public List<RankingEntity> getAll(){
        return rankingService.getAll();
    }

    @GetMapping("/{id}")
    public RankingEntity getById(@PathVariable int id){
        return rankingService.getById(id);
    }

    //FIXME: manejo de errores!
    @PostMapping("/save")
    public RankingEntity save(@RequestBody RankingEntity ranking){
        RankingEntity rankingNew = rankingService.save(ranking);
        return ranking;
    }

    @PutMapping("/update")
    public RankingEntity update(@RequestBody RankingEntity ranking){
        RankingEntity rankingNew = rankingService.update(ranking);
        return ranking;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody RankingEntity ranking){
        return rankingService.delete(ranking);
    }
}
