package com.example.app.controller;


import com.example.app.service.PostService;
import com.utils.openapi.api.PostClientApi;
import com.utils.openapi.model.PostRequestBody;
import com.utils.openapi.model.PostResponseBody;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PostResponseBody> createPost(PostRequestBody postRequestBody) {
        PostResponseBody postResponseBody = postService.createPost(postRequestBody);
        if (postResponseBody == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(postResponseBody);
    }
}
