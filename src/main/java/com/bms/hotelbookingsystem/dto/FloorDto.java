package com.bms.hotelbookingsystem.dto;

import java.util.List;

public record FloorDto(
        String id,
        String number,
        List<FloorRoomDto> rooms
) {
}
