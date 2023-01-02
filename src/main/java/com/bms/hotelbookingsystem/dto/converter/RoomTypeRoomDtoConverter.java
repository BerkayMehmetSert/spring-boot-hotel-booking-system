package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.RoomTypeRoomDto;
import com.bms.hotelbookingsystem.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomTypeRoomDtoConverter {
    public RoomTypeRoomDto convert(Room from){
        return new RoomTypeRoomDto(
                from.getId(),
                from.getRoomNumber(),
                from.getRoomStatus()
        );
    }

    public List<RoomTypeRoomDto> convert(List<Room> from){
        return from.stream().map(this::convert).toList();
    }
}
