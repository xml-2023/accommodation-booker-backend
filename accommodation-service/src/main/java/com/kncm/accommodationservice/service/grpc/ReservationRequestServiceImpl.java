package com.kncm.accommodationservice.service.grpc;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.AccommodationAvailability;
import com.kncm.accommodationservice.repository.accommodation.AccommodationRepository;
import com.kncm.accommodationservice.repository.availability.AccommodationAvailabilityRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import proto.ReservationAccommodation;
import proto.ReservationRequestServiceGrpc;
import proto.ReservationServiceProto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@GrpcService
@RequiredArgsConstructor
public class ReservationRequestServiceImpl extends ReservationRequestServiceGrpc.ReservationRequestServiceImplBase{
    private final AccommodationRepository repository;
    private final AccommodationAvailabilityRepository availabilityRepository;
    private final SequenceGenerator generator;

    @Override
    public void createReservation(ReservationAccommodation.CreateReservationRequest request, StreamObserver<ReservationAccommodation.CreateReservationResponse> responseObserver) {
        // Extract the necessary data from the request
        // Add any other fields that are necessary to create an Accommodation in the Reservation Service

        String status = "";
        boolean areValidDates = false;
        boolean isGuestNumberValid = false;
        LocalDateTime from = null;
        LocalDateTime to = null ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            from = LocalDate.parse(request.getReserveFrom(), formatter).atStartOfDay();
            to = LocalDate.parse(request.getReserveTo(), formatter).atStartOfDay();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
//            throw new InvalidDateFormatException();
        }
        // Create a new Accommodation object
        Accommodation accommodation = repository.findOne(request.getAccommodationId());
        if(accommodation == null){
            status = "Accommodation does not exist";
        }

        if(accommodation.isAutomaticConfirmation()){
            status = "ACCEPTED";
        }
        else {
            status = "PENDING";
        }

        for(AccommodationAvailability slot : accommodation.getAvailableSlots()) {
            if(!from.isBefore(slot.getAvailableFrom()) && !from.isAfter(slot.getAvailableTo())
                && !to.isBefore(slot.getAvailableFrom()) && !to.isAfter(slot.getAvailableTo())) {
                    manageAvailableSlots(from, to, slot, accommodation);
                areValidDates = true;
                break;
            }
        }

        if(accommodation.getMinGuests() <= request.getGuestsNumber() &&  request.getGuestsNumber() <= accommodation.getMaxGuests()){
            isGuestNumberValid = true;
        }

//        Accommodation accommodation = new Accommodation();
//        accommodation.setId(request.getId());
//        accommodation.setName(request.getName());
        // Add any other fields that are necessary to create an Accommodation in the Reservation Service

        // Save the new Accommodation object to the database
//        accommodationRepository.save(accommodation);
//        ReservationServiceProto.CreateAccommodationResponse response = ReservationServiceProto.CreateAccommodationResponse.newBuilder()
//                .setIsCreated(true)
//                .build();
        ReservationAccommodation.CreateReservationResponse response = ReservationAccommodation.CreateReservationResponse.newBuilder()
                .setAreDatesValid(areValidDates)
                .setStatus(status)
                .setIsGuestNumberValid(isGuestNumberValid)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    private void manageAvailableSlots(LocalDateTime from, LocalDateTime to, AccommodationAvailability availability, Accommodation accommodationToUpdate) {
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
