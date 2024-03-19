package com.example.small_rest_app.repository;

import com.example.small_rest_app.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByPostIdAndUserId(Long userId, Long postId);
    List<Like> findByPostId(Long postId);
    List<Like> findByUserId(Long userId);
}
