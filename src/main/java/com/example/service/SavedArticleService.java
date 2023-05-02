package com.example.service;


import com.example.dto.SavedArticleDTO;
import com.example.dto.profile.ProfileDTO;
import com.example.entity.ArticleEntity;
import com.example.entity.ProfileEntity;
import com.example.enums.ArticleStatus;
import com.example.exps.AppBadRequestException;
import com.example.exps.MethodNotAllowedException;
import com.example.repository.SavedArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SavedArticleService {

    @Autowired
    private SavedArticleRepository savedArticleRepository;

    @Autowired
    private SavedArticleService savedArticleService;


//    public SavedArticleDTO create(SavedArticleDTO dto, Integer id) {
//            SavedArticleEntity entity = new SavedArticleEntity();
//            entity.setId(dto.getId());
//            entity.setArticleID(dto.getArticleId());
//            entity.setTitle(dto.getTitle());
//            entity.setDescription(dto.getDescription());
//            entity.setAttach(dto.getImageID());
//            entity.setArticle(dto.getArticle());
//            savedArticleRepository.save(entity);
//            dto.setId(entity.getId());
//            return dto;
//
//    }
//
//    public SavedArticleEntity get(Integer id) {
//        Optional<SavedArticleEntity> optional = savedArticleRepository.findById(id);
//        if (optional.isEmpty()) {
//            throw new AppBadRequestException("Profile not found: " + id);
//        }
//        return optional.get();
//    }
//
//    public Boolean delete(Integer id) {
//
//            SavedArticleEntity entity = get(id);
//            if (entity == null) {
//                throw new MethodNotAllowedException("Article not found:)");
//            }
//            savedArticleRepository.deleteById(id);
//            return true;
//        }
//
//
//    public List<SavedArticleDTO> getAll() {
//        List<SavedArticleDTO> dtoList = getdtoList(savedArticleRepository.findAll());
//        return dtoList;
//    }
//    public List<SavedArticleDTO> getdtoList(Iterable<SavedArticleEntity> dtos) {
//        List<SavedArticleDTO> dtoList = new LinkedList<>();
//        dtos.forEach(entity -> {
//            SavedArticleDTO dto = new SavedArticleDTO();
//            dto.setId(entity.getId());
//            dto.setArticle(entity.getArticle());
//            dto.setArticleId(entity.getArticleID());
//            dto.setDescription(entity.getDescription());
//            dto.setImageID(entity.getAttach());
//            dto.setTitle(entity.getTitle());
//
//            dtoList.add(dto);
//        });
//        return dtoList;
//    }
}

