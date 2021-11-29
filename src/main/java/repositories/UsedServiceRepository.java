package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.UsedService;

public interface UsedServiceRepository extends JpaRepository<UsedService, String> {
	@Query(value = "SELECT * FROM used_service u WHERE u.service_id = ?1 AND u.company_id = ?2 AND u.month = ?3 AND u.year = ?4 LIMIT 1", 
			nativeQuery = true)
    UsedService getUsedService(String service_id, String company_id, String month, String year);
	
	@Query(value = "SELECT * FROM used_service u WHERE u.company_id = ?1 AND u.month = ?2 AND u.year = ?3", nativeQuery = true)
	List<UsedService> getListUsedService(String company_id, String month, String year);
}