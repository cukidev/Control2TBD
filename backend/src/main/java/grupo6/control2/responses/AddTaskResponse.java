package grupo6.control2.responses;

public class AddTaskResponse {

    private boolean success;

    public AddTaskResponse(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
