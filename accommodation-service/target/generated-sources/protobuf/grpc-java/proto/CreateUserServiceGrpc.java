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
  private static volatile io.grpc.MethodDescriptor<proto.Accommodation.CreateUserRequest,
      proto.Accommodation.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = proto.Accommodation.CreateUserRequest.class,
      responseType = proto.Accommodation.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Accommodation.CreateUserRequest,
      proto.Accommodation.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<proto.Accommodation.CreateUserRequest, proto.Accommodation.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = CreateUserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (CreateUserServiceGrpc.class) {
        if ((getCreateUserMethod = CreateUserServiceGrpc.getCreateUserMethod) == null) {
          CreateUserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<proto.Accommodation.CreateUserRequest, proto.Accommodation.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Accommodation.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Accommodation.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateUserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Accommodation.UpdateUserRequest,
      proto.Accommodation.UpdateUserResponse> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = proto.Accommodation.UpdateUserRequest.class,
      responseType = proto.Accommodation.UpdateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Accommodation.UpdateUserRequest,
      proto.Accommodation.UpdateUserResponse> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<proto.Accommodation.UpdateUserRequest, proto.Accommodation.UpdateUserResponse> getUpdateUserMethod;
    if ((getUpdateUserMethod = CreateUserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (CreateUserServiceGrpc.class) {
        if ((getUpdateUserMethod = CreateUserServiceGrpc.getUpdateUserMethod) == null) {
          CreateUserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<proto.Accommodation.UpdateUserRequest, proto.Accommodation.UpdateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Accommodation.UpdateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Accommodation.UpdateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateUserServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Accommodation.DeleteUserRequest,
      proto.Accommodation.DeleteUserResponse> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = proto.Accommodation.DeleteUserRequest.class,
      responseType = proto.Accommodation.DeleteUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Accommodation.DeleteUserRequest,
      proto.Accommodation.DeleteUserResponse> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<proto.Accommodation.DeleteUserRequest, proto.Accommodation.DeleteUserResponse> getDeleteUserMethod;
    if ((getDeleteUserMethod = CreateUserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (CreateUserServiceGrpc.class) {
        if ((getDeleteUserMethod = CreateUserServiceGrpc.getDeleteUserMethod) == null) {
          CreateUserServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<proto.Accommodation.DeleteUserRequest, proto.Accommodation.DeleteUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Accommodation.DeleteUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Accommodation.DeleteUserResponse.getDefaultInstance()))
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
        @java.lang.Override
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
        @java.lang.Override
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
        @java.lang.Override
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
    default void createUser(proto.Accommodation.CreateUserRequest request,
        io.grpc.stub.StreamObserver<proto.Accommodation.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    default void updateUser(proto.Accommodation.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<proto.Accommodation.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    default void deleteUser(proto.Accommodation.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<proto.Accommodation.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CreateUserService.
   */
  public static abstract class CreateUserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
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

    @java.lang.Override
    protected CreateUserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateUserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(proto.Accommodation.CreateUserRequest request,
        io.grpc.stub.StreamObserver<proto.Accommodation.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(proto.Accommodation.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<proto.Accommodation.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(proto.Accommodation.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<proto.Accommodation.DeleteUserResponse> responseObserver) {
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

    @java.lang.Override
    protected CreateUserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateUserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.Accommodation.CreateUserResponse createUser(proto.Accommodation.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Accommodation.UpdateUserResponse updateUser(proto.Accommodation.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Accommodation.DeleteUserResponse deleteUser(proto.Accommodation.DeleteUserRequest request) {
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

    @java.lang.Override
    protected CreateUserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateUserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Accommodation.CreateUserResponse> createUser(
        proto.Accommodation.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Accommodation.UpdateUserResponse> updateUser(
        proto.Accommodation.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Accommodation.DeleteUserResponse> deleteUser(
        proto.Accommodation.DeleteUserRequest request) {
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

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER:
          serviceImpl.createUser((proto.Accommodation.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<proto.Accommodation.CreateUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((proto.Accommodation.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<proto.Accommodation.UpdateUserResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((proto.Accommodation.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<proto.Accommodation.DeleteUserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
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
              proto.Accommodation.CreateUserRequest,
              proto.Accommodation.CreateUserResponse>(
                service, METHODID_CREATE_USER)))
        .addMethod(
          getUpdateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.Accommodation.UpdateUserRequest,
              proto.Accommodation.UpdateUserResponse>(
                service, METHODID_UPDATE_USER)))
        .addMethod(
          getDeleteUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.Accommodation.DeleteUserRequest,
              proto.Accommodation.DeleteUserResponse>(
                service, METHODID_DELETE_USER)))
        .build();
  }

  private static abstract class CreateUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CreateUserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Accommodation.getDescriptor();
    }

    @java.lang.Override
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

    @java.lang.Override
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