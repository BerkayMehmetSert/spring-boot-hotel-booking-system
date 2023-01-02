package com.bms.hotelbookingsystem.exception;

public class RoomAlreadyExistException extends RuntimeException {
    public RoomAlreadyExistException(String message) {
        super(message);
    }
}
