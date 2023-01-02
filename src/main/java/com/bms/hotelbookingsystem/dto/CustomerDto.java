package com.bms.hotelbookingsystem.dto;

import java.util.List;

public record CustomerDto(
        String id,
        String firstName,
        String lastName,
        String nationalId,
        String passportId,
        String email,
        String phone,
        String address,
        String city,
        String country,
        String zipCode,
        List<CustomerRoomDto> rooms,
        List<CustomerRatingDto> ratings
) {
}
