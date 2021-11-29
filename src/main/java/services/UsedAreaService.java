package services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.BadRequestHttpException;
import exceptions.InternalServerHttpException;
import exceptions.NotFoundHttpException;
import models.Floor;
import models.UsedArea;
import repositories.FloorRepository;
import repositories.UsedAreaRepository;

@Service
public class UsedAreaService {
    
    private final UsedAreaRepository repo;
    private final FloorRepository repoFloor;
    
    @Autowired
    public UsedAreaService(UsedAreaRepository repo, FloorRepository repoFloor) { 
        this.repo = repo;
        this.repoFloor = repoFloor;
    }

    public List<UsedArea> index() {
        return repo.findAll();
    }
    
    public UsedArea create(UsedArea ua) {
    	UsedArea uaf = repo.getUa(ua.getFloor_id(), ua.getCompany_id());
    	
    	if (uaf != null) {
    		throw new BadRequestHttpException();
    	}
    	
    	Floor f = repoFloor.findById(ua.getFloor_id()).get();
    	int s = f.getFloor_area();
    	String startTerm = ua.getRental_term().split(" ~ ")[0];
    	List<UsedArea> list = repo.getUsedArea(ua.getFloor_id());
   
    	for ( UsedArea u : list) {
    		
    		String endTerm = u.getRental_term().split(" ~ ")[1];
    		LocalDate today = LocalDate.now();
        	String day = String.valueOf(today.getDayOfMonth());
        	String month = String.valueOf(today.getMonthValue());
	    	String year = String.valueOf(today.getYear());
	    	String[] arrStrStart = startTerm.split("-");
	    	String[] arrStr = endTerm.split("-");
	    	
    		if (arrStrStart[2].compareTo(arrStr[2]) <= 0) {
    			if (arrStrStart[2].compareTo(arrStr[2]) == 0) {	
    				if (arrStrStart[0].compareTo(arrStr[0]) <= 0) {
    					if (arrStrStart[1].compareTo(arrStr[1]) > 0) {   						        						
    						continue;
    					}
    				} else {
    					continue;
    				}  
    			}
    		} else {
    			continue;
    		}    		        	

    		if (year.compareTo(arrStr[2]) <= 0) {
    			if (year.compareTo(arrStr[2]) == 0) {			
    				if (month.compareTo(arrStr[0]) == 0) {
    					if (day.compareTo(arrStr[1]) <= 0) {   						
    						s -= u.getUsed_area();
    					} else {
    						continue;
    					}
    				} else if (month.compareTo(arrStr[0]) < 0) {
    					s -= u.getUsed_area();
    				} else {
    					continue;
    				}
    			} else {
    				s -= u.getUsed_area();
    			}   			
    		} else {
    			continue;
    		}
    	}
    	System.out.println(s);
    	
    	if (s > 0 && ua.getUsed_area() <= s) {
    		 return repo.save(ua);
    	}
    	throw new InternalServerHttpException();
    }

    public UsedArea update(UsedArea ua, String id) {
    	UsedArea uaf = repo.findById(id).get();
    	if (uaf != null) {
    		ua.setId(id);
    		Floor f = repoFloor.findById(ua.getFloor_id()).get();
        	int s = f.getFloor_area();
        	String startTerm = ua.getRental_term().split(" ~ ")[0];
        	List<UsedArea> list = repo.getUsedArea(ua.getFloor_id());
        	
        	for ( UsedArea u : list) {
        		
        		if (u.getId().equals(uaf.getId())) {
        			continue;
        		}
        		        		
        		String endTerm = u.getRental_term().split(" ~ ")[1];
        		
        		LocalDate today = LocalDate.now();
            	String day = String.valueOf(today.getDayOfMonth());
            	String month = String.valueOf(today.getMonthValue());
    	    	String year = String.valueOf(today.getYear());
    	    	String[] arrStrStart = startTerm.split("-");
    	    	String[] arrStr = endTerm.split("-");
    	    	
        		if (arrStrStart[2].compareTo(arrStr[2]) <= 0) {
        			if (arrStrStart[2].compareTo(arrStr[2]) == 0) {	
        				if (arrStrStart[0].compareTo(arrStr[0]) <= 0) {
        					if (arrStrStart[1].compareTo(arrStr[1]) > 0) {   						        						
        						continue;
        					}
        				} else {
        					continue;
        				}  
        			}
        		} else {
        			continue;
        		}

        		if (year.compareTo(arrStr[2]) <= 0) {
        			if (year.compareTo(arrStr[2]) == 0) {	
        				if (month.compareTo(arrStr[0]) == 0) {
        					if (day.compareTo(arrStr[1]) <= 0) {   						
        						s -= u.getUsed_area();
        					} else {
        						continue;
        					}
        				} else if (month.compareTo(arrStr[0]) < 0) {
        					s -= u.getUsed_area();
        				} else {
        					continue;
        				}
        			} else {
        				s -= u.getUsed_area();
        			}   			
        		} else {
        			continue;
        		}
        	}
        	
        	if (s > 0 && ua.getUsed_area() <= s) {
        		 return repo.save(ua);
        	}
        	throw new InternalServerHttpException();
    	}
    	throw new NotFoundHttpException();
    }

    public UsedArea show(String id) {
    	UsedArea uaf = repo.findById(id).get();
    	if (uaf != null) {
    		return uaf;
    	}
    	throw new NotFoundHttpException();
    }

    public void delete(String id) {
    	UsedArea uaf = repo.findById(id).get();
    	if (uaf != null) {
    		repo.deleteById(id);
    	} else {
        	throw new NotFoundHttpException();
    	}
    }
}