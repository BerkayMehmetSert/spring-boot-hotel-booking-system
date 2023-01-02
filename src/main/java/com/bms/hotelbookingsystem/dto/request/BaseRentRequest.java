package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.helper.message.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRentRequest {
    @NotEmpty(message = ValidationMessage.Rent.RENT_PRICE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Rent.RENT_PRICE_NOT_NULL)
    private Double price;

    @NotEmpty(message = ValidationMessage.Rent.RENT_ROOM_TYPE_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Rent.RENT_ROOM_TYPE_ID_NOT_NULL)
    private String roomTypeId;
}
