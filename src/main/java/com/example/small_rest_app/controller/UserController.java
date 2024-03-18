package com.example.small_rest_app.controller;

import com.example.small_rest_app.entity.User;
import com.example.small_rest_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/")
    public List<User> findAllUser(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @PutMapping("/{userId}")
    public User update(@RequestBody User user,@PathVariable Long userId){
        return userService.update(user,userId);
    }

    @DeleteMapping("/{userId}")
    public User delete(@PathVariable Long userId){
        return userService.delete(userId);
    }
}
