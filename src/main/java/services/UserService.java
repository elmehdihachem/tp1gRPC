package services;

import io.grpc.stub.StreamObserver;
import stub.User;
import stub.userGrpc;

public class UserService extends userGrpc.userImplBase{
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.LoginResponse> responseObserver) {
        String username=request.getUserName();
        String password=request.getPassWord();
        User.LoginResponse.Builder response= User.LoginResponse.newBuilder();
        if(username.equals(password)) {
            response.setIdResponse(1).setMsgResponse("SUCCES");
        }
        else
            response.setIdResponse(-1).setMsgResponse("NON VALIDE");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
