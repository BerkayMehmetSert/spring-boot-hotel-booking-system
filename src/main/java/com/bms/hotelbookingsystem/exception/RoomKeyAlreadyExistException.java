package com.bms.hotelbookingsystem.exception;

public class RoomKeyAlreadyExistException extends RuntimeException {
    public RoomKeyAlreadyExistException(String message) {
        super(message);
    }
}
