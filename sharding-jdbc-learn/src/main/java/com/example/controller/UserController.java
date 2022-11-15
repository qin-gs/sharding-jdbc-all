package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("getUsers")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("addUser")
    public User addUser() {
        return service.addUser();
    }
}
