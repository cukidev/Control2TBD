package grupo6.control2.forms;

public class JWTForm {
    private String token;

    public JWTForm() {
        this.token = "";
    }

    public JWTForm(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
