package com.example.app.mapper;

import com.example.app.domain.User;
import com.utils.openapi.model.UserResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseBody userToUserResponseBody(User user);
}
