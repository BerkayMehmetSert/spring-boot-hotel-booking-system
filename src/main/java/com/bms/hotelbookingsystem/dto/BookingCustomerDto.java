package com.bms.hotelbookingsystem.dto;

public record BookingCustomerDto(
        String id,
        String firstName,
        String lastName,
        String nationalId,
        String passportId,
        String phone
) {
}
