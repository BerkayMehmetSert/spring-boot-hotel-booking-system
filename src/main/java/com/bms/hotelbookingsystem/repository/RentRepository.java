package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, String> {
}