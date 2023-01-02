package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.helper.message.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillRequest extends BaseBillRequest {
    @NotEmpty(message = ValidationMessage.Bill.BILL_RENT_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Bill.BILL_RENT_ID_NOT_NULL)
    private String rentId;
}
