package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.RoomRoomRatingDto;
import com.bms.hotelbookingsystem.model.RoomRating;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomRoomRatingDtoConverter {
    public RoomRoomRatingDto convert(RoomRating from) {
        return new RoomRoomRatingDto(
                from.getId(),
                from.getName(),
                from.getRating() != null ? from.getRating().getId() : null
        );
    }

    public List<RoomRoomRatingDto> convert(List<RoomRating> from) {
        return from.stream().map(this::convert).toList();
    }
}
