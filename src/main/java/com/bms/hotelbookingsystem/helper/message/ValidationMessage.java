package com.bms.hotelbookingsystem.helper.message;

public class ValidationMessage {
    private ValidationMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class General {
        private General() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        public static final String PHONE_REGEX = "^[09]{2}[0-9]{9}$";
    }

    public static class Bill {
        private Bill() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BILL_PRICE_NOT_EMPTY = "Bill price cannot be empty";
        public static final String BILL_PRICE_NOT_NULL = "Bill price cannot be null";
        public static final String BILL_RENT_ID_NOT_EMPTY = "Bill rent id cannot be empty";
        public static final String BILL_RENT_ID_NOT_NULL = "Bill rent id cannot be null";
    }

    public static class BillPayment {
        private BillPayment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BILL_PAYMENT_TYPE_ID_NOT_EMPTY = "Bill payment type id cannot be empty";
        public static final String BILL_PAYMENT_TYPE_ID_NOT_NULL = "Bill payment type id cannot be null";
        public static final String BILL_BOOKING_DATE_ID_NOT_EMPTY = "Bill booking date id cannot be empty";
        public static final String BILL_BOOKING_DATE_ID_NOT_NULL = "Bill booking date id cannot be null";
    }

    public static class BookingDate {
        private BookingDate() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BOOKING_DATE_CHECK_IN_NOT_EMPTY = "Booking date check in cannot be empty";
        public static final String BOOKING_DATE_CHECK_IN_NOT_NULL = "Booking date check in cannot be null";
        public static final String BOOKING_DATE_CHECK_OUT_NOT_EMPTY = "Booking date check out cannot be empty";
        public static final String BOOKING_DATE_CHECK_OUT_NOT_NULL = "Booking date check out cannot be null";
    }

    public static class Booking {
        private Booking() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BOOKING_CUSTOMER_ID_NOT_EMPTY = "Booking customer id cannot be empty";
        public static final String BOOKING_CUSTOMER_ID_NOT_NULL = "Booking customer id cannot be null";
        public static final String BOOKING_BOOKING_DATE_ID_NOT_EMPTY = "Booking booking date id cannot be empty";
        public static final String BOOKING_BOOKING_DATE_ID_NOT_NULL = "Booking booking date id cannot be null";
    }

    public static class Customer {
        private Customer() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CUSTOMER_FIRST_NAME_NOT_EMPTY = "Customer first name cannot be empty";
        public static final String CUSTOMER_FIRST_NAME_NOT_NULL = "Customer first name cannot be null";
        public static final String CUSTOMER_LAST_NAME_NOT_EMPTY = "Customer last name cannot be empty";
        public static final String CUSTOMER_LAST_NAME_NOT_NULL = "Customer last name cannot be null";
        public static final String CUSTOMER_NATIONAL_ID_NOT_EMPTY = "Customer national id cannot be empty";
        public static final String CUSTOMER_NATIONAL_ID_NOT_NULL = "Customer national id cannot be null";
        public static final String CUSTOMER_PHONE_NOT_EMPTY = "Customer phone cannot be empty";
        public static final String CUSTOMER_PHONE_NOT_NULL = "Customer phone cannot be null";
        public static final String CUSTOMER_PHONE_NOT_VALID = "Customer phone is not valid";
        public static final String CUSTOMER_EMAIL_NOT_EMPTY = "Customer email cannot be empty";
        public static final String CUSTOMER_EMAIL_NOT_NULL = "Customer email cannot be null";
        public static final String CUSTOMER_EMAIL_NOT_VALID = "Customer email is not valid";
        public static final String CUSTOMER_PASSPORT_ID_NOT_EMPTY = "Customer passport id cannot be empty";
        public static final String CUSTOMER_PASSPORT_ID_NOT_NULL = "Customer passport id cannot be null";
        public static final String CUSTOMER_ADDRESS_NOT_EMPTY = "Customer address cannot be empty";
        public static final String CUSTOMER_ADDRESS_NOT_NULL = "Customer address cannot be null";
        public static final String CUSTOMER_CITY_NOT_EMPTY = "Customer city cannot be empty";
        public static final String CUSTOMER_CITY_NOT_NULL = "Customer city cannot be null";
        public static final String CUSTOMER_COUNTRY_NOT_EMPTY = "Customer country cannot be empty";
        public static final String CUSTOMER_COUNTRY_NOT_NULL = "Customer country cannot be null";
        public static final String CUSTOMER_ZIP_CODE_NOT_EMPTY = "Customer zip code cannot be empty";
        public static final String CUSTOMER_ZIP_CODE_NOT_NULL = "Customer zip code cannot be null";
    }

