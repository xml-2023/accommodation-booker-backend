package com.kncm.accommodationservice.service.grpc;

import com.kncm.accommodationservice.model.Accommodation;
import com.kncm.accommodationservice.repository.accommodation.AccommodationRepository;
import io.grpc.stub.StreamObserver;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import proto.AccountAccommodation;
import proto.AccountAccommodationServiceGrpc;
import proto.ReservationAccommodation;

import java.util.ArrayList;
import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class AccountAccommodationServiceGrpcImpl extends AccountAccommodationServiceGrpc.AccountAccommodationServiceImplBase {
    private final AccommodationRepository repository;

    @Override
    public void getAccommodations(AccountAccommodation.CreateAccountAccommodationRequest request, StreamObserver<AccountAccommodation.CreateAccountAccommodationResponse> responseObserver) {
        List<Accommodation> accommodations = repository.findByUserId(request.getUserId());
        List<Long> ids = new ArrayList<>();
        for (Accommodation a : accommodations) {
            ids.add(a.getId());
        }

        AccountAccommodation.CreateAccountAccommodationResponse.Builder responseBuilder = AccountAccommodation.CreateAccountAccommodationResponse.newBuilder();
        for (int i = 0; i < ids.size(); i++) {
            responseBuilder.addAccommodationIds(ids.get(i));
        }

        AccountAccommodation.CreateAccountAccommodationResponse response = responseBuilder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
