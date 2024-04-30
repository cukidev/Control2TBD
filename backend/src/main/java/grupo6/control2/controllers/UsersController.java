package grupo6.control2.controllers;

import grupo6.control2.entities.UserEntity;
import grupo6.control2.forms.LoginForm;
import grupo6.control2.responses.Login;
import grupo6.control2.responses.RegisterResponse;
import grupo6.control2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/users/save")
    public RegisterResponse createUser(@RequestBody UserEntity user) {
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

    @GetMapping("/{username}")
    public UserEntity getUserByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

//    @PutMapping("/")
//    public UserEntity updateUser(@RequestBody UserEntity user) {
//        return userService.updateUser(user);
//    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) throws Exception {
        return userService.deleteUser(id);
    }

    @PostMapping("/users/login")
    public Login login(@RequestBody LoginForm form){
        System.out.println(form.getUser());
        return userService.login(form);
    }


}
