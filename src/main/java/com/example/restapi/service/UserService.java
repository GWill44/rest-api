package com.example.restapi.service;

import com.example.restapi.model.User;
import com.example.restapi.utility.error.UserNotFoundException;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserService {
    List<User> getAllUsers();
    User getUserByID(Integer userId) throws UserNotFoundException;
    User getUserByIdOrUsername(Integer userId, String username) throws UserNotFoundException;
    void createUser(String username, String password);
    void updateUser(User user);
}
