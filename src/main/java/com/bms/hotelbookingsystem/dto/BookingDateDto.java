package com.bms.hotelbookingsystem.dto;

import java.time.LocalDate;

public record BookingDateDto(
        String id,
        LocalDate checkInDate,
        LocalDate checkOutDate
) {
}
