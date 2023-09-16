package com.example.app.service;

import com.example.app.domain.Comment;
import com.example.app.mapper.CommentMapper;
import com.example.app.repository.CommentRepository;
import com.utils.openapi.model.CommentRequestBody;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public boolean createComment(CommentRequestBody commentRequestBody) {
        Comment comment = CommentMapper.INSTANCE.commentRequestBodyToComment(commentRequestBody);
        return commentRepository.save(comment) != null;
    }
}
