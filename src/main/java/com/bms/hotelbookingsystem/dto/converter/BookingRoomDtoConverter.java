package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.BookingRoomDto;
import com.bms.hotelbookingsystem.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingRoomDtoConverter {
    public BookingRoomDto convert(Room from){
        return new BookingRoomDto(
                from.getId(),
                from.getRoomNumber(),
                from.getRoomStatus()
        );
    }

    public List<BookingRoomDto> convert(List<Room> from){
        return from.stream().map(this::convert).toList();
    }
}
