package com.bms.hotelbookingsystem.dto;

public record RoomKeyDto(
        String id,
        String keyCode,
        Boolean isActive,
        Boolean isMaster,
        String roomId
) {
}
