package com.example.restapi.controller;

import com.example.restapi.model.User;
import com.example.restapi.model.request.UserLoginRequest;
import com.example.restapi.model.request.UserRegistrationRequest;
import com.example.restapi.service.JWTService;
import com.example.restapi.service.UserService;
import com.example.restapi.utility.error.IncorrectCredentialsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTService jwtService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        userService.createUser(userRegistrationRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest userLoginRequest) throws IncorrectCredentialsException {
        boolean correctCredentials = userService.checkCredentials(userLoginRequest);
        if(correctCredentials){
            User user = userService.getUserByUsername(userLoginRequest.getUsername());
            String token = jwtService.generateToken(user);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Token", token);
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
