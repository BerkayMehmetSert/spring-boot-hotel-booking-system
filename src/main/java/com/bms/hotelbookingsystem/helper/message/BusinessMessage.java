package com.bms.hotelbookingsystem.helper.message;

public class BusinessMessage {
    public static final String ILLEGAL_STATE_EXCEPTION = "Utility class, cannot be instantiated";

    private BusinessMessage() {
        throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
    }
    public static class Bill{
        private Bill() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String BILL_SAVE_SUCCESS = "Bill saved successfully";
        public static final String BILL_UPDATE_SUCCESS = "Bill updated successfully";
        public static final String BILL_DELETE_SUCCESS = "Bill deleted successfully";
        public static final String BILL_LISTED_SUCCESS = "Bill listed successfully";
        public static final String BILL_NOT_FOUND = "Bill not found";
        public static final String BILL_ALREADY_EXIST = "Bill already exist";
        public static final String BILL_LIST_EMPTY = "Bill list is empty";
    }

    public static class BillPayment{
        private BillPayment() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String BILL_PAYMENT_SAVE_SUCCESS = "Bill payment saved successfully";
        public static final String BILL_PAYMENT_UPDATE_SUCCESS = "Bill payment updated successfully";
        public static final String BILL_PAYMENT_DELETE_SUCCESS = "Bill payment deleted successfully";
        public static final String BILL_PAYMENT_LISTED_SUCCESS = "Bill payment listed successfully";
        public static final String BILL_PAYMENT_NOT_FOUND = "Bill payment not found";
        public static final String BILL_PAYMENT_ALREADY_EXIST = "Bill payment already exist";
        public static final String BILL_PAYMENT_LIST_EMPTY = "Bill payment list is empty";
    }

    public static class Booking{
        private Booking() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String BOOKING_SAVE_SUCCESS = "Booking saved successfully";
        public static final String BOOKING_UPDATE_SUCCESS = "Booking updated successfully";
        public static final String BOOKING_DELETE_SUCCESS = "Booking deleted successfully";
        public static final String BOOKING_LISTED_SUCCESS = "Booking listed successfully";
        public static final String BOOKING_NOT_FOUND = "Booking not found";
        public static final String BOOKING_ALREADY_EXIST = "Booking already exist";
        public static final String BOOKING_LIST_EMPTY = "Booking list is empty";
    }

    public static class BookingDate{
        private BookingDate() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String BOOKING_DATE_SAVE_SUCCESS = "Booking date saved successfully";
        public static final String BOOKING_DATE_UPDATE_SUCCESS = "Booking date updated successfully";
        public static final String BOOKING_DATE_DELETE_SUCCESS = "Booking date deleted successfully";
        public static final String BOOKING_DATE_LISTED_SUCCESS = "Booking date listed successfully";
        public static final String BOOKING_DATE_NOT_FOUND = "Booking date not found";
        public static final String BOOKING_DATE_ALREADY_EXIST = "Booking date already exist";
        public static final String BOOKING_DATE_LIST_EMPTY = "Booking date list is empty";
    }

    public static class Customer{
        private Customer() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String CUSTOMER_SAVE_SUCCESS = "Customer saved successfully";
        public static final String CUSTOMER_UPDATE_SUCCESS = "Customer updated successfully";
        public static final String CUSTOMER_DELETE_SUCCESS = "Customer deleted successfully";
        public static final String CUSTOMER_LISTED_SUCCESS = "Customer listed successfully";
        public static final String CUSTOMER_NOT_FOUND = "Customer not found";
        public static final String CUSTOMER_ALREADY_EXIST = "Customer already exist";
        public static final String CUSTOMER_LIST_EMPTY = "Customer list is empty";
    }

    public static class Floor{
        private Floor() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String FLOOR_SAVE_SUCCESS = "Floor saved successfully";
        public static final String FLOOR_UPDATE_SUCCESS = "Floor updated successfully";
        public static final String FLOOR_DELETE_SUCCESS = "Floor deleted successfully";
        public static final String FLOOR_LISTED_SUCCESS = "Floor listed successfully";
        public static final String FLOOR_NOT_FOUND = "Floor not found";
        public static final String FLOOR_ALREADY_EXIST = "Floor already exist";
        public static final String FLOOR_LIST_EMPTY = "Floor list is empty";
    }

