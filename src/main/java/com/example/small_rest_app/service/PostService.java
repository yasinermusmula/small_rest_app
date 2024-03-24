package com.example.small_rest_app.service;

import com.example.small_rest_app.dto.PostResponseDto;
import com.example.small_rest_app.dto.PostUpdateReq;
import com.example.small_rest_app.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponseDto> findAll(Optional<Long> userId);
    Post save(PostResponseDto post);
    Post delete(Long id);
    Post findById(Long postId);
    Post update(PostUpdateReq postUpdateReq, Long id);

}
