package com.kncm.reservationservice.service.grpc;

import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.service.request.RequestService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import proto.RatingReservation;

@GrpcService
@RequiredArgsConstructor
public class RatingServiceGrpcImpl extends proto.RatingServiceGrpc.RatingServiceImplBase {
    private final RequestService service;
    @Override
    public void isAccommodationAllowedToRate(RatingReservation.IsAccommodationAllowedToRateRequest request, StreamObserver<RatingReservation.IsAccommodationAllowedToRateResponse> responseObserver){

        boolean isAllowed = service.isAllowedToRate(request.getUserId(), request.getAccommodationId(), RequestStatus.ACCEPTED);

        RatingReservation.IsAccommodationAllowedToRateResponse response = RatingReservation.IsAccommodationAllowedToRateResponse.newBuilder()
                .setIsAllowed(isAllowed)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
