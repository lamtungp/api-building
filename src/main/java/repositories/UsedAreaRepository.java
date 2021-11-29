package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.UsedArea;

public interface UsedAreaRepository extends JpaRepository<UsedArea, String> {
	@Query(value = "SELECT * FROM used_area u WHERE u.floor_id = ?1", nativeQuery = true)
	List<UsedArea> getUsedArea(String floor_id);
	
	@Query(value = "SELECT * FROM used_area u WHERE u.floor_id = ?1 AND u.company_id=?2 LIMIT 1", nativeQuery = true)
	UsedArea getUa(String floor_id, String company_id);
}