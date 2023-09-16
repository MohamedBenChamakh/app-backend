package com.example.app.mapper;

import com.example.app.domain.User;
import com.utils.openapi.model.UserRequestBody;
import com.utils.openapi.model.UserResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseBody userToUserResponseBody(User user);

    @Mapping(target="id",source="userRequestBody.id")
    @Mapping(target="lastName",source="userRequestBody.lastName")
    @Mapping(target="firstName",source="userRequestBody.firstName")
    @Mapping(target="email",source="userRequestBody.email")
    @Mapping(target="phoneNumber",source="userRequestBody.phoneNumber")
    @Mapping(target="region",source="userRequestBody.region")
    User userRequestBodyToUser(User user, UserRequestBody userRequestBody);
}
