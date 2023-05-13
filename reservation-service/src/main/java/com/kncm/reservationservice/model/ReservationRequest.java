package com.kncm.reservationservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private RequestStatus status;
    private LocalDateTime reserveFrom;
    private LocalDateTime reserveTo;
    private Integer guestsNumber;
    private boolean isCanceled;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Accommodation accommodation;
}
