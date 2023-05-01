package com.example.repository;

import com.example.entity.ArticleEntity;
import com.example.enums.ArticleStatus;
import com.example.mapper.ArticleShortInfoMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends CrudRepository<ArticleEntity,Integer>, PagingAndSortingRepository<ArticleEntity, Integer> {
    Optional<ArticleEntity> findAllByTitle(String title);
    Optional<ArticleEntity> findById(String id);
    @Transactional
    @Modifying
    @Query("update article set visible = :visible, status = :status where id = :id")
    Integer changeVisible(@Param("visible") Boolean visible, @Param("status") ArticleStatus status, @Param("id") String id);


    @Transactional
    @Modifying
    @Query("update article set visible = :visible, status = :status where id = :id")
    Integer changeStatus(@Param("visible") Boolean visible, @Param("status") ArticleStatus status, @Param("id") String id);


    @Query("FROM article WHERE articleType.id =:articleTypeId ORDER BY createdDate DESC limit 5")
    List<ArticleEntity> findLastFiveArticleByType(@Param("articleTypeId") Integer articleTypeId);

//    @Query("from ArticleEntity where  status =:status and visible =true order by  crez")
//    List<ArticleEntity>findby5typeid();

    @Query("FROM article WHERE articleType.id =:articleTypeId ORDER BY createdDate DESC limit 3")
    List<ArticleEntity> findLastThreeArticleByType(@Param("articleTypeId") Integer articleTypeId);

//    @Query("SELECT new ArticleEntity(id,title,description,attachId,publishedDate) From ArticleEntity where status =:status and visible = true and typeId =:typeId order by createdDate desc limit 5")
//    List<ArticleEntity> find5ByTypeId(@Param("typeId") Integer typeId, @Param("status") ArticleStatus status);

    @Query(value = "SELECT a.id,a.title,a.description,a.attach_id,a.published_date " +
            " FROM article AS a  where  a.type_id =:t_id and status =:status order by created_date desc Limit :limit",
            nativeQuery = true)
    List<ArticleShortInfoMapper> find5ByTypeIdNative(@Param("t_id") Integer t_id, @Param("status") String status, @Param("limit") Integer limit);


}

