package com.bms.hotelbookingsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateCustomerRequest extends BaseCustomerRequest{
    private String nationalId;
    private String passportId;
}
