package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
    boolean existsByNameIgnoreCase(String name);
}