package com.bms.hotelbookingsystem.exception;

public class RatingAlreadyExistException extends RuntimeException {
    public RatingAlreadyExistException(String message) {
        super(message);
    }
}
