package com.kncm.reservationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationResponse {
    private Long id;
    private String status;
    private String reserveFrom;
    private String reserveTo;
    private Integer guestsNumber;
    private Integer cancellations;
}
