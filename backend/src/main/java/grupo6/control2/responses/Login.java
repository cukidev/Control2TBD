package grupo6.control2.responses;

public class Login {

    private boolean success;
    private String jwt;

    private Long id_usuario;
    public Login(boolean success, String jwt,Long id_usuario) {
        this.success = success;
        this.jwt = jwt;
        this.id_usuario=id_usuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

}
