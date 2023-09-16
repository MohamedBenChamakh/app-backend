package com.example.app.service;

import com.utils.openapi.model.PostRequestBody;
import com.utils.openapi.model.PostResponseBody;

import java.util.List;

public interface PostService {

    List<PostResponseBody> getAllPosts(int page);


    boolean createPost(PostRequestBody postRequestBody);
}
