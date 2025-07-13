package ChainOfResponsibility.DTO;

import java.util.Objects;
import java.util.Optional;

public class Request {
    private final int id;
    private final String request;
    private Optional<Objects> body ;

    public Request(int id, String request) {
        this.id = id;
        this.request = request;

    }
    public int getId() {
        return id;
    }
    public String getRequest() {
        return request;
    }
}
