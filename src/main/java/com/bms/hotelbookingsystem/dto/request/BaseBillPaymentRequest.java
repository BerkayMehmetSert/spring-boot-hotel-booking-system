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
public class BaseBillPaymentRequest {
    @NotEmpty(message = ValidationMessage.BillPayment.BILL_PAYMENT_TYPE_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.BillPayment.BILL_PAYMENT_TYPE_ID_NOT_NULL)
    private String paymentTypeId;

    @NotEmpty(message = ValidationMessage.BillPayment.BILL_BOOKING_DATE_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.BillPayment.BILL_BOOKING_DATE_ID_NOT_NULL)
    private String bookingDateId;
}
