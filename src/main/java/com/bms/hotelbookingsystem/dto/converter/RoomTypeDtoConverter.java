package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.RoomTypeDto;
import com.bms.hotelbookingsystem.model.RoomType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomTypeDtoConverter {
    private final RoomTypeRoomDtoConverter roomTypeRoomDtoConverter;

    public RoomTypeDtoConverter(RoomTypeRoomDtoConverter roomTypeRoomDtoConverter) {
        this.roomTypeRoomDtoConverter = roomTypeRoomDtoConverter;
    }

    public RoomTypeDto convert(RoomType from) {
        return new RoomTypeDto(
                from.getId(),
                from.getName(),
                from.getRooms() != null ? roomTypeRoomDtoConverter.convert(from.getRooms()) : null
        );
    }

    public List<RoomTypeDto> convert(List<RoomType> from) {
        return from.stream().map(this::convert).toList();
    }
}
