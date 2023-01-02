package com.bms.hotelbookingsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRoomRatingRequest {
    private String name;
    private String roomId;
    private String customerId;
    private String ratingId;
}
