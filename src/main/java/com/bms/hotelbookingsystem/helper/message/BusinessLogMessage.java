package com.bms.hotelbookingsystem.helper.message;

public class BusinessLogMessage {

    private BusinessLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class Bill {
        private Bill() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BILL_NOT_FOUND = "Bill not found : {}";
        public static final String BILL_ALREADY_EXISTS = "Bill already exists : {}";
        public static final String BILL_CREATED = "Bill created successfully";
        public static final String BILL_UPDATED = "Bill updated successfully : {}";
        public static final String BILL_DELETED = "Bill deleted successfully : {}";
        public static final String BILL_LISTED = "Bill listed successfully";
        public static final String BILL_FOUND = "Bill found successfully : {}";
        public static final String BILL_LIST_EMPTY = "Bill list is empty";
    }

    public static class BillPayment {
        private BillPayment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BILL_PAYMENT_NOT_FOUND = "BillPayment not found : {}";
        public static final String BILL_PAYMENT_ALREADY_EXISTS = "BillPayment already exists : {}";
        public static final String BILL_PAYMENT_CREATED = "BillPayment created successfully";
        public static final String BILL_PAYMENT_UPDATED = "BillPayment updated successfully : {}";
        public static final String BILL_PAYMENT_DELETED = "BillPayment deleted successfully : {}";
        public static final String BILL_PAYMENT_LISTED = "BillPayment listed successfully";
        public static final String BILL_PAYMENT_FOUND = "BillPayment found successfully : {}";
        public static final String BILL_PAYMENT_LIST_EMPTY = "BillPayment list is empty";
    }

    public static class Booking {
        private Booking() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BOOKING_NOT_FOUND = "Booking not found : {}";
        public static final String BOOKING_ALREADY_EXISTS = "Booking already exists : {}";
        public static final String BOOKING_CREATED = "Booking created successfully";
        public static final String BOOKING_UPDATED = "Booking updated successfully : {}";
        public static final String BOOKING_DELETED = "Booking deleted successfully : {}";
        public static final String BOOKING_LISTED = "Booking listed successfully";
        public static final String BOOKING_FOUND = "Booking found successfully : {}";
        public static final String BOOKING_LIST_EMPTY = "Booking list is empty";
    }

    public static class BookingDate {
        private BookingDate() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BOOKING_DATE_NOT_FOUND = "BookingDate not found : {}";
        public static final String BOOKING_DATE_ALREADY_EXISTS = "BookingDate already exists : {}";
        public static final String BOOKING_DATE_CREATED = "BookingDate created successfully";
        public static final String BOOKING_DATE_UPDATED = "BookingDate updated successfully : {}";
        public static final String BOOKING_DATE_DELETED = "BookingDate deleted successfully : {}";
        public static final String BOOKING_DATE_LISTED = "BookingDate listed successfully";
        public static final String BOOKING_DATE_FOUND = "BookingDate found successfully : {}";
        public static final String BOOKING_DATE_LIST_EMPTY = "BookingDate list is empty";
    }

    public static class Customer {
        private Customer() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CUSTOMER_NOT_FOUND = "Customer not found : {}";
        public static final String CUSTOMER_ALREADY_EXISTS = "Customer already exists : {}";
        public static final String CUSTOMER_CREATED = "Customer created successfully";
        public static final String CUSTOMER_UPDATED = "Customer updated successfully : {}";
        public static final String CUSTOMER_DELETED = "Customer deleted successfully : {}";
        public static final String CUSTOMER_LISTED = "Customer listed successfully";
        public static final String CUSTOMER_FOUND = "Customer found successfully : {}";
        public static final String CUSTOMER_LIST_EMPTY = "Customer list is empty";
    }

    public static class Floor {
        private Floor() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String FLOOR_NOT_FOUND = "Floor not found : {}";
        public static final String FLOOR_ALREADY_EXISTS = "Floor already exists : {}";
        public static final String FLOOR_CREATED = "Floor created successfully";
        public static final String FLOOR_UPDATED = "Floor updated successfully : {}";
        public static final String FLOOR_DELETED = "Floor deleted successfully : {}";
        public static final String FLOOR_LISTED = "Floor listed successfully";
        public static final String FLOOR_FOUND = "Floor found successfully : {}";
        public static final String FLOOR_LIST_EMPTY = "Floor list is empty";
    }

