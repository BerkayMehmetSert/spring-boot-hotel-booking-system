package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.BillDto;
import com.bms.hotelbookingsystem.model.Bill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillDtoConverter {
    public BillDto convert(Bill from){
        return new BillDto(
                from.getId(),
                from.getPrice(),
                from.getRent() != null ? from.getRent().getId() : null
        );
    }

    public List<BillDto> convert(List<Bill> from){
        return from.stream().map(this::convert).toList();
    }
}
