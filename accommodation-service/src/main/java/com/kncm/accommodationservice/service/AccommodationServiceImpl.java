package com.kncm.accommodationservice.service;

import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService{
    private final AccommodationRepository accommodationRepository;
    private final MongoTemplate mongoTemplate;
    @Override
    public void create(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }

    @Override
    public Collection<Accommodation> search(String location, Integer numOfGuests, String startDate, String endDate) {
        var query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
//        LocalDateTime start = LocalDateTime.parse(startDate);
//        LocalDateTime end = LocalDateTime.parse(endDate);
        List<Accommodation> accommodations = new ArrayList<>();

        if (location != null && !location.isBlank())
            criteria.add(new Criteria().orOperator(
                    Criteria.where("address.country").is(location),
                    Criteria.where("address.city").is(location)
            ));
        if (numOfGuests != null && numOfGuests > 0)
            criteria.add(Criteria.where("minGuests").lte(numOfGuests).andOperator(Criteria.where("maxGuests").gte(numOfGuests)));

        if(criteria.size() == 2){
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
            accommodations = mongoTemplate.find(query, Accommodation.class, "accommodations");
        }

        //potrebno konvertovati listu accommodation objekata u searchaccommodationDto objekte jer se oni prikazuju
        return accommodations;
    }
}
