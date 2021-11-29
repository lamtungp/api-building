package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Floor;

public interface FloorRepository extends JpaRepository<Floor, String> {}