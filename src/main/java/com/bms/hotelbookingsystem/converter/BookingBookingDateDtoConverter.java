package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.BookingBookingDateDto;
import com.bms.hotelbookingsystem.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingBookingDateDtoConverter {
    public BookingBookingDateDto convert(BookingDate from) {
        return new BookingBookingDateDto(
                from.getId(),
                from.getCheckInDate(),
                from.getCheckOutDate()
        );
    }

    public List<BookingBookingDateDto> convert(List<BookingDate> from) {
        return from.stream().map(this::convert).toList();
    }
}
