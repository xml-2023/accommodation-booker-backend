package com.kncm.ratingservice.service.grpc;

import com.kncm.ratingservice.model.Role;
import com.kncm.ratingservice.model.User;
import com.kncm.ratingservice.repository.RoleRepository;
import com.kncm.ratingservice.repository.UserRepository;
import com.kncm.ratingservice.service.hostgrade.HostGradeService;
import com.kncm.ratingservice.service.user.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.crypto.password.PasswordEncoder;
import proto.ManageUserServiceGrpc;
import proto.AccountRating;
import proto.RatingReservation;
import proto.RatingServiceGrpc;

@GrpcService
@RequiredArgsConstructor
public class CrudUserServiceGrpc extends ManageUserServiceGrpc.ManageUserServiceImplBase{
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserService userService;
    private final HostGradeService hostGradeService;

    @Override
    public void createUser(AccountRating.CreateUserRequest request, StreamObserver<AccountRating.CreateUserResponse> responseObserver) {
        // Perform the necessary logic to create the user in the accommodation-service
        // You can access the fields from the request using request.getUsername(), request.getPassword(), etc.
        User user = new User();
        user.setId(request.getUserId());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        Role role = roleRepository.findByName(request.getRole());
        user.setRole(role);

        repository.save(user);
        AccountRating.CreateUserResponse response = AccountRating.CreateUserResponse.newBuilder()
                .setIsCreated(true)
                .setUserId(request.getUserId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(AccountRating.UpdateUserRequest request, StreamObserver<AccountRating.UpdateUserResponse> responseObserver) {
        boolean isUpdated = false;
        User user = repository.findOne(request.getUserId());

        if (request.getUsername().equals(user.getUsername())) {
            if (request.getPassword().equals(user.getPassword())) {
                map(user, request);
                repository.save(user);
            } else {
                map(user, request);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                repository.save(user);
            }
        } else {
            map(user, request);
            if (!repository.existsByUsername(user.getUsername())) {
                repository.save(user);
                isUpdated = true;
            }
        }

        AccountRating.UpdateUserResponse response = AccountRating.UpdateUserResponse.newBuilder()
                .setIsUpdated(isUpdated)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(AccountRating.DeleteUserRequest request, StreamObserver<AccountRating.DeleteUserResponse> responseObserver) {
        boolean isDeleted = true;
        try{
            repository.deleteById(request.getUserId());
        } catch (Exception e) {
            isDeleted = false;
        }

        AccountRating.DeleteUserResponse response = AccountRating.DeleteUserResponse.newBuilder()
                .setIsDeleted(isDeleted)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getDistinguishedHostStatusFromRatings(AccountRating.DistinguishedHostRatingRequest request, StreamObserver<AccountRating.DistinguishedHostRatingResponse> responseObserver){
        boolean isDistinguished;
        boolean reservationResponseStatus = false;
        User host = userService.findOne(request.getHostId());
        if (host != null) {
            isDistinguished = hostGradeService.isHostGradeBigEnoughForDistinguishedStatus(host);
            if (isDistinguished) {
                //-------------------------------------------Grpc begin to reservation service----------------------------------------------
                ManagedChannel channel = ManagedChannelBuilder.forAddress("reservation-service", 9080)
                        .usePlaintext()
                        .build();

                RatingServiceGrpc.RatingServiceBlockingStub stub = RatingServiceGrpc.newBlockingStub(channel);
                try {
                    RatingReservation.DistinguishedHostReservationRequest reservationRequest = RatingReservation.DistinguishedHostReservationRequest.newBuilder()
                            .setHostId(host.getId())
                            .build();

                    RatingReservation.DistinguishedHostReservationResponse response = stub.getDistinguishedHostStatusFromReservations(reservationRequest);
                    if (response.getIsDistinguished()) {
                        reservationResponseStatus = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Grpc exception happened");
                } finally {
                    channel.shutdown();
                }
                //-------------------------------------------Grpc end ----------------------------------------------
            }
        }
        AccountRating.DistinguishedHostRatingResponse response = AccountRating.DistinguishedHostRatingResponse.newBuilder()
                .setIsDistinguished(reservationResponseStatus)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void map(User user, AccountRating.UpdateUserRequest request) {
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setRole(roleRepository.findByName(request.getRole()));
    }
}
