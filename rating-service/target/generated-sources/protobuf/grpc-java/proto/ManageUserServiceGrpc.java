package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: account-rating.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ManageUserServiceGrpc {

  private ManageUserServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ManageUserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.AccountRating.CreateUserRequest,
      proto.AccountRating.CreateUserResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = proto.AccountRating.CreateUserRequest.class,
      responseType = proto.AccountRating.CreateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountRating.CreateUserRequest,
      proto.AccountRating.CreateUserResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<proto.AccountRating.CreateUserRequest, proto.AccountRating.CreateUserResponse> getCreateUserMethod;
    if ((getCreateUserMethod = ManageUserServiceGrpc.getCreateUserMethod) == null) {
      synchronized (ManageUserServiceGrpc.class) {
        if ((getCreateUserMethod = ManageUserServiceGrpc.getCreateUserMethod) == null) {
          ManageUserServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<proto.AccountRating.CreateUserRequest, proto.AccountRating.CreateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.CreateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.CreateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManageUserServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.AccountRating.UpdateUserRequest,
      proto.AccountRating.UpdateUserResponse> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = proto.AccountRating.UpdateUserRequest.class,
      responseType = proto.AccountRating.UpdateUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountRating.UpdateUserRequest,
      proto.AccountRating.UpdateUserResponse> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<proto.AccountRating.UpdateUserRequest, proto.AccountRating.UpdateUserResponse> getUpdateUserMethod;
    if ((getUpdateUserMethod = ManageUserServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (ManageUserServiceGrpc.class) {
        if ((getUpdateUserMethod = ManageUserServiceGrpc.getUpdateUserMethod) == null) {
          ManageUserServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<proto.AccountRating.UpdateUserRequest, proto.AccountRating.UpdateUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.UpdateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.UpdateUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManageUserServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.AccountRating.DeleteUserRequest,
      proto.AccountRating.DeleteUserResponse> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = proto.AccountRating.DeleteUserRequest.class,
      responseType = proto.AccountRating.DeleteUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountRating.DeleteUserRequest,
      proto.AccountRating.DeleteUserResponse> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<proto.AccountRating.DeleteUserRequest, proto.AccountRating.DeleteUserResponse> getDeleteUserMethod;
    if ((getDeleteUserMethod = ManageUserServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (ManageUserServiceGrpc.class) {
        if ((getDeleteUserMethod = ManageUserServiceGrpc.getDeleteUserMethod) == null) {
          ManageUserServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<proto.AccountRating.DeleteUserRequest, proto.AccountRating.DeleteUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.DeleteUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.DeleteUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManageUserServiceMethodDescriptorSupplier("DeleteUser"))
              .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.AccountRating.DistinguishedHostRatingRequest,
      proto.AccountRating.DistinguishedHostRatingResponse> getGetDistinguishedHostStatusFromRatingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDistinguishedHostStatusFromRatings",
      requestType = proto.AccountRating.DistinguishedHostRatingRequest.class,
      responseType = proto.AccountRating.DistinguishedHostRatingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountRating.DistinguishedHostRatingRequest,
      proto.AccountRating.DistinguishedHostRatingResponse> getGetDistinguishedHostStatusFromRatingsMethod() {
    io.grpc.MethodDescriptor<proto.AccountRating.DistinguishedHostRatingRequest, proto.AccountRating.DistinguishedHostRatingResponse> getGetDistinguishedHostStatusFromRatingsMethod;
    if ((getGetDistinguishedHostStatusFromRatingsMethod = ManageUserServiceGrpc.getGetDistinguishedHostStatusFromRatingsMethod) == null) {
      synchronized (ManageUserServiceGrpc.class) {
        if ((getGetDistinguishedHostStatusFromRatingsMethod = ManageUserServiceGrpc.getGetDistinguishedHostStatusFromRatingsMethod) == null) {
          ManageUserServiceGrpc.getGetDistinguishedHostStatusFromRatingsMethod = getGetDistinguishedHostStatusFromRatingsMethod =
              io.grpc.MethodDescriptor.<proto.AccountRating.DistinguishedHostRatingRequest, proto.AccountRating.DistinguishedHostRatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDistinguishedHostStatusFromRatings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.DistinguishedHostRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountRating.DistinguishedHostRatingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManageUserServiceMethodDescriptorSupplier("GetDistinguishedHostStatusFromRatings"))
              .build();
        }
      }
    }
    return getGetDistinguishedHostStatusFromRatingsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ManageUserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManageUserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManageUserServiceStub>() {
        @java.lang.Override
        public ManageUserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManageUserServiceStub(channel, callOptions);
        }
      };
    return ManageUserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManageUserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManageUserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManageUserServiceBlockingStub>() {
        @java.lang.Override
        public ManageUserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManageUserServiceBlockingStub(channel, callOptions);
        }
      };
    return ManageUserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ManageUserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManageUserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManageUserServiceFutureStub>() {
        @java.lang.Override
        public ManageUserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManageUserServiceFutureStub(channel, callOptions);
        }
      };
    return ManageUserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createUser(proto.AccountRating.CreateUserRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.CreateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    default void updateUser(proto.AccountRating.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    default void deleteUser(proto.AccountRating.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     */
    default void getDistinguishedHostStatusFromRatings(proto.AccountRating.DistinguishedHostRatingRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.DistinguishedHostRatingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDistinguishedHostStatusFromRatingsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ManageUserService.
   */
  public static abstract class ManageUserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ManageUserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ManageUserService.
   */
  public static final class ManageUserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ManageUserServiceStub> {
    private ManageUserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManageUserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManageUserServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(proto.AccountRating.CreateUserRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.CreateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(proto.AccountRating.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.UpdateUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(proto.AccountRating.DeleteUserRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.DeleteUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDistinguishedHostStatusFromRatings(proto.AccountRating.DistinguishedHostRatingRequest request,
        io.grpc.stub.StreamObserver<proto.AccountRating.DistinguishedHostRatingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDistinguishedHostStatusFromRatingsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ManageUserService.
   */
  public static final class ManageUserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ManageUserServiceBlockingStub> {
    private ManageUserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManageUserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManageUserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.AccountRating.CreateUserResponse createUser(proto.AccountRating.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.AccountRating.UpdateUserResponse updateUser(proto.AccountRating.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.AccountRating.DeleteUserResponse deleteUser(proto.AccountRating.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.AccountRating.DistinguishedHostRatingResponse getDistinguishedHostStatusFromRatings(proto.AccountRating.DistinguishedHostRatingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDistinguishedHostStatusFromRatingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ManageUserService.
   */
  public static final class ManageUserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ManageUserServiceFutureStub> {
    private ManageUserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManageUserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManageUserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountRating.CreateUserResponse> createUser(
        proto.AccountRating.CreateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountRating.UpdateUserResponse> updateUser(
        proto.AccountRating.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountRating.DeleteUserResponse> deleteUser(
        proto.AccountRating.DeleteUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountRating.DistinguishedHostRatingResponse> getDistinguishedHostStatusFromRatings(
        proto.AccountRating.DistinguishedHostRatingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDistinguishedHostStatusFromRatingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_UPDATE_USER = 1;
  private static final int METHODID_DELETE_USER = 2;
  private static final int METHODID_GET_DISTINGUISHED_HOST_STATUS_FROM_RATINGS = 3;

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
          serviceImpl.createUser((proto.AccountRating.CreateUserRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountRating.CreateUserResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((proto.AccountRating.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountRating.UpdateUserResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((proto.AccountRating.DeleteUserRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountRating.DeleteUserResponse>) responseObserver);
          break;
        case METHODID_GET_DISTINGUISHED_HOST_STATUS_FROM_RATINGS:
          serviceImpl.getDistinguishedHostStatusFromRatings((proto.AccountRating.DistinguishedHostRatingRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountRating.DistinguishedHostRatingResponse>) responseObserver);
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
              proto.AccountRating.CreateUserRequest,
              proto.AccountRating.CreateUserResponse>(
                service, METHODID_CREATE_USER)))
        .addMethod(
          getUpdateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.AccountRating.UpdateUserRequest,
              proto.AccountRating.UpdateUserResponse>(
                service, METHODID_UPDATE_USER)))
        .addMethod(
          getDeleteUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.AccountRating.DeleteUserRequest,
              proto.AccountRating.DeleteUserResponse>(
                service, METHODID_DELETE_USER)))
        .addMethod(
          getGetDistinguishedHostStatusFromRatingsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.AccountRating.DistinguishedHostRatingRequest,
              proto.AccountRating.DistinguishedHostRatingResponse>(
                service, METHODID_GET_DISTINGUISHED_HOST_STATUS_FROM_RATINGS)))
        .build();
  }

  private static abstract class ManageUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManageUserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.AccountRating.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManageUserService");
    }
  }

  private static final class ManageUserServiceFileDescriptorSupplier
      extends ManageUserServiceBaseDescriptorSupplier {
    ManageUserServiceFileDescriptorSupplier() {}
  }

  private static final class ManageUserServiceMethodDescriptorSupplier
      extends ManageUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ManageUserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ManageUserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManageUserServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getDeleteUserMethod())
              .addMethod(getGetDistinguishedHostStatusFromRatingsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
