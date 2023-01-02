package com.bms.hotelbookingsystem.helper.message;

public class ControllerLogMessage {
    private ControllerLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class Bill{
        private Bill() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BILL_CREATED = "Bill API : Created successfully";
        public static final String BILL_UPDATED = "Bill API : Updated successfully : {}";
        public static final String BILL_DELETED = "Bill API : Deleted successfully : {}";
        public static final String BILL_FOUND = "Bill API : Found successfully : {}";
        public static final String BILL_LISTED = "Bill API : Listed successfully";
    }

    public static class BillPayment{
        private BillPayment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BILL_PAYMENT_CREATED = "BillPayment API : Created successfully";
        public static final String BILL_PAYMENT_UPDATED = "BillPayment API : Updated successfully : {}";
        public static final String BILL_PAYMENT_DELETED = "BillPayment API : Deleted successfully : {}";
        public static final String BILL_PAYMENT_FOUND = "BillPayment API : Found successfully : {}";
        public static final String BILL_PAYMENT_LISTED = "BillPayment API : Listed successfully";
    }

    public static class Booking{
        private Booking() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BOOKING_CREATED = "Booking API : Created successfully";
        public static final String BOOKING_UPDATED = "Booking API : Updated successfully : {}";
        public static final String BOOKING_DELETED = "Booking API : Deleted successfully : {}";
        public static final String BOOKING_FOUND = "Booking API : Found successfully : {}";
        public static final String BOOKING_LISTED = "Booking API : Listed successfully";
    }

    public static class BookingDate{
        private BookingDate() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String BOOKING_DATE_CREATED = "BookingDate API : Created successfully";
        public static final String BOOKING_DATE_UPDATED = "BookingDate API : Updated successfully : {}";
        public static final String BOOKING_DATE_DELETED = "BookingDate API : Deleted successfully : {}";
        public static final String BOOKING_DATE_FOUND = "BookingDate API : Found successfully : {}";
        public static final String BOOKING_DATE_LISTED = "BookingDate API : Listed successfully";
    }

    public static class Customer{
        private Customer() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CUSTOMER_CREATED = "Customer API : Created successfully";
        public static final String CUSTOMER_UPDATED = "Customer API : Updated successfully : {}";
        public static final String CUSTOMER_DELETED = "Customer API : Deleted successfully : {}";
        public static final String CUSTOMER_FOUND = "Customer API : Found successfully : {}";
        public static final String CUSTOMER_LISTED = "Customer API : Listed successfully";
    }

    public static class Floor{
        private Floor() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String FLOOR_CREATED = "Floor API : Created successfully";
        public static final String FLOOR_UPDATED = "Floor API : Updated successfully : {}";
        public static final String FLOOR_DELETED = "Floor API : Deleted successfully : {}";
        public static final String FLOOR_FOUND = "Floor API : Found successfully : {}";
        public static final String FLOOR_LISTED = "Floor API : Listed successfully";
    }

    public static class PaymentType{
        private PaymentType() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PAYMENT_TYPE_CREATED = "PaymentType API : Created successfully";
        public static final String PAYMENT_TYPE_UPDATED = "PaymentType API : Updated successfully : {}";
        public static final String PAYMENT_TYPE_DELETED = "PaymentType API : Deleted successfully : {}";
        public static final String PAYMENT_TYPE_FOUND = "PaymentType API : Found successfully : {}";
        public static final String PAYMENT_TYPE_LISTED = "PaymentType API : Listed successfully";
    }

    public static class Rating{
        private Rating() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String RATING_CREATED = "Rating API : Created successfully";
        public static final String RATING_UPDATED = "Rating API : Updated successfully : {}";
        public static final String RATING_DELETED = "Rating API : Deleted successfully : {}";
        public static final String RATING_FOUND = "Rating API : Found successfully : {}";
        public static final String RATING_LISTED = "Rating API : Listed successfully";
    }

    public static class Rent{
        private Rent() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String RENT_CREATED = "Rent API : Created successfully";
        public static final String RENT_UPDATED = "Rent API : Updated successfully : {}";
        public static final String RENT_DELETED = "Rent API : Deleted successfully : {}";
        public static final String RENT_FOUND = "Rent API : Found successfully : {}";
        public static final String RENT_LISTED = "Rent API : Listed successfully";
    }

    public static class Room{
        private Room() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_CREATED = "Room API : Created successfully";
        public static final String ROOM_UPDATED = "Room API : Updated successfully : {}";
        public static final String ROOM_DELETED = "Room API : Deleted successfully : {}";
        public static final String ROOM_FOUND = "Room API : Found successfully : {}";
        public static final String ROOM_LISTED = "Room API : Listed successfully";
    }

    public static class RoomKey{
        private RoomKey() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_KEY_CREATED = "RoomKey API : Created successfully";
        public static final String ROOM_KEY_UPDATED = "RoomKey API : Updated successfully : {}";
        public static final String ROOM_KEY_DELETED = "RoomKey API : Deleted successfully : {}";
        public static final String ROOM_KEY_FOUND = "RoomKey API : Found successfully : {}";
        public static final String ROOM_KEY_LISTED = "RoomKey API : Listed successfully";
    }

    public static class RoomRating{
        private RoomRating() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_RATING_CREATED = "RoomRating API : Created successfully";
        public static final String ROOM_RATING_UPDATED = "RoomRating API : Updated successfully : {}";
        public static final String ROOM_RATING_DELETED = "RoomRating API : Deleted successfully : {}";
        public static final String ROOM_RATING_FOUND = "RoomRating API : Found successfully : {}";
        public static final String ROOM_RATING_LISTED = "RoomRating API : Listed successfully";
    }

    public static class RoomType{
        private RoomType() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROOM_TYPE_CREATED = "RoomType API : Created successfully";
        public static final String ROOM_TYPE_UPDATED = "RoomType API : Updated successfully : {}";
        public static final String ROOM_TYPE_DELETED = "RoomType API : Deleted successfully : {}";
        public static final String ROOM_TYPE_FOUND = "RoomType API : Found successfully : {}";
        public static final String ROOM_TYPE_LISTED = "RoomType API : Listed successfully";
    }
}
