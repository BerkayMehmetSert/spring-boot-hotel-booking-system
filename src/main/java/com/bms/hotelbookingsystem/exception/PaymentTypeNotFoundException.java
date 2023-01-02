package com.bms.hotelbookingsystem.exception;

public class PaymentTypeNotFoundException extends RuntimeException {
    public PaymentTypeNotFoundException(String message) {
        super(message);
    }
}
