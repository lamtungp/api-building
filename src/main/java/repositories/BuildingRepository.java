package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Building;

public interface BuildingRepository extends JpaRepository<Building, String> {}