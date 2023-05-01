package com.example.dto.article;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ArticleRequestDTO {
     @NotNull(message = "title reuqired")
    @Size(min = 10, max = 225, message = "Title must be between 10 and 225 characters")
    private String title;
    private String description;

    @NotEmpty(message = "content empty")
    private String content;
    private Integer attachId;
    private Integer regionId;
    private Integer categoryId;

   @NotEmpty (message = "content empty")
    private Integer articleTypeId;
}
