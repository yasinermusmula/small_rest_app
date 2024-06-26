package com.example.small_rest_app.service;

import com.example.small_rest_app.dto.PostResponseDto;
import com.example.small_rest_app.dto.PostUpdateReq;
import com.example.small_rest_app.entity.Post;
import com.example.small_rest_app.entity.User;
import com.example.small_rest_app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository,UserService userService) {
        this.postRepository = postRepository;
        this.userService=userService;
    }

    @Override
    public List<PostResponseDto> findAll(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()){
            list = postRepository.findByUserId(userId.get());
        } else {
            list = postRepository.findAll();
        }
        return list.stream().map(post -> new PostResponseDto(post)).collect(Collectors.toList());
    }

    @Override
    public Post save (PostResponseDto newPostRes) {
        //TODO Make Converter Here
        User user = userService.findById(newPostRes.getUserId());
        if (user == null){
            return null;
        }
            Post postSave = new Post();
            postSave.setText(newPostRes.getText());
            postSave.setTitle(newPostRes.getTitle());
            postSave.setUser(user);
            return postRepository.save(postSave);
        //TODO Make Exceptions
    }

    @Override
    public Post delete(Long id) {
        Post post = findById(id);
        if (post != null){
            postRepository.delete(post);
        }
        return null;
    }

    @Override
    public Post findById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post update(PostUpdateReq postUpdateReq, Long id) {
        Post existingUser = findById(id);
        existingUser.setText(postUpdateReq.getText());
        existingUser.setTitle(postUpdateReq.getTitle());
        return postRepository.save(existingUser);
    }


}
