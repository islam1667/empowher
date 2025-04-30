package com.company.api.dto;

import com.company.api.models.UserEntity;
import com.company.api.models.VideoMetadata;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Integer id;
    private UserEntity author;
    private String content;
    private LocalDateTime timestamp;
    private VideoMetadata video;
}
