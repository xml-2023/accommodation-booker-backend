package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: accommodation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CreateUserServiceGrpc {

  private CreateUserServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CreateUserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Accommodation.CreateUserRequest,
      Accommodation.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = Accommodation.CreateUserRequest.class,
      responseType = Accommodation.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Accommodation.CreateUserRequest,
      Accommodation.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<Accommodation.CreateUserRequest, Accommodation.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = CreateUserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (CreateUserServiceGrpc.class) {
        if ((getCreateUserMethod = CreateUserServiceGrpc.getCreateUserMethod) == null) {
          CreateUserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<Accommodation.CreateUserRequest, Accommodation.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Accommodation.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Accommodation.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateUserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Accommodation.UpdateUserRequest,
      Accommodation.UpdateUserResponse> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = Accommodation.UpdateUserRequest.class,
      responseType = Accommodation.UpdateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Accommodation.UpdateUserRequest,
      Accommodation.UpdateUserResponse> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<Accommodation.UpdateUserRequest, Accommodation.UpdateUserResponse> getUpdateUserMethod;
    if ((getUpdateUserMethod = CreateUserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (CreateUserServiceGrpc.class) {
        if ((getUpdateUserMethod = CreateUserServiceGrpc.getUpdateUserMethod) == null) {
          CreateUserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<Accommodation.UpdateUserRequest, Accommodation.UpdateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Accommodation.UpdateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Accommodation.UpdateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateUserServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Accommodation.DeleteUserRequest,
      Accommodation.DeleteUserResponse> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = Accommodation.DeleteUserRequest.class,
      responseType = Accommodation.DeleteUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Accommodation.DeleteUserRequest,
      Accommodation.DeleteUserResponse> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<Accommodation.DeleteUserRequest, Accommodation.DeleteUserResponse> getDeleteUserMethod;
    if ((getDeleteUserMethod = CreateUserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (CreateUserServiceGrpc.class) {
        if ((getDeleteUserMethod = CreateUserServiceGrpc.getDeleteUserMethod) == null) {
          CreateUserServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<Accommodation.DeleteUserRequest, Accommodation.DeleteUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Accommodation.DeleteUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Accommodation.DeleteUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateUserServiceMethodDescriptorSupplier("DeleteUser"))
              .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CreateUserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateUserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateUserServiceStub>() {
        @Override
        public CreateUserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateUserServiceStub(channel, callOptions);
        }
      };
    return CreateUserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CreateUserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateUserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateUserServiceBlockingStub>() {
        @Override
        public CreateUserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateUserServiceBlockingStub(channel, callOptions);
        }
      };
    return CreateUserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CreateUserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateUserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateUserServiceFutureStub>() {
        @Override
        public CreateUserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateUserServiceFutureStub(channel, callOptions);
        }
      };
    return CreateUserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createUser(Accommodation.CreateUserRequest request,
                            io.grpc.stub.StreamObserver<Accommodation.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    default void updateUser(Accommodation.UpdateUserRequest request,
                            io.grpc.stub.StreamObserver<Accommodation.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    default void deleteUser(Accommodation.DeleteUserRequest request,
                            io.grpc.stub.StreamObserver<Accommodation.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CreateUserService.
   */
  public static abstract class CreateUserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return CreateUserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CreateUserService.
   */
  public static final class CreateUserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CreateUserServiceStub> {
    private CreateUserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CreateUserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateUserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(Accommodation.CreateUserRequest request,
                           io.grpc.stub.StreamObserver<Accommodation.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(Accommodation.UpdateUserRequest request,
                           io.grpc.stub.StreamObserver<Accommodation.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(Accommodation.DeleteUserRequest request,
                           io.grpc.stub.StreamObserver<Accommodation.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CreateUserService.
   */
  public static final class CreateUserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CreateUserServiceBlockingStub> {
    private CreateUserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CreateUserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateUserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Accommodation.CreateUserResponse createUser(Accommodation.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public Accommodation.UpdateUserResponse updateUser(Accommodation.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public Accommodation.DeleteUserResponse deleteUser(Accommodation.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CreateUserService.
   */
  public static final class CreateUserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CreateUserServiceFutureStub> {
    private CreateUserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CreateUserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateUserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Accommodation.CreateUserResponse> createUser(
        Accommodation.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Accommodation.UpdateUserResponse> updateUser(
        Accommodation.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Accommodation.DeleteUserResponse> deleteUser(
        Accommodation.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_UPDATE_USER = 1;
  private static final int METHODID_DELETE_USER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((Accommodation.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<Accommodation.CreateUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((Accommodation.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<Accommodation.UpdateUserResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((Accommodation.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<Accommodation.DeleteUserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Accommodation.CreateUserRequest,
              Accommodation.CreateUserResponse>(
                service, METHODID_CREATE_USER)))
        .addMethod(
          getUpdateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Accommodation.UpdateUserRequest,
              Accommodation.UpdateUserResponse>(
                service, METHODID_UPDATE_USER)))
        .addMethod(
          getDeleteUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              Accommodation.DeleteUserRequest,
              Accommodation.DeleteUserResponse>(
                service, METHODID_DELETE_USER)))
        .build();
  }

  private static abstract class CreateUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CreateUserServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Accommodation.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CreateUserService");
    }
  }

  private static final class CreateUserServiceFileDescriptorSupplier
      extends CreateUserServiceBaseDescriptorSupplier {
    CreateUserServiceFileDescriptorSupplier() {}
  }

  private static final class CreateUserServiceMethodDescriptorSupplier
      extends CreateUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CreateUserServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CreateUserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CreateUserServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getDeleteUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
