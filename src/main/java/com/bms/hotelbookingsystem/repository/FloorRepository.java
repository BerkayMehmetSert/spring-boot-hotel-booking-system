package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepository extends JpaRepository<Floor, String> {
}