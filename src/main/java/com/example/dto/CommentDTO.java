package com.example.dto;

import com.example.dto.profile.ProfileDTO;
import com.example.entity.ArticleEntity;
import com.example.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {


    private Integer id;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    private ProfileEntity profileID;
    private String content;
    private ArticleEntity articleId;
    private Boolean visible;



}
