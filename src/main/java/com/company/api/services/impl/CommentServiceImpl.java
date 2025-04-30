package com.company.api.services.impl;

import com.company.api.dto.CommentDto;
import com.company.api.models.Comment;
import com.company.api.repositories.CommentRepository;
import com.company.api.repositories.VideoRepository;
import com.company.api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private VideoRepository videoRepository;
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(VideoRepository videoRepository, CommentRepository commentRepository) {
        this.videoRepository = videoRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDto> getCommentsByVideoId(Integer videoId) {
        return commentRepository.findAllByVideoId(videoId).stream().map(this::mapToDto).toList();
    }

    @Override
    public CommentDto createComment(Integer videoId, Integer userId, CommentDto commentDto) {
        //check if user and video exist
        Comment savedComment = commentRepository.save(mapToEntity(commentDto));
        return mapToDto(savedComment);
    }

    private CommentDto mapToDto(Comment comment){
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setAuthor(comment.getAuthor());
        dto.setContent(comment.getContent());
        dto.setTimestamp(comment.getPostedOn());
        return dto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setAuthor(commentDto.getAuthor());
        comment.setContent(commentDto.getContent());
        comment.setVideo(commentDto.getVideo());
        return comment;
    }
}
