package com.example.entity;

import com.example.enums.ArticleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "shared_count")
    private Integer sharedCount;

    @Column(name = "region_id")
    private Integer regionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id",insertable = false, updatable = false)
    private RegionEntity region;


    @Column(name = "category_id")
    private Integer categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",insertable = false, updatable = false)
    private CategoryEntity category;


    @Column(name = "moderator_id")
    private Integer moderatorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moderator_id" ,insertable = false, updatable = false)
    private ProfileEntity moderator;


    @Column(name = "publisher_id")
    private Integer publisherId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id",insertable = false, updatable = false)
    private ProfileEntity publisher;


    @Column(name = "attach_id")
    private String attachId;
    @ManyToOne
    @JoinColumn(name = "attach_id",insertable = false, updatable = false)
    private AttachEntity attach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_type")
    private ArticleTypeEntity articleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ArticleStatus status;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "published_date")
    private LocalDateTime publishedDate;
    @Column(name = "visible")
    private Boolean visible;
    @Column(name = "view_count")
    private Integer viewCount;


    public ArticleEntity() {

    }

    public ArticleEntity(String id, String title, String description, String attachId, LocalDateTime publishedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.attachId = attachId;
        this.publishedDate = publishedDate;
    }


}
