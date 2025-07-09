package com.tcg.backend.services;

import com.tcg.backend.entities.RankingEntity;
import com.tcg.backend.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    private RankingRepository rankingRepo;

    public RankingEntity getById(int id){
        return rankingRepo.findById(id);
    }
    public List<RankingEntity> getAll(){
        return rankingRepo.findAll();
    }
    public RankingEntity save(RankingEntity ranking){
        return rankingRepo.save(ranking);
    }
    public RankingEntity update(RankingEntity ranking){
        return rankingRepo.update(ranking);
    }
    public boolean delete(RankingEntity ranking){
        return rankingRepo.delete(ranking);
    }
}