package com.example.small_rest_app.service;

import com.example.small_rest_app.dto.LikeResponseDto;
import com.example.small_rest_app.entity.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> findAllCommentsWithParam(Optional<Long>postId,Optional<Long> userId);
    Like save(LikeResponseDto likeRes);
    Like delete(Long id);
    Like findById(Long id);

}
