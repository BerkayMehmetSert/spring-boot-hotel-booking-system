package com.bms.hotelbookingsystem.dto;

public record BillDto(
        String id,
        Double price,
        String rentId
) {
}
