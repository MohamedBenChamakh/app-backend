package com.example.app.service;


import com.utils.openapi.model.UserResponseBody;

public interface UserService {

    UserResponseBody getUserById(String userId);
}
