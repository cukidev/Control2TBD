package grupo6.control2.repositories;

import grupo6.control2.forms.LoginForm;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTMiddlewareRepository{
    public String generateToken(LoginForm form);
    public Boolean validateToken(String token);
    public LoginForm decodeJWT(String token);
}