    public static class PaymentType {
        private PaymentType() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PAYMENT_TYPE_NOT_FOUND = "PaymentType not found : {}";
        public static final String PAYMENT_TYPE_ALREADY_EXISTS = "PaymentType already exists : {}";
        public static final String PAYMENT_TYPE_CREATED = "PaymentType created successfully";
        public static final String PAYMENT_TYPE_UPDATED = "PaymentType updated successfully : {}";
        public static final String PAYMENT_TYPE_DELETED = "PaymentType deleted successfully : {}";
        public static final String PAYMENT_TYPE_LISTED = "PaymentType listed successfully";
        public static final String PAYMENT_TYPE_FOUND = "PaymentType found successfully : {}";
        public static final String PAYMENT_TYPE_LIST_EMPTY = "PaymentType list is empty";
    }

    public static class Rating {
        private Rating() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String RATING_NOT_FOUND = "Rating not found : {}";
        public static final String RATING_ALREADY_EXISTS = "Rating already exists : {}";
        public static final String RATING_CREATED = "Rating created successfully";
        public static final String RATING_UPDATED = "Rating updated successfully : {}";
        public static final String RATING_DELETED = "Rating deleted successfully : {}";
        public static final String RATING_LISTED = "Rating listed successfully";
        public static final String RATING_FOUND = "Rating found successfully : {}";
        public static final String RATING_LIST_EMPTY = "Rating list is empty";
    }

    public static class Rent {
        private Rent() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String RENT_NOT_FOUND = "Rent not found : {}";
        public static final String RENT_ALREADY_EXISTS = "Rent already exists : {}";
        public static final String RENT_CREATED = "Rent created successfully";
        public static final String RENT_UPDATED = "Rent updated successfully : {}";
        public static final String RENT_DELETED = "Rent deleted successfully : {}";
        public static final String RENT_LISTED = "Rent listed successfully";
        public static final String RENT_FOUND = "Rent found successfully : {}";
        public static final String RENT_LIST_EMPTY = "Rent list is empty";
    }

    public static class Room {
        private Room() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_NOT_FOUND = "Room not found : {}";
        public static final String ROOM_ALREADY_EXISTS = "Room already exists : {}";
        public static final String ROOM_CREATED = "Room created successfully";
        public static final String ROOM_UPDATED = "Room updated successfully : {}";
        public static final String ROOM_DELETED = "Room deleted successfully : {}";
        public static final String ROOM_LISTED = "Room listed successfully";
        public static final String ROOM_FOUND = "Room found successfully : {}";
        public static final String ROOM_LIST_EMPTY = "Room list is empty";
    }

    public static class RoomKey {
        private RoomKey() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_KEY_NOT_FOUND = "RoomKey not found : {}";
        public static final String ROOM_KEY_ALREADY_EXISTS = "RoomKey already exists : {}";
        public static final String ROOM_KEY_CREATED = "RoomKey created successfully";
        public static final String ROOM_KEY_UPDATED = "RoomKey updated successfully : {}";
        public static final String ROOM_KEY_DELETED = "RoomKey deleted successfully : {}";
        public static final String ROOM_KEY_LISTED = "RoomKey listed successfully";
        public static final String ROOM_KEY_FOUND = "RoomKey found successfully : {}";
        public static final String ROOM_KEY_LIST_EMPTY = "RoomKey list is empty";
    }

    public static class RoomRating {
        private RoomRating() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_RATING_NOT_FOUND = "RoomRating not found : {}";
        public static final String ROOM_RATING_ALREADY_EXISTS = "RoomRating already exists : {}";
        public static final String ROOM_RATING_CREATED = "RoomRating created successfully";
        public static final String ROOM_RATING_UPDATED = "RoomRating updated successfully : {}";
        public static final String ROOM_RATING_DELETED = "RoomRating deleted successfully : {}";
        public static final String ROOM_RATING_LISTED = "RoomRating listed successfully";
        public static final String ROOM_RATING_FOUND = "RoomRating found successfully : {}";
        public static final String ROOM_RATING_LIST_EMPTY = "RoomRating list is empty";
    }

    public static class RoomType {
        private RoomType() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_TYPE_NOT_FOUND = "RoomType not found : {}";
        public static final String ROOM_TYPE_ALREADY_EXISTS = "RoomType already exists : {}";
        public static final String ROOM_TYPE_CREATED = "RoomType created successfully";
        public static final String ROOM_TYPE_UPDATED = "RoomType updated successfully : {}";
        public static final String ROOM_TYPE_DELETED = "RoomType deleted successfully : {}";
        public static final String ROOM_TYPE_LISTED = "RoomType listed successfully";
        public static final String ROOM_TYPE_FOUND = "RoomType found successfully : {}";
        public static final String ROOM_TYPE_LIST_EMPTY = "RoomType list is empty";
    }
}
