package com.kncm.reservationservice;

import com.kncm.reservationservice.repository.AccommodationRepository;
import com.kncm.reservationservice.service.grpc.AccommodationServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class GrpcServerConfig {

    private static final int GRPC_SERVER_PORT = 9090;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Bean
    public Server grpcServer() throws IOException {
        Server server = ServerBuilder.forPort(GRPC_SERVER_PORT)
                .addService(new AccommodationServiceGrpc(accommodationRepository))
                .build();
        server.start();
        return server;
    }
}
