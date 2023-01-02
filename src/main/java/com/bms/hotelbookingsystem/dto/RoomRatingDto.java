package com.bms.hotelbookingsystem.dto;

public record RoomRatingDto(
        String id,
        String name,
        String roomId,
        String customerId,
        String ratingId
) {
}
