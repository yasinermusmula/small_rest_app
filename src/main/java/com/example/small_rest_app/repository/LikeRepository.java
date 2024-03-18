package com.example.small_rest_app.repository;

import com.example.small_rest_app.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
