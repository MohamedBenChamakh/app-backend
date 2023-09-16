package com.example.app.controller;

import com.example.app.service.UserService;
import com.utils.openapi.api.UserClientApi;
import com.utils.openapi.model.UserResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientApiImpl implements UserClientApi {


    private final UserService userService;

    public UserClientApiImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserResponseBody> getUserById(String userId) {
        UserResponseBody userResponseBody = userService.getUserById(userId);
        if(userResponseBody == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userResponseBody);
    }
}
