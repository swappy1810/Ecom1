package com.example.roleBased.controller;

import com.example.roleBased.dao.UserDao;
import com.example.roleBased.entity.User;
import com.example.roleBased.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserDao userDao;

    //get user by username and login user
    @GetMapping("/login/{userId}")
    public Optional<User> getUserByUsername(String userId){
        Optional<User> user = this.userDao.getUserByUsername(userId);
        return userService.findByUsername(userId);
    }

    //add or register new user
    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    //method to initialize the roles of admin and user
    @PostConstruct
    public void initRolesAndUsers(){
         userService.initRolesAndUsers();
    }

//redirect to admin home page
    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "Only accessible for admin";
    }

    //redirect to user home page
    @GetMapping("/forUser")
    public String forUser(){
        return "Only accessible for user";
    }

}
