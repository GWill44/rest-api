package com.example.restapi.service;

import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.utility.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(String username, String password) {
        userRepository.save(new User(username, password));
    }

    public User findUserByID(Integer userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId.toString()));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getByIdOrUsername(Integer userId, String username) throws UserNotFoundException{
        if (userId == null){
            return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        }
        else {
            return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId.toString()));
        }
    }
}
