package grupo6.control2.responses;

public class RegisterResponse {
    private boolean success;

    public RegisterResponse(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
