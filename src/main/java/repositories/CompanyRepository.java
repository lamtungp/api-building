package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {}