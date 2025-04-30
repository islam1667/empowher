package com.company.api.services;

import com.company.api.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getCommentsByVideoId(Integer videoId);

    CommentDto createComment(Integer videoId, Integer userId, CommentDto commentDto);
}
