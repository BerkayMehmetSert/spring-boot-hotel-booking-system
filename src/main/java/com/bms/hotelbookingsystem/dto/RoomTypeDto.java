package com.bms.hotelbookingsystem.dto;

import java.util.List;

public record RoomTypeDto(
        String id,
        String name,
        List<RoomTypeRoomDto> rooms
) {
}
