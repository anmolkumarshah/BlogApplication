package com.anmol.BlogApplication.controller;

import com.anmol.BlogApplication.model.Blog;
import com.anmol.BlogApplication.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blog){
        Blog saved = blogService.save(blog);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id){
        Blog byId = blogService.findById(id);
        return ResponseEntity.ok(byId);
    }

}
