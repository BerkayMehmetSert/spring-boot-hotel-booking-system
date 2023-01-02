package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.CustomerDto;
import com.bms.hotelbookingsystem.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomerDtoConverter {
    private final CustomerRoomDtoConverter customerRoomDtoConverter;
    private final CustomerRoomRatingDtoConverter customerRoomRatingDtoConverter;

    public CustomerDtoConverter(CustomerRoomDtoConverter customerRoomDtoConverter,
                                CustomerRoomRatingDtoConverter customerRoomRatingDtoConverter) {
        this.customerRoomDtoConverter = customerRoomDtoConverter;
        this.customerRoomRatingDtoConverter = customerRoomRatingDtoConverter;
    }

    public CustomerDto convert(Customer from){
        return new CustomerDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalId(),
                from.getPassportId(),
                from.getEmail(),
                from.getPhone(),
                from.getAddress(),
                from.getCity(),
                from.getCountry(),
                from.getZipCode(),
                from.getRooms() != null ? customerRoomDtoConverter.convert(from.getRooms()) : null,
                from.getRoomRatings() != null ? customerRoomRatingDtoConverter.convert(from.getRoomRatings()) : null
        );
    }

    public List<CustomerDto> convert(List<Customer> from){
        return from.stream().map(this::convert).toList();
    }
}
