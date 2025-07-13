package ChainOfResponsibility.Handlers;

import ChainOfResponsibility.DTO.Request;

public class AuthorizationHandler implements RequestHandler {
    RequestHandler requestsHandler;

    public AuthorizationHandler(RequestHandler requestsHandler){
        this.requestsHandler = requestsHandler;
    }

    @Override
    public void handle(Request request) {

        System.out.println("Authorization handler");
        this.requestsHandler.handle(request);
    }
}
