package com.company.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserEntityDto {
    private Integer id;

    @JsonProperty("username")
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 6, max = 15, message = "Username should be 6-15 characters long")
    private String username;

    @JsonProperty("password")
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 8, max = 20, message = "Password should be 8-20 characters long")
    private String password;

    @JsonProperty("email")
    @Email(message = "Email should be correct")
    @NotEmpty(message = "Email should not be empty")
    private String email;
    // private UserRole role;
}
