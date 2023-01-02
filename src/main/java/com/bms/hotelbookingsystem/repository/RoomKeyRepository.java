package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.RoomKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomKeyRepository extends JpaRepository<RoomKey, String> {
}