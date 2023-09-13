package com.example.app.service.impl;

import com.example.app.domain.Post;
import com.example.app.mapper.PostMapper;
import com.example.app.repository.PostRepository;
import com.example.app.service.PostService;
import com.utils.openapi.model.PostResponseBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostResponseBody> getAllPosts() {
        List<Post> postList= postRepository.findAll();
        return PostMapper.INSTANCE.postListToPostListResponseBody(postList);
    }
}
