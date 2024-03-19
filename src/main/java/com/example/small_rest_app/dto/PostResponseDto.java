package com.example.small_rest_app.dto;

import lombok.Data;

@Data
public class PostResponseDto {
    private Long id;
    private String text;
    private String title;
    private Long userId;
}
