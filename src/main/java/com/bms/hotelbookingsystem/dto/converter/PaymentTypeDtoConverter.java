package com.bms.hotelbookingsystem.dto.converter;

import com.bms.hotelbookingsystem.dto.PaymentTypeDto;
import com.bms.hotelbookingsystem.model.PaymentType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentTypeDtoConverter {
    public PaymentTypeDto convert(PaymentType from) {
        return new PaymentTypeDto(
                from.getId(),
                from.getName()
        );
    }

    public List<PaymentTypeDto> convert(List<PaymentType> from) {
        return from.stream().map(this::convert).toList();
    }
}
