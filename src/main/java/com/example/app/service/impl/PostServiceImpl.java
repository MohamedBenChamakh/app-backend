package com.example.app.service.impl;

import com.example.app.domain.Post;
import com.example.app.mapper.PostMapper;
import com.example.app.repository.PostRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.PostService;
import com.utils.openapi.model.PostRequestBody;
import com.utils.openapi.model.PostResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostResponseBody> getAllPosts(int page) {
        int size = 10;
        Sort sort = Sort.by("createdAt").descending();
        Page<Post> postPage = postRepository.findAll(PageRequest.of(page, size, sort));
        return PostMapper.INSTANCE.postListToPostListResponseBody(postPage.toList());
    }

    @Override
    public PostResponseBody createPost(PostRequestBody postRequestBody) {
        Post newPost = PostMapper.INSTANCE.postRequestBodyToPost(postRequestBody);
        return PostMapper.INSTANCE.postToPostResponseBody(postRepository.save(newPost));
    }
}
