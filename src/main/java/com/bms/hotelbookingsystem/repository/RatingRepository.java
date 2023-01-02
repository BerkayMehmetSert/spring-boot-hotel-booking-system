package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, String> {
}