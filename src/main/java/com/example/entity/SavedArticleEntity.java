package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "savedarticle")
public class SavedArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//
//    @Column(name = "article")
//    private String article;
//
//
//    @JoinColumn(name = "article_id")
//    private Integer articleID;
//
//
//    @JoinColumn(name = "title")
//    private String title;
//
//
//    @JoinColumn(name = "description")
//    private String description;
//
//
//    @JoinColumn(name = "attach_id")
//    private String attach;


}
