package com.company.api.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity author;
    private String content;
    @CreationTimestamp
    private LocalDateTime postedOn;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private VideoMetadata video;
}
