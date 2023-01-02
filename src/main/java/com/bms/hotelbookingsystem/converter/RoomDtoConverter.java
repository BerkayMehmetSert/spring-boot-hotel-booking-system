package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.RoomDto;
import com.bms.hotelbookingsystem.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomDtoConverter {
    private final RoomRoomRatingDtoConverter roomRoomRatingDtoConverter;
    private final RoomRoomKeyDtoConverter roomRoomKeyDtoConverter;

    public RoomDtoConverter(RoomRoomRatingDtoConverter roomRoomRatingDtoConverter,
                            RoomRoomKeyDtoConverter roomRoomKeyDtoConverter) {
        this.roomRoomRatingDtoConverter = roomRoomRatingDtoConverter;
        this.roomRoomKeyDtoConverter = roomRoomKeyDtoConverter;
    }

    public RoomDto convert(Room from) {
        return new RoomDto(
                from.getId(),
                from.getRoomNumber(),
                from.getIsSmoking(),
                from.getCustomer() != null ? from.getCustomer().getId() : null,
                from.getRoomType() != null ? from.getRoomType().getId() : null,
                from.getRoomStatus(),
                from.getBooking() != null ? from.getBooking().getId() : null,
                from.getFloor() != null ? from.getFloor().getId() : null,
                from.getRoomRatings() != null ? roomRoomRatingDtoConverter.convert(from.getRoomRatings()) : null,
                from.getRoomKeys() != null ? roomRoomKeyDtoConverter.convert(from.getRoomKeys()) : null
        );
    }

    public List<RoomDto> convert(List<Room> from) {
        return from.stream().map(this::convert).toList();
    }
}
