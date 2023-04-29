package com.example.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {

    @Email(regexp = "email is empty")
    private String email;
    private String password;
}
