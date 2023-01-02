package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.helper.message.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateCustomerRequest extends BaseCustomerRequest {
    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_FIRST_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_FIRST_NAME_NOT_NULL)
    private String firstName;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_LAST_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_LAST_NAME_NOT_NULL)
    private String lastName;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_EMAIL_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_EMAIL_NOT_NULL)
    @Email(message = ValidationMessage.Customer.CUSTOMER_EMAIL_NOT_VALID,
            regexp = ValidationMessage.General.EMAIL_REGEX)
    private String email;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_PHONE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_PHONE_NOT_NULL)
    @Pattern(message = ValidationMessage.Customer.CUSTOMER_PHONE_NOT_VALID,
            regexp = ValidationMessage.General.PHONE_REGEX)
    private String phone;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_NATIONAL_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_NATIONAL_ID_NOT_NULL)
    private String nationalId;

    @NotEmpty(message = ValidationMessage.Customer.CUSTOMER_PASSPORT_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Customer.CUSTOMER_PASSPORT_ID_NOT_NULL)
    private String passportId;
}
