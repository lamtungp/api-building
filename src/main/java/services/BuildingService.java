package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Building;
import repositories.BuildingRepository;

@Service
public class BuildingService {
    
    private final BuildingRepository repo;
    
    @Autowired
    public BuildingService(BuildingRepository repo) {
        this.repo = repo;
    }

    public void save(Building bd) {
    	bd.setId("b001");
        repo.save(bd);
    }

    public Building show(String id) {
        return repo.findById(id).get();
    }
}