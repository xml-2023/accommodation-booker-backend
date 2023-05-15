package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: account-accommodation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccountAccommodationServiceGrpc {

  private AccountAccommodationServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.AccountAccommodationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.AccountAccommodation.CreateAccountAccommodationRequest,
      proto.AccountAccommodation.CreateAccountAccommodationResponse> getGetAccommodationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccommodations",
      requestType = proto.AccountAccommodation.CreateAccountAccommodationRequest.class,
      responseType = proto.AccountAccommodation.CreateAccountAccommodationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.AccountAccommodation.CreateAccountAccommodationRequest,
      proto.AccountAccommodation.CreateAccountAccommodationResponse> getGetAccommodationsMethod() {
    io.grpc.MethodDescriptor<proto.AccountAccommodation.CreateAccountAccommodationRequest, proto.AccountAccommodation.CreateAccountAccommodationResponse> getGetAccommodationsMethod;
    if ((getGetAccommodationsMethod = AccountAccommodationServiceGrpc.getGetAccommodationsMethod) == null) {
      synchronized (AccountAccommodationServiceGrpc.class) {
        if ((getGetAccommodationsMethod = AccountAccommodationServiceGrpc.getGetAccommodationsMethod) == null) {
          AccountAccommodationServiceGrpc.getGetAccommodationsMethod = getGetAccommodationsMethod =
              io.grpc.MethodDescriptor.<proto.AccountAccommodation.CreateAccountAccommodationRequest, proto.AccountAccommodation.CreateAccountAccommodationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccommodations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountAccommodation.CreateAccountAccommodationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.AccountAccommodation.CreateAccountAccommodationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccountAccommodationServiceMethodDescriptorSupplier("GetAccommodations"))
              .build();
        }
      }
    }
    return getGetAccommodationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccountAccommodationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountAccommodationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountAccommodationServiceStub>() {
        @Override
        public AccountAccommodationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountAccommodationServiceStub(channel, callOptions);
        }
      };
    return AccountAccommodationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccountAccommodationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountAccommodationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountAccommodationServiceBlockingStub>() {
        @Override
        public AccountAccommodationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountAccommodationServiceBlockingStub(channel, callOptions);
        }
      };
    return AccountAccommodationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccountAccommodationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccountAccommodationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccountAccommodationServiceFutureStub>() {
        @Override
        public AccountAccommodationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccountAccommodationServiceFutureStub(channel, callOptions);
        }
      };
    return AccountAccommodationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getAccommodations(proto.AccountAccommodation.CreateAccountAccommodationRequest request,
        io.grpc.stub.StreamObserver<proto.AccountAccommodation.CreateAccountAccommodationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccommodationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AccountAccommodationService.
   */
  public static abstract class AccountAccommodationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return AccountAccommodationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AccountAccommodationService.
   */
  public static final class AccountAccommodationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AccountAccommodationServiceStub> {
    private AccountAccommodationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AccountAccommodationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountAccommodationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAccommodations(proto.AccountAccommodation.CreateAccountAccommodationRequest request,
        io.grpc.stub.StreamObserver<proto.AccountAccommodation.CreateAccountAccommodationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccommodationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AccountAccommodationService.
   */
  public static final class AccountAccommodationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AccountAccommodationServiceBlockingStub> {
    private AccountAccommodationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AccountAccommodationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountAccommodationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.AccountAccommodation.CreateAccountAccommodationResponse getAccommodations(proto.AccountAccommodation.CreateAccountAccommodationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccommodationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AccountAccommodationService.
   */
  public static final class AccountAccommodationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AccountAccommodationServiceFutureStub> {
    private AccountAccommodationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AccountAccommodationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccountAccommodationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.AccountAccommodation.CreateAccountAccommodationResponse> getAccommodations(
        proto.AccountAccommodation.CreateAccountAccommodationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccommodationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOMMODATIONS = 0;

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
        case METHODID_GET_ACCOMMODATIONS:
          serviceImpl.getAccommodations((proto.AccountAccommodation.CreateAccountAccommodationRequest) request,
              (io.grpc.stub.StreamObserver<proto.AccountAccommodation.CreateAccountAccommodationResponse>) responseObserver);
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
          getGetAccommodationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              proto.AccountAccommodation.CreateAccountAccommodationRequest,
              proto.AccountAccommodation.CreateAccountAccommodationResponse>(
                service, METHODID_GET_ACCOMMODATIONS)))
        .build();
  }

  private static abstract class AccountAccommodationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccountAccommodationServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.AccountAccommodation.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccountAccommodationService");
    }
  }

  private static final class AccountAccommodationServiceFileDescriptorSupplier
      extends AccountAccommodationServiceBaseDescriptorSupplier {
    AccountAccommodationServiceFileDescriptorSupplier() {}
  }

  private static final class AccountAccommodationServiceMethodDescriptorSupplier
      extends AccountAccommodationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccountAccommodationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccountAccommodationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccountAccommodationServiceFileDescriptorSupplier())
              .addMethod(getGetAccommodationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
