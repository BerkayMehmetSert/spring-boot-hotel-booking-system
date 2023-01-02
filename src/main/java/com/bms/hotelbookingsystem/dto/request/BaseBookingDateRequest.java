package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.helper.message.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseBookingDateRequest {
    @NotEmpty(message = ValidationMessage.BookingDate.BOOKING_DATE_CHECK_IN_NOT_EMPTY)
    @NotNull(message = ValidationMessage.BookingDate.BOOKING_DATE_CHECK_IN_NOT_NULL)
    private LocalDate checkInDate;

    @NotEmpty(message = ValidationMessage.BookingDate.BOOKING_DATE_CHECK_OUT_NOT_EMPTY)
    @NotNull(message = ValidationMessage.BookingDate.BOOKING_DATE_CHECK_OUT_NOT_NULL)
    private LocalDate checkOutDate;
}
