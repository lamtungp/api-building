package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.NotFoundHttpException;
import models.Floor;
import repositories.FloorRepository;
import ultis.GenerateID;

@Service
public class FloorService {
    
    private final FloorRepository repo;
    
    @Autowired
    public FloorService(FloorRepository repo) { 
        this.repo = repo;
    }

    public List<Floor> index() {
        return repo.findAll();
    }
    
    public Floor create(Floor f) {
    	f.setId(new GenerateID().genID());
    	f.setBuilding_id("b001");
        return repo.save(f);
    }

    public Floor update(Floor f, String id) {
    	Floor f_find = repo.findById(id).get();
    	if (f_find != null) {
    		f.setId(id);       	
    		return repo.save(f);
    	}
    	throw new NotFoundHttpException();
    }

    public Floor show(String id) {
    	Floor f_find = repo.findById(id).get();
    	if (f_find != null) {
    		return f_find;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	Floor f_find = repo.findById(id).get();
    	if (f_find != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}