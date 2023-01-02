package com.bms.hotelbookingsystem.exception;

public class BillPaymentAlreadyExistException extends RuntimeException {
    public BillPaymentAlreadyExistException(String message) {
        super(message);
    }
}
