package com.bms.hotelbookingsystem.helper;

import java.time.LocalDate;

public class DateHelper {
    private static final String ILLEGAL_STATE_EXCEPTION_MESSAGE = "Utility class, cannot be instantiated";
    private DateHelper() {
        throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION_MESSAGE);
    }
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
