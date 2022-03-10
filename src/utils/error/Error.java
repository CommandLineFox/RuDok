package utils.error;

public class Error {
    private ErrorType errorType;
    private final String message;

    public Error(ErrorType errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
