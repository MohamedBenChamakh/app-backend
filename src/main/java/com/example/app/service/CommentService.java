package com.example.app.service;

import com.utils.openapi.model.CommentRequestBody;
import com.utils.openapi.model.CommentResponseBody;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    CommentResponseBody createComment(CommentRequestBody commentRequestBody);
}
