package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {
}