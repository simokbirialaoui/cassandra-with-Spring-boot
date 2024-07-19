package net.master.tp_cassandra_bdcc.web;

import net.master.tp_cassandra_bdcc.entities.User;
import net.master.tp_cassandra_bdcc.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public String saveUser(@RequestParam String name,
                           @RequestParam int age,
                           @RequestParam String email) {
        userService.addUser(name,age,email);
        return "User saved";
    }
}
