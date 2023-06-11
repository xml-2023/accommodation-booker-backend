package com.kncm.ratingservice.service.grpc;

import com.kncm.ratingservice.model.Accommodation;
import com.kncm.ratingservice.repository.AccommodationRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import proto.ReservationServiceGrpc;
import proto.ReservationServiceProto;


@GrpcService
public class AccommodationServiceGrpc extends ReservationServiceGrpc.ReservationServiceImplBase{
    private final AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationServiceGrpc(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public void createAccommodation(ReservationServiceProto.CreateAccommodationRequest request, StreamObserver<ReservationServiceProto.CreateAccommodationResponse> responseObserver) {
        // Extract the necessary data from the request
        // Add any other fields that are necessary to create an Accommodation in the Reservation Service

        // Create a new Accommodation object
        Accommodation accommodation = new Accommodation();
        accommodation.setId(request.getId());
        accommodation.setName(request.getName());
        // Add any other fields that are necessary to create an Accommodation in the Reservation Service

        // Save the new Accommodation object to the database
        accommodationRepository.save(accommodation);
        ReservationServiceProto.CreateAccommodationResponse response = ReservationServiceProto.CreateAccommodationResponse.newBuilder()
                .setIsCreated(true)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}