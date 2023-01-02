package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.RoomKeyDto;
import com.bms.hotelbookingsystem.model.RoomKey;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomKeyDtoConverter {
    public RoomKeyDto convert(RoomKey from){
        return new RoomKeyDto(
                from.getId(),
                from.getKeyCode(),
                from.getIsActive(),
                from.getIsMaster(),
                from.getRoom() != null ? from.getRoom().getId() : null
        );
    }

    public List<RoomKeyDto> convert(List<RoomKey> from){
        return from.stream().map(this::convert).toList();
    }
}
