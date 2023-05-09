package com.kncm.accommodationservice.controller.accommodation;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.dto.accommodation.CreateAccommodationRequest;
import com.kncm.accommodationservice.dto.accommodation.SearchAccommodationResponse;
import com.kncm.accommodationservice.handler.exceptions.CreateAccommodationException;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.Address;
import com.kncm.accommodationservice.model.PriceType;
import com.kncm.accommodationservice.service.accommodation.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/accommodation")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final SequenceGenerator generator;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateAccommodationRequest dto){
        Accommodation accommodation = new Accommodation();
        Map(dto, accommodation);
        accommodation.setId(generator.getSequenceNumber(Accommodation.SEQUENCE_NAME));
        accommodation.setAvailableSlots(new ArrayList<>());
        accommodation.setImagesPath("accommodation-service/src/main/resources/images/" + accommodation.getName());
        try{
            accommodationService.create(accommodation);
        }
        catch (CreateAccommodationException e){
            throw new CreateAccommodationException();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<SearchAccommodationResponse>> search(
            @RequestParam String location,
            @RequestParam Integer numOfGuests,
            @RequestParam String startDate,
            @RequestParam String endDate){
        return new ResponseEntity<>(accommodationService.search(location, numOfGuests, startDate, endDate), HttpStatus.OK);
    }

    private void Map(CreateAccommodationRequest dto, Accommodation accommodation){
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
