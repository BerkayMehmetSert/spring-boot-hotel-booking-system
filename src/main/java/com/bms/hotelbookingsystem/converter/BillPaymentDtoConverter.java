package com.bms.hotelbookingsystem.converter;

import com.bms.hotelbookingsystem.dto.BillPaymentDto;
import com.bms.hotelbookingsystem.model.BillPayment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillPaymentDtoConverter {
    public BillPaymentDto convert(BillPayment from) {
        return new BillPaymentDto(
                from.getId(),
                from.getPaymentType() != null ? from.getPaymentType().getId() : null,
                from.getBookingDate() != null ? from.getBookingDate().getId() : null
        );
    }

    public List<BillPaymentDto> convert(List<BillPayment> from) {
        return from.stream().map(this::convert).toList();
    }
}
