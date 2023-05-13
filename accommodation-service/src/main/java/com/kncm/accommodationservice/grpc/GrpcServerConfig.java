package com.kncm.accommodationservice.grpc;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.repository.user.UserRepository;
import com.kncm.accommodationservice.service.user.UserServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GrpcServerConfig {

    private static final int GRPC_SERVER_PORT = 9091;

    @Autowired
    private UserRepository repository;
    @Autowired
    private SequenceGenerator generator;

    @Bean
    public Server grpcServer() throws IOException {
        Server server = ServerBuilder.forPort(GRPC_SERVER_PORT)
                .addService(new UserServiceImpl(generator, repository))
                .build();
        server.start();
        return server;
    }
}
