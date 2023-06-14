package com.kncm.reservationservice.service.grpc;

import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.service.request.RequestService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.cglib.core.Local;
import proto.RatingReservation;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

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

    @Override
    public void isHostAllowedToRate(RatingReservation.IsHostAllowedToRateRequest request, StreamObserver<RatingReservation.IsHostAllowedToRateResponse> responseObserver){
        boolean isAllowed = service.isHostAllowedToRate(request.getGuestId(), request.getHostId(), RequestStatus.ACCEPTED);

        RatingReservation.IsHostAllowedToRateResponse response = RatingReservation.IsHostAllowedToRateResponse.newBuilder()
                .setIsAllowed(isAllowed)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getDistinguishedHostStatusFromReservations(RatingReservation.DistinguishedHostReservationRequest request, StreamObserver<RatingReservation.DistinguishedHostReservationResponse> responseObserver){
        List<ReservationRequest> canceledHostRequests = service.findByStatusAndAccommodation_HostId(RequestStatus.CANCELLED, request.getHostId());
        List<ReservationRequest> acceptedHostRequests = service.findByStatusAndAccommodation_HostId(RequestStatus.ACCEPTED, request.getHostId());
        List<ReservationRequest> allHostRequests = service.findByAccommodation_HostId(request.getHostId());

        boolean isCancellationPercentageSatisfied = isCancellationLowerThanGivenPercentage(allHostRequests.size(), canceledHostRequests.size());
        boolean isNumOfPastReservationsSatisfied = isNumOfPastReservationsSatisfied(acceptedHostRequests);
        boolean isTotalDurationSatisfied = isTotalDurationBiggerThanGivenAmount(acceptedHostRequests);

        boolean finalResponseStatus = isCancellationPercentageSatisfied && isNumOfPastReservationsSatisfied && isTotalDurationSatisfied;

        RatingReservation.DistinguishedHostReservationResponse response = RatingReservation.DistinguishedHostReservationResponse.newBuilder()
                .setIsDistinguished(finalResponseStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private boolean isCancellationLowerThanGivenPercentage(Integer numOfAllRequests, Integer numOfCancelledRequests){
        return ((double)numOfCancelledRequests / (double)numOfAllRequests * 100) < 5;
    }

    private boolean isNumOfPastReservationsSatisfied(List<ReservationRequest> allAcceptedRequests){
        int counter = 0;
        for (ReservationRequest rr : allAcceptedRequests){
            if (rr.getReserveTo().isBefore(LocalDateTime.now())){
                counter++;
            }
        }
        return counter >= 5;
    }

    private boolean isTotalDurationBiggerThanGivenAmount(List<ReservationRequest> acceptedHostRequests) {
        int totalDurationInDays = 0;
        for (ReservationRequest rr : acceptedHostRequests){
            totalDurationInDays += getDateRangeDurationInDays(rr.getReserveFrom(), rr.getReserveTo());
        }
        return totalDurationInDays > 50;
    }

    private int getDateRangeDurationInDays(LocalDateTime from, LocalDateTime to){
        long days = ChronoUnit.DAYS.between(from, to);
        return Math.toIntExact(days);
    }
}
