package com.example.restapi.utility.error;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String userId) {
        super("User '" + userId + "' was not found.");
    }
}
