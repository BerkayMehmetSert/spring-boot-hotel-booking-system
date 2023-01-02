package com.bms.hotelbookingsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRatingRequest {
    private Integer value;
    private String description;
}
