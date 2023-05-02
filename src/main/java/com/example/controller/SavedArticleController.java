package com.example.controller;

import com.example.dto.JwtDTO;
import com.example.dto.SavedArticleDTO;
import com.example.dto.article.ArticleDTO;
import com.example.dto.profile.ProfileDTO;
import com.example.enums.ProfileRole;
import com.example.service.ArticleService;
import com.example.service.SavedArticleService;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/savedarticle")
public class SavedArticleController {
    @Autowired
    private SavedArticleService savedArticleService;

//    @PostMapping({"", "/"})
//
//    public ResponseEntity<SavedArticleDTO> create(@RequestBody SavedArticleDTO dto,
//                                                  @RequestHeader("Authorization") String authorization) {
//
//        JwtDTO jwtDTO = JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.MODERATOR,ProfileRole.PUBLISHER,ProfileRole.USER);
//        return ResponseEntity.ok(savedArticleService.create(dto, jwtDTO.getId()));
//    }
//
//    @PutMapping(value = "/delete/{id}")
//    public ResponseEntity<?> delete(@RequestHeader("Authorization") String authorization,
//                                    @PathVariable("id") Integer id) {
//        return ResponseEntity.ok(savedArticleService.delete(id));
//
//    }
//    @GetMapping("/getProfileList")
//    public ResponseEntity<List<SavedArticleDTO>> getAll() {
//        List<SavedArticleDTO> list = savedArticleService.getAll();
//        return ResponseEntity.ok(list);
//
//    }
}
