package com.example.repository;

import com.example.entity.ArticleEntity;
import com.example.entity.CommentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommentRepository  extends CrudRepository<CommentEntity,Integer>, PagingAndSortingRepository<CommentEntity, Integer> {
    Optional<CommentEntity> findAllById(String id);

    @Transactional
    @Modifying
    @Query("update article set visible = :visible, status = :status where id = :id")
    Integer changeVisible(@Param("visible") Boolean visible);


}
