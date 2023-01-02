package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.CustomerRoomDto;
import com.bms.hotelbookingsystem.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerRoomDtoConverter {
    public CustomerRoomDto convert(Room from) {
        return new CustomerRoomDto(
                from.getId(),
                from.getRoomNumber(),
                from.getRoomStatus()
        );
    }

    public List<CustomerRoomDto> convert(List<Room> from) {
        return from.stream().map(this::convert).toList();
    }
}
