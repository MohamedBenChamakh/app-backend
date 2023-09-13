package com.example.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);


}
