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
public class BaseRoomTypeRequest {
    @NotEmpty(message = ValidationMessage.RoomType.ROOM_TYPE_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.RoomType.ROOM_TYPE_NAME_NOT_NULL)
    private String name;
}
