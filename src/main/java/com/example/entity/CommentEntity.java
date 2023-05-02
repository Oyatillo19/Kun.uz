package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_Date")
    private LocalDateTime createdDate=LocalDateTime.now();
    @Column(name = "update_Date")
    private LocalDateTime updateDate;


/// DTO da integerda olingan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id",insertable = false, updatable = false)
    private ProfileEntity profileID;

    @Column(name = "content")
    private String content;


    /// DTO DA STRINGDA OLINGAN
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id",insertable = false, updatable = false)
    private ArticleEntity articleId;

    @Column(name = "visible")
    private Boolean visible=Boolean.TRUE;







}
