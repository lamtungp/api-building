package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Salary;

public interface SalaryRepository extends JpaRepository<Salary, String> {}