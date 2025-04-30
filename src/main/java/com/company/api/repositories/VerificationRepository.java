package com.company.api.repositories;

import com.company.api.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationRepository extends JpaRepository<VerificationToken, Integer> {
    Optional<VerificationToken> findByUserId(Integer userId);

    Optional<VerificationToken> findByToken(String token);
}
