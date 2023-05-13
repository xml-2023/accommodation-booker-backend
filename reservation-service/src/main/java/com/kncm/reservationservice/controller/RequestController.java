package com.kncm.reservationservice.controller;

import com.kncm.reservationservice.dto.CreateReservationRequest;
import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.service.accommodation.AccommodationService;
import com.kncm.reservationservice.service.request.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.apache.logging.log4j.util.Strings.isBlank;

@RestController
@RequiredArgsConstructor
public class RequestController {
    private final RequestService service;
    private final AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateReservationRequest dto) {
        if (!isValid(dto)) {
            //throw new CreateReservationRequestIsNotValidException();
            throw new IllegalArgumentException();
        }
        ReservationRequest request = new ReservationRequest();
        Map(dto, request);
        //grpc call za dobijanje validnosti datuma i dobijanje status
        service.createRequest(request);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    private void Map(CreateReservationRequest dto, ReservationRequest request) {
        LocalDateTime from = null;
        LocalDateTime to = null;
        parseDate(from, to, dto.getReserveFrom(), dto.getReserveTo());
        request.setReserveFrom(from);
        request.setReserveTo(to);
        request.setGuestsNumber(dto.getGuestNumber());
        request.setCanceled(false);
        request.setAccommodation(accommodationService.find(dto.getAccommodationId()));
    }

    private void parseDate(LocalDateTime from, LocalDateTime to, String fromString, String toString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            from = LocalDate.parse(fromString, formatter).atStartOfDay();
            to = LocalDate.parse(toString, formatter).atStartOfDay();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
//            throw new InvalidDateFormatException();
        }

    }

    private boolean isValid(CreateReservationRequest dto) {
        return !isBlank(dto.getReserveFrom()) && !isBlank(dto.getReserveTo())
                && dto.getGuestNumber() > 0;
    }

}
