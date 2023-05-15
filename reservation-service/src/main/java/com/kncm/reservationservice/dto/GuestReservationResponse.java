package com.kncm.reservationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuestReservationResponse {
    private Long requestId;
    private String accommodationName;
    private String status;
    private String reserveFrom;
    private String reserveTo;
    private Integer guestsNumber;
}
