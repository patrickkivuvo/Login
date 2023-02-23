package com.login.Software.controller;

import com.login.Software.model.User;
import com.login.Software.repository.UserRepository;
import com.login.Software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getFlights(){
        return service.findAllUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        User saveUser = service.addUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return service.getUserByUserId(userId);
    }
    @GetMapping("/username/{username}")
    public List<User> findUserUsingUsername(@PathVariable String username) {
        return service.getUserByUsername(username);
    }
    @GetMapping("/password/{password}")
    public List<User> findUserByPassword(@PathVariable String password){
        return service.getUserByPassword(password);
    }

    @DeleteMapping("/{userId}")
    public String deleteFlight(@PathVariable String userId){
        return service.deleteUser(userId);
    }



}
