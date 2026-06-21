package com.ev.ev_project.controller;

import com.ev.ev_project.DTO.LoginRequest;
import com.ev.ev_project.DTO.LoginResponse;
import com.ev.ev_project.DTO.RegisterRequest;
import com.ev.ev_project.entity.User;
import com.ev.ev_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequest request){

        return service.register(request);

    }
    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return service.login(request);

    }

}
