package com.example.app.service;


import com.utils.openapi.model.UserRequestBody;
import com.utils.openapi.model.UserResponseBody;

public interface UserService {

    UserResponseBody getUserById(String userId);

    UserResponseBody updateUser(UserRequestBody userRequestBody);
}
