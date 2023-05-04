package com.example.repository;

import com.example.entity.ArticleEntity;
import com.example.entity.CommentLikeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentLikeRepository  extends CrudRepository<CommentLikeEntity,Integer>, PagingAndSortingRepository<CommentLikeEntity, Integer> {

}
