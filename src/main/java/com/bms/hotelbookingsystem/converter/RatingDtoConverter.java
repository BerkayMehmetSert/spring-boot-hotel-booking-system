package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.RatingDto;
import com.bms.hotelbookingsystem.model.Rating;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingDtoConverter {
    public RatingDto convert(Rating from) {
        return new RatingDto(
                from.getId(),
                from.getValue(),
                from.getDescription()
        );
    }

    public List<RatingDto> convert(List<Rating> from) {
        return from.stream().map(this::convert).toList();
    }
}
