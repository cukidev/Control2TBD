package grupo6.control2.controllers;

import grupo6.control2.entities.UserEntity;
import grupo6.control2.forms.LoginForm;
import grupo6.control2.responses.Login;
import grupo6.control2.responses.RegisterResponse;
import grupo6.control2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    /*
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id){
        try {
            user.setId(id);
            UserEntity updatedUser = userService.updateUser(user);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

     */

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
