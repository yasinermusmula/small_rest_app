package com.example.small_rest_app.dto;

import lombok.Data;

@Data
public class PostResponseDto {
    Long id;
    String text;
    String title;
    Long userId;
}
