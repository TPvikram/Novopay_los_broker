package in.novopay.broker.exception;

public class NovoBrokerException extends RuntimeException {

    public NovoBrokerException(String message) {
        super(message);
    }

    public NovoBrokerException(String message, Throwable cause) {
        super(message, cause);
    }
}
