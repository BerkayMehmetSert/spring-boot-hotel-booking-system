package com.bms.hotelbookingsystem.dto;

public record RoomRoomKey(
        String id,
        String keyCode,
        Boolean isActive,
        Boolean isMaster
) {
}
