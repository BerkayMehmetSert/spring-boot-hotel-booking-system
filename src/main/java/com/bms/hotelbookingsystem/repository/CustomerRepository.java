package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}