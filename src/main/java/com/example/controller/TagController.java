package com.example.controller;

import com.example.dto.JwtDTO;
import com.example.dto.TagDTO;
import com.example.dto.article.ArticleDTO;
import com.example.dto.profile.ProfileDTO;
import com.example.enums.ProfileRole;
import com.example.service.TagService;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping({"", "/"})

    public ResponseEntity<TagDTO> create(@RequestBody TagDTO dto,
                                         @RequestHeader("Authorization") String authorization) {
        JwtDTO jwtDTO = JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.MODERATOR,ProfileRole.ADMIN);
        return ResponseEntity.ok(tagService.create(dto, jwtDTO.getId()));
    }

    @PutMapping (value = "/update")
    public ResponseEntity<?> update(@RequestBody TagDTO dto,
                                    @RequestHeader("Authorization") String authorization) {
        JwtDTO jwtDTO = JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.MODERATOR,ProfileRole.ADMIN);
        return ResponseEntity.ok(tagService.update(dto,jwtDTO.getId()));
    }

    @PutMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestHeader("Authorization") String authorization,
                                    @PathVariable("id") Integer id) {
        JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.MODERATOR,ProfileRole.ADMIN);
        return ResponseEntity.ok(tagService.delete(id));
    }

    @GetMapping("/getTagList")
    public ResponseEntity<List<TagDTO>> getAll() {
        List<TagDTO> list = tagService.getAll();
        return ResponseEntity.ok(list);
    }


}
