package com.example.service;

import com.example.dto.CommentDTO;
import com.example.entity.ArticleEntity;
import com.example.entity.CommentEntity;
import com.example.enums.ArticleStatus;
import com.example.exp.AppBadRequestException;
import com.example.exp.MethodNotAllowedException;
import com.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
  private CommentRepository commentRepository;

    public CommentDTO create(CommentDTO dto) {
        CommentEntity entity = new CommentEntity();
        entity.setId(dto.getId());
        entity.setContent(dto.getContent());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setUpdateDate(dto.getUpdateDate());
        entity.setProfileID(dto.getProfileID());
        entity.setArticleId(dto.getArticleId());
        entity.setVisible(dto.getVisible());
        return dto;
    }

    public Boolean update(CommentDTO dto, String id) {
        CommentEntity entity = get(id);
        entity.setId(dto.getId());
        entity.setArticleId(dto.getArticleId());
        entity.setProfileID(dto.getProfileID());
        entity.setContent(dto.getContent());
        entity.setUpdateDate(dto.getUpdateDate());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setVisible(dto.getVisible());

        commentRepository.save(entity);
        return true;


    }
    public CommentEntity get(String id) {
        Optional<CommentEntity> optional = commentRepository.findAllById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Article not found: " + id);
        }
        return optional.get();
    }

    public Boolean delete(String id) {

        CommentEntity entity = get(id);
        if (entity == null) {
            throw new MethodNotAllowedException("Article not found:)");
        }
        commentRepository.changeVisible(Boolean.FALSE);
        return true;
    }
}
