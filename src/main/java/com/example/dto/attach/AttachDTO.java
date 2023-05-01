package com.example.dto.attach;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachDTO {
    private String id;

    @NotNull(message = "originalName empty")
    private String originalName;
    private String path;
    private Long size;
    private String extension;
    private LocalDateTime createdData;
    private String url;
}
