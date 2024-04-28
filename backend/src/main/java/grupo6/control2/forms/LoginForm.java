package grupo6.control2.forms;

public class LoginForm {
    private String user;
    private String password;

    public LoginForm(String email, String password) {
        this.user = email;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
