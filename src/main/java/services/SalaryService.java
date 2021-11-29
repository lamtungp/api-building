package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.NotFoundHttpException;
import models.Salary;
import repositories.SalaryRepository;
import ultis.GenerateID;

@Service
public class SalaryService {
    
    private final SalaryRepository repo;
    
    @Autowired
    public SalaryService(SalaryRepository repo) {
        this.repo = repo;
    }

    public List<Salary> index() {
        return repo.findAll();
    }
    
    public Salary create(Salary sl) {
    	sl.setId(new GenerateID().genID());
        return repo.save(sl);
    }

    public Salary update(Salary sl, String id) {
    	Salary slf = repo.findById(id).get();
    	if (slf != null) {
    		sl.setId(id);
    		return repo.save(sl);
    	}
    	throw new NotFoundHttpException();
    }

    public Salary show(String id) {
    	Salary slf = repo.findById(id).get();
    	if (slf != null) {
    		return slf;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	Salary slf = repo.findById(id).get();
    	if (slf != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}