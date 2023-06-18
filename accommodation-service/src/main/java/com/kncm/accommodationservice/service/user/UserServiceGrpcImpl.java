package com.kncm.accommodationservice.service.user;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.model.User;
import com.kncm.accommodationservice.repository.accommodation.AccommodationRepository;
import com.kncm.accommodationservice.repository.role.RoleRepository;
import com.kncm.accommodationservice.repository.user.UserRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.crypto.password.PasswordEncoder;
import proto.Accommodation;
import proto.CreateUserServiceGrpc;

import java.util.List;

@RequiredArgsConstructor
@GrpcService
public class UserServiceGrpcImpl extends CreateUserServiceGrpc.CreateUserServiceImplBase {
    private final SequenceGenerator generator;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AccommodationRepository accommodationRepository;
    @Override
    public void createUser(Accommodation.CreateUserRequest request, StreamObserver<Accommodation.CreateUserResponse> responseObserver) {
        // Perform the necessary logic to create the user in the accommodation-service
        // You can access the fields from the request using request.getUsername(), request.getPassword(), etc.
        User user = new User();
        Long id = generator.getSequenceNumber(com.kncm.accommodationservice.model.User.SEQUENCE_NAME);
        user.setId(id);
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setRole(roleRepository.findByName(request.getName()));
        repository.save(user);
        Accommodation.CreateUserResponse response = Accommodation.CreateUserResponse.newBuilder()
                .setUserId(id)
                .setIsCreated(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUser(Accommodation.UpdateUserRequest request, StreamObserver<Accommodation.UpdateUserResponse> responseObserver) {
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

        Accommodation.UpdateUserResponse response = Accommodation.UpdateUserResponse.newBuilder()
                .setIsUpdated(isUpdated)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteUser(Accommodation.DeleteUserRequest request, StreamObserver<Accommodation.DeleteUserResponse> responseObserver) {
        repository.deleteById(request.getUserId());
        List<com.kncm.accommodationservice.model.Accommodation> accommodations = accommodationRepository.findByUserId(request.getUserId());
        accommodationRepository.deleteAll(accommodations);
        Accommodation.DeleteUserResponse response = Accommodation.DeleteUserResponse.newBuilder()
                .setIsDeleted(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    private void map(User user, Accommodation.UpdateUserRequest request) {
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setRole(roleRepository.findByName(request.getRole()));
    }
}
