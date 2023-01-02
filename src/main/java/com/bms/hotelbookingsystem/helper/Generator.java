package com.bms.hotelbookingsystem.helper;

import com.bms.hotelbookingsystem.helper.message.BusinessMessage;

import java.util.Random;

public class Generator {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final Random random = new Random();
    private static final StringBuilder code = new StringBuilder();

    private Generator() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static String generateKeyCode() {
        for (int i = 0; i < 2; i++) {
            code.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        code.append(" ");

        for (int i = 0; i < 3; i++) {

            code.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        code.append(" ");

        for (int i = 0; i < 3; i++) {
            code.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        code.append(" ");

        for (int i = 0; i < 3; i++) {
            code.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        code.append(" ");

        for (int i = 0; i < 2; i++) {
            code.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return code.toString();
    }
}
