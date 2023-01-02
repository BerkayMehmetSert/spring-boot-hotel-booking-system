package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.helper.message.ValidationMessage;
import com.bms.hotelbookingsystem.model.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRoomRequest {
    @NotEmpty(message = ValidationMessage.Room.ROOM_NUMBER_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Room.ROOM_NUMBER_NOT_NULL)
    private String roomNumber;

    @NotEmpty(message = ValidationMessage.Room.ROOM_IS_SMOKING_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Room.ROOM_IS_SMOKING_NOT_NULL)
    private boolean isSmoking;

    @NotEmpty(message = ValidationMessage.Room.ROOM_CUSTOMER_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Room.ROOM_CUSTOMER_ID_NOT_NULL)
    private String customerId;

    @NotEmpty(message = ValidationMessage.Room.ROOM_ROOM_TYPE_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Room.ROOM_ROOM_TYPE_ID_NOT_NULL)
    private String roomTypeId;

    @NotEmpty(message = ValidationMessage.Room.ROOM_ROOM_STATUS_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Room.ROOM_ROOM_STATUS_NOT_NULL)
    private RoomStatus roomStatus;

    @NotEmpty(message = ValidationMessage.Room.ROOM_BOOKING_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Room.ROOM_BOOKING_ID_NOT_NULL)
    private String bookingId;

    @NotEmpty(message = ValidationMessage.Room.ROOM_FLOOR_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Room.ROOM_FLOOR_ID_NOT_NULL)
    private String floorId;
}
