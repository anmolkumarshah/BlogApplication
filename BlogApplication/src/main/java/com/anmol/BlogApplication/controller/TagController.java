package com.anmol.BlogApplication.controller;

import com.anmol.BlogApplication.model.Tag;
import com.anmol.BlogApplication.repository.TagRepository;
import com.anmol.BlogApplication.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tag")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping
    public ResponseEntity<Tag> save(@RequestBody Tag tag){
        Tag saved = tagService.save(tag);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable("id") Long id){
        Tag byId = tagService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags(){
        List<Tag> allTags = tagService.getAllTags();
        return ResponseEntity.ok(allTags);
    }



}
