package com.kncm.accommodationservice.service.grpc;

import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.model.AccommodationAvailability;
import com.kncm.accommodationservice.repository.accommodation.AccommodationRepository;
import com.kncm.accommodationservice.service.slotmanagement.SlotManagementService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import proto.ReservationAccommodation;
import proto.ReservationRequestServiceGrpc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@GrpcService
@RequiredArgsConstructor
public class ReservationRequestServiceImpl extends ReservationRequestServiceGrpc.ReservationRequestServiceImplBase{
    private final AccommodationRepository repository;
    private final SlotManagementService managementService;

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
                if(accommodation.isAutomaticConfirmation()) {
                    managementService.manageAvailableSlots(from, to, slot, accommodation);
                }
                areValidDates = true;
                break;
            }
        }

        if(accommodation.getMinGuests() <= request.getGuestsNumber() &&  request.getGuestsNumber() <= accommodation.getMaxGuests()){
            isGuestNumberValid = true;
        }

        ReservationAccommodation.CreateReservationResponse response = ReservationAccommodation.CreateReservationResponse.newBuilder()
                .setAreDatesValid(areValidDates)
                .setStatus(status)
                .setIsGuestNumberValid(isGuestNumberValid)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
