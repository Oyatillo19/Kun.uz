package com.example.dto.register;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponseDTO {
    private String message;

    public RegistrationResponseDTO(String message) {
        this.message = message;
    }
}
