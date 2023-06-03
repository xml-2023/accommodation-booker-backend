package com.kncm.accommodationservice.controller.accommodation;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.dto.accommodation.AccommodationByHostResponse;
import com.kncm.accommodationservice.dto.accommodation.CreateAccommodationRequest;
import com.kncm.accommodationservice.dto.accommodation.SearchAccommodationResponse;
import com.kncm.accommodationservice.handler.exceptions.CreateAccommodationException;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.Address;
import com.kncm.accommodationservice.model.PriceType;
import com.kncm.accommodationservice.service.accommodation.AccommodationService;
import com.kncm.accommodationservice.service.user.UserService;
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
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accommodation")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final SequenceGenerator generator;
    private final UserService userService;
    @Value("${grpc.reservation-service.host}")
    private String reservationServiceHost;
    @Value("${grpc.reservation-service.port}")
    private int reservationServicePort;

    @GetMapping("/{userId}")
    public ResponseEntity<Collection<AccommodationByHostResponse>> getAllAccommodationsByHost(@PathVariable("userId") Long userId) {
        List<Accommodation> accommodations = accommodationService.findByUserId(userId);

        List<AccommodationByHostResponse> responses = accommodations.stream()
                .map(request -> new AccommodationByHostResponse(request.getId(), request.getName(), request.getDescription(), request.getAddress().getCountry(), request.getAddress().getCity(), request.getAddress().getStreet(), request.getAddress().getNumber()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateAccommodationRequest dto) {
        Accommodation accommodation = new Accommodation();
        Map(dto, accommodation);
        accommodation.setId(generator.getSequenceNumber(Accommodation.SEQUENCE_NAME));
        accommodation.setAvailableSlots(new ArrayList<>());
        accommodation.setImagesPath("accommodation-service/src/main/resources/images/" + accommodation.getName());
        boolean responseStatus = false;
        boolean responseStatusRating = false;
//        ReservationServiceProto.CreateAccommodationResponse response = null;

        //------------------------------------------Create accommodation in reservation service------------------------------
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
        //------------------------------------------Create accommodation in reservation service end------------------------------

        //------------------------------------------Create accommodation in rating service------------------------------
        ManagedChannel ratingChannel = ManagedChannelBuilder.forAddress("localhost", 9098)
                .usePlaintext()
                .build();

        try {
            // Create a blocking stub for the reservation service
            ReservationServiceGrpc.ReservationServiceBlockingStub stub = ReservationServiceGrpc.newBlockingStub(ratingChannel);

            // Create the request for the reservation service
            ReservationServiceProto.CreateAccommodationRequest request = ReservationServiceProto.CreateAccommodationRequest.newBuilder()
                    .setId(accommodation.getId())
                    .setName(accommodation.getName())
                    .build();

            // Call the reservation service
            ReservationServiceProto.CreateAccommodationResponse response = stub.createAccommodation(request);
            if(response.getIsCreated()){
                responseStatusRating = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the channel after use
            ratingChannel.shutdown();
        }
        //------------------------------------------Create accommodation in rating service end------------------------------
        if(responseStatus && responseStatusRating){
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

    @GetMapping("/findById")
    public ResponseEntity<Accommodation> findById(@RequestParam Long id){
        return new ResponseEntity<>(accommodationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Collection<SearchAccommodationResponse>> findAll() {
        return new ResponseEntity<>(accommodationService.findAll(), HttpStatus.OK);
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
        accommodation.setUser(userService.findOne(dto.getUserId()));
    }
}
