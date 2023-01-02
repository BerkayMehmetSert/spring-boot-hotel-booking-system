package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPaymentRepository extends JpaRepository<BillPayment, String> {
}