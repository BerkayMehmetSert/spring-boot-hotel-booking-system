package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.BookingDto;
import com.bms.hotelbookingsystem.model.Booking;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingDtoConverter {
    private final BookingCustomerDtoConverter bookingCustomerDtoConverter;
    private final BookingBookingDateDtoConverter bookingBookingDateDtoConverter;
    private final BookingRoomDtoConverter bookingRoomDtoConverter;

    public BookingDtoConverter(BookingCustomerDtoConverter bookingCustomerDtoConverter,
                               BookingBookingDateDtoConverter bookingBookingDateDtoConverter,
                               BookingRoomDtoConverter bookingRoomDtoConverter) {
        this.bookingCustomerDtoConverter = bookingCustomerDtoConverter;
        this.bookingBookingDateDtoConverter = bookingBookingDateDtoConverter;
        this.bookingRoomDtoConverter = bookingRoomDtoConverter;
    }

    public BookingDto convert(Booking from) {
        return new BookingDto(
                from.getId(),
                from.getCustomer() != null ? bookingCustomerDtoConverter.convert(from.getCustomer()) : null,
                from.getBookingDate() != null ? bookingBookingDateDtoConverter.convert(from.getBookingDate()) : null,
                from.getRooms() != null ? bookingRoomDtoConverter.convert(from.getRooms()) : null
        );
    }

    public List<BookingDto> convert(List<Booking> from) {
        return from.stream().map(this::convert).toList();
    }
}
