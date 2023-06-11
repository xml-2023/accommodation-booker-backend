package com.kncm.ratingservice.controller;

import com.kncm.ratingservice.dto.CreateAccommodationGradeRequest;
import com.kncm.ratingservice.dto.UpdateAccommodationGradeRequest;
import com.kncm.ratingservice.model.Accommodation;
import com.kncm.ratingservice.model.AccommodationGrade;
import com.kncm.ratingservice.model.User;
import com.kncm.ratingservice.service.accommodation.AccommodationService;
import com.kncm.ratingservice.service.accommodationgrade.AccommodationGradeService;
import com.kncm.ratingservice.service.user.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proto.RatingReservation;
import proto.RatingServiceGrpc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
public class AccommodationGradeController {
    private final AccommodationGradeService accommodationGradeService;
    private final AccommodationService accommodationService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateAccommodationGradeRequest dto){

        AccommodationGrade grade = new AccommodationGrade();
        Map(dto, grade);
        User user = userService.findOne(dto.getUserId());
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        grade.setGradeGiver(user);
        Accommodation accommodation = accommodationService.findOne(dto.getAccommodationId());
        if (accommodation == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        grade.setAccommodation(accommodation);

        boolean responseStatus = false;

        //-------------------------------------grpc poziv na rezervation service----------------------------------------
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9080)
                .usePlaintext()
                .build();

        try {
            RatingServiceGrpc.RatingServiceBlockingStub stub = RatingServiceGrpc.newBlockingStub(channel);

            RatingReservation.IsAccommodationAllowedToRateRequest request = RatingReservation.IsAccommodationAllowedToRateRequest.newBuilder()
                    .setUserId(dto.getUserId())
                    .setAccommodationId(dto.getAccommodationId())
                    .build();

            RatingReservation.IsAccommodationAllowedToRateResponse response = stub.isAccommodationAllowedToRate(request);
            if(response.getIsAllowed()){
                responseStatus = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
        //-------------------------------------grpc poziv na rezervation service end ----------------------------------------
        if (responseStatus){
            accommodationGradeService.save(grade);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateAccommodationGradeRequest request){
        AccommodationGrade grade = accommodationGradeService.findOne(request.getGradeId());
        if (grade == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MapUpdate(request, grade);
        accommodationGradeService.save(grade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        AccommodationGrade toDelete = accommodationGradeService.findOne(id);
        if (toDelete == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accommodationGradeService.delete(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/averageGrade/{accommodationId}")
    public ResponseEntity<Double> getAccommodationAverageGrade(@PathVariable Long accommodationId){
        Double averageGrade = accommodationGradeService.getAccommodationAverageGrade(accommodationId);
        return new ResponseEntity<>(averageGrade, HttpStatus.OK);
    }

    private void MapUpdate(UpdateAccommodationGradeRequest request, AccommodationGrade grade){
        grade.setValue(request.getValue());

        LocalDateTime date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            date = LocalDate.parse(request.getRatingDate(), formatter).atStartOfDay();
            grade.setRatingDate(date);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }
    private void Map(CreateAccommodationGradeRequest dto, AccommodationGrade grade) {
        LocalDateTime date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            date = LocalDate.parse(dto.getRatingDate(), formatter).atStartOfDay();
            grade.setRatingDate(date);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        grade.setValue(dto.getValue());
    }
}
