package com.example.dto;


import com.example.dto.article.ArticleDTO;
import com.example.dto.profile.ProfileDTO;

import com.example.entity.ArticleEntity;
import com.example.entity.ProfileEntity;
import com.example.enums.CommentLikeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentLikeDTO {

    private Integer id;
    private ProfileEntity profileid;
    private ArticleEntity articleid;
    private LocalDateTime createddate;
    private CommentLikeEnum status;



}
