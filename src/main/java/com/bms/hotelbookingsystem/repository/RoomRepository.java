package com.bms.hotelbookingsystem.repository;

import com.bms.hotelbookingsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, String> {
}