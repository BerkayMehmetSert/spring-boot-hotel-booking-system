package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.RentDto;
import com.bms.hotelbookingsystem.model.Rent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentDtoConverter {
    public RentDto convert(Rent from) {
        return new RentDto(
                from.getId(),
                from.getPrice(),
                from.getRoomType() != null ? from.getRoomType().getId() : null
        );
    }

    public List<RentDto> convert(List<Rent> from) {
        return from.stream().map(this::convert).toList();
    }
}
