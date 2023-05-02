package com.example.dto;

import com.example.entity.ArticleEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SavedArticleDTO {

    private Integer id;
    private String article;
    private Integer articleId;
    private String title ;
    private String description ;
    private String imageID ;



}
