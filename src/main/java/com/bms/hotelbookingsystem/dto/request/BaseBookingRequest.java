package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.helper.message.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseBookingRequest {
    @NotEmpty(message = ValidationMessage.Booking.BOOKING_CUSTOMER_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Booking.BOOKING_CUSTOMER_ID_NOT_NULL)
    private String customerId;

    @NotEmpty(message = ValidationMessage.Booking.BOOKING_BOOKING_DATE_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Booking.BOOKING_BOOKING_DATE_ID_NOT_NULL)
    private String bookingDateId;
}
