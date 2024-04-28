package grupo6.control2.controllers;

import grupo6.control2.entities.UserEntity;
import grupo6.control2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/")
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }



    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) throws Exception {
        return userService.deleteUser(id);
    }

}
