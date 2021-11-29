package services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.NotFoundHttpException;
import models.Salary;
import models.Staff;
import models.WorkedTime;
import repositories.SalaryRepository;
import repositories.StaffRepository;
import repositories.WorkedTimeRepository;
import ultis.GenerateID;

@Service
public class WorkedTimeService {
    
    private final WorkedTimeRepository repo;
    private final StaffRepository repoStaff;
    private final SalaryRepository repoSalary;
    
    @Autowired
    public WorkedTimeService(WorkedTimeRepository repo, StaffRepository repoStaff, SalaryRepository repoSalary) { 
        this.repo = repo;
        this.repoStaff = repoStaff;
        this.repoSalary = repoSalary;
    }

    public List<WorkedTime> index() {
        return repo.findAll();
    }
    
    public List<WorkedTime> indexTime(String time) {
        return repo.getWorkedTime(time);
    }
    
    public WorkedTime create(WorkedTime wt) {
    	wt.setId(new GenerateID().genID());
    	LocalDate today = LocalDate.now();
    	String date = String.valueOf(today.getMonthValue()) + "/" + String.valueOf(today.getYear());
    	wt.setWorked_date(date);
    	Staff st = repoStaff.findById(wt.getStaff_id()).get();
    	Salary sl = repoSalary.findById(st.getSalary_id()).get();
    	wt.setSalary_id(sl.getId());
        return repo.save(wt);
    }

    public WorkedTime update(WorkedTime wt, String id) {
    	WorkedTime wtf = repo.findById(id).get();
    	if (wtf != null) {
    		wt.setId(id);
    		LocalDate today = LocalDate.now();
        	String date = String.valueOf(today.getMonthValue()) + "/" + String.valueOf(today.getYear());
        	wt.setWorked_date(date);
    		Staff st = repoStaff.findById(wt.getStaff_id()).get();
        	Salary sl = repoSalary.findById(st.getSalary_id()).get();
        	wt.setSalary_id(sl.getId());
    		return repo.save(wt);
    	}
    	throw new NotFoundHttpException();
    }

    public WorkedTime show(String id) {
    	WorkedTime wtf = repo.findById(id).get();
    	if (wtf != null) {
    		return wtf;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	WorkedTime usf = repo.findById(id).get();
    	if (usf != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}