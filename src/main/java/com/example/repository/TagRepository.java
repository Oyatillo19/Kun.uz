package com.example.repository;

import com.example.entity.ArticleEntity;
import com.example.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TagRepository extends CrudRepository<TagEntity,Integer>, PagingAndSortingRepository<TagEntity, Integer> {

}
