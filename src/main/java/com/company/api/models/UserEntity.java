package com.company.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String email;
    private Boolean enabled = false;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
}
