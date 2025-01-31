package com.shriram.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shriram.crm.entity.User;
import com.shriram.crm.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Registration & Login ", description = "...")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Operation(
            summary = " REGISTRATION ",
            description = " ")
    public ResponseEntity<?> registerUser(
            @RequestParam String name,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) String role) {
        try {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role != null ? role : "USER"); // Default role to "USER" if not provided
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully with username: " + registeredUser.getUsername());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    @Operation(
            summary = "LOGIN",
            description = "login with username and password")
 
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        try {
            String token = userService.loginUser(username, password);
            return ResponseEntity.ok("Login Successful. Token: " + token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
