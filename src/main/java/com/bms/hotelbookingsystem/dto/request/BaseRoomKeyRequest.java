package com.bms.hotelbookingsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRoomKeyRequest {
    private String keyCode;
    private Boolean isActive;
    private Boolean isMaster;
    private String roomId;
}
