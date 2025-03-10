package fin.org.trst.exception;

public class ClientAccountNotFoundException extends RuntimeException {
    public ClientAccountNotFoundException(String message) {
        super(message);
    }
}
