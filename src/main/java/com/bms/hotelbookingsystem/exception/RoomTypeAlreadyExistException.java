package com.bms.hotelbookingsystem.exception;

public class RoomTypeAlreadyExistException extends RuntimeException {
    public RoomTypeAlreadyExistException(String message) {
        super(message);
    }
}
