package ChainOfResponsibility.Controllers;

import ChainOfResponsibility.DTO.Request;
import ChainOfResponsibility.Entity.Todo;
import ChainOfResponsibility.Factory.RequestsHandler;

public class TodoController {
    private Todo createTodo(Request request) {
        RequestsHandler.getTodoControllerHandlers().handle(request);
        // return a new todo
        return new Todo();

    }
}
