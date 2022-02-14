package com.example.restapi.service;

import com.example.restapi.model.User;
import com.example.restapi.model.request.UserLoginRequest;
import com.example.restapi.model.request.UserRegistrationRequest;
import com.example.restapi.utility.error.IncorrectCredentialsException;
import com.example.restapi.utility.error.UserNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserService {

    List<User> getAllUsers();

    User getUserByID(Integer userId) throws UserNotFoundException;

    User getUserByUsername(String username) throws IncorrectCredentialsException;

    boolean checkCredentials(UserLoginRequest userLoginRequest) throws IncorrectCredentialsException;

    void createUser(UserRegistrationRequest userRegistrationRequest);
}
