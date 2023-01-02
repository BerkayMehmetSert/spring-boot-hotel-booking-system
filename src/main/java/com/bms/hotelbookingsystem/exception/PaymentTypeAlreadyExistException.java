package com.bms.hotelbookingsystem.exception;

public class PaymentTypeAlreadyExistException extends RuntimeException {
    public PaymentTypeAlreadyExistException(String message) {
        super(message);
    }
}
