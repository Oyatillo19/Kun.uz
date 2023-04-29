package com.example.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class RegistrationDTO {


    @NotNull(message = "name empty")
    private String name;
    @NotNull(message = "surname empty")
    private String surname;

    @Email(regexp = "email empty")
    private String email;

    @NotNull(message = "phone empty")
    private String phone;

    @NotNull(message = "password empty")
    private String password;
}
