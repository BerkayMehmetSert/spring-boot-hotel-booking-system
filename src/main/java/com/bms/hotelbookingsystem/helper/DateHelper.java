package com.bms.hotelbookingsystem.helper;

import com.bms.hotelbookingsystem.helper.message.BusinessMessage;

import java.time.LocalDate;

public class DateHelper {
    private DateHelper() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
}
