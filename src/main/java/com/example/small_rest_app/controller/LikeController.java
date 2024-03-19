package com.example.small_rest_app.controller;


import com.example.small_rest_app.dto.LikeResponseDto;
import com.example.small_rest_app.entity.Like;
import com.example.small_rest_app.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/")
    public Like save(@RequestBody LikeResponseDto responseDto){
        return likeService.save(responseDto);
    }

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId,
                                  @RequestParam Optional<Long> postId){
        return likeService.findAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{userId}")
    public Like findById(@PathVariable Long likeId){
        return likeService.findById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public Like delete(@PathVariable Long likeId){
        return likeService.delete(likeId);
    }
}
