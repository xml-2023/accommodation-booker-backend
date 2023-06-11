package com.kncm.ratingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHostGradeRequest {
    private Integer value;
    private String ratingDate;
    private Long guestId;
    private Long hostId;
}
