package services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.NotFoundHttpException;
import models.Company;
import models.UsedService;
import repositories.CompanyRepository;
import repositories.UsedServiceRepository;
import ultis.GenerateID;

@Service
public class CompanyService {
    
    private final CompanyRepository repo;
    private final UsedServiceRepository usedServiceRepo;
    
    @Autowired
    public CompanyService(CompanyRepository repo, UsedServiceRepository usedServiceRepo) {
        this.repo = repo;
        this.usedServiceRepo = usedServiceRepo;
    }

    public List<Company> index() {
        return repo.findAll();
    }

    public Company create(Company c) {
    	c.setId(new GenerateID().genID());
    	Company c_create = repo.save(c);
    	LocalDate today = LocalDate.now();
    	String month = String.valueOf(today.getMonthValue());
    	String year = String.valueOf(today.getYear());
    	UsedService us = new UsedService();
    	us.setId(new GenerateID().genID());
    	us.setCompany_id(c.getId());
    	us.setService_id("s001");
    	us.setMonth(month);
    	us.setYear(year);
    	usedServiceRepo.save(us);
    	us.setId(new GenerateID().genID());
    	us.setService_id("s002");
    	usedServiceRepo.save(us);
		return c_create;
    }
    
    public Company update(Company c, String id) {
    	Company cf = repo.findById(id).get();
    	if (cf != null) {
    		c.setId(id);
    		return repo.save(c);
    	}
    	throw new NotFoundHttpException();
    }

    public Company show(String id) {
    	Company cf = repo.findById(id).get();
    	if (cf != null) {
    		return cf;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	Company cf = repo.findById(id).get();
    	if (cf != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}