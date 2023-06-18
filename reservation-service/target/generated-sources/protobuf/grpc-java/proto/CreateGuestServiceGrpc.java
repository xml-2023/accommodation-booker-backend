package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: account-reservation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CreateGuestServiceGrpc {

  private CreateGuestServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.CreateGuestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.AccountReservation.CreateGuestRequest,
      proto.AccountReservation.CreateGuestResponse> getCreateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUser",
      requestType = proto.AccountReservation.CreateGuestRequest.class,
      responseType = proto.AccountReservation.CreateGuestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountReservation.CreateGuestRequest,
      proto.AccountReservation.CreateGuestResponse> getCreateUserMethod() {
    io.grpc.MethodDescriptor<proto.AccountReservation.CreateGuestRequest, proto.AccountReservation.CreateGuestResponse> getCreateUserMethod;
    if ((getCreateUserMethod = CreateGuestServiceGrpc.getCreateUserMethod) == null) {
      synchronized (CreateGuestServiceGrpc.class) {
        if ((getCreateUserMethod = CreateGuestServiceGrpc.getCreateUserMethod) == null) {
          CreateGuestServiceGrpc.getCreateUserMethod = getCreateUserMethod =
              io.grpc.MethodDescriptor.<proto.AccountReservation.CreateGuestRequest, proto.AccountReservation.CreateGuestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.CreateGuestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.CreateGuestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateGuestServiceMethodDescriptorSupplier("CreateUser"))
              .build();
        }
      }
    }
    return getCreateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.AccountReservation.UpdateGuestRequest,
      proto.AccountReservation.UpdateGuestResponse> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUser",
      requestType = proto.AccountReservation.UpdateGuestRequest.class,
      responseType = proto.AccountReservation.UpdateGuestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountReservation.UpdateGuestRequest,
      proto.AccountReservation.UpdateGuestResponse> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<proto.AccountReservation.UpdateGuestRequest, proto.AccountReservation.UpdateGuestResponse> getUpdateUserMethod;
    if ((getUpdateUserMethod = CreateGuestServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (CreateGuestServiceGrpc.class) {
        if ((getUpdateUserMethod = CreateGuestServiceGrpc.getUpdateUserMethod) == null) {
          CreateGuestServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<proto.AccountReservation.UpdateGuestRequest, proto.AccountReservation.UpdateGuestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.UpdateGuestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.UpdateGuestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateGuestServiceMethodDescriptorSupplier("UpdateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.AccountReservation.DeleteGuestRequest,
      proto.AccountReservation.DeleteGuestResponse> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUser",
      requestType = proto.AccountReservation.DeleteGuestRequest.class,
      responseType = proto.AccountReservation.DeleteGuestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountReservation.DeleteGuestRequest,
      proto.AccountReservation.DeleteGuestResponse> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<proto.AccountReservation.DeleteGuestRequest, proto.AccountReservation.DeleteGuestResponse> getDeleteUserMethod;
    if ((getDeleteUserMethod = CreateGuestServiceGrpc.getDeleteUserMethod) == null) {
      synchronized (CreateGuestServiceGrpc.class) {
        if ((getDeleteUserMethod = CreateGuestServiceGrpc.getDeleteUserMethod) == null) {
          CreateGuestServiceGrpc.getDeleteUserMethod = getDeleteUserMethod =
              io.grpc.MethodDescriptor.<proto.AccountReservation.DeleteGuestRequest, proto.AccountReservation.DeleteGuestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.DeleteGuestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.DeleteGuestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateGuestServiceMethodDescriptorSupplier("DeleteUser"))
              .build();
        }
      }
    }
    return getDeleteUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.AccountReservation.CanHostBeDeletedRequest,
      proto.AccountReservation.CanHostBeDeletedResponse> getCanHostBeDeletedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CanHostBeDeleted",
      requestType = proto.AccountReservation.CanHostBeDeletedRequest.class,
      responseType = proto.AccountReservation.CanHostBeDeletedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountReservation.CanHostBeDeletedRequest,
      proto.AccountReservation.CanHostBeDeletedResponse> getCanHostBeDeletedMethod() {
    io.grpc.MethodDescriptor<proto.AccountReservation.CanHostBeDeletedRequest, proto.AccountReservation.CanHostBeDeletedResponse> getCanHostBeDeletedMethod;
    if ((getCanHostBeDeletedMethod = CreateGuestServiceGrpc.getCanHostBeDeletedMethod) == null) {
      synchronized (CreateGuestServiceGrpc.class) {
        if ((getCanHostBeDeletedMethod = CreateGuestServiceGrpc.getCanHostBeDeletedMethod) == null) {
          CreateGuestServiceGrpc.getCanHostBeDeletedMethod = getCanHostBeDeletedMethod =
              io.grpc.MethodDescriptor.<proto.AccountReservation.CanHostBeDeletedRequest, proto.AccountReservation.CanHostBeDeletedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CanHostBeDeleted"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.CanHostBeDeletedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountReservation.CanHostBeDeletedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CreateGuestServiceMethodDescriptorSupplier("CanHostBeDeleted"))
              .build();
        }
      }
    }
    return getCanHostBeDeletedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CreateGuestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateGuestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateGuestServiceStub>() {
        @java.lang.Override
        public CreateGuestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateGuestServiceStub(channel, callOptions);
        }
      };
    return CreateGuestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CreateGuestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateGuestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateGuestServiceBlockingStub>() {
        @java.lang.Override
        public CreateGuestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateGuestServiceBlockingStub(channel, callOptions);
        }
      };
    return CreateGuestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CreateGuestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CreateGuestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CreateGuestServiceFutureStub>() {
        @java.lang.Override
        public CreateGuestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CreateGuestServiceFutureStub(channel, callOptions);
        }
      };
    return CreateGuestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createUser(proto.AccountReservation.CreateGuestRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.CreateGuestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserMethod(), responseObserver);
    }

    /**
     */
    default void updateUser(proto.AccountReservation.UpdateGuestRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.UpdateGuestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    default void deleteUser(proto.AccountReservation.DeleteGuestRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.DeleteGuestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    /**
     */
    default void canHostBeDeleted(proto.AccountReservation.CanHostBeDeletedRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.CanHostBeDeletedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCanHostBeDeletedMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CreateGuestService.
   */
  public static abstract class CreateGuestServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CreateGuestServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CreateGuestService.
   */
  public static final class CreateGuestServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CreateGuestServiceStub> {
    private CreateGuestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateGuestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateGuestServiceStub(channel, callOptions);
    }

    /**
     */
    public void createUser(proto.AccountReservation.CreateGuestRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.CreateGuestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(proto.AccountReservation.UpdateGuestRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.UpdateGuestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(proto.AccountReservation.DeleteGuestRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.DeleteGuestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void canHostBeDeleted(proto.AccountReservation.CanHostBeDeletedRequest request,
        io.grpc.stub.StreamObserver<proto.AccountReservation.CanHostBeDeletedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCanHostBeDeletedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CreateGuestService.
   */
  public static final class CreateGuestServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CreateGuestServiceBlockingStub> {
    private CreateGuestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateGuestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateGuestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.AccountReservation.CreateGuestResponse createUser(proto.AccountReservation.CreateGuestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.AccountReservation.UpdateGuestResponse updateUser(proto.AccountReservation.UpdateGuestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.AccountReservation.DeleteGuestResponse deleteUser(proto.AccountReservation.DeleteGuestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.AccountReservation.CanHostBeDeletedResponse canHostBeDeleted(proto.AccountReservation.CanHostBeDeletedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCanHostBeDeletedMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CreateGuestService.
   */
  public static final class CreateGuestServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CreateGuestServiceFutureStub> {
    private CreateGuestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CreateGuestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CreateGuestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountReservation.CreateGuestResponse> createUser(
        proto.AccountReservation.CreateGuestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountReservation.UpdateGuestResponse> updateUser(
        proto.AccountReservation.UpdateGuestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountReservation.DeleteGuestResponse> deleteUser(
        proto.AccountReservation.DeleteGuestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountReservation.CanHostBeDeletedResponse> canHostBeDeleted(
        proto.AccountReservation.CanHostBeDeletedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCanHostBeDeletedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_USER = 0;
  private static final int METHODID_UPDATE_USER = 1;
  private static final int METHODID_DELETE_USER = 2;
  private static final int METHODID_CAN_HOST_BE_DELETED = 3;

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
          serviceImpl.createUser((proto.AccountReservation.CreateGuestRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountReservation.CreateGuestResponse>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((proto.AccountReservation.UpdateGuestRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountReservation.UpdateGuestResponse>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((proto.AccountReservation.DeleteGuestRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountReservation.DeleteGuestResponse>) responseObserver);
          break;
        case METHODID_CAN_HOST_BE_DELETED:
          serviceImpl.canHostBeDeleted((proto.AccountReservation.CanHostBeDeletedRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountReservation.CanHostBeDeletedResponse>) responseObserver);
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
              proto.AccountReservation.CreateGuestRequest,
              proto.AccountReservation.CreateGuestResponse>(
                service, METHODID_CREATE_USER)))
        .addMethod(
          getUpdateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.AccountReservation.UpdateGuestRequest,
              proto.AccountReservation.UpdateGuestResponse>(
                service, METHODID_UPDATE_USER)))
        .addMethod(
          getDeleteUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.AccountReservation.DeleteGuestRequest,
              proto.AccountReservation.DeleteGuestResponse>(
                service, METHODID_DELETE_USER)))
        .addMethod(
          getCanHostBeDeletedMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.AccountReservation.CanHostBeDeletedRequest,
              proto.AccountReservation.CanHostBeDeletedResponse>(
                service, METHODID_CAN_HOST_BE_DELETED)))
        .build();
  }

  private static abstract class CreateGuestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CreateGuestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.AccountReservation.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CreateGuestService");
    }
  }

  private static final class CreateGuestServiceFileDescriptorSupplier
      extends CreateGuestServiceBaseDescriptorSupplier {
    CreateGuestServiceFileDescriptorSupplier() {}
  }

  private static final class CreateGuestServiceMethodDescriptorSupplier
      extends CreateGuestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CreateGuestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CreateGuestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CreateGuestServiceFileDescriptorSupplier())
              .addMethod(getCreateUserMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getDeleteUserMethod())
              .addMethod(getCanHostBeDeletedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
