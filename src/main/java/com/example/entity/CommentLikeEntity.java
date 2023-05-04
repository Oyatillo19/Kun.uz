package com.example.entity;

import com.example.enums.CommentLikeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "commentlike")
public class CommentLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    @Column(name = "created_date")
    private LocalDateTime createddate=LocalDateTime.now();

    @Column(name = "status")
    private CommentLikeEnum status=CommentLikeEnum.NONE;


}
