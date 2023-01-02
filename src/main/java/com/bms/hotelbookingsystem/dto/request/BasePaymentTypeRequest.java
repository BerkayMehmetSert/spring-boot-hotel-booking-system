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
public class BasePaymentTypeRequest {
    @NotEmpty(message = ValidationMessage.PaymentType.PAYMENT_TYPE_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.PaymentType.PAYMENT_TYPE_NAME_NOT_NULL)
    private String name;
}
