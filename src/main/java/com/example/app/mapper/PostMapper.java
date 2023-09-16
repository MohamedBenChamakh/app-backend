package com.example.app.mapper;

import com.example.app.domain.Comment;
import com.example.app.domain.Post;
import com.utils.openapi.model.CommentResponseBody;
import com.utils.openapi.model.PostResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "createdAt",dateFormat = "dd/MM/yyyy")
    PostResponseBody postToPostResponseBody(Post post);


    List<PostResponseBody> postListToPostListResponseBody(List<Post> postList);


    @Mapping(target = "createdAt",dateFormat = "dd/MM/yyyy")
    CommentResponseBody commentToCommentResponseBody(Comment comment);


}
