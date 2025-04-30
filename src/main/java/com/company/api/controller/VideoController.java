package com.company.api.controller;

import com.company.api.services.fileStorage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class VideoController {
    private final FileStorageService fileStorageService;

    @Autowired
    public VideoController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5050")
    @GetMapping("/video/{filename}")
    public ResponseEntity<Resource> streamVideo(
            @PathVariable("filename") String filename,
            @RequestHeader(value = "Range", required = false) String rangeHeader
    ){
        try {
            Resource resource = fileStorageService.loadFileAsResource(filename);
            long fileSize = resource.contentLength();

            // Full file download
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(determineContentType(filename)))
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String determineContentType(String filename) {
        // Logic to detect MIME type based on file extension
        if (filename.endsWith(".m3u8")) {
            return "application/x-mpegURL";
        } else if (filename.endsWith(".ts")) {
            return "video/MP2T";
        }
        return "application/octet-stream";
    }
}
