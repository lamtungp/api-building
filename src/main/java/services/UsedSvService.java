package services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.BadRequestHttpException;
import exceptions.NotFoundHttpException;
import models.UsedService;
import repositories.UsedServiceRepository;
import ultis.GenerateID;

@Service
public class UsedSvService {
    
    private final UsedServiceRepository repo;
    
    @Autowired
    public UsedSvService(UsedServiceRepository repo) { 
        this.repo = repo;
    }

    public List<UsedService> index() {
        return repo.findAll();
    }
    
    public List<UsedService> indexUsedService(String company_id, String time) {
    	String[] date = time.split("/");
        return repo.getListUsedService(company_id, date[0], date[1]);
    }


    public UsedService create(UsedService us) {
    	us.setId(new GenerateID().genID());
    	LocalDate today = LocalDate.now();
    	String month = String.valueOf(today.getMonthValue());
    	String year = String.valueOf(today.getYear());
    	
    	if (us.getService_id().equals("s001") || us.getService_id().equals("s002") ) {
    		UsedService usf = repo.getUsedService(us.getService_id(), us.getCompany_id(), month, year);
    		System.out.println("df " + usf);
        	if (usf != null) {
        		System.out.println(usf);
        		throw new BadRequestHttpException();
        	}
        	
    	}
    	
    	us.setMonth(month);
    	us.setYear(year);
        return repo.save(us);
    }

    public UsedService update(UsedService us, String id) {
    	UsedService usf = repo.findById(id).get();
    	if (usf != null) {
    		us.setId(id);
        	us.setMonth(usf.getMonth());
        	us.setYear(usf.getYear());
    		return repo.save(us);
    	}
    	throw new NotFoundHttpException();
    }

    public UsedService show(String id) {
    	UsedService usf = repo.findById(id).get();
    	if (usf != null) {
    		return usf;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	UsedService usf = repo.findById(id).get();
    	if (usf != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}