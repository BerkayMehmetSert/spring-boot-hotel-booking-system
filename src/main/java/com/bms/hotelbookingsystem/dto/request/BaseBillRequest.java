package com.bms.hotelbookingsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseBillRequest {
    private Double price;
    private String rentId;
}
