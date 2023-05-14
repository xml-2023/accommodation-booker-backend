package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: reservation-accommodation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReservationRequestServiceGrpc {

  private ReservationRequestServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.ReservationRequestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ReservationAccommodation.CreateReservationRequest,
      proto.ReservationAccommodation.CreateReservationResponse> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = proto.ReservationAccommodation.CreateReservationRequest.class,
      responseType = proto.ReservationAccommodation.CreateReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ReservationAccommodation.CreateReservationRequest,
      proto.ReservationAccommodation.CreateReservationResponse> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<proto.ReservationAccommodation.CreateReservationRequest, proto.ReservationAccommodation.CreateReservationResponse> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationRequestServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationRequestServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationRequestServiceGrpc.getCreateReservationMethod) == null) {
          ReservationRequestServiceGrpc.getCreateReservationMethod = getCreateReservationMethod =
              io.grpc.MethodDescriptor.<proto.ReservationAccommodation.CreateReservationRequest, proto.ReservationAccommodation.CreateReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ReservationAccommodation.CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ReservationAccommodation.CreateReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationRequestServiceMethodDescriptorSupplier("CreateReservation"))
              .build();
        }
      }
    }
    return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.ReservationAccommodation.AcceptOrCancelReservationRequest,
      proto.ReservationAccommodation.AcceptOrCancelReservationResponse> getAcceptOrCancelReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptOrCancelReservation",
      requestType = proto.ReservationAccommodation.AcceptOrCancelReservationRequest.class,
      responseType = proto.ReservationAccommodation.AcceptOrCancelReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ReservationAccommodation.AcceptOrCancelReservationRequest,
      proto.ReservationAccommodation.AcceptOrCancelReservationResponse> getAcceptOrCancelReservationMethod() {
    io.grpc.MethodDescriptor<proto.ReservationAccommodation.AcceptOrCancelReservationRequest, proto.ReservationAccommodation.AcceptOrCancelReservationResponse> getAcceptOrCancelReservationMethod;
    if ((getAcceptOrCancelReservationMethod = ReservationRequestServiceGrpc.getAcceptOrCancelReservationMethod) == null) {
      synchronized (ReservationRequestServiceGrpc.class) {
        if ((getAcceptOrCancelReservationMethod = ReservationRequestServiceGrpc.getAcceptOrCancelReservationMethod) == null) {
          ReservationRequestServiceGrpc.getAcceptOrCancelReservationMethod = getAcceptOrCancelReservationMethod =
              io.grpc.MethodDescriptor.<proto.ReservationAccommodation.AcceptOrCancelReservationRequest, proto.ReservationAccommodation.AcceptOrCancelReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcceptOrCancelReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ReservationAccommodation.AcceptOrCancelReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ReservationAccommodation.AcceptOrCancelReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationRequestServiceMethodDescriptorSupplier("AcceptOrCancelReservation"))
              .build();
        }
      }
    }
    return getAcceptOrCancelReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationRequestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationRequestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationRequestServiceStub>() {
        @java.lang.Override
        public ReservationRequestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationRequestServiceStub(channel, callOptions);
        }
      };
    return ReservationRequestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationRequestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationRequestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationRequestServiceBlockingStub>() {
        @java.lang.Override
        public ReservationRequestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationRequestServiceBlockingStub(channel, callOptions);
        }
      };
    return ReservationRequestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationRequestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationRequestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationRequestServiceFutureStub>() {
        @java.lang.Override
        public ReservationRequestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationRequestServiceFutureStub(channel, callOptions);
        }
      };
    return ReservationRequestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createReservation(proto.ReservationAccommodation.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<proto.ReservationAccommodation.CreateReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    default void acceptOrCancelReservation(proto.ReservationAccommodation.AcceptOrCancelReservationRequest request,
        io.grpc.stub.StreamObserver<proto.ReservationAccommodation.AcceptOrCancelReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAcceptOrCancelReservationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReservationRequestService.
   */
  public static abstract class ReservationRequestServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReservationRequestServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReservationRequestService.
   */
  public static final class ReservationRequestServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReservationRequestServiceStub> {
    private ReservationRequestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationRequestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationRequestServiceStub(channel, callOptions);
    }

    /**
     */
    public void createReservation(proto.ReservationAccommodation.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<proto.ReservationAccommodation.CreateReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptOrCancelReservation(proto.ReservationAccommodation.AcceptOrCancelReservationRequest request,
        io.grpc.stub.StreamObserver<proto.ReservationAccommodation.AcceptOrCancelReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptOrCancelReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReservationRequestService.
   */
  public static final class ReservationRequestServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReservationRequestServiceBlockingStub> {
    private ReservationRequestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationRequestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationRequestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ReservationAccommodation.CreateReservationResponse createReservation(proto.ReservationAccommodation.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.ReservationAccommodation.AcceptOrCancelReservationResponse acceptOrCancelReservation(proto.ReservationAccommodation.AcceptOrCancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptOrCancelReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReservationRequestService.
   */
  public static final class ReservationRequestServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReservationRequestServiceFutureStub> {
    private ReservationRequestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationRequestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationRequestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ReservationAccommodation.CreateReservationResponse> createReservation(
        proto.ReservationAccommodation.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ReservationAccommodation.AcceptOrCancelReservationResponse> acceptOrCancelReservation(
        proto.ReservationAccommodation.AcceptOrCancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptOrCancelReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_ACCEPT_OR_CANCEL_RESERVATION = 1;

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
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((proto.ReservationAccommodation.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<proto.ReservationAccommodation.CreateReservationResponse>) responseObserver);
          break;
        case METHODID_ACCEPT_OR_CANCEL_RESERVATION:
          serviceImpl.acceptOrCancelReservation((proto.ReservationAccommodation.AcceptOrCancelReservationRequest) request,
              (io.grpc.stub.StreamObserver<proto.ReservationAccommodation.AcceptOrCancelReservationResponse>) responseObserver);
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
          getCreateReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.ReservationAccommodation.CreateReservationRequest,
              proto.ReservationAccommodation.CreateReservationResponse>(
                service, METHODID_CREATE_RESERVATION)))
        .addMethod(
          getAcceptOrCancelReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.ReservationAccommodation.AcceptOrCancelReservationRequest,
              proto.ReservationAccommodation.AcceptOrCancelReservationResponse>(
                service, METHODID_ACCEPT_OR_CANCEL_RESERVATION)))
        .build();
  }

  private static abstract class ReservationRequestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationRequestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ReservationAccommodation.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationRequestService");
    }
  }

  private static final class ReservationRequestServiceFileDescriptorSupplier
      extends ReservationRequestServiceBaseDescriptorSupplier {
    ReservationRequestServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationRequestServiceMethodDescriptorSupplier
      extends ReservationRequestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationRequestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReservationRequestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationRequestServiceFileDescriptorSupplier())
              .addMethod(getCreateReservationMethod())
              .addMethod(getAcceptOrCancelReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
