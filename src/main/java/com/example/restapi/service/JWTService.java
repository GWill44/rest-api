package com.example.restapi.service;

import com.example.restapi.model.User;
import com.example.restapi.model.UserPrincipal;
import org.springframework.stereotype.Component;

@Component
public interface JWTService {

    String generateToken(User user);

    UserPrincipal parseToken(String token);
}
