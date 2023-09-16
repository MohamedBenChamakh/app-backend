package com.example.app.controller;

import com.example.app.service.CommentService;
import com.utils.openapi.api.CommentClientApi;
import com.utils.openapi.model.CommentRequestBody;
import com.utils.openapi.model.CommentResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentClientApiIml implements CommentClientApi {


    private final CommentService commentService;

    public CommentClientApiIml(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public ResponseEntity<CommentResponseBody> createComment(CommentRequestBody commentRequestBody) {
        CommentResponseBody commentResponseBody = commentService.createComment(commentRequestBody);
        if (commentResponseBody == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponseBody);
    }
}
