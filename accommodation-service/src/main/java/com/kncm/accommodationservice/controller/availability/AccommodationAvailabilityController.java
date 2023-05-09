package com.kncm.accommodationservice.controller.availability;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.dto.availability.CreateAccommodationAvailabilityRequest;
import com.kncm.accommodationservice.dto.availability.UpdateAccommodationAvailabilityRequest;
import com.kncm.accommodationservice.handler.exceptions.AccommodationIsNullException;
import com.kncm.accommodationservice.handler.exceptions.AvailabilityIsNullException;
import com.kncm.accommodationservice.handler.exceptions.CreateAvailabilityException;
import com.kncm.accommodationservice.handler.exceptions.InvalidDateFormatException;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.AccommodationAvailability;
import com.kncm.accommodationservice.service.accommodation.AccommodationService;
import com.kncm.accommodationservice.service.availability.AccommodationAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@RestController
@RequestMapping("/api/accommodation/availability")
@RequiredArgsConstructor
public class AccommodationAvailabilityController {
    private final AccommodationAvailabilityService accommodationAvailabilityService;
    private final SequenceGenerator generator;
    private final AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateAccommodationAvailabilityRequest dto){
        AccommodationAvailability availability = new AccommodationAvailability();
        Map(dto, availability);
        availability.setId(generator.getSequenceNumber(AccommodationAvailability.SEQUENCE_NAME));
        Accommodation accommodation = accommodationService.findById(dto.getAccommodationId());
        if(accommodation == null){
            throw new AccommodationIsNullException();
        }
        try{
            accommodationAvailabilityService.create(availability);
            accommodation.getAvailableSlots().add(availability);
            accommodationService.update(accommodation);
        }
        catch (CreateAvailabilityException e){
            throw new CreateAvailabilityException();
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateAccommodationAvailabilityRequest request){
        AccommodationAvailability toUpdate = accommodationAvailabilityService.findById(request.getId());
        if(toUpdate == null){
            throw new AvailabilityIsNullException();
        }

        MapUpdate(toUpdate, request);
        accommodationAvailabilityService.update(toUpdate);
        Accommodation accommodation = accommodationService.findById(request.getAccommodationId());
        if (accommodation == null){
            throw new AccommodationIsNullException();
        }
        for(AccommodationAvailability availability : accommodation.getAvailableSlots()){
            if(Objects.equals(availability.getId(), toUpdate.getId())){
                availability.setAvailableFrom(toUpdate.getAvailableFrom());
                availability.setAvailableTo(toUpdate.getAvailableTo());
                availability.setPriceInEuros(toUpdate.getPriceInEuros());
                break;
            }
        }
        accommodationService.update(accommodation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void MapUpdate(AccommodationAvailability toUpdate, UpdateAccommodationAvailabilityRequest request){
        toUpdate.setId(request.getId());
        toUpdate.setPriceInEuros(request.getPriceInEuros());

        LocalDateTime from;
        LocalDateTime to;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            from = LocalDate.parse(request.getAvailableFrom(), formatter).atStartOfDay();
            to = LocalDate.parse(request.getAvailableTo(), formatter).atStartOfDay();
        }
        catch (DateTimeParseException e){
            e.printStackTrace();
            throw new InvalidDateFormatException();
        }

        toUpdate.setAvailableFrom(from);
        toUpdate.setAvailableTo(to);
    }
    private void Map(CreateAccommodationAvailabilityRequest dto, AccommodationAvailability availability) {
        LocalDateTime from;
        LocalDateTime to;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
             from = LocalDate.parse(dto.getFrom(), formatter).atStartOfDay();
             to = LocalDate.parse(dto.getTo(), formatter).atStartOfDay();
        }
        catch (DateTimeParseException e){
            e.printStackTrace();
            throw new InvalidDateFormatException();
        }

        availability.setAvailableFrom(from);
        availability.setAvailableTo(to);
        availability.setPriceInEuros(dto.getPriceInEuros());
    }
}
