package com.bms.hotelbookingsystem.dto;

public record RoomRoomKeyDto(
        String id,
        String keyCode,
        Boolean isActive,
        Boolean isMaster
) {
}
