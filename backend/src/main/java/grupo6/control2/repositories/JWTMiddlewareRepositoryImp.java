package grupo6.control2.repositories;

import grupo6.control2.forms.LoginForm;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.crypto.SecretKey;
import java.util.Date;

@Repository
@Primary
public class JWTMiddlewareRepositoryImp implements JWTMiddlewareRepository {
    private final SecretKey secretKey;

    @Autowired
    public JWTMiddlewareRepositoryImp(SecretKey topSecretKey){
        this.secretKey = topSecretKey;
    }

    @Override
    public String generateToken(LoginForm form){
        Date expiration_date = new Date(System.currentTimeMillis() + 14400000);

        return Jwts
                .builder()
                .claim("username", form.getUser())
                .claim("password", form.getPassword())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiration_date)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public Boolean validateToken(String token){
        try{
            Jws<Claims> jws = Jwts
                    .parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return !jws.getPayload().getExpiration().before(new Date());
        }catch(ExpiredJwtException e){
            e.printStackTrace();
            return false;
        }catch(MalformedJwtException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public LoginForm decodeJWT(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String name = claims.get("name", String.class);
        String password = claims.get("password", String.class);
        return new LoginForm(name, password);
    }
}

