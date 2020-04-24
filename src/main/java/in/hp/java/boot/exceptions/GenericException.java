package in.hp.java.boot.exceptions;

public class GenericException {
    private String timestamp;
    private String message;
    private String details;

    public GenericException(String timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
