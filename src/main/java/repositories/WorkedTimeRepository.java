package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.WorkedTime;

public interface WorkedTimeRepository extends JpaRepository<WorkedTime, String> {
	@Query(value = "SELECT * FROM worked_time wt WHERE wt.worked_date = ?1", nativeQuery = true)
	List<WorkedTime> getWorkedTime(String time);
}