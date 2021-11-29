package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.NotFoundHttpException;
import models.Employee;
import repositories.EmployeeRepository;
import ultis.GenerateID;

@Service
public class EmployeeService {
    
    private final EmployeeRepository repo;
    
    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> index() {
        return repo.findAll();
    }
    
    public List<Employee> listEmployee(String companyId) {
        return repo.getListEmployee(companyId);
    }

    public Employee create(Employee e) {
    	e.setId(new GenerateID().genID());
        return repo.save(e);
    }
    
    public Employee update(Employee e, String id) {
    	Employee ef = repo.findById(id).get();
    	if (ef != null) {
    		e.setId(id);
    		return repo.save(e);
    	}
    	throw new NotFoundHttpException();
    }

    public Employee show(String id) {
    	Employee ef = repo.findById(id).get();
    	if (ef != null) {
    		return ef;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	Employee ef = repo.findById(id).get();
    	if (ef != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}