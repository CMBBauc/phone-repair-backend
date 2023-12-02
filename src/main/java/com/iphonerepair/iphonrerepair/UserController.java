package com.iphonerepair.iphonrerepair;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @CrossOrigin
    @PostMapping("/api/createUser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
