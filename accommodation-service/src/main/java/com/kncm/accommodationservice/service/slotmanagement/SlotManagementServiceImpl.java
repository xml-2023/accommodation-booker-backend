package com.kncm.accommodationservice.service.slotmanagement;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.AccommodationAvailability;
import com.kncm.accommodationservice.repository.accommodation.AccommodationRepository;
import com.kncm.accommodationservice.repository.availability.AccommodationAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SlotManagementServiceImpl implements SlotManagementService{
    private final AccommodationRepository repository;
    private final AccommodationAvailabilityRepository availabilityRepository;
    private final SequenceGenerator generator;

    @Override
    public void manageAvailableSlots(LocalDateTime from, LocalDateTime to, AccommodationAvailability availability, Accommodation accommodationToUpdate) {
        LocalDateTime availStartDate = availability.getAvailableFrom();
        LocalDateTime availEndDate = availability.getAvailableTo();

//        if (from.isAfter(availEndDate) || to.isBefore(availStartDate)) {
//            // Date range does not overlap with availability, skip to next item
//            return;
//        }

        if (from.isEqual(availStartDate) && to.isEqual(availEndDate)) {
            // Date range covers entire availability, remove availability from list
            accommodationToUpdate.getAvailableSlots().remove(availability);
            repository.save(accommodationToUpdate);
            availabilityRepository.delete(availability);
        } else if (from.isAfter(availStartDate) && to.isBefore(availEndDate)) {
            // Date range is contained within availability, split availability into two
            AccommodationAvailability newAvailability = new AccommodationAvailability();
            newAvailability.setAvailableFrom(to.plusDays(1));
            newAvailability.setAvailableTo(availEndDate);
            newAvailability.setPriceInEuros(availability.getPriceInEuros());
            newAvailability.setId(generator.getSequenceNumber(AccommodationAvailability.SEQUENCE_NAME));
            availabilityRepository.save(newAvailability);
            accommodationToUpdate.getAvailableSlots().add(newAvailability);
            repository.save(accommodationToUpdate);

            accommodationToUpdate.getAvailableSlots().remove(availability);
            availability.setAvailableTo(from.minusDays(1));
            accommodationToUpdate.getAvailableSlots().add(availability);
            repository.save(accommodationToUpdate);
            availabilityRepository.save(availability);
        } else if (from.isEqual(availStartDate) && to.isBefore(availEndDate)) {
            //
            accommodationToUpdate.getAvailableSlots().remove(availability);
            availability.setAvailableFrom(to.plusDays(1));
            accommodationToUpdate.getAvailableSlots().add(availability);
            repository.save(accommodationToUpdate);
            availabilityRepository.save(availability);
        } else if (from.isAfter(availStartDate) && to.isEqual(availEndDate)) {
            //
            accommodationToUpdate.getAvailableSlots().remove(availability);
            availability.setAvailableTo(from.minusDays(1));
            accommodationToUpdate.getAvailableSlots().add(availability);
            repository.save(accommodationToUpdate);
            availabilityRepository.save(availability);
        }
    }
}
