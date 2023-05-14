package com.kncm.accommodationservice.service.user;

import com.kncm.accommodationservice.SequenceGenerator;
import com.kncm.accommodationservice.model.User;
import com.kncm.accommodationservice.repository.user.UserRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import proto.Accommodation;
import proto.UserServiceGrpc;

@RequiredArgsConstructor
@GrpcService
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {
    private final SequenceGenerator generator;
    private final UserRepository repository;

    @Override
    public void createUser(Accommodation.CreateUserRequest request, StreamObserver<Accommodation.CreateUserResponse> responseObserver) {
        // Perform the necessary logic to create the user in the accommodation-service
        // You can access the fields from the request using request.getUsername(), request.getPassword(), etc.
        User user = new User();
        user.setId(generator.getSequenceNumber(com.kncm.accommodationservice.model.User.SEQUENCE_NAME));
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setSurname(request.getSurname());

//        Accommodation.CreateUserResponse response;
//        try{
//            repository.save(user);
//             response = Accommodation.CreateUserResponse.newBuilder()
//                    .setIsCreated(true)
//                    .build();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            response = Accommodation.CreateUserResponse.newBuilder()
//                    .setIsCreated(false)
//                    .build();
//        }
        repository.save(user);
        Accommodation.CreateUserResponse response = Accommodation.CreateUserResponse.newBuilder()
                .setIsCreated(true)
                .build();

        // Assuming you have successfully created the user, you can build the response message

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
