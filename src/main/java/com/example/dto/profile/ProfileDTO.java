package com.example.dto.profile;

import com.example.enums.GeneralStatus;
import com.example.enums.ProfileRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
    private Integer id;

    @NotNull(message = "name empty")
    private String name;

    @NotNull(message = "name empty")
    private String surname;

    @Email(regexp = "emial is empty")
    private String email;

    @NotNull(message = "phone empty")
    private String phone;

    @NotNull(message = "password empty")
    private String password;

    @NotNull(message = "role  empty")
    private ProfileRole role;
    private GeneralStatus status;
    private Boolean visible;
}
