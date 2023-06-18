package com.kncm.ratingservice.controller;

import com.kncm.ratingservice.dto.CreateHostGradeRequest;
import com.kncm.ratingservice.dto.UpdateAccommodationGradeRequest;
import com.kncm.ratingservice.model.AccommodationGrade;
import com.kncm.ratingservice.model.HostGrade;
import com.kncm.ratingservice.model.User;
import com.kncm.ratingservice.service.hostgrade.HostGradeService;
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
import java.util.Collection;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
public class HostGradeController {
    private final HostGradeService hostGradeService;
    private final UserService userService;
    @PostMapping("hostGrade")
    public ResponseEntity<Void> create(@RequestBody CreateHostGradeRequest dto){

        HostGrade grade = new HostGrade();
        Map(dto, grade);
        User gradeGiver = userService.findOne(dto.getGuestId());
        if (gradeGiver == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        grade.setGradeGiver(gradeGiver);
        User gradeReceiver = userService.findOne(dto.getHostId());
        if (gradeReceiver == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        grade.setGradeReceiver(gradeReceiver);

        boolean responseStatus = false;

        //-------------------------------------grpc poziv na rezervation service----------------------------------------
        ManagedChannel channel = ManagedChannelBuilder.forAddress("reservation-service", 9080)
                .usePlaintext()
                .build();

        try {
            RatingServiceGrpc.RatingServiceBlockingStub stub = RatingServiceGrpc.newBlockingStub(channel);

            RatingReservation.IsHostAllowedToRateRequest request = RatingReservation.IsHostAllowedToRateRequest.newBuilder()
                    .setGuestId(dto.getGuestId())
                    .setHostId(dto.getHostId())
                    .build();

            RatingReservation.IsHostAllowedToRateResponse response = stub.isHostAllowedToRate(request);
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
            hostGradeService.save(grade);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("hostGrade")
    public ResponseEntity<Void> update(@RequestBody UpdateAccommodationGradeRequest request){
        HostGrade grade = hostGradeService.findOne(request.getGradeId());
        if (grade == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        MapUpdate(request, grade);
        hostGradeService.save(grade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/hostGrade/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        HostGrade toDelete = hostGradeService.findOne(id);
        if (toDelete == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hostGradeService.delete(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hostGrade/averageGrade/{hostId}")
    public ResponseEntity<Double> getHostAverageGrade(@PathVariable Long hostId){
        Double averageGrade = hostGradeService.getHostAverageGrade(hostId);
        return new ResponseEntity<>(averageGrade, HttpStatus.OK);
    }

    @GetMapping("/hostGrade/findByUserId")
    public ResponseEntity<Collection<HostGrade>> findByGuestId(@RequestParam Long id){
        return new ResponseEntity<>(hostGradeService.findAllByGuestId(id), HttpStatus.OK);
    }

    @GetMapping("/hostGrade/findByHostId")
    public ResponseEntity<Collection<HostGrade>> findByHostId(@RequestParam Long id) {
        return new ResponseEntity<>(hostGradeService.findAllByHostId(id), HttpStatus.OK);
    }
    @GetMapping("/hostGrade/findById")
    public ResponseEntity<Collection<HostGrade>> findById(@RequestParam Long id) {
        return new ResponseEntity<>(hostGradeService.findAllById(id), HttpStatus.OK);
    }

    private void MapUpdate(UpdateAccommodationGradeRequest request, HostGrade grade){
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

    private void Map(CreateHostGradeRequest dto, HostGrade grade) {
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
