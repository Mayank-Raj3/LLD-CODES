package ChainOfResponsibility.Handlers;

import ChainOfResponsibility.DTO.Request;

public interface RequestHandler {
    public void handle(Request request);
}
