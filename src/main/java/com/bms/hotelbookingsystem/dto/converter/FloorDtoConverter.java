package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.FloorDto;
import com.bms.hotelbookingsystem.model.Floor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FloorDtoConverter {
    private final FloorRoomDtoConverter floorRoomDtoConverter;

    public FloorDtoConverter(FloorRoomDtoConverter floorRoomDtoConverter) {
        this.floorRoomDtoConverter = floorRoomDtoConverter;
    }

    public FloorDto convert(Floor from) {
        return new FloorDto(
                from.getId(),
                from.getNumber(),
                from.getRooms() != null ? floorRoomDtoConverter.convert(from.getRooms()) : null
        );
    }

    public List<FloorDto> convert(List<Floor> from) {
        return from.stream().map(this::convert).toList();
    }
}
