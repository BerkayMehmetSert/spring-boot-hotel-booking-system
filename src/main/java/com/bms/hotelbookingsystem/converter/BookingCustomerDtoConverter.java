package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.BookingCustomerDto;
import com.bms.hotelbookingsystem.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingCustomerDtoConverter {
    public BookingCustomerDto convert(Customer from) {
        return new BookingCustomerDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalId(),
                from.getPassportId(),
                from.getPhone()
        );
    }

    public List<BookingCustomerDto> convert(List<Customer> from) {
        return from.stream().map(this::convert).toList();
    }
}
