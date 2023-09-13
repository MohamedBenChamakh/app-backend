package com.example.app.controller;


import com.utils.openapi.api.PostClientApi;
import com.utils.openapi.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostClientImpl implements PostClientApi {

    @Override
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
