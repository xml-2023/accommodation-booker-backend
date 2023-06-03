package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: rating-reservation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RatingServiceGrpc {

  private RatingServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.RatingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.RatingReservation.IsAccommodationAllowedToRateRequest,
      proto.RatingReservation.IsAccommodationAllowedToRateResponse> getIsAccommodationAllowedToRateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsAccommodationAllowedToRate",
      requestType = proto.RatingReservation.IsAccommodationAllowedToRateRequest.class,
      responseType = proto.RatingReservation.IsAccommodationAllowedToRateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.RatingReservation.IsAccommodationAllowedToRateRequest,
      proto.RatingReservation.IsAccommodationAllowedToRateResponse> getIsAccommodationAllowedToRateMethod() {
    io.grpc.MethodDescriptor<proto.RatingReservation.IsAccommodationAllowedToRateRequest, proto.RatingReservation.IsAccommodationAllowedToRateResponse> getIsAccommodationAllowedToRateMethod;
    if ((getIsAccommodationAllowedToRateMethod = RatingServiceGrpc.getIsAccommodationAllowedToRateMethod) == null) {
      synchronized (RatingServiceGrpc.class) {
        if ((getIsAccommodationAllowedToRateMethod = RatingServiceGrpc.getIsAccommodationAllowedToRateMethod) == null) {
          RatingServiceGrpc.getIsAccommodationAllowedToRateMethod = getIsAccommodationAllowedToRateMethod =
              io.grpc.MethodDescriptor.<proto.RatingReservation.IsAccommodationAllowedToRateRequest, proto.RatingReservation.IsAccommodationAllowedToRateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IsAccommodationAllowedToRate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.RatingReservation.IsAccommodationAllowedToRateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.RatingReservation.IsAccommodationAllowedToRateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RatingServiceMethodDescriptorSupplier("IsAccommodationAllowedToRate"))
              .build();
        }
      }
    }
    return getIsAccommodationAllowedToRateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.RatingReservation.IsHostAllowedToRateRequest,
      proto.RatingReservation.IsHostAllowedToRateResponse> getIsHostAllowedToRateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsHostAllowedToRate",
      requestType = proto.RatingReservation.IsHostAllowedToRateRequest.class,
      responseType = proto.RatingReservation.IsHostAllowedToRateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.RatingReservation.IsHostAllowedToRateRequest,
      proto.RatingReservation.IsHostAllowedToRateResponse> getIsHostAllowedToRateMethod() {
    io.grpc.MethodDescriptor<proto.RatingReservation.IsHostAllowedToRateRequest, proto.RatingReservation.IsHostAllowedToRateResponse> getIsHostAllowedToRateMethod;
    if ((getIsHostAllowedToRateMethod = RatingServiceGrpc.getIsHostAllowedToRateMethod) == null) {
      synchronized (RatingServiceGrpc.class) {
        if ((getIsHostAllowedToRateMethod = RatingServiceGrpc.getIsHostAllowedToRateMethod) == null) {
          RatingServiceGrpc.getIsHostAllowedToRateMethod = getIsHostAllowedToRateMethod =
              io.grpc.MethodDescriptor.<proto.RatingReservation.IsHostAllowedToRateRequest, proto.RatingReservation.IsHostAllowedToRateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "IsHostAllowedToRate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.RatingReservation.IsHostAllowedToRateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.RatingReservation.IsHostAllowedToRateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RatingServiceMethodDescriptorSupplier("IsHostAllowedToRate"))
              .build();
        }
      }
    }
    return getIsHostAllowedToRateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RatingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RatingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RatingServiceStub>() {
        @java.lang.Override
        public RatingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RatingServiceStub(channel, callOptions);
        }
      };
    return RatingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RatingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RatingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RatingServiceBlockingStub>() {
        @java.lang.Override
        public RatingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RatingServiceBlockingStub(channel, callOptions);
        }
      };
    return RatingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RatingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RatingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RatingServiceFutureStub>() {
        @java.lang.Override
        public RatingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RatingServiceFutureStub(channel, callOptions);
        }
      };
    return RatingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void isAccommodationAllowedToRate(proto.RatingReservation.IsAccommodationAllowedToRateRequest request,
        io.grpc.stub.StreamObserver<proto.RatingReservation.IsAccommodationAllowedToRateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsAccommodationAllowedToRateMethod(), responseObserver);
    }

    /**
     */
    default void isHostAllowedToRate(proto.RatingReservation.IsHostAllowedToRateRequest request,
        io.grpc.stub.StreamObserver<proto.RatingReservation.IsHostAllowedToRateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsHostAllowedToRateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RatingService.
   */
  public static abstract class RatingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RatingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RatingService.
   */
  public static final class RatingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RatingServiceStub> {
    private RatingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RatingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RatingServiceStub(channel, callOptions);
    }

    /**
     */
    public void isAccommodationAllowedToRate(proto.RatingReservation.IsAccommodationAllowedToRateRequest request,
        io.grpc.stub.StreamObserver<proto.RatingReservation.IsAccommodationAllowedToRateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsAccommodationAllowedToRateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isHostAllowedToRate(proto.RatingReservation.IsHostAllowedToRateRequest request,
        io.grpc.stub.StreamObserver<proto.RatingReservation.IsHostAllowedToRateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsHostAllowedToRateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RatingService.
   */
  public static final class RatingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RatingServiceBlockingStub> {
    private RatingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RatingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RatingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.RatingReservation.IsAccommodationAllowedToRateResponse isAccommodationAllowedToRate(proto.RatingReservation.IsAccommodationAllowedToRateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsAccommodationAllowedToRateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.RatingReservation.IsHostAllowedToRateResponse isHostAllowedToRate(proto.RatingReservation.IsHostAllowedToRateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsHostAllowedToRateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RatingService.
   */
  public static final class RatingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RatingServiceFutureStub> {
    private RatingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RatingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RatingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.RatingReservation.IsAccommodationAllowedToRateResponse> isAccommodationAllowedToRate(
        proto.RatingReservation.IsAccommodationAllowedToRateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsAccommodationAllowedToRateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.RatingReservation.IsHostAllowedToRateResponse> isHostAllowedToRate(
        proto.RatingReservation.IsHostAllowedToRateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsHostAllowedToRateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IS_ACCOMMODATION_ALLOWED_TO_RATE = 0;
  private static final int METHODID_IS_HOST_ALLOWED_TO_RATE = 1;

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
        case METHODID_IS_ACCOMMODATION_ALLOWED_TO_RATE:
          serviceImpl.isAccommodationAllowedToRate((proto.RatingReservation.IsAccommodationAllowedToRateRequest) request,
              (io.grpc.stub.StreamObserver<proto.RatingReservation.IsAccommodationAllowedToRateResponse>) responseObserver);
          break;
        case METHODID_IS_HOST_ALLOWED_TO_RATE:
          serviceImpl.isHostAllowedToRate((proto.RatingReservation.IsHostAllowedToRateRequest) request,
              (io.grpc.stub.StreamObserver<proto.RatingReservation.IsHostAllowedToRateResponse>) responseObserver);
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
          getIsAccommodationAllowedToRateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.RatingReservation.IsAccommodationAllowedToRateRequest,
              proto.RatingReservation.IsAccommodationAllowedToRateResponse>(
                service, METHODID_IS_ACCOMMODATION_ALLOWED_TO_RATE)))
        .addMethod(
          getIsHostAllowedToRateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.RatingReservation.IsHostAllowedToRateRequest,
              proto.RatingReservation.IsHostAllowedToRateResponse>(
                service, METHODID_IS_HOST_ALLOWED_TO_RATE)))
        .build();
  }

  private static abstract class RatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RatingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.RatingReservation.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RatingService");
    }
  }

  private static final class RatingServiceFileDescriptorSupplier
      extends RatingServiceBaseDescriptorSupplier {
    RatingServiceFileDescriptorSupplier() {}
  }

  private static final class RatingServiceMethodDescriptorSupplier
      extends RatingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RatingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RatingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RatingServiceFileDescriptorSupplier())
              .addMethod(getIsAccommodationAllowedToRateMethod())
              .addMethod(getIsHostAllowedToRateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
