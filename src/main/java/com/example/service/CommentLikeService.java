package com.example.service;

import com.example.dto.CommentDTO;
import com.example.dto.CommentLikeDTO;
import com.example.dto.article.ArticleDTO;
import com.example.entity.ArticleEntity;
import com.example.entity.CommentEntity;
import com.example.entity.CommentLikeEntity;
import com.example.enums.ArticleStatus;
import com.example.enums.CommentLikeEnum;
import com.example.exps.MethodNotAllowedException;
import com.example.repository.CommentLikeRepository;
import com.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class CommentLikeService {
    @Autowired
    private CommentLikeRepository commentLikeRepository;

    @Autowired
    private CommentRepository commentRepository;

    public CommentLikeDTO create(CommentLikeDTO dto) {
        isValidProfile(dto);
        CommentLikeEntity entity = new CommentLikeEntity();
        entity.setId(dto.getId());
        entity.setProfile(dto.getProfileid());
        entity.setArticle(dto.getArticleid());
        entity.setCreateddate(dto.getCreateddate());
        entity.setStatus(dto.getStatus());
        entity.setStatus(CommentLikeEnum.LIKE);
        commentLikeRepository.save(entity);

     return dto;
    }

    public void isValidProfile(CommentLikeDTO dto) {
        Optional<CommentEntity> optional = commentRepository.findById(dto.getId());
        if (optional.isPresent()) {
            throw new MethodNotAllowedException("This Article already use :)");
        }
    }


    public CommentLikeDTO dislike(CommentLikeDTO dto) {
        isValidProfile(dto);
        CommentLikeEntity entity = new CommentLikeEntity();

        if(entity.getStatus()!=dto.getStatus()){
            entity.setStatus(CommentLikeEnum.DISLIKE);
        }
        entity.setId(dto.getId());
        entity.setProfile(dto.getProfileid());
        entity.setArticle(dto.getArticleid());
        entity.setCreateddate(dto.getCreateddate());
        entity.setStatus(dto.getStatus());
        commentLikeRepository.save(entity);
        return dto;
    }
}
