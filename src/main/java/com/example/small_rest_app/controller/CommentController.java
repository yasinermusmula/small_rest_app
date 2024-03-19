package com.example.small_rest_app.controller;

import com.example.small_rest_app.dto.CommentResponseDto;
import com.example.small_rest_app.dto.CommentUpdateReq;
import com.example.small_rest_app.entity.Comment;
import com.example.small_rest_app.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    public Comment save(@RequestBody CommentResponseDto commentResponseDto){
        return commentService.save(commentResponseDto);
    }

    @GetMapping
    public List<Comment> findAllComments(@RequestParam Optional<Long> userId,
                                         @RequestParam Optional<Long> postId){
        return commentService.findAllCommentsWithParam(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment findById(@PathVariable Long commentId){
        return commentService.findById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment update(@RequestBody CommentUpdateReq commentUpdateReq,
                          @PathVariable Long commentId){
        return commentService.update(commentUpdateReq,commentId);
    }

    @DeleteMapping("/{commentId}")
    public Comment delete(@PathVariable Long commentId){
        return commentService.delete(commentId);
    }
}
