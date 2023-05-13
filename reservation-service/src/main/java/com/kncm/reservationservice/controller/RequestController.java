package com.kncm.reservationservice.controller;

import com.kncm.reservationservice.dto.CreateReservationRequest;
import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.service.accommodation.AccommodationService;
import com.kncm.reservationservice.service.request.RequestService;
import com.kncm.reservationservice.service.user.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proto.ReservationAccommodation;
import proto.ReservationRequestServiceGrpc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.util.Strings.isBlank;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService service;
    private final AccommodationService accommodationService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateReservationRequest dto) {
        if (!isValid(dto)) {
            //throw new CreateReservationRequestIsNotValidException();
            throw new IllegalArgumentException();
        }
        ReservationRequest request = new ReservationRequest();
        Map(dto, request);
        boolean responseStatus = false;
        String reservationStatus = "";

        // Create a gRPC channel to the accommodation-service
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9092)
                .usePlaintext()
                .build();

        // Create a gRPC client stub for the accommodation-service
        ReservationRequestServiceGrpc.ReservationRequestServiceBlockingStub reservationServiceStub = ReservationRequestServiceGrpc.newBlockingStub(channel);
        try {
            // Create a gRPC request to create a user in the accommodation-service
            ReservationAccommodation.CreateReservationRequest reservationRequest = ReservationAccommodation.CreateReservationRequest.newBuilder()
                    .setAccommodationId(dto.getAccommodationId())
                    .setReserveFrom(dto.getReserveFrom())
                    .setReserveTo(dto.getReserveTo())
                    .setGuestsNumber(dto.getGuestNumber())
                    .build();

            // Make the gRPC request to create the user in the accommodation-service
            ReservationAccommodation.CreateReservationResponse response = reservationServiceStub.createReservation(reservationRequest);
            if(response.getStatus().equals("Accommodation does not exist"))
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            reservationStatus = response.getStatus();
            if(response.getAreDatesValid() && response.getIsGuestNumberValid()){
                responseStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Grpc exception happened");
        } finally {
            // Shutdown the gRPC channel
            channel.shutdown();
            try {
                channel.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // Handle channel shutdown interruption
                System.out.println("Shutdown interruption happened");
            }
        }
        if (responseStatus) {
            request.setStatus(RequestStatus.valueOf(reservationStatus));
            service.createRequest(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void Map(CreateReservationRequest dto, ReservationRequest request) {
        LocalDateTime from;
        LocalDateTime to;
//        parseDate(from, to, dto.getReserveFrom(), dto.getReserveTo());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            from = LocalDate.parse(dto.getReserveFrom(), formatter).atStartOfDay();
            to = LocalDate.parse(dto.getReserveTo(), formatter).atStartOfDay();
            request.setReserveFrom(from);
            request.setReserveTo(to);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
//            throw new InvalidDateFormatException();
        }
        request.setGuestsNumber(dto.getGuestNumber());
        request.setCanceled(false);
        request.setAccommodation(accommodationService.find(dto.getAccommodationId()));
        request.setUser(userService.findOne(dto.getUserId()));
    }

    private boolean isValid(CreateReservationRequest dto) {
        return !isBlank(dto.getReserveFrom()) && !isBlank(dto.getReserveTo())
                && dto.getGuestNumber() > 0;
    }

}
