package com.example.restapi.controller;

import com.example.restapi.model.User;
import com.example.restapi.service.UserService;
import com.example.restapi.utility.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Integer id) throws UserNotFoundException {
        User user = userService.getUserByID(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/discover")
    public ResponseEntity<User> getByIdOrUsername(@RequestParam(required = false) Integer id, @RequestParam(required = false) String username) throws UserNotFoundException {
        User user = userService.getUserByIdOrUsername(id, username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add/{username}/{password}")
    public ResponseEntity<String> addUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        userService.createUser(username, password);
        return new ResponseEntity<>("User, " + username + ", has been added.", HttpStatus.CREATED);
    }
    @PutMapping("/user/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>("User, " + user.getUsername() + ", has been updated.", HttpStatus.OK);
    }
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>("User with id:  " + id + ", has been deleted.", HttpStatus.OK);
    }
}
