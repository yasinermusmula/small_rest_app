package com.example.small_rest_app.dto;

import com.example.small_rest_app.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class PostResponseDto {
    private Long id;
    private Long userId;
    private String userName;
    private String text;
    private String title;

    public PostResponseDto(Post entity){
        this.id = entity.getId();
        this.userId=entity.getUser().getId();
        this.userName = entity.getUser().getUserName();
        this.text=entity.getText();
        this.title=entity.getTitle();
    }
}
