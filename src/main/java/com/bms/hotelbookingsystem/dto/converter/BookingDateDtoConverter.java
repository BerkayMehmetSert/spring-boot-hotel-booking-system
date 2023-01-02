package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.BookingDateDto;
import com.bms.hotelbookingsystem.model.BookingDate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDateDtoConverter {
    public BookingDateDto convert(BookingDate from) {
        return new BookingDateDto(
                from.getId(),
                from.getCheckInDate(),
                from.getCheckOutDate()
        );
    }

    public List<BookingDateDto> convert(List<BookingDate> from) {
        return from.stream().map(this::convert).toList();
    }
}
