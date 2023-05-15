package com.kncm.reservationservice.service.grpc;

import com.kncm.reservationservice.model.RequestStatus;
import com.kncm.reservationservice.model.ReservationRequest;
import com.kncm.reservationservice.model.Role;
import com.kncm.reservationservice.model.User;
import com.kncm.reservationservice.repository.RequestRepository;
import com.kncm.reservationservice.repository.RoleRepository;
import com.kncm.reservationservice.repository.UserRepository;
import com.kncm.reservationservice.service.user.UserService;
import io.grpc.stub.StreamObserver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import proto.AccountReservation;
import proto.CreateGuestServiceGrpc;

import java.time.LocalDateTime;
import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class CreateGuestServiceGrpcImpl extends CreateGuestServiceGrpc.CreateGuestServiceImplBase {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserService service;
    private final RequestRepository requestRepository;

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
        Role role = roleRepository.findByName(request.getRole());
        user.setRole(role);
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

    @Override
    public void deleteUser(AccountReservation.DeleteGuestRequest request, StreamObserver<AccountReservation.DeleteGuestResponse> responseObserver) {
        boolean isDeleted = false;
        if (!service.haveActiveReservations(request.getUserId())) {
            List<ReservationRequest> reservationRequests = requestRepository.findByUserId(request.getUserId());
            requestRepository.deleteAll(reservationRequests);
            repository.deleteById(request.getUserId());
            isDeleted = true;
        }


        AccountReservation.DeleteGuestResponse response = AccountReservation.DeleteGuestResponse.newBuilder()
                .setIsDeleted(isDeleted)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void canHostBeDeleted(AccountReservation.CanHostBeDeletedRequest request, StreamObserver<AccountReservation.CanHostBeDeletedResponse> responseObserver) {
        boolean canBeDeleted = true;
        List<Long> accommodationIds = request.getAccommodationIdsList();
        for (Long id : accommodationIds) {
            if (!canBeDeleted)
                break;
            List<ReservationRequest> reservationRequests = requestRepository.findByAccommodationId(id);
            for (ReservationRequest r : reservationRequests) {
                if (r.getStatus() == RequestStatus.ACCEPTED && r.getReserveTo().isAfter(LocalDateTime.now())) {
                    canBeDeleted = false;
                    break;
                }
            }
        }

        AccountReservation.CanHostBeDeletedResponse response = AccountReservation.CanHostBeDeletedResponse.newBuilder()
                .setCanBeDeleted(canBeDeleted)
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

