package grupo6.control2.services;

import grupo6.control2.entities.UserEntity;
import grupo6.control2.forms.LoginForm;
import grupo6.control2.repositories.UserRepository;
import grupo6.control2.repositories.JWTMiddlewareRepository;
import grupo6.control2.responses.Login;
import grupo6.control2.responses.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("JWTMiddlewareRepositoryImp")
    private JWTMiddlewareRepository JWT;

    public List<UserEntity> getUsers() {
        return userRepository.getAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public UserEntity getByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public Login login(LoginForm form) {
        UserEntity vol = userRepository.getUserByUsername(form.getUser());
        if (vol == null) {
            return new Login(false, null,0L);
        }
        if (!form.getPassword().equals(vol.getPassword())) {
            return new Login(false, null,0L);
        }
        Long id=vol.getId();
        String jwt = JWT.generateToken(form);
        return new Login(true, jwt,vol.getId());
    }

    public LoginForm testJWT(String token) {
        if (JWT.validateToken(token)) {
            return JWT.decodeJWT(token);
        }
        return null;
    }

    public RegisterResponse saveUser(UserEntity user) {
        try {
            userRepository.saveUserCustom(user.getUsername(), user.getPassword());
            return new RegisterResponse(true);
        } catch (Exception e) {
            return new RegisterResponse(false);
        }

    }

    public UserEntity updateUser(UserEntity user) {
        UserEntity existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }


    public boolean deleteUser(Long id) throws Exception {
        try {
            userRepository.deleteByIdCustom(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}

