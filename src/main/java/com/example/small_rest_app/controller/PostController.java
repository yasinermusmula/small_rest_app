package com.example.small_rest_app.controller;

import com.example.small_rest_app.dto.PostResponseDto;
import com.example.small_rest_app.dto.PostUpdateReq;
import com.example.small_rest_app.entity.Post;
import com.example.small_rest_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public Post save(@RequestBody PostResponseDto newPostRes){
        return postService.save(newPostRes);
    }

    @GetMapping("/")
    public List<PostResponseDto> getAllPosts(@RequestParam Optional<Long> userId){
        return postService.findAll(userId);
    }

    @GetMapping("/{postId}")
    public Post findById(@PathVariable Long postId){
        return postService.findById(postId);
    }

    @DeleteMapping("/{postId}")
    public Post delete(@PathVariable Long postId){
        return postService.delete(postId);
    }

    @PutMapping("/{postId}")
    public Post update(@RequestBody PostUpdateReq updateReq, @PathVariable Long postId){
        return postService.update(updateReq,postId);
    }
}
