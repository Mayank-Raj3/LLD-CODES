package ChainOfResponsibility.Factory;

import ChainOfResponsibility.Handlers.*;

public class RequestsHandler {
    public static RequestHandler getTodoControllerHandlers(){
        return new ValidateParams(
                new ValidateBody(
                        new AuthenticationHandler(
                                new AuthorizationHandler(new FinalHandler())
                        )
                )
        );
    }
}
