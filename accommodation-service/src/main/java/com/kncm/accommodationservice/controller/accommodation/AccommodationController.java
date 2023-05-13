package com.kncm.accommodationservice.controller.accommodation;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.dto.accommodation.CreateAccommodationRequest;
import com.kncm.accommodationservice.dto.accommodation.SearchAccommodationResponse;
import com.kncm.accommodationservice.handler.exceptions.CreateAccommodationException;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.Address;
import com.kncm.accommodationservice.model.PriceType;
import com.kncm.accommodationservice.service.accommodation.AccommodationService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proto.ReservationServiceGrpc;
import proto.ReservationServiceProto;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/accommodation")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final SequenceGenerator generator;
    @Value("${grpc.reservation-service.host}")
    private String reservationServiceHost;
    @Value("${grpc.reservation-service.port}")
    private int reservationServicePort;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateAccommodationRequest dto) {
        Accommodation accommodation = new Accommodation();
        Map(dto, accommodation);
        accommodation.setId(generator.getSequenceNumber(Accommodation.SEQUENCE_NAME));
        accommodation.setAvailableSlots(new ArrayList<>());
        accommodation.setImagesPath("accommodation-service/src/main/resources/images/" + accommodation.getName());
        boolean responseStatus = false;
//        ReservationServiceProto.CreateAccommodationResponse response = null;

        //grpc starts
        ManagedChannel channel = ManagedChannelBuilder.forAddress(reservationServiceHost, reservationServicePort)
                .usePlaintext()
                .build();

        try {
            // Create a blocking stub for the reservation service
            ReservationServiceGrpc.ReservationServiceBlockingStub stub = ReservationServiceGrpc.newBlockingStub(channel);

            // Create the request for the reservation service
            ReservationServiceProto.CreateAccommodationRequest request = ReservationServiceProto.CreateAccommodationRequest.newBuilder()
                    .setId(accommodation.getId())
                    .setName(accommodation.getName())
                    .build();

            // Call the reservation service
            ReservationServiceProto.CreateAccommodationResponse response = stub.createAccommodation(request);
            if(response.getIsCreated()){
                responseStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the channel after use
            channel.shutdown();
        }
        //grpc ends

        if(responseStatus){
            try {
                accommodationService.create(accommodation);
            } catch (CreateAccommodationException e) {
                throw new CreateAccommodationException();
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<Collection<SearchAccommodationResponse>> search(
            @RequestParam String location,
            @RequestParam Integer numOfGuests,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return new ResponseEntity<>(accommodationService.search(location, numOfGuests, startDate, endDate), HttpStatus.OK);
    }

    private void Map(CreateAccommodationRequest dto, Accommodation accommodation) {
        accommodation.setName(dto.getName());
        accommodation.setDescription(dto.getDescription());
        accommodation.setAutomaticConfirmation(dto.isAutomaticConfirmation());
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        accommodation.setAddress(address);
        accommodation.setPriceType(PriceType.valueOf(dto.getPriceType()));
    }
}
