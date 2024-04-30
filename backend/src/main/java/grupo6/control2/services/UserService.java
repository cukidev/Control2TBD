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

    public UserEntity getByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public Login login(LoginForm form) {
        UserEntity vol = userRepository.getUserByUsername(form.getUser());
        if (vol == null) {
            return new Login(false, null);
        }
        if (!form.getPassword().equals(vol.getPassword())) {
            return new Login(false, null);
        }

        String jwt = JWT.generateToken(form);
        return new Login(true, jwt);
    }

    public LoginForm testJWT(String token) {
        if (JWT.validateToken(token)) {
            return JWT.decodeJWT(token);
        }
        return null;
    }
    public RegisterResponse saveUser(UserEntity user) {
        try {
            userRepository.saveUserCustom(user.getUsername(),user.getPassword());
            return new RegisterResponse(true);
        } catch (Exception e) {
            return new RegisterResponse(false);
        }

    }

//    public void updateUser(UserEntity user) {
//        userRepository.saveUserCustom(user.getUsername(),user.getPassword());
//
//    }
    public boolean deleteUser(Long id) throws Exception {
        try {
            userRepository.deleteByIdCustom(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
