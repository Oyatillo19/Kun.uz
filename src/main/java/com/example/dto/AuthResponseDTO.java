package com.example.dto;

import com.example.enums.ProfileRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {

    @NotNull(message = "name empty")
    private String name;

    @NotNull(message = "surname empty")
    private String surname;

    @NotNull(message = "role empty")
    private ProfileRole role;
    private String jwt;
}
