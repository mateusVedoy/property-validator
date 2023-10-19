package property.validator.application.response;

public class APIResponse {
    private int status;
    private String message;

    public APIResponse(int status, String message) {
        this.status= status;
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
