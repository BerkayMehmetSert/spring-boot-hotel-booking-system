package com.bms.hotelbookingsystem.dto;

import java.util.List;

public record BookingDto(
        String id,
        BookingCustomerDto customer,
        BookingBookingDateDto bookingDate,
        List<BookingRoomDto> rooms
) {
}
