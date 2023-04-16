package com.kncm.accommodationservice.controller;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.dto.AccommodationTestDTO;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accommodation")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final SequenceGenerator generator;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AccommodationTestDTO dto){
        Accommodation accommodation = new Accommodation();
        Map(dto, accommodation);
        accommodation.setId(generator.getSequenceNumber(Accommodation.SEQUENCE_NAME));
        accommodationService.create(accommodation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private void Map(AccommodationTestDTO dto, Accommodation accommodation){
        accommodation.setName(dto.getName());
        accommodation.setDescription(dto.getDescription());
        accommodation.setAutomaticConfirmation(dto.isAutomaticConfirmation());
        accommodation.setMinGuests(dto.getMinGuests());
        accommodation.setMaxGuests(dto.getMaxGuests());
    }
}
