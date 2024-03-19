package com.example.small_rest_app.dto;

import lombok.Data;

@Data
public class CommentResponseDto {
    private String text;
    private Long userId;
    private Long postId;
}
