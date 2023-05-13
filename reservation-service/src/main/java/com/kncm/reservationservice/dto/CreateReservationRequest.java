package com.kncm.reservationservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateReservationRequest {
    private Long accommodationId;
    private Long userId;
    private String reserveFrom;
    private String reserveTo;
    private Integer guestNumber;
}
