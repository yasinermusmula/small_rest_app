package com.example.small_rest_app.repository;

import com.example.small_rest_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
