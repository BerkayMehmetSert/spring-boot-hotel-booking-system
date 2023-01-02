package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, String> {
}