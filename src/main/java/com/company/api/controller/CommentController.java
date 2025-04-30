package com.company.api.controller;

import com.company.api.dto.CommentDto;
import com.company.api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/video/{videoId}/comment/create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable("videoId") Integer videoId){
        return ResponseEntity.ok(commentService.createComment(videoId, commentDto.getAuthor().getId(), commentDto));
    }

    @GetMapping("/video/{videoId}/comments")
    public ResponseEntity<List<CommentDto>> getAllComments(@PathVariable("videoId") Integer videoId){
        return ResponseEntity.ok(commentService.getCommentsByVideoId(videoId));
    }
}
