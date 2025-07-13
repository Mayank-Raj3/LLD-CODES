package ChainOfResponsibility.Handlers;

import ChainOfResponsibility.DTO.Request;

public class AuthenticationHandler implements RequestHandler {
    RequestHandler requestsHandler;
    public AuthenticationHandler(RequestHandler requestsHandler){
        this.requestsHandler = requestsHandler;
    }
    @Override
    public void handle(Request request) {
        //before

        //Handles Authentication Reqs
        System.out.println("Authentication Request");
        //after

        //calls next validator
        requestsHandler.handle(request);
    }
}
