package com.example.app.service.impl;

import com.example.app.domain.Comment;
import com.example.app.mapper.CommentMapper;
import com.example.app.repository.CommentRepository;
import com.example.app.service.CommentService;
import com.utils.openapi.model.CommentRequestBody;
import com.utils.openapi.model.CommentResponseBody;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentResponseBody createComment(CommentRequestBody commentRequestBody) {
        Comment comment = CommentMapper.INSTANCE.commentRequestBodyToComment(commentRequestBody);
        return CommentMapper.INSTANCE.commentToCommentResponseBody(commentRepository.save(comment)) ;
    }
}
