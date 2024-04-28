package grupo6.control2.services;

import grupo6.control2.entities.UserEntity;
import grupo6.control2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.getAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.saveUserCustom(user.getUsername(),user.getPassword());
    }

    public UserEntity updateUser(UserEntity user) {
        return userRepository.saveUserCustom(user.getUsername(),user.getPassword());

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
