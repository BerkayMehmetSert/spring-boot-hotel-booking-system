package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.helper.message.ValidationMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRoomRatingRequest {
    @NotEmpty(message = ValidationMessage.RoomRating.ROOM_RATING_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.RoomRating.ROOM_RATING_NAME_NOT_NULL)
    private String name;

    @NotEmpty(message = ValidationMessage.RoomRating.ROOM_RATING_ROOM_ID_NOT_NULL)
    @NotNull(message = ValidationMessage.RoomRating.ROOM_RATING_ROOM_ID_NOT_NULL)
    private String roomId;

    @NotEmpty(message = ValidationMessage.RoomRating.ROOM_RATING_CUSTOMER_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.RoomRating.ROOM_RATING_CUSTOMER_ID_NOT_NULL)
    private String customerId;

    @NotEmpty(message = ValidationMessage.RoomRating.ROOM_RATING_RATING_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.RoomRating.ROOM_RATING_RATING_ID_NOT_NULL)
    private String ratingId;
}
