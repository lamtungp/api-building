package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.NotFoundHttpException;
import repositories.ServiceRepository;
import ultis.GenerateID;

@Service
public class SvService {
    
    private final ServiceRepository repo;
    
    @Autowired
    public SvService(ServiceRepository repo) {
        this.repo = repo;
    }

    public List<models.Service> index() {
        return repo.findAll();
    }
    
    public models.Service create(models.Service sv) {
    	sv.setId(new GenerateID().genID());
    	sv.setBuilding_id("b001");
        return repo.save(sv);
    }

    public models.Service update(models.Service sv, String id) {
    	models.Service svf = repo.findById(id).get();
    	if (svf != null) {
    		sv.setId(id);
    		return repo.save(sv);
    	}
    	throw new NotFoundHttpException();
    }

    public models.Service show(String id) {
    	models.Service svf = repo.findById(id).get();
    	if (svf != null) {
    		return svf;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	models.Service svf = repo.findById(id).get();
    	if (svf != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}