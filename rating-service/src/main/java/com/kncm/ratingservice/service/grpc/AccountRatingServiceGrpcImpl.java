//package com.kncm.ratingservice.service.grpc;
//
//import com.kncm.ratingservice.model.User;
//import com.kncm.ratingservice.service.hostgrade.HostGradeService;
//import com.kncm.ratingservice.service.user.UserService;
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.stub.StreamObserver;
//import lombok.RequiredArgsConstructor;
//import net.devh.boot.grpc.server.service.GrpcService;
//import proto.AccountRating;
//import proto.ManageUserServiceGrpc;
//import proto.RatingReservation;
//import proto.RatingServiceGrpc;
//
//@GrpcService
//@RequiredArgsConstructor
//public class AccountRatingServiceGrpcImpl extends ManageUserServiceGrpc.ManageUserServiceImplBase {
//
//    private final UserService userService;
//    private final HostGradeService hostGradeService;
//    @Override
//    public void getDistinguishedHostStatusFromRatings(AccountRating.DistinguishedHostRatingRequest request, StreamObserver<AccountRating.DistinguishedHostRatingResponse> responseObserver){
//        boolean isDistinguished;
//        boolean reservationResponseStatus = false;
//        User host = userService.findOne(request.getHostId());
//        if (host != null) {
//            isDistinguished = hostGradeService.isHostGradeBigEnoughForDistinguishedStatus(host);
//            if (isDistinguished) {
//                //-------------------------------------------Grpc begin to reservation service----------------------------------------------
//                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9085)
//                        .usePlaintext()
//                        .build();
//
//                RatingServiceGrpc.RatingServiceBlockingStub stub = RatingServiceGrpc.newBlockingStub(channel);
//                try {
//                    RatingReservation.DistinguishedHostReservationRequest reservationRequest = RatingReservation.DistinguishedHostReservationRequest.newBuilder()
//                            .setHostId(host.getId())
//                            .build();
//
//                    RatingReservation.DistinguishedHostReservationResponse response = stub.getDistinguishedHostStatusFromReservations(reservationRequest);
//                    if (response.getIsDistinguished()) {
//                        reservationResponseStatus = true;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.out.println("Grpc exception happened");
//                } finally {
//                    channel.shutdown();
//                }
//                //-------------------------------------------Grpc end ----------------------------------------------
//            }
//        }
//        AccountRating.DistinguishedHostRatingResponse response = AccountRating.DistinguishedHostRatingResponse.newBuilder()
//                .setIsDistinguished(reservationResponseStatus)
//                .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
//}
