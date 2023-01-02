package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.RoomRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRatingRepository extends JpaRepository<RoomRating, String> {
}