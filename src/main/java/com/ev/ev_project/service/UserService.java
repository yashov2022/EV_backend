package com.ev.ev_project.service;

import com.ev.ev_project.DTO.LoginRequest;
import com.ev.ev_project.DTO.LoginResponse;
import com.ev.ev_project.DTO.RegisterRequest;
import com.ev.ev_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ev.ev_project.entity.User;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    public User register(RegisterRequest request) {

        User user = new User();

        user.setUsername(
                request.getUsername());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole("USER");

        return userRepo.save(user);


    }

    public LoginResponse login(LoginRequest request) {
        User user = userRepo.findByUsername(request.getUsername()).orElseThrow(
                () -> new RuntimeException("user not found"));
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid password");
        }

        String token =
                jwtService.generateToken(
                        user.getUsername()
                );

        LoginResponse response =
                new LoginResponse();

        response.setToken(token);
        response.setRole(
                user.getRole()
        );
        return response;
    }
}