package com.example.app.controller;


import com.example.app.service.PostService;
import com.utils.openapi.api.PostClientApi;
import com.utils.openapi.model.PostResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostClientApiImpl implements PostClientApi {

    private PostService postService;

    public PostClientApiImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<List<PostResponseBody>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }
}
