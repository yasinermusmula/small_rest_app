package com.example.small_rest_app.service;

import com.example.small_rest_app.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById (Long id);

    User save (User user);

    User update(User user,Long id);

    User delete(Long id);
}
