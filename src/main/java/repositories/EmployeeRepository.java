package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	@Query(value = "select * from employee e where e.company_id = ?1", nativeQuery = true)
    List<Employee> getListEmployee(String companyId);
}