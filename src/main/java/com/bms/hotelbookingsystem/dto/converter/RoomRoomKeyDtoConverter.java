package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.RoomRoomKeyDto;
import com.bms.hotelbookingsystem.model.RoomKey;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomRoomKeyDtoConverter {
    public RoomRoomKeyDto convert(RoomKey from) {
        return new RoomRoomKeyDto(
                from.getId(),
                from.getKeyCode(),
                from.getIsActive(),
                from.getIsMaster()
        );
    }

    public List<RoomRoomKeyDto> convert(List<RoomKey> from) {
        return from.stream().map(this::convert).toList();
    }
}
