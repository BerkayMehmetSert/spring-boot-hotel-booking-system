package com.bms.hotelbookingsystem.dto;

import com.bms.hotelbookingsystem.model.RoomStatus;

public record RoomTypeRoomDto(
        String id,
        String roomNumber,
        RoomStatus roomStatus
) {
}
