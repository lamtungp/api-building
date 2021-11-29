package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.NotFoundHttpException;
import models.Staff;
import repositories.StaffRepository;
import ultis.GenerateID;

@Service
public class StaffService {
    
    private final StaffRepository repo;
    
    @Autowired
    public StaffService(StaffRepository repo) {
        this.repo = repo;
    }

    public List<Staff> index() {
        return repo.findAll();
    }
    
    public Staff create(Staff st) {
    	st.setId(new GenerateID().genID());
    	st.setBuilding_id("b001");
        return repo.save(st);
    }

    public Staff update(Staff st, String id) {
    	Staff stf = repo.findById(id).get();
    	if (stf != null) {
    		st.setId(id);
    		return repo.save(st);
    	}
    	throw new NotFoundHttpException();
    }

    public Staff show(String id) {
    	Staff stf = repo.findById(id).get();
    	if (stf != null) {
    		return stf;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	Staff stf = repo.findById(id).get();
    	if (stf != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}