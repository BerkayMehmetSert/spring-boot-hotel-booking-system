package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, String> {
}