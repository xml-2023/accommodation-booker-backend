package com.kncm.ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccommodationGradeRequest {
    private Integer value;
    private String ratingDate;
    private Long userId;
    private Long accommodationId;
}
