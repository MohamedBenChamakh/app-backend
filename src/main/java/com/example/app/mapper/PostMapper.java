package com.example.app.mapper;

import com.example.app.domain.Comment;
import com.example.app.domain.Post;
import com.utils.openapi.model.CommentResponseBody;
import com.utils.openapi.model.PostRequestBody;
import com.utils.openapi.model.PostResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;

@Mapper
public abstract class PostMapper {

    public static final PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "createdAt", dateFormat = "dd/MM/yyyy")
    @Mapping(target = "type", source = "type.name")
    abstract PostResponseBody postToPostResponseBody(Post post);


    public abstract List<PostResponseBody> postListToPostListResponseBody(List<Post> postList);


    @Mapping(target = "createdAt", dateFormat = "dd/MM/yyyy")
    abstract CommentResponseBody commentToCommentResponseBody(Comment comment);

    @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "setCreatedPostDate", dateFormat = "yyyy-MM-dd")
    public abstract Post postRequestBodyToPost(PostRequestBody postRequestBody);

    @Named(value = "setCreatedPostDate")
    Date setDate(String createdAt) {
        return new Date();
    }

}
