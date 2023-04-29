package com.example.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ArticleRequestDTO {
    private String title;
    private String description;
    private String content;
    private Integer attachId;
    private Integer regionId;
    private Integer categoryId;
    private List<Integer> typeList;
}
