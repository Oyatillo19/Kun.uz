package com.example.controller;

import com.example.dto.CommentDTO;
import com.example.dto.JwtDTO;
import com.example.dto.article.ArticleDTO;
import com.example.enums.ProfileRole;
import com.example.service.ArticleService;
import com.example.service.CommentService;
import com.example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping({"", "/"})

    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO dto) {
        return ResponseEntity.ok(commentService.create(dto));
    }
    @PutMapping (value = "/update")
    public ResponseEntity<?> update(@RequestBody CommentDTO dto,
                                    @RequestHeader("Authorization") String id) {

        return ResponseEntity.ok(commentService.update(dto,id));
    }

    @PutMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestHeader("Authorization") String authorization,
                                    @PathVariable("id") String id) {
        JwtUtil.getJwtDTOForArticle(authorization, ProfileRole.ADMIN);
        return ResponseEntity.ok(commentService.delete(id));
    }


}
