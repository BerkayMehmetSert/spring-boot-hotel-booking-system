package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.BookingDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDateRepository extends JpaRepository<BookingDate, String> {
}