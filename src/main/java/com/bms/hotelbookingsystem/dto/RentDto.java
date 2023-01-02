package com.bms.hotelbookingsystem.dto;

public record RentDto(
        String id,
        Double price,
        String roomTypeId
) {
}
