package com.bms.hotelbookingsystem.dto;

import com.bms.hotelbookingsystem.model.RoomStatus;

import java.util.List;

public record RoomDto(
        String id,
        String roomNumber,
        Boolean isSmoking,
        String customerId,
        String roomTypeId,
        RoomStatus roomStatus,
        String bookingId,
        String floorId,
        List<RoomRoomRatingDto> roomRatings,
        List<RoomRoomKeyDto> roomKeys
) {
}
