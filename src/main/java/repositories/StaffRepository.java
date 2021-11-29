package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {}