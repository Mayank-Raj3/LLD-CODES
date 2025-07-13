package ChainOfResponsibility.Handlers;

import ChainOfResponsibility.DTO.Request;

public class ValidateBody implements RequestHandler {
    RequestHandler requestsHandler;

    public ValidateBody(RequestHandler requestsHandler){
        this.requestsHandler = requestsHandler;
    }

    @Override
    public void handle(Request request) {

        System.out.println("Validate Body");

        requestsHandler.handle(request);

    }
}
