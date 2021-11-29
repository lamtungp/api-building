package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Service;

public interface ServiceRepository extends JpaRepository<Service, String> {}