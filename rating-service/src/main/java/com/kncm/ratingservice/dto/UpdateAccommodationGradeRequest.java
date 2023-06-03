package com.kncm.ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccommodationGradeRequest {
    private Long gradeId;
    private Integer value;
    private String ratingDate;
}
