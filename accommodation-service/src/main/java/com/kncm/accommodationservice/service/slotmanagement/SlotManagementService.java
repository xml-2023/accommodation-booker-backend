package com.kncm.accommodationservice.service.slotmanagement;

import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.AccommodationAvailability;

import java.time.LocalDateTime;

public interface SlotManagementService {
    void manageAvailableSlots(LocalDateTime from, LocalDateTime to, AccommodationAvailability availability, Accommodation accommodationToUpdate);
    void manageCancelledSlots(LocalDateTime from, LocalDateTime to, AccommodationAvailability availability, Accommodation accommodationToUpdate);
}
