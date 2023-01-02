package com.bms.hotelbookingsystem.dto;

public record BillPaymentDto(
        String id,
        String paymentTypeId,
        String bookingDateId
) {
}
