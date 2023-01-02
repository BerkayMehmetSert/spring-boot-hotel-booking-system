package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.FloorRoomDto;
import com.bms.hotelbookingsystem.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FloorRoomDtoConverter {
    public FloorRoomDto convert(Room from) {
        return new FloorRoomDto(
                from.getId(),
                from.getRoomNumber(),
                from.getRoomStatus()
        );
    }

    public List<FloorRoomDto> convert(List<Room> from) {
        return from.stream().map(this::convert).toList();
    }
}
