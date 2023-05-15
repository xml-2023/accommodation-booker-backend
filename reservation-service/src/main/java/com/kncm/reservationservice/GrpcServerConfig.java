package com.kncm.reservationservice;

import com.kncm.reservationservice.repository.AccommodationRepository;
import com.kncm.reservationservice.repository.RequestRepository;
import com.kncm.reservationservice.repository.RoleRepository;
import com.kncm.reservationservice.repository.UserRepository;
import com.kncm.reservationservice.service.grpc.AccommodationServiceGrpc;
import com.kncm.reservationservice.service.grpc.CreateGuestServiceGrpcImpl;
import com.kncm.reservationservice.service.user.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

@Configuration
public class GrpcServerConfig {

    private static final int GRPC_SERVER_PORT = 9090;

    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService service;
    @Autowired
    private RequestRepository requestRepository;

    @Bean
    public Server grpcServer() throws IOException {
        Server server = ServerBuilder.forPort(GRPC_SERVER_PORT)
                .addService(new AccommodationServiceGrpc(accommodationRepository))
                .build();
        server.start();
        return server;
    }

    @Bean
    public Server grpcServerAccount() throws IOException {
        Server server = ServerBuilder.forPort(9094)
                .addService(new CreateGuestServiceGrpcImpl(repository, passwordEncoder, roleRepository, service, requestRepository))
                .build();
        server.start();
        System.out.println("Server on port 9093 started");
        return server;
    }
}
