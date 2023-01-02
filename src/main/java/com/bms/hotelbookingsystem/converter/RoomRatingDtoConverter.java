package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.RoomRatingDto;
import com.bms.hotelbookingsystem.model.RoomRating;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomRatingDtoConverter {
    public RoomRatingDto convert(RoomRating from){
        return new RoomRatingDto(
                from.getId(),
                from.getName(),
                from.getRoom() != null ? from.getRoom().getId() : null,
                from.getCustomer() != null ? from.getCustomer().getId() : null,
                from.getRating() != null ? from.getRating().getId() : null
        );
    }

    public List<RoomRatingDto> convert(List<RoomRating> from){
        return from.stream().map(this::convert).toList();
    }
}
