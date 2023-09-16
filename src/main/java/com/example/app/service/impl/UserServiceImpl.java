package com.example.app.service.impl;

import com.example.app.domain.User;
import com.example.app.mapper.UserMapper;
import com.example.app.repository.UserRepository;
import com.example.app.service.UserService;
import com.utils.openapi.model.UserRequestBody;
import com.utils.openapi.model.UserResponseBody;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponseBody getUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserMapper.INSTANCE::userToUserResponseBody).orElse(null);
    }

    @Override
    public UserResponseBody updateUser(UserRequestBody userRequestBody) {
        Optional<User> user = userRepository.findById(userRequestBody.getId());
        if (user.isEmpty())
            return null;
        User updatedUser = UserMapper.INSTANCE.userRequestBodyToUser(user.get(), userRequestBody);
        return UserMapper.INSTANCE.userToUserResponseBody(userRepository.saveAndFlush(updatedUser));
    }
}
