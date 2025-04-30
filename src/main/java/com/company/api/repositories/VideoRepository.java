package com.company.api.repositories;

import com.company.api.models.VideoMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoMetadata, Integer> {
}
