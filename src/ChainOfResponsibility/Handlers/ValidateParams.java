package ChainOfResponsibility.Handlers;

import ChainOfResponsibility.DTO.Request;

public class ValidateParams implements RequestHandler {
    RequestHandler requestsHandler;

    public ValidateParams(RequestHandler requestsHandler){
        this.requestsHandler = requestsHandler;
    }

    @Override
    public void handle(Request request) {
        System.out.println("Validating parameters");

        requestsHandler.handle(request);
    }
}
