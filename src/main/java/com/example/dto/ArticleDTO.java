package com.example.dto;

import com.example.enums.ArticleStatus;
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
public class ArticleDTO {
    private String id;

    @NotNull(message = "title empty")
    private String title;

    @NotNull(message = "description empty")
    private String description;

    @NotNull(message = "content empty")
    private String content;
    private Integer sharedCount;
    private Integer regionId;
    private Integer articleTypeId;
    private Integer categoryId;
    private Integer moderatorId;
    private Integer publisherId;
    private ArticleStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime publishedDate;
    private Boolean visible;
    private Integer viewCount;
    //image_id,
}
