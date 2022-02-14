package com.example.restapi.service;

import com.example.restapi.model.User;
import com.example.restapi.model.request.UserLoginRequest;
import com.example.restapi.model.request.UserRegistrationRequest;
import com.example.restapi.repository.UserRepository;
import com.example.restapi.utility.error.IncorrectCredentialsException;
import com.example.restapi.utility.error.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        Optional<User> byUsername = userRepository.findByUsername(userRegistrationRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setUsername(userRegistrationRequest.getUsername());
        user.setEmail(userRegistrationRequest.getEmail());
        user.setPassword(userRegistrationRequest.getPassword());
        userRepository.save(user);
    }

    public boolean checkCredentials(UserLoginRequest userLoginRequest) throws IncorrectCredentialsException {
        boolean credentialsMatch = false;
        Optional<User> userExists = userRepository.findByUsername(userLoginRequest.getUsername());
        if (userExists.isPresent() &&
                (getUserByUsername(userLoginRequest.getUsername()).getPassword()
                            .equals(userLoginRequest.getPassword()))) {
                credentialsMatch = true;
        }
        return credentialsMatch;
    }

    public User getUserByUsername(String username) throws IncorrectCredentialsException {
        return userRepository.findByUsername(username).orElseThrow(() -> new IncorrectCredentialsException());
    }












    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByID(Integer userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId.toString()));
    }

    public User getUserByIdOrUsername(Integer userId, String username) throws UserNotFoundException{
        if (userId == null){
            return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        }
        else {
            return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId.toString()));
        }
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) throws UserNotFoundException{
        userRepository.delete(getUserByID(userId));
    }
}
