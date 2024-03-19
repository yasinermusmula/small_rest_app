package com.example.small_rest_app.service;

import com.example.small_rest_app.dto.CommentResponseDto;
import com.example.small_rest_app.dto.CommentUpdateReq;
import com.example.small_rest_app.entity.Comment;
import com.example.small_rest_app.entity.Post;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAllCommentsWithParam(Optional<Long> userId,Optional<Long> postId);
    Comment save(CommentResponseDto comment);
    Comment delete(Long id);
    Comment findById(Long id);
    Comment update(CommentUpdateReq commentUpdateReq, Long id);
}
