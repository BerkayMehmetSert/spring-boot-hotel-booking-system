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
public class BaseCustomerRequest {
    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_ADDRESS_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_ADDRESS_NOT_NULL)
    private String address;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_CITY_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_CITY_NOT_NULL)
    private String city;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_COUNTRY_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_COUNTRY_NOT_NULL)
    private String country;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_ZIP_CODE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_ZIP_CODE_NOT_NULL)
    private String zipCode;
}
