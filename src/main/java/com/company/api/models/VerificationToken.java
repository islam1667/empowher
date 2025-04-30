package com.company.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime expiryDate;
    private Boolean verified = false;

    public VerificationToken() {}

    public VerificationToken(UserEntity user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        this.expiryDate = LocalDateTime.now().plusHours(1); // Token expires in 1 hour
    }

    public Boolean isExpired(){
        return LocalDateTime.now().isBefore(expiryDate);
    }
}
