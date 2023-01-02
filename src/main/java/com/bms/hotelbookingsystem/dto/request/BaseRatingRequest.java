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
public class BaseRatingRequest {
    @NotEmpty(message = ValidationMessage.Rating.RATING_VALUE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Rating.RATING_VALUE_NOT_NULL)
    private Integer value;

    @NotEmpty(message = ValidationMessage.Rating.RATING_DESCRIPTION_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Rating.RATING_DESCRIPTION_NOT_NULL)
    private String description;
}
