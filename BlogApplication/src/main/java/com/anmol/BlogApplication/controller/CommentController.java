package com.anmol.BlogApplication.controller;

import com.anmol.BlogApplication.model.Comment;
import com.anmol.BlogApplication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        Comment saved = commentService.save(comment);
        return ResponseEntity.ok(saved);
    }

}
