package ChainOfResponsibility.Handlers;

import ChainOfResponsibility.DTO.Request;

public class FinalHandler implements RequestHandler {


    @Override
    public void handle(Request request) {
        System.out.println("All Reqs Handled");
    }
}
