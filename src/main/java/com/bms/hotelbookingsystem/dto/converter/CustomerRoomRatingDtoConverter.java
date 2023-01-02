package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.CustomerRoomRatingDto;
import com.bms.hotelbookingsystem.model.RoomRating;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRoomRatingDtoConverter {
    public CustomerRoomRatingDto convert(RoomRating from) {
        return new CustomerRoomRatingDto(
                from.getId(),
                from.getName(),
                from.getRating() != null ? from.getRating().getId() : null
        );
    }

    public List<CustomerRoomRatingDto> convert(List<RoomRating> from) {
        return from.stream().map(this::convert).toList();
    }
}
