package com.kncm.accommodationservice.grpc;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.repository.accommodation.AccommodationRepository;
import com.kncm.accommodationservice.repository.role.RoleRepository;
import com.kncm.accommodationservice.repository.user.UserRepository;
import com.kncm.accommodationservice.service.grpc.ReservationRequestServiceImpl;
import com.kncm.accommodationservice.service.slotmanagement.SlotManagementService;
import com.kncm.accommodationservice.service.user.UserServiceGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

@Configuration
public class GrpcServerConfig {

    private static final int GRPC_SERVER_PORT = 9091;
    private static final int GRPC_SERVER_PORT_RESERVATION = 9092;

    @Autowired
    private UserRepository repository;

    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private SlotManagementService managementService;
    @Autowired
    private SequenceGenerator generator;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public Server grpcServer() throws IOException {
        Server server = ServerBuilder.forPort(GRPC_SERVER_PORT)
                .addService(new UserServiceGrpcImpl(generator, repository, passwordEncoder, roleRepository))
                .build();
        server.start();
        return server;
    }

    @Bean
    public Server grpcServerReservation() throws IOException {
        Server server = ServerBuilder.forPort(GRPC_SERVER_PORT_RESERVATION)
                .addService(new ReservationRequestServiceImpl(accommodationRepository, managementService))
                .build();
        server.start();
        return server;
    }
}
