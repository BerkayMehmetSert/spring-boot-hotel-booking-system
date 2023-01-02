package com.bms.hotelbookingsystem.dto;

import java.time.LocalDate;

public record BookingBookingDateDto(
        String id,
        LocalDate checkInDate,
        LocalDate checkOutDate
) {
}
