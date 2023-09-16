package com.example.app.controller;

import com.example.app.service.CommentService;
import com.utils.openapi.api.CommentClientApi;
import com.utils.openapi.model.CommentRequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentClientApiIml implements CommentClientApi {


    private final CommentService commentService;

    public CommentClientApiIml(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public ResponseEntity<Void> createComment(CommentRequestBody commentRequestBody) {
        if (commentService.createComment(commentRequestBody))
            return ResponseEntity.noContent().build();
        return ResponseEntity.badRequest().build();
    }
}
