package com.kncm.ratingservice;

import com.kncm.ratingservice.repository.AccommodationRepository;
import com.kncm.ratingservice.repository.RoleRepository;
import com.kncm.ratingservice.repository.UserRepository;
import com.kncm.ratingservice.service.grpc.AccommodationServiceGrpc;
import com.kncm.ratingservice.service.grpc.CrudUserServiceGrpc;
import com.kncm.ratingservice.service.hostgrade.HostGradeService;
import com.kncm.ratingservice.service.user.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

@Configuration
public class GrpcServerConfig {

    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private HostGradeService hostGradeService;

    @Bean
    public Server grpcServer() throws IOException {
        Server server = ServerBuilder.forPort(9098)
                .addService(new AccommodationServiceGrpc(accommodationRepository))
                .build();
        server.start();
        return server;
    }

    @Bean
    public Server grpcServerManageUsers() throws IOException {
        Server server = ServerBuilder.forPort(9099)
                .addService(new CrudUserServiceGrpc(repository, passwordEncoder, roleRepository,userService, hostGradeService))
                .build();
        server.start();
        return server;
    }

//    @Bean
//    public Server grpcServerDistinguished() throws IOException {
//        Server server = ServerBuilder.forPort(9084)
//                .addService(new AccountRatingServiceGrpcImpl(userService, hostGradeService))
//                .build();
//        server.start();
//        return server;
//    }
}
