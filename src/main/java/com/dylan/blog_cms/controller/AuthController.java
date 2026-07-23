package com.dylan.blog_cms.controller;

import com.dylan.blog_cms.model.User;
import com.dylan.blog_cms.repository.UserRepository;
import com.dylan.blog_cms.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        User user = userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("Invalid username or password"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new NoSuchElementException("Invalid username or password");
        }

        String token = jwtService.generateToken(user.getUsername());
        return Map.of("token", token);
    }

}
