package com.example.restapi.utility.error;

public class IncorrectCredentialsException extends Exception {

    public IncorrectCredentialsException() {
        super("Incorrect username or password.");
    }
}
