package com.bms.hotelbookingsystem.dto;

import com.bms.hotelbookingsystem.model.RoomStatus;

public record CustomerRoomDto(
        String id,
        String roomNumber,
        RoomStatus roomStatus
) {
}