    public static class Floor {
        private Floor() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String FLOOR_NUMBER_NOT_EMPTY = "Floor number cannot be empty";
        public static final String FLOOR_NUMBER_NOT_NULL = "Floor number cannot be null";
    }

    public static class PaymentType {
        private PaymentType() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PAYMENT_TYPE_NAME_NOT_EMPTY = "Payment type name cannot be empty";
        public static final String PAYMENT_TYPE_NAME_NOT_NULL = "Payment type name cannot be null";
    }

    public static class Rating {
        private Rating() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String RATING_VALUE_NOT_EMPTY = "Rating value cannot be empty";
        public static final String RATING_VALUE_NOT_NULL = "Rating value cannot be null";
        public static final String RATING_DESCRIPTION_NOT_EMPTY = "Rating description cannot be empty";
        public static final String RATING_DESCRIPTION_NOT_NULL = "Rating description cannot be null";
    }

    public static class Rent {
        private Rent() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String RENT_PRICE_NOT_EMPTY = "Rent price cannot be empty";
        public static final String RENT_PRICE_NOT_NULL = "Rent price cannot be null";
        public static final String RENT_ROOM_TYPE_ID_NOT_EMPTY = "Rent room type id cannot be empty";
        public static final String RENT_ROOM_TYPE_ID_NOT_NULL = "Rent room type id cannot be null";
    }

    public static class RoomKey {
        private RoomKey() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_KEY_IS_ACTIVE_NOT_EMPTY = "Room key is active cannot be empty";
        public static final String ROOM_KEY_IS_ACTIVE_NOT_NULL = "Room key is active cannot be null";
        public static final String ROOM_KEY_IS_MASTER_NOT_EMPTY = "Room key is master cannot be empty";
        public static final String ROOM_KEY_IS_MASTER_NOT_NULL = "Room key is master cannot be null";
        public static final String ROOM_KEY_ROOM_ID_NOT_EMPTY = "Room key room id cannot be empty";
        public static final String ROOM_KEY_ROOM_ID_NOT_NULL = "Room key room id cannot be null";
    }

    public static class RoomRating {
        private RoomRating() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_RATING_ROOM_ID_NOT_NULL = "Room rating room id cannot be null";
        public static final String ROOM_RATING_RATING_ID_NOT_EMPTY = "Room rating rating id cannot be empty";
        public static final String ROOM_RATING_RATING_ID_NOT_NULL = "Room rating rating id cannot be null";
        public static final String ROOM_RATING_CUSTOMER_ID_NOT_EMPTY = "Room rating customer id cannot be empty";
        public static final String ROOM_RATING_CUSTOMER_ID_NOT_NULL = "Room rating customer id cannot be null";
        public static final String ROOM_RATING_NAME_NOT_EMPTY = "Room rating name cannot be empty";
        public static final String ROOM_RATING_NAME_NOT_NULL = "Room rating name cannot be null";
    }

    public static class Room {
        private Room() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_NUMBER_NOT_EMPTY = "Room number cannot be empty";
        public static final String ROOM_NUMBER_NOT_NULL = "Room number cannot be null";
        public static final String ROOM_FLOOR_ID_NOT_EMPTY = "Room floor id cannot be empty";
        public static final String ROOM_FLOOR_ID_NOT_NULL = "Room floor id cannot be null";
        public static final String ROOM_ROOM_TYPE_ID_NOT_EMPTY = "Room room type id cannot be empty";
        public static final String ROOM_ROOM_TYPE_ID_NOT_NULL = "Room room type id cannot be null";
        public static final String ROOM_BOOKING_ID_NOT_EMPTY = "Room booking id cannot be empty";
        public static final String ROOM_BOOKING_ID_NOT_NULL = "Room booking id cannot be null";
        public static final String ROOM_CUSTOMER_ID_NOT_EMPTY = "Room customer id cannot be empty";
        public static final String ROOM_CUSTOMER_ID_NOT_NULL = "Room customer id cannot be null";
        public static final String ROOM_ROOM_STATUS_NOT_EMPTY = "Room room status cannot be empty";
        public static final String ROOM_ROOM_STATUS_NOT_NULL = "Room room status cannot be null";
        public static final String ROOM_IS_SMOKING_NOT_EMPTY = "Room is smoking cannot be empty";
        public static final String ROOM_IS_SMOKING_NOT_NULL = "Room is smoking cannot be null";
    }

    public static class RoomType {
        private RoomType() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_TYPE_NAME_NOT_EMPTY = "Room type name cannot be empty";
        public static final String ROOM_TYPE_NAME_NOT_NULL = "Room type name cannot be null";
    }
}