    public static class PaymentType{
        private PaymentType() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String PAYMENT_TYPE_SAVE_SUCCESS = "Payment type saved successfully";
        public static final String PAYMENT_TYPE_UPDATE_SUCCESS = "Payment type updated successfully";
        public static final String PAYMENT_TYPE_DELETE_SUCCESS = "Payment type deleted successfully";
        public static final String PAYMENT_TYPE_LISTED_SUCCESS = "Payment type listed successfully";
        public static final String PAYMENT_TYPE_NOT_FOUND = "Payment type not found";
        public static final String PAYMENT_TYPE_ALREADY_EXIST = "Payment type already exist";
        public static final String PAYMENT_TYPE_LIST_EMPTY = "Payment type list is empty";
    }

    public static class Rating{
        private Rating() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String RATING_SAVE_SUCCESS = "Rating saved successfully";
        public static final String RATING_UPDATE_SUCCESS = "Rating updated successfully";
        public static final String RATING_DELETE_SUCCESS = "Rating deleted successfully";
        public static final String RATING_LISTED_SUCCESS = "Rating listed successfully";
        public static final String RATING_NOT_FOUND = "Rating not found";
        public static final String RATING_ALREADY_EXIST = "Rating already exist";
        public static final String RATING_LIST_EMPTY = "Rating list is empty";
    }

    public static class Rent{
        private Rent() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String RENT_SAVE_SUCCESS = "Rent saved successfully";
        public static final String RENT_UPDATE_SUCCESS = "Rent updated successfully";
        public static final String RENT_DELETE_SUCCESS = "Rent deleted successfully";
        public static final String RENT_LISTED_SUCCESS = "Rent listed successfully";
        public static final String RENT_NOT_FOUND = "Rent not found";
        public static final String RENT_ALREADY_EXIST = "Rent already exist";
        public static final String RENT_LIST_EMPTY = "Rent list is empty";
    }

    public static class Room{
        private Room() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String ROOM_SAVE_SUCCESS = "Room saved successfully";
        public static final String ROOM_UPDATE_SUCCESS = "Room updated successfully";
        public static final String ROOM_DELETE_SUCCESS = "Room deleted successfully";
        public static final String ROOM_LISTED_SUCCESS = "Room listed successfully";
        public static final String ROOM_NOT_FOUND = "Room not found";
        public static final String ROOM_ALREADY_EXIST = "Room already exist";
        public static final String ROOM_LIST_EMPTY = "Room list is empty";
    }

    public static class RoomKey{
        private RoomKey() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String ROOM_KEY_SAVE_SUCCESS = "Room key saved successfully";
        public static final String ROOM_KEY_UPDATE_SUCCESS = "Room key updated successfully";
        public static final String ROOM_KEY_DELETE_SUCCESS = "Room key deleted successfully";
        public static final String ROOM_KEY_LISTED_SUCCESS = "Room key listed successfully";
        public static final String ROOM_KEY_NOT_FOUND = "Room key not found";
        public static final String ROOM_KEY_ALREADY_EXIST = "Room key already exist";
        public static final String ROOM_KEY_LIST_EMPTY = "Room key list is empty";
    }

    public static class RoomRating{
        private RoomRating() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String ROOM_RATING_SAVE_SUCCESS = "Room rating saved successfully";
        public static final String ROOM_RATING_UPDATE_SUCCESS = "Room rating updated successfully";
        public static final String ROOM_RATING_DELETE_SUCCESS = "Room rating deleted successfully";
        public static final String ROOM_RATING_LISTED_SUCCESS = "Room rating listed successfully";
        public static final String ROOM_RATING_NOT_FOUND = "Room rating not found";
        public static final String ROOM_RATING_ALREADY_EXIST = "Room rating already exist";
        public static final String ROOM_RATING_LIST_EMPTY = "Room rating list is empty";
    }

    public static class RoomType{
        private RoomType() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }
        public static final String ROOM_TYPE_SAVE_SUCCESS = "Room type saved successfully";
        public static final String ROOM_TYPE_UPDATE_SUCCESS = "Room type updated successfully";
        public static final String ROOM_TYPE_DELETE_SUCCESS = "Room type deleted successfully";
        public static final String ROOM_TYPE_LISTED_SUCCESS = "Room type listed successfully";
        public static final String ROOM_TYPE_NOT_FOUND = "Room type not found";
        public static final String ROOM_TYPE_ALREADY_EXIST = "Room type already exist";
        public static final String ROOM_TYPE_LIST_EMPTY = "Room type list is empty";
    }
}
