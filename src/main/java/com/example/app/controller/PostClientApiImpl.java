package com.example.app.controller;


import com.example.app.service.PostService;
import com.utils.openapi.api.PostClientApi;
import com.utils.openapi.model.PostRequestBody;
import com.utils.openapi.model.PostResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostClientApiImpl implements PostClientApi {

    private final PostService postService;

    public PostClientApiImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<List<PostResponseBody>> getAllPosts(Integer page) {
        return ResponseEntity.ok(postService.getAllPosts(page));
    }

    @Override
    public ResponseEntity<Void> createPost(PostRequestBody postRequestBody) {
        if (postService.createPost(postRequestBody))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().build();
    }
}
