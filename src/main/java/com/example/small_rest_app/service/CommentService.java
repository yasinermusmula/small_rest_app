package com.example.small_rest_app.service;

import com.example.small_rest_app.dto.CommentResponseDto;
import com.example.small_rest_app.entity.Comment;
import com.example.small_rest_app.entity.Post;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAll(Optional<Long> userId);
    Comment save(CommentResponseDto comment);
    Comment delete(Long id);
    Comment findById(Long id);

}
