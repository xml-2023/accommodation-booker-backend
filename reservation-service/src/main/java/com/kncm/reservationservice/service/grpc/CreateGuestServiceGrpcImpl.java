package com.kncm.reservationservice.service.grpc;

import com.kncm.reservationservice.model.User;
import com.kncm.reservationservice.repository.RoleRepository;
import com.kncm.reservationservice.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.crypto.password.PasswordEncoder;
import proto.AccountReservation;
import proto.CreateGuestServiceGrpc;

@GrpcService
@RequiredArgsConstructor
public class CreateGuestServiceGrpcImpl extends CreateGuestServiceGrpc.CreateGuestServiceImplBase {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void createUser(AccountReservation.CreateGuestRequest request, StreamObserver<AccountReservation.CreateGuestResponse> responseObserver) {
        // Perform the necessary logic to create the user in the accommodation-service
        // You can access the fields from the request using request.getUsername(), request.getPassword(), etc.
        User user = new User();
        user.setId(request.getUserId());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setRole(roleRepository.findByName(request.getName()));
        user.setCanceledReservations(0);

        repository.save(user);
        AccountReservation.CreateGuestResponse response = AccountReservation.CreateGuestResponse.newBuilder()
                .setIsCreated(true)
                .setUserId(0)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(AccountReservation.UpdateGuestRequest request, StreamObserver<AccountReservation.UpdateGuestResponse> responseObserver) {
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

        AccountReservation.UpdateGuestResponse response = AccountReservation.UpdateGuestResponse.newBuilder()
                .setIsUpdated(isUpdated)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void map(User user, AccountReservation.UpdateGuestRequest request) {
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setRole(roleRepository.findByName(request.getRole()));
    }
}

