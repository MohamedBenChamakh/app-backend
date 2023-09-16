package com.example.app.service;

import com.utils.openapi.model.CommentRequestBody;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    boolean createComment(CommentRequestBody commentRequestBody);
}
