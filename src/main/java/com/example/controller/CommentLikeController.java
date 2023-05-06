package com.example.controller;
import com.example.dto.CommentLikeDTO;
import com.example.service.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commenlike")
public class CommentLikeController {

    @Autowired
    CommentLikeService commentLikeService;
    @PostMapping({"", "/"})

    public ResponseEntity<CommentLikeDTO> createdislike(@RequestBody CommentLikeDTO dto) {
        return ResponseEntity.ok(commentLikeService.create(dto));
    }


    public ResponseEntity<CommentLikeDTO> create(@RequestBody CommentLikeDTO dto) {
        return ResponseEntity.ok(commentLikeService.dislike(dto));
    }
}
