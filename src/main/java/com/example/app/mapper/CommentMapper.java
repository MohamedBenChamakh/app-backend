package com.example.app.mapper;

import com.example.app.domain.Comment;
import com.utils.openapi.model.CommentResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "createdAt",dateFormat = "dd/MM/yyyy")
    CommentResponseBody commentToCommentResponseBody(Comment comment);



}
