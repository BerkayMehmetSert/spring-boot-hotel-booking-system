package com.bms.hotelbookingsystem.dto.request;

import com.bms.hotelbookingsystem.model.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRoomRequest {
    private boolean isSmoking;
    private String customerId;
    private String roomTypeId;
    private RoomStatus roomStatus;
    private String bookingId;
    private String floorId;
}
