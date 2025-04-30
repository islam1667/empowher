package com.company.api.repositories;

import com.company.api.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByVideoId(Integer videoId);
}
