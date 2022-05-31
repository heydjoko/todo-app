package com.example.todoapp.controller;

import com.example.todoapp.entity.User;
import com.example.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    private User getCurrentUser(@RequestBody User user) {
        System.out.println("User by username and pass");
        return userService.getUser(user);
    }

    @GetMapping("/login/{username}/{password}")
    private boolean findUserByUsername(@PathVariable String username,@PathVariable String password) {
        System.out.println("User by username and pass");
        return userService.getUserByUsername(username,password);
    }

    @PostMapping("/addUser")
    private boolean addUser(@RequestBody User user) {
        boolean user_exits = userService.findUserByUsername(user.getUsername());
        if(user_exits) {
        System.out.println("CAN NOT ADD USER!");
        return false;
        }
        userService.saveUser(user);
        return true;
        }
}