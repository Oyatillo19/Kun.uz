package com.example.controller;

import com.example.dto.article.ArticleDTO;
import com.example.dto.JwtDTO;


import com.example.dto.article.ArticleShortInfoDTO;
import com.example.enums.ProfileRole;
import com.example.service.ArticleService;
import com.example.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("priavte/create")

    public ResponseEntity<ArticleDTO> create(@RequestBody @Valid  ArticleDTO dto,
                                             HttpServletRequest request) {
        JwtUtil.checkForRequiredRole(request,ProfileRole.MODERATOR);
        Integer prtId=(Integer) request.getAttribute("id");
        return ResponseEntity.ok(articleService.create(dto,prtId));
    }



    @PutMapping (value = "/private/update")
    public ResponseEntity<?> update(@RequestBody ArticleDTO dto,
                                    @RequestHeader("Authorization") String authorization) {
        JwtDTO jwtDTO = JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.MODERATOR);
        return ResponseEntity.ok(articleService.update(dto,jwtDTO.getId()));
    }


    @PutMapping(value = "/private/delete/{id}")
    public ResponseEntity<?> delete(@RequestHeader("Authorization") String authorization,
                                    @PathVariable("id") String id) {
        JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.MODERATOR);
        return ResponseEntity.ok(articleService.delete(id));
    }


    @PutMapping(value = "/private/changeStatus/{id}")
    public ResponseEntity<?> changeStatus(@RequestHeader("Authorization") String authorization,
                                          @PathVariable("id") String id) {
        JwtDTO jwtDTO = JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.PUBLISHER);
        return ResponseEntity.ok(articleService.changeStatus(id,jwtDTO.getId()));
    }


    @GetMapping(value = "/getLastFiveArticleByType/{id}")
    public ResponseEntity<List<ArticleDTO>> getLastFiveArticleByType(@PathVariable("id") Integer articleId) {
        List<ArticleDTO> list = articleService.findLastFiveArticleByType(articleId);
        return ResponseEntity.ok(list);
    }


    @GetMapping(value = "/getLastThreeArticleByType/{id}")
    public ResponseEntity<List<ArticleDTO>> getLastThreeArticleByType(@PathVariable("id") Integer articleId) {
        List<ArticleDTO> list = articleService.findLastThreeArticleByType(articleId);
        return ResponseEntity.ok(list);
    }



    

}
