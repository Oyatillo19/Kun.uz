package com.example.service;

import com.example.dto.TagDTO;
import com.example.dto.profile.ProfileDTO;
import com.example.entity.ArticleEntity;
import com.example.entity.ProfileEntity;
import com.example.entity.TagEntity;

import com.example.exp.AppBadRequestException;
import com.example.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTML;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    public TagDTO create(TagDTO dto, Integer id) {
        TagEntity entity = new TagEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());


        tagRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }


    public Boolean update(TagDTO dto, Integer id) {

        TagEntity entity = get(dto.getId());
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        tagRepository.save(entity);
        return true;


    }
    public TagEntity get(Integer id) {
        Optional<TagEntity> optional = tagRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Article not found: " + id);
        }
        return optional.get();
    }

    public Boolean delete(Integer id) {
        tagRepository.deleteById(id);
        return true;

    }

    public List<TagDTO> getAll() {
            List<TagDTO> dtoList = getdtoList(tagRepository.findAll());
            return dtoList;
        }


    public List<TagDTO> getdtoList(Iterable<TagEntity> dtos) {
        List<TagDTO> dtoList = new LinkedList<>();
        dtos.forEach(entity -> {
            TagDTO dto = new TagDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            dtoList.add(dto);
        });
        return dtoList;
    }
}
