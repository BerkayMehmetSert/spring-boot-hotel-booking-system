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
public class BaseRoomKeyRequest {
    @NotEmpty(message = ValidationMessage.RoomKey.ROOM_KEY_IS_ACTIVE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.RoomKey.ROOM_KEY_IS_ACTIVE_NOT_NULL)
    private Boolean isActive;

    @NotEmpty(message = ValidationMessage.RoomKey.ROOM_KEY_IS_MASTER_NOT_EMPTY)
    @NotNull(message = ValidationMessage.RoomKey.ROOM_KEY_IS_MASTER_NOT_NULL)
    private Boolean isMaster;

    @NotEmpty(message = ValidationMessage.RoomKey.ROOM_KEY_ROOM_ID_NOT_EMPTY)
    @NotNull(message = ValidationMessage.RoomKey.ROOM_KEY_ROOM_ID_NOT_NULL)
    private String roomId;
}
