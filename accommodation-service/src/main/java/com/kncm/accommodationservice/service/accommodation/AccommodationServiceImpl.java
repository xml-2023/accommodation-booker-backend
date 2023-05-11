package com.kncm.accommodationservice.service.accommodation;

import com.kncm.accommodationservice.dto.accommodation.SearchAccommodationResponse;
import com.kncm.accommodationservice.handler.exceptions.InvalidDateFormatException;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.AccommodationAvailability;
import com.kncm.accommodationservice.model.PriceType;
import com.kncm.accommodationservice.repository.accommodation.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void create(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }

    @Override
    public void update(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation findById(Long id) {
        return accommodationRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<SearchAccommodationResponse> search(String location, Integer numOfGuests, String startDate, String endDate) {
        var query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime start;
        LocalDateTime end;
        try {
            start = LocalDate.parse(startDate, formatter).atStartOfDay();
            end = LocalDate.parse(endDate, formatter).atStartOfDay();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            throw new InvalidDateFormatException();
        }
        List<Accommodation> accommodations = new ArrayList<>();

        if (location != null && !location.isBlank())
            criteria.add(new Criteria().orOperator(
                    Criteria.where("address.country").is(location),
                    Criteria.where("address.city").is(location)
            ));
        if (numOfGuests != null && numOfGuests > 0)
            criteria.add(Criteria.where("minGuests").lte(numOfGuests).andOperator(Criteria.where("maxGuests").gte(numOfGuests)));

        criteria.add(Criteria.where("availableSlots").elemMatch(
                Criteria.where("availableFrom").lte(start)
                        .andOperator(Criteria.where("availableTo").gte(end))));

        if (criteria.size() == 3) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
            accommodations = mongoTemplate.find(query, Accommodation.class, "accommodations");
        }

        //potrebno konvertovati listu accommodation objekata u searchaccommodationDto objekte jer se oni prikazuju
        // i prikazati odgovarajucu cenu
        ArrayList<SearchAccommodationResponse> responses = new ArrayList<>();
        for (Accommodation accommodation : accommodations) {
            SearchAccommodationResponse response = new SearchAccommodationResponse();
            Map(accommodation, response);
            response.setStartDate(startDate);
            response.setEndDate(endDate);

            for (AccommodationAvailability availability : accommodation.getAvailableSlots()) {
                if ((start.isEqual(availability.getAvailableFrom()) || start.isAfter(availability.getAvailableFrom())
                        && (end.isEqual(availability.getAvailableTo()) || end.isBefore(availability.getAvailableTo())))) {
                    if (accommodation.getPriceType() == PriceType.PER_PERSON) {
                        response.setTotalPrice(availability.getPriceInEuros() * Duration.between(start, end).toDays() * numOfGuests);
                    } else {
                        response.setTotalPrice(availability.getPriceInEuros() * Duration.between(start, end).toDays());
                    }
                    response.setUnitPrice(availability.getPriceInEuros());
                }
            }
            responses.add(response);
        }
        return responses;
    }

    private void Map(Accommodation accommodation, SearchAccommodationResponse response) {
        response.setName(accommodation.getName());
        response.setDescription(accommodation.getDescription());
        response.setCity(accommodation.getAddress().getCity());
        response.setCountry(accommodation.getAddress().getCountry());
        response.setStreet(accommodation.getAddress().getStreet());
        response.setNumber(accommodation.getAddress().getNumber());
        response.setMinGuests(accommodation.getMinGuests());
        response.setMaxGuests(accommodation.getMaxGuests());
    }
}
